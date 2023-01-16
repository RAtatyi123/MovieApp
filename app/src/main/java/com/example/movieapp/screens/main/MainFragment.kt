package com.example.movieapp.screens.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.MAIN
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentMainBinding


class MainFragment : Fragment() {


    private var mBinding: FragmentMainBinding ?=  null
    private val binding get() = mBinding!!
    lateinit var recyclerView: RecyclerView
    private val adapter by lazy { MainAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(MainFragmentViewModel::class.java)
        viewModel.getMovies()
        recyclerView = binding.rcMain
        recyclerView.adapter = adapter

            viewModel.getMovies()
            viewModel.myMovies.observe(viewLifecycleOwner) { list ->
                adapter.setList(list.body()!!.results)
        }




    }

    override fun onDestroyView() {
        super.onDestroyView()
        mBinding = null
    }



}