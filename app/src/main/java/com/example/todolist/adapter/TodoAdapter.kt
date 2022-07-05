package com.example.todolist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.R
import com.example.todolist.database.model.MyTodoEntity
import kotlinx.android.synthetic.main.row.view.*

class TodoAdapter : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {
    private var mList : MutableList<MyTodoEntity> = mutableListOf()
    class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row, parent,false))
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val mItem = mList[position]

        holder.itemView.tvIDRow.setText("${mItem.id}")
        holder.itemView.tvTitle.setText("${mItem.title}")

    }

    override fun getItemCount(): Int {
        return mList.size
    }
    fun initData(todoList : MutableList<MyTodoEntity>) {
        this.mList = todoList
    }
}