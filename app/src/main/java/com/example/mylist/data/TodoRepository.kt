package com.example.mylist.data

import kotlinx.coroutines.flow.Flow

class TodoRepository(private val todoDao: TodoDao) {

    val allItems: Flow<List<TodoItem>> = todoDao.getAllItems()

    suspend fun insert(item: TodoItem) = todoDao.insertItem(item)

    suspend fun update(item: TodoItem) = todoDao.updateItem(item)

    suspend fun delete(item: TodoItem) = todoDao.deleteItem(item)
}
