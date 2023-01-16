package retrofit

import models.MessageToUser.MessageToUser
import models.ServerReply.ServerReply
import models.ServerUpdates.UpdatesFromTG
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("/bot5933410539:AAGfSGEpw8O7bHt7qa5EJnqycWpZ3o3qpw8/getMe")
    fun getServerReply(): Call<ServerReply>

    @GET("/bot5933410539:AAGfSGEpw8O7bHt7qa5EJnqycWpZ3o3qpw8/getUpdates")
    fun getUpdates(): Call<UpdatesFromTG>

    @POST("/bot5933410539:AAGfSGEpw8O7bHt7qa5EJnqycWpZ3o3qpw8/sendMessage")
    fun postMessage(@Body messageToUser: MessageToUser): Call<MessageToUser>
}
//bot5933410539:AAGfSGEpw8O7bHt7qa5EJnqycWpZ3o3qpw8