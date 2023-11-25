package com.example.todoapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface TaskDao {
    @Query("SELECT * FROM task_table")
    fun getAll(): LiveData<List<TaskItem>>

    @Insert
    suspend fun insert(taskItem: TaskItem)

    @Update
    suspend fun update(taskItem: TaskItem)

    @Delete
    suspend fun delete(taskItem: TaskItem)

    @Query("DELETE FROM task_table")
    suspend fun deleteAll()
}