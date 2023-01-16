package repository

import models.MessageToUser.MessageToUser
import retrofit.ApiService
import javax.inject.Inject

class Sender
@Inject constructor(private val service: ApiService) {

    fun postMessage(message: MessageToUser) {
        service
            .postMessage(message)
            .execute()
    }
}