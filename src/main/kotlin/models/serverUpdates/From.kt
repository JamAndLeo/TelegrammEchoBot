package models.serverUpdates

import com.google.gson.annotations.SerializedName

data class From(
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("is_bot")
    val isBot: Boolean,
    @SerializedName("language_code")
    val languageCode: String
)