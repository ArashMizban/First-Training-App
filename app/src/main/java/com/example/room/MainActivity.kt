package com.example.room

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.room.DB.UserDataBase
import com.example.room.Utils.Constans
import com.example.room.Utils.UserAdapter
import com.example.room.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private val userDB: UserDataBase by lazy {
        Room.databaseBuilder(this, UserDataBase::class.java, Constans.USER_DATABASE)
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    private val userAdapter by lazy { UserAdapter() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            addUser.setOnClickListener {
                startActivity(Intent(this@MainActivity, AddUserActivity::class.java))
            }
        }
    }

    override fun onResume() {
        super.onResume()
        checkitems()
    }

    private fun checkitems() {
        binding.apply {
            if (userDB.userdao().getalluser().isNotEmpty()) {
                userList.visibility = View.VISIBLE
                emtytext.visibility = View.GONE

                userAdapter.differ.submitList(userDB.userdao().getalluser())
                setuprecyclerview()

            } else {
                userList.visibility = View.GONE
                emtytext.visibility = View.VISIBLE
            }
        }
    }

    private fun setuprecyclerview(){
        binding.userList.apply {
            layoutManager = LinearLayoutManager(this@MainActivity , )
            adapter = userAdapter
        }
    }
}