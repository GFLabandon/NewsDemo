package com.example.newsdemo.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 * Room 数据访问接口
 */
@Dao
interface NewsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertAll(list: List<NewsEntity>)

    @Query("SELECT * FROM news ORDER BY id DESC LIMIT :limit OFFSET :offset")
    suspend fun getPaged(limit: Int, offset: Int): List<NewsEntity>

    @Query("SELECT * FROM news WHERE title LIKE '%' || :keyword || '%' ORDER BY id DESC LIMIT :limit OFFSET :offset")
    suspend fun searchPaged(keyword: String, limit: Int, offset: Int): List<NewsEntity>
}
