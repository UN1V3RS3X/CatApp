package co.net.tps.catsapp.views

import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.GET
import retrofit2.http.Headers

interface CatsApi {
    @Headers("x-api-key: bda53789-d59e-46cd-9bc4-2936630fde39")
    @GET("/v1/breeds")
    fun getCats() : Call<List<Cat>>
}