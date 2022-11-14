package uz.iraimjanov.lazycolumn.data.remote

import retrofit2.Response
import uz.iraimjanov.lazycolumn.model.ContactRequest
import uz.iraimjanov.lazycolumn.model.ContactResponse
import retrofit2.http.*
import uz.iraimjanov.lazycolumn.model.MyResponse

interface MyApi {

    @GET("get")
    suspend fun getAllContact(): Response<List<ContactResponse>>

    @POST("add")
    suspend fun addContact(
        @Body contactRequest: ContactRequest
    ): Response<MyResponse>

    @PUT("update")
    suspend fun updateContact(
        @Body contactResponse: ContactResponse
    ): Response<MyResponse>

    @FormUrlEncoded
    @POST("delete")
    suspend fun deleteContact(
        @Field("id") id: Int
    ): Response<MyResponse>

}