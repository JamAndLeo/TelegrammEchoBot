package repository

import models.ServerReply.ServerReply
import models.ServerUpdates.UpdatesFromTG
import retrofit.ApiService
import javax.inject.Inject

class Recipient
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

}
