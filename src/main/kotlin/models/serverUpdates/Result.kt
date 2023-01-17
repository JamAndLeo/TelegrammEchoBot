package models.serverUpdates

import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("message")
    val message: Message,
    @SerializedName("update_id")
    val updateId: Int
)