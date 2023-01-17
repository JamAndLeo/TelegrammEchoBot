package repository

import models.messageToUser.MessageToUser
import models.serverReply.ServerReply
import models.serverUpdates.UpdatesFromTG
import retrofit.ApiService
import javax.inject.Inject

class Repository
@Inject constructor(private val service: ApiService) {

    fun getUpdates(): UpdatesFromTG? {
        return service
            .getUpdates()
            .execute()
            .body()
    }

    fun getServerReply(): ServerReply? {
        return service
            .getServerReply()
            .execute()
            .body()
    }

    fun postMessage(message: MessageToUser) {
        service
            .postMessage(message)
            .execute()
    }
}