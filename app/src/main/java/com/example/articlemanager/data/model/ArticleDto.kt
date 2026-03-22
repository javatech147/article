package com.example.articlemanager.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArticleDto(
    val canonical_url: String?,
    val collection_id: String?,
    val comments_count: Int?,
    val cover_image: String?,
    val created_at: String?,
    val crossposted_at: String?,
    val description: String,
    val edited_at: String?,
    val flare_tag: FlareTagDto? = null,
    val id: Int,
    val language: String?,
    val last_comment_at: String?,
    val organization: OrganizationDto? = null,
    val path: String?,
    val positive_reactions_count: Int?,
    val public_reactions_count: Int?,
    val published_at: String?,
    val published_timestamp: String?,
    val readable_publish_date: String?,
    val reading_time_minutes: Int?,
    val slug: String?,
    @SerialName("social_image") val imageUrl: String?,
    val subforem_id: Int?,
    val tag_list: List<String>?,
    val tags: String?,
    val title: String,
    val type_of: String?,
    val url: String?,
    val user: UserDto?
)

@Serializable
data class OrganizationDto(
    val name: String?,
    val profile_image: String?,
    val profile_image_90: String?,
    val slug: String?,
    val username: String?
)

@Serializable
data class FlareTagDto(
    val bg_color_hex: String,
    val name: String,
    val text_color_hex: String
)

@Serializable
data class UserDto(
    val github_username: String?,
    val name: String?,
    val profile_image: String?,
    val profile_image_90: String,
    val twitter_username: String?,
    val user_id: Int?,
    val username: String?,
    val website_url: String?
)
