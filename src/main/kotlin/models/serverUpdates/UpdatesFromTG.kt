package models.serverUpdates

import com.google.gson.annotations.SerializedName

data class UpdatesFromTG(
    @SerializedName("ok")
    val isOk: Boolean,
    @SerializedName("result")
    val results: List<Result>
)