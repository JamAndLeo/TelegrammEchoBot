package repository

import java.io.File
import javax.inject.Inject

class UserStorageManager
@Inject constructor() {

    private val usersID = File("storageUsers_ID.txt")
    val userIdCash = getOurUsers()

    private fun getOurUsers(): MutableList<Int> {
        usersID.createNewFile()
        val ourUsers = mutableListOf<Int>()
        usersID.readLines().forEach() { ourUsers.add(it.toInt()) }
        return ourUsers
    }

    fun putNewUser(userId: Int) {
        if (!userIdCash.contains(userId)) {
            usersID.appendText("\n$userId")
            userIdCash.add(userId)
        }
    }
}