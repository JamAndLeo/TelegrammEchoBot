package models.serverReply

import com.google.gson.annotations.SerializedName

data class ServerReply(
    @SerializedName("ok")
    val isOk: Boolean,
    @SerializedName("result")
    val results: Result,
)