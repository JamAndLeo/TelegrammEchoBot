package models.ServerUpdates

data class From(
    val first_name: String,
    val id: Int,
    val is_bot: Boolean,
    val language_code: String
)