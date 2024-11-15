package com.example.ulkerff

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {

    private lateinit var taskList: RecyclerView
    private lateinit var addTaskButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set up the Toolbar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Initialize views
        taskList = findViewById(R.id.taskList)
        addTaskButton = findViewById(R.id.addTaskButton)

        // Set up RecyclerView with a LinearLayoutManager
        taskList.layoutManager = LinearLayoutManager(this)
        val tasks = mutableListOf<String>()  // Sample tasks
        val adapter = TaskAdapter(tasks)
        taskList.adapter = adapter

        // Add new task
        addTaskButton.setOnClickListener {
            tasks.add("New Task")
            adapter.notifyItemInserted(tasks.size - 1)
            Toast.makeText(this, "New task added", Toast.LENGTH_SHORT).show()
        }
    }

    // Create the options menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    // Handle menu item selection
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> {
                // Open Settings activity or show a Toast
                Toast.makeText(this, "Settings clicked", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_logout -> {
                // Handle logout action
                Toast.makeText(this, "Logging out...", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
