package com.sales.cleanarchitecturenoteapp.feature_auth.presentation.components

import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import com.sales.cleanarchitecturenoteapp.R
import com.sales.cleanarchitecturenoteapp.ui.theme.GoodOrange

@Composable
fun AuthClickableText(
    onTextSelected: (String) -> Unit
) {
    val termsOfUse = stringResource(id = R.string.terms_of_use)
    val privacyPolicy = stringResource(id = R.string.privacy_policy)
    val annotatedString = buildAnnotatedString {
        append("By continuing you accept our ")
        withStyle(style = SpanStyle(color = GoodOrange)){
            pushStringAnnotation(tag = privacyPolicy, annotation = privacyPolicy)
            append(privacyPolicy)
        }
        append(" and ")
        withStyle(style = SpanStyle(color = GoodOrange)){
            pushStringAnnotation(tag = termsOfUse, annotation = termsOfUse)
            append(termsOfUse)
        }

    }

    ClickableText(text = annotatedString ) { offset ->
        annotatedString.getStringAnnotations(offset, offset)
            .firstOrNull()?.also { span ->
                if (span.item == termsOfUse || span.item == privacyPolicy ) {
                    onTextSelected(span.item)
                }
            }

    }
}