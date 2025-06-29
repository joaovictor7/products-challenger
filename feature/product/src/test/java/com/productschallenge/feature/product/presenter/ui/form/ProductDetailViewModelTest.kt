package com.productschallenge.feature.product.presenter.ui.form

import com.productschallenge.core.analytic.event.CommonAnalyticEvent
import com.productschallenge.core.analytic.sender.AnalyticSender
import com.productschallenge.core.test.BaseTest
import com.productschallenge.core.test.extension.runFlowTest
import com.productschallenge.core.ui.util.AsyncTaskUtils
import com.productschallenge.feature.product.R
import com.productschallenge.feature.product.analytic.screen.ProductDetailScreenAnalytic
import com.productschallenge.feature.product.navigation.destination.ProductDetailDestination
import com.productschallenge.feature.product.presenter.mapper.ProductDetailMapper
import com.productschallenge.feature.product.presenter.model.ProductDetailRow
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.test.TestDispatcher
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class ProductDetailViewModelTest : BaseTest() {

    private val analyticSender: AnalyticSender = mockk(relaxed = true)
    private val productDetailMapper: ProductDetailMapper = mockk()
    private lateinit var viewModel: ProductDetailViewModel

    override lateinit var testDispatcher: TestDispatcher

    private val asyncTaskUtils = AsyncTaskUtils(analyticSender, ProductDetailScreenAnalytic)

    @BeforeEach
    fun setUp() {
        every { productDetailMapper.mapperToModel(destinationMock) } returns listOf(
            ProductDetailRow(
                R.string.product_detail_rating,
                destinationMock.rating.toString(),
                true
            ),
            ProductDetailRow(R.string.product_detail_price, "$199.99"),
            ProductDetailRow(
                R.string.product_detail_discount_percentage,
                "${destinationMock.discountPercentage}%"
            ),
            ProductDetailRow(R.string.product_detail_stock, destinationMock.stock.toString()),
        )
        viewModel = initViewModel()
    }

    @Test
    fun `init Should update uiState with product details and send analytics`() =
        runFlowTest(viewModel.uiState) { onCancelJob, states ->
            onCancelJob()
            val state = states.last()
            assertEquals(destinationMock.title, state.title)
            assertEquals(destinationMock.thumbnail, state.thumbnail)
            assertEquals(destinationMock.description, state.description)
            assertEquals(detailModelMock, state.infoRows)
            coVerify {
                analyticSender.sendEvent(
                    CommonAnalyticEvent.OpenScreen(
                        ProductDetailScreenAnalytic
                    )
                )
            }
        }

    private fun initViewModel() = ProductDetailViewModel(
        destination = destinationMock,
        productDetailMapper = productDetailMapper,
        analyticSender = analyticSender,
        asyncTaskUtils = asyncTaskUtils,
    )

    private companion object {
        val destinationMock = ProductDetailDestination(
            title = "Product Title",
            thumbnail = "http://image.com/image.png",
            description = "Product Description",
            price = 199.99,
            discountPercentage = 0.0,
            rating = 0.0,
            stock = 2,
        )

        val detailModelMock = listOf(
            ProductDetailRow(
                R.string.product_detail_rating,
                destinationMock.rating.toString(),
                true
            ),
            ProductDetailRow(R.string.product_detail_price, "$199.99"),
            ProductDetailRow(
                R.string.product_detail_discount_percentage,
                "${destinationMock.discountPercentage}%"
            ),
            ProductDetailRow(R.string.product_detail_stock, destinationMock.stock.toString()),
        )
    }
}
