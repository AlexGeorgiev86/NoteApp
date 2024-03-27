package com.sales.cleanarchitecturenoteapp.feature_note.presentation.notes

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuth.AuthStateListener
import com.sales.cleanarchitecturenoteapp.feature_auth.presentation.SharedAuthViewModel
import com.sales.cleanarchitecturenoteapp.feature_note.domain.model.Note
import com.sales.cleanarchitecturenoteapp.feature_note.domain.use_case.NoteUseCases
import com.sales.cleanarchitecturenoteapp.feature_note.presentation.util.NoteOrder
import com.sales.cleanarchitecturenoteapp.feature_note.presentation.util.OrderType
import com.sales.cleanarchitecturenoteapp.utilities.connectivity.ConnectivityObserver
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private val noteUseCases: NoteUseCases,
    private val connectivityObserver: ConnectivityObserver
) : ViewModel() {

    private val _state = mutableStateOf(NotesState())
    val state: State<NotesState> = _state

    private var getNotesJob: Job? = null

    private var recentlyDeletedNote: Note? = null

    private val _networkStatus = MutableStateFlow<ConnectivityObserver.Status?>(null)
    val networkStatus: StateFlow<ConnectivityObserver.Status?> = _networkStatus.asStateFlow()

    init {
        viewModelScope.launch {
            connectivityObserver.observe().collectLatest { status ->
                _networkStatus.value = status
            }
        }
        getNotes(NoteOrder.Date(OrderType.Descending))
    }

    fun onEvent(event: NotesEvent) {
        when (event) {
            is NotesEvent.Order -> {
                if (state.value.noteOrder::class == event.noteOrder::class &&
                    state.value.noteOrder.orderType == event.noteOrder.orderType
                ) {
                    return
                }
                getNotes(event.noteOrder)
            }

            is NotesEvent.DeleteNote -> {
                viewModelScope.launch {
                    noteUseCases.deleteNote(event.note)
                    recentlyDeletedNote = event.note
                }
            }

            is NotesEvent.RestoreNote -> {
                viewModelScope.launch {
                    noteUseCases.addNote(recentlyDeletedNote ?: return@launch)
                    recentlyDeletedNote = null
                }
            }

            is NotesEvent.ToggleOrderSection -> {
                _state.value = state.value.copy(
                    isOrderSectionVisible = !state.value.isOrderSectionVisible
                )
            }
        }
    }

    private fun getNotes(noteOrder: NoteOrder) {
        getNotesJob?.cancel()
        getNotesJob = noteUseCases.getNotes(noteOrder)
            .onEach { notes ->
                _state.value = state.value.copy(
                    notes = notes,
                    noteOrder = noteOrder
                )
            }
            .launchIn(viewModelScope)
    }

    fun logout() {
        FirebaseAuth.getInstance().signOut()
        val authStateListener = AuthStateListener {
            if (it.currentUser == null) {
                Log.d(TAG, "sign out success")
            } else {
                Log.d(TAG, "sign out failed")
            }
        }
    }

    companion object {
        private val TAG = NotesViewModel::class.java.simpleName
    }
}