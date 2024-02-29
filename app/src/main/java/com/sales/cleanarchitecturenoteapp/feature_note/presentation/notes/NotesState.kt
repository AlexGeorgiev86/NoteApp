package com.sales.cleanarchitecturenoteapp.feature_note.presentation.notes

import com.sales.cleanarchitecturenoteapp.feature_note.domain.model.Note
import com.sales.cleanarchitecturenoteapp.feature_note.presentation.util.NoteOrder
import com.sales.cleanarchitecturenoteapp.feature_note.presentation.util.OrderType

data class NotesState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)
