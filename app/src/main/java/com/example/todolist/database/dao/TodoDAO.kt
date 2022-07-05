package com.example.todolist.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.todolist.database.model.MyTodoEntity
@Dao
interface TodoDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addTodo(todoEntity: MyTodoEntity)

    @Query("SELECT * FROM todo_table ORDER BY id ASC")
    fun getAll(): LiveData<List<MyTodoEntity>>

}