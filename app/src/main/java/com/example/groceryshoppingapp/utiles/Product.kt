package com.example.groceryshoppingapp.utiles

data class Product(
    val productGram: String?,
    val productImage: String? = "", // Changed type to String
    val productName: String?,
    val productPrice: String?
) {
    constructor() : this(null, null, null, null)
}
