package com.example.todoapp.database

import androidx.lifecycle.LiveData

class TaskRepository(private val taskDao: TaskDao) {
    val allTask: LiveData<List<TaskItem>> = taskDao.getAll()

    suspend fun insertTask(taskItem: TaskItem){
        taskDao.insert(taskItem)
    }
    suspend fun deleteTask(taskItem: TaskItem){
        taskDao.delete(taskItem)
    }
    suspend fun updateTask(taskItem: TaskItem){
        taskDao.update(taskItem)
    }
    suspend fun deleteAllTask() {
        taskDao.deleteAll()
    }
}