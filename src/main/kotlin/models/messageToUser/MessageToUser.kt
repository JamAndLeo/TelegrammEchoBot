package models.messageToUser

import com.google.gson.annotations.SerializedName

data class MessageToUser(
    @SerializedName("chat_id")
    val chatId: Int,
    @SerializedName("text")
    val text: String
)