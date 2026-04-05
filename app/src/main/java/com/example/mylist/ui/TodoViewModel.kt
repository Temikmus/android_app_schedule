package com.example.mylist.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.mylist.data.TodoDatabase
import com.example.mylist.data.TodoItem
import com.example.mylist.data.TodoRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class TodoViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: TodoRepository = run {
        val dao = TodoDatabase.getDatabase(application).todoDao()
        TodoRepository(dao)
    }

    val items: StateFlow<List<TodoItem>> = repository.allItems.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = emptyList()
    )

    fun addItem(title: String, description: String) {
        viewModelScope.launch {
            repository.insert(
                TodoItem(title = title.trim(), description = description.trim())
            )
        }
    }

    fun updateItem(item: TodoItem) {
        viewModelScope.launch {
            repository.update(item)
        }
    }

    fun toggleCompleted(item: TodoItem) {
        viewModelScope.launch {
            repository.update(item.copy(isCompleted = !item.isCompleted))
        }
    }

    fun deleteItem(item: TodoItem) {
        viewModelScope.launch {
            repository.delete(item)
        }
    }
}
