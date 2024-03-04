package com.example.restapis.data

import com.example.restapis.data.model.Product
import kotlinx.coroutines.flow.Flow

interface ProductsRepo {
    suspend fun getProducts(): Flow<Result<List<Product>>>
}