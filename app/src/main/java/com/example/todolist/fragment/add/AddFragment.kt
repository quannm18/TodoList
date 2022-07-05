package com.example.todolist.fragment.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.todolist.R
import com.example.todolist.database.model.MyTodoEntity
import com.example.todolist.database.viewmodel.TodoViewModel
import kotlinx.android.synthetic.main.fragment_add.view.*


class AddFragment : Fragment() {
    private lateinit var mViewModel: TodoViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v: View = inflater.inflate(R.layout.fragment_add, container, false)

        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mViewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(requireActivity().application)).get(TodoViewModel::class.java)
        mViewModel.initViewModel(requireActivity().application)

        view.button.setOnClickListener {
            val title: String = view.edTitle.text.toString()
            val des: String = view.edDes.text.toString()
            val level: String = view.edLevel.text.toString()
            val isCheckedCHK: Boolean = view.chkStatus.isSelected
            val status = if (isCheckedCHK){
                1
            }else{
                0
            }
            if (checkNull(title, des, level, status) == 0) {
                val mModel = MyTodoEntity(
                    0,
                    title,
                    des,
                    level,
                    status
                )
                mViewModel.addTodo(mModel)
                Toast.makeText(requireContext(), "Add success!",Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_addFragment_to_listFragment)
            }else{
                Toast.makeText(requireContext(), "Fill data please!",Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun checkNull(title: String, des: String, level: String, status: Int): Int {
        if (title.trim().isEmpty() ||
            des.trim().isEmpty() ||
            level.trim().isEmpty()
        ) {
            return 1
        }
        return 0
    }
}