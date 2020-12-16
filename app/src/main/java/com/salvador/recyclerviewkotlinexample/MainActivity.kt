package com.salvador.recyclerviewkotlinexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //lateinit replaces the need to initialize it with null,
    //the var is not nullable but it will be initialized quickly later
    private lateinit var blogAdapter: BlogRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
        addDataSet()
    }

    //HARDCODED INFO
    private fun addDataSet(){
        val data = DataSource.createDataSet()
        blogAdapter.submitList(data)
    }

    private fun initRecyclerView(){

        /*
        Withouth Apply
        mRecyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
        blogAdapter = BlogRecyclerAdapter()
        mRecyclerView.adapter = blogAdapter*/

        mRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            val topSpacingDecoration = TopSpaceingItemDecoration(30)
            addItemDecoration(topSpacingDecoration)
            blogAdapter = BlogRecyclerAdapter()
            adapter = blogAdapter
        }
    }


}