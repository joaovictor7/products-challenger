package com.productschallenge.feature.product.data.mapper

import com.productschallenge.feature.product.domain.model.ReviewModel
import com.productschallenge.feature.product.network.response.ReviewResponse
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject

internal class ReviewMapper @Inject constructor() {

    fun mapperTo(reviews: List<ReviewResponse>) = reviews.map { mapperTo(it) }

    fun mapperTo(review: ReviewResponse): ReviewModel {
        return ReviewModel(
            rating = review.rating,
            comment = review.comment,
            date = ZonedDateTime.parse(review.date, DateTimeFormatter.ISO_ZONED_DATE_TIME)
                .toLocalDateTime(),
            reviewerName = review.reviewerName,
            reviewerEmail = review.reviewerEmail
        )
    }
}