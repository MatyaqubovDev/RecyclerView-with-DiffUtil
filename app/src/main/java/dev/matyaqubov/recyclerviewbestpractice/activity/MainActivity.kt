package dev.matyaqubov.recyclerviewbestpractice.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import dev.matyaqubov.recyclerviewbestpractice.R
import dev.matyaqubov.recyclerviewbestpractice.adapter.CustomAdapter
import dev.matyaqubov.recyclerviewbestpractice.model.Contact

class MainActivity : AppCompatActivity() {

    private lateinit var contacts:ArrayList<Contact>
    private val adapter by lazy {  CustomAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()

    }

    private fun initViews() {
        contacts= ArrayList()
        var recyclerView = findViewById<RecyclerView>(R.id.rv_main)
        for (i in 0..10){
            contacts.add(Contact("Alisher","+998975259712"))
        }
        adapter.submitList(contacts)
        recyclerView.adapter=adapter
    }
}