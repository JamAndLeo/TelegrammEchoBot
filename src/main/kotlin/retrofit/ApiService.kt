package retrofit

import models.messageToUser.MessageToUser
import models.serverReply.ServerReply
import models.serverUpdates.UpdatesFromTG
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

private const val token = "bot5933410539:AAGfSGEpw8O7bHt7qa5EJnqycWpZ3o3qpw8"

interface ApiService {

    @GET("/$token/getMe")
    fun getServerReply(): Call<ServerReply>

    @GET("/$token/getUpdates")
    fun getUpdates(): Call<UpdatesFromTG>

    @POST("/$token/sendMessage")
    fun postMessage(@Body messageToUser: MessageToUser): Call<MessageToUser>
}