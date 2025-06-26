package com.productschallenge.core.designsystem.enums.topbar

import androidx.annotation.DrawableRes
import com.productschallenge.core.designsystem.R

enum class TopBarAction(@param:DrawableRes val iconId: Int) {
    EDIT(R.drawable.ic_edit),
    MENU(R.drawable.ic_menu),
    REFRESH(R.drawable.ic_refresh_medium),
}