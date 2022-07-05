package com.example.todolist.database.repository

import androidx.lifecycle.LiveData
import com.example.todolist.database.dao.TodoDAO
import com.example.todolist.database.model.MyTodoEntity
//
//class TodoRepository (private val todoDAO: TodoDAO){
//    val getAll: LiveData<List<MyTodoEntity>> = todoDAO.getAll()
//
//    suspend fun addTodo(todoEntity: MyTodoEntity){
//        todoDAO.addTodo(todoEntity)
//    }
//}
class TodoRepository(private val userDao: TodoDAO) {

    val getAll: LiveData<List<MyTodoEntity>> = userDao.getAll()

    fun addTodo(user: MyTodoEntity){
        userDao.addTodo(user)
    }

}