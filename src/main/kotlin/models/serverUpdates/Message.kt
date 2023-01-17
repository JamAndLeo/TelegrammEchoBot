package models.serverUpdates

import com.google.gson.annotations.SerializedName

data class Message(
    @SerializedName("chat")
    val chat: Chat,
    @SerializedName("date")
    val dateOfMessage: Int,
    @SerializedName("from")
    val from: From,
    @SerializedName("message_id")
    val messageId: Int,
    @SerializedName("text")
    val text: String
)