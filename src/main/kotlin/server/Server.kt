package server

import models.MessageToUser.MessageToUser
import models.ServerUpdates.Result
import repository.Recipient
import repository.Sender
import java.io.File
import javax.inject.Inject

class Server
@Inject constructor(
    private val sender: Sender,
    private val recipient: Recipient,
) {

    private val answeredMessages = File("storageAnsweredMessage_ID.txt")
    private val usersID = File("storageUsers_ID.txt")

    fun postingEchoMessagesForAll() {
        Thread.sleep(2000)
        val newMessages = getNewMessages()
        val ourUsers = getOurUsers()
        for (maseege in newMessages) {
            putNewUser(maseege.message.from.id)
            ourUsers.forEach {
                val echoMessage = MessageToUser(
                    it,
                    "Пользователь ${maseege.message.from.first_name} написал следующее сообщение:\n[${maseege.message.text}]"
                )
                sender.postMessage(echoMessage)
            }
            answeredMessages.appendText("\n${maseege.update_id}")
        }
    }

    fun postingEchoMessages() {
        Thread.sleep(2000)
        val newMessages = getNewMessages()
        for (maseege in newMessages) {
            val echoMessage = MessageToUser(maseege.message.from.id, maseege.message.text)
            sender.postMessage(echoMessage)
            answeredMessages.appendText("\n${maseege.update_id}")
            putNewUser(maseege.message.from.id)
        }
    }


    fun getNewMessages(): MutableList<Result> {
        val updates = recipient.getUpdates()
        answeredMessages.createNewFile()

        val answeredMessagesInCash = mutableListOf<Int>()
        answeredMessages.readLines().forEach { answeredMessagesInCash.add(it.toInt()) }

        val newMessages = mutableListOf<Result>()

        updates?.result?.map {
            if (!answeredMessagesInCash.contains(it.update_id)) newMessages.add(it)
        }

        return newMessages
    }

    fun getOurUsers(): MutableList<Int> {
        usersID.createNewFile()
        val ourUsers = mutableListOf<Int>()
        usersID.readLines().forEach() { ourUsers.add(it.toInt()) }
        return ourUsers
    }

    fun putNewUser(userId: Int) {
        val ourUsers = getOurUsers()
        if (!ourUsers.contains(userId)) usersID.appendText("\n$userId")
    }

}

