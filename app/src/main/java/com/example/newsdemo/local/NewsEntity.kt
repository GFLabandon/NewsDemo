package com.example.newsdemo.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.newsdemo.model.NewsItem

/**
 * Room 本地表结构
 */
@Entity(tableName = "news")
data class NewsEntity(
    @PrimaryKey
    val id: Int,
    val title: String,
    val summary: String,
    val imageUrl: String,
    val url: String
)

fun NewsEntity.toNewsItem(): NewsItem {
    return NewsItem(
        id = id,
        title = title,
        summary = summary,
        imageUrl = imageUrl,
        url = url
    )
}

fun NewsItem.toEntity(): NewsEntity {
    return NewsEntity(
        id = id,
        title = title,
        summary = summary,
        imageUrl = imageUrl,
        url = url
    )
}
