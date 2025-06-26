package com.productschallenge.feature.product.data.mapper

import com.productschallenge.common.extension.convertToLocalDateTime
import com.productschallenge.feature.product.domain.model.MetaModel
import com.productschallenge.feature.product.network.response.MetaResponse
import javax.inject.Inject

internal class MetaMapper @Inject constructor() {

    fun mapperTo(meta: MetaResponse) = MetaModel(
        createdAt = meta.createdAt.convertToLocalDateTime(),
        updatedAt = meta.updatedAt.convertToLocalDateTime(),
        barcode = meta.barcode,
        qrCode = meta.qrCode
    )
}