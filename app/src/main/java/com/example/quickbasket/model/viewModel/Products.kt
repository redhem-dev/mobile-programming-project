package com.example.quickbasket.model.viewModel

import com.example.quickbasket.model.models.Products

data class ProductDetails(
    val id: Int = 0,
    val name: String = "",
    val description: String = "",
    val price: Int = 0
)

data class ProductsUiState(
    val productsList: List<ProductDetails> = emptyList(),
    val isEntryValid: Boolean = false
)
fun ProductDetails.toProducts(): Products = Products(
    id = id,
    name = name,
    description = description,
    price = price
)

fun Products.toProductDetails(): ProductDetails {
    return ProductDetails(
        id = id,
        name = name,
        description = description,
        price = price
    )
}

fun Products.toProductsUiState(isEntryValid: Boolean = false): ProductsUiState = ProductsUiState(
    productsList = listOf(this.toProductDetails()),
    isEntryValid = isEntryValid
)
