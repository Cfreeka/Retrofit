package com.example.restapis.data

import com.example.restapis.data.model.Product
import com.example.restapis.data.model.Products
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class ProductRepoImpl(
    private val api: Api
): ProductsRepo {
    override suspend fun getProducts(): Flow<Result<List<Product>>> {
      return flow {

          val productsFromApi = try {
              api.getProductsList()
          }catch (e: IOException) {
              e.printStackTrace()
              emit(Result.Error( message = "Error loading products"))
              return@flow
          }catch (e: HttpException) {
              e.printStackTrace()
              emit(Result.Error( message = "Error loading products"))
              return@flow
          }catch (e: Exception) {
              e.printStackTrace()
              emit(Result.Error( message = "Error loading products"))
              return@flow
          }
          emit(Result.Success(productsFromApi.products))

      }
    }
}