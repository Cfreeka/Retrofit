package com.example.restapis.data.model

import com.example.restapis.data.model.Product

data class Products(
    val limit: Int,
    val products: List<Product>,
    val skip: Int,
    val total: Int
)