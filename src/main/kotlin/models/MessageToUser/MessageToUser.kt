package models.MessageToUser

import models.ServerUpdates.Chat
import models.ServerUpdates.From

data class MessageToUser(
    val chat_id: Int,
    val text: String
)
