package models.ServerUpdates

data class UpdatesFromTG(
    val ok: Boolean,
    val result: List<Result>
)