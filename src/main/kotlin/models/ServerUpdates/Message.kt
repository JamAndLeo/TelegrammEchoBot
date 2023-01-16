package models.ServerUpdates

data class Message(
    val chat: Chat,
    val date: Int,
    val from: From,
    val message_id: Int,
    val text: String
)