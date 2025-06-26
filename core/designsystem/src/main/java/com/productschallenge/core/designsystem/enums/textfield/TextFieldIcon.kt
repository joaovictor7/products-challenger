package com.productschallenge.core.designsystem.enums.textfield

import androidx.annotation.DrawableRes
import com.productschallenge.core.designsystem.R

enum class TextFieldIcon(@param:DrawableRes val iconId: Int) {
    CLEAR_TEXT(R.drawable.ic_cancel),
    ERROR(R.drawable.ic_error),
    SEARCH(R.drawable.ic_search)
}