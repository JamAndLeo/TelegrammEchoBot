package server

import models.messageToUser.MessageToUser
import models.serverUpdates.Result
import repository.Repository
import repository.UserStorageManager
import java.io.File
import javax.inject.Inject

class Server
@Inject constructor(
    private val repository: Repository,
    private val userManager: UserStorageManager,
) {

    private val threshold: Long = 2000
    private val answeredMessages = File("storageAnsweredMessage_ID.txt")
    private val answeredMessagesInCash = getAnsweredMessages()

    fun postingEchoMessagesForAll() {
        Thread.sleep(threshold)
        val newMessages = getNewMessages()
        for (message in newMessages) {
            userManager.putNewUser(message.message.from.id)
            userManager.userIdCash.forEach {
                val echoMessage = MessageToUser(
                    it,
                    "Пользователь ${message.message.from.firstName} написал следующее сообщение:\n[${message.message.text}]"
                )
                repository.postMessage(echoMessage)
            }
            answeredMessages.appendText("\n${message.updateId}")
            answeredMessagesInCash.add(message.updateId)
        }
    }

    fun postingEchoMessages() {
        Thread.sleep(threshold)
        val newMessages = getNewMessages()
        for (message in newMessages) {
            val echoMessage = MessageToUser(message.message.from.id, message.message.text)
            repository.postMessage(echoMessage)
            answeredMessages.appendText("\n${message.updateId}")
            answeredMessagesInCash.add(message.updateId)
            userManager.putNewUser(message.message.from.id)
        }
    }

    fun getServerReply(){
        repository.getServerReply()
    }

    private fun getNewMessages(): MutableList<Result> {
        val updates = repository.getUpdates()
        val newMessages = mutableListOf<Result>()
        updates?.results?.map {
            if (!answeredMessagesInCash.contains(it.updateId)) newMessages.add(it)
        }
        return newMessages
    }

    private fun getAnsweredMessages(): MutableList<Int> {
        answeredMessages.createNewFile()
        val answeredMessagesInCash = mutableListOf<Int>()
        answeredMessages.readLines().forEach { answeredMessagesInCash.add(it.toInt()) }
        return answeredMessagesInCash
    }
}