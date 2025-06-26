package com.productschallenge.feature.product.presenter.enums

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import com.productschallenge.feature.product.R

private val like = Color(0xFF2ECC71)
private val dislike = Color(0xFFE74C3C)
private val neutral = Color(0xFF9E9E9E)

internal enum class RatingStatus(
    @param:DrawableRes val iconId: Int? = null,
    val iconColor: Color,
) {
    LIKE(R.drawable.ic_like, like),
    DISLIKE(R.drawable.ic_dislike, dislike),
    NEUTRAL(iconColor = neutral),
}