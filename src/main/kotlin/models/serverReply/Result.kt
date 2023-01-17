package models.serverReply

import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("can_join_groups")
    val isCanJoinGroups: Boolean,
    @SerializedName("can_read_all_group_messages")
    val isCanReadAllGroupMessages: Boolean,
    @SerializedName("first_name")
    val firstNameBot: String,
    @SerializedName("id")
    val id: Long,
    @SerializedName("is_bot")
    val isBot: Boolean,
    @SerializedName("supports_inline_queries")
    val supportsInlineQueries: Boolean,
    @SerializedName("username")
    val username: String
)