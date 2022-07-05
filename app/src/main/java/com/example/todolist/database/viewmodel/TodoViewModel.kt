package com.example.todolist.database.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todolist.database.dao.TodoDAO
import com.example.todolist.database.mdatabase.TodoDatabase
import com.example.todolist.database.model.MyTodoEntity
import com.example.todolist.database.repository.TodoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

public class TodoViewModel() : ViewModel() {
    public lateinit var getAll : LiveData<List<MyTodoEntity>>
    private lateinit var mRepository : TodoRepository

    fun addTodo(todoEntity: MyTodoEntity) {
        viewModelScope.launch (Dispatchers.IO){
            mRepository.addTodo(todoEntity)
        }
    }
    fun initViewModel(application: Application) {
        val todoDao : TodoDAO = TodoDatabase.getDatabase(application).todoDao()
        mRepository = TodoRepository(todoDao)
        getAll = mRepository.getAll
    }
}