package com.example.todolist.fragment.list
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolist.R
import com.example.todolist.adapter.PaginationScrollListener
import com.example.todolist.adapter.TodoAdapter
import com.example.todolist.database.model.MyTodoEntity
import com.example.todolist.database.viewmodel.TodoViewModel
import kotlinx.android.synthetic.main.fragment_list.*
import kotlinx.android.synthetic.main.fragment_list.view.*

class ListFragment : Fragment() {
    private val mList : MutableList<MyTodoEntity> = mutableListOf()
    private val mAdapter : TodoAdapter = TodoAdapter()
    private lateinit var mViewModel : TodoViewModel;
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.floatingActionButton.setOnClickListener{
            this.findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }

        mViewModel = ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory(requireActivity().application)).get(TodoViewModel::class.java)

        mViewModel.initViewModel(requireActivity().application)

        mAdapter.initData(mList)
        mViewModel.getAll.observe(viewLifecycleOwner){
            mList.clear()
            mList.addAll(it)
            mAdapter.notifyDataSetChanged()
        }
        recyclerView.addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))

//        val paginationScrollListener = 
//        recyclerView.addOnScrollListener()
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = mAdapter

        button2.setOnClickListener {
            for (i in 0..100){
                mViewModel.addTodo(MyTodoEntity(0,"A $i","aksucbiabscia asjcbiua jcgwc nbc","Medium",i))
            }
        }
    }

}