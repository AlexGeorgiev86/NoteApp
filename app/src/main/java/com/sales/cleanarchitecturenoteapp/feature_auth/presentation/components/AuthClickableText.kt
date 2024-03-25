package com.sales.cleanarchitecturenoteapp.feature_auth.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import com.sales.cleanarchitecturenoteapp.R
import com.sales.cleanarchitecturenoteapp.ui.theme.Active

@Composable
fun AuthClickableText(
    tryingToLogin: Boolean,
    onTextSelected: (String) -> Unit
) {
    val unclickableText = if(tryingToLogin) stringResource(id = R.string.go_to_login) else stringResource(id = R.string.go_to_register)
    val clickableText = if(tryingToLogin) stringResource(id = R.string.login) else stringResource(id = R.string.register)
    val annotatedString = buildAnnotatedString {
        append(unclickableText)
        withStyle(style = SpanStyle(color = Active)) {
            pushStringAnnotation(tag = clickableText, annotation = clickableText)
            append(clickableText)
        }
    }

    ClickableText(
        text = annotatedString,
        modifier = Modifier.fillMaxWidth(),
        style = TextStyle(
            fontSize = 21.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center
        )
    ) { offset ->
        annotatedString.getStringAnnotations(offset, offset)
            .firstOrNull()?.also { span ->
                if (span.item == clickableText) {
                    onTextSelected(span.item)
                }
            }
    }
}