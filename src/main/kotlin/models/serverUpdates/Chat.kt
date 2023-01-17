package models.serverUpdates

import com.google.gson.annotations.SerializedName

data class Chat(
    @SerializedName("first_name")
    val firstNameUser: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("type")
    val type: String
)