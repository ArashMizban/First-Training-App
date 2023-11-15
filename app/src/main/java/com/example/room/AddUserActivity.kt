package com.example.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.example.room.DB.Dao
import com.example.room.DB.UserDataBase
import com.example.room.DB.UserEntity
import com.example.room.Utils.Constans
import com.example.room.databinding.ActivityAddUserBinding
import com.example.room.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class AddUserActivity : AppCompatActivity() {

    lateinit var binding: ActivityAddUserBinding

    //Database
    private val userDB: UserDataBase by lazy {
        Room.databaseBuilder(this, UserDataBase::class.java, Constans.USER_DATABASE)
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    private lateinit var user: UserEntity




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddUserBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.apply {
            saveBtn.setOnClickListener {
                val name = nameEdittext.text.toString()
                val age = AgeEdttext.text.toString()
                val phone = phoneText.text.toString()


                if (name.isNotEmpty() || age.isNotEmpty() || phone.isNotEmpty()) {
                    user = UserEntity(0, name, age.toInt() , phone.toInt())
                    userDB.userdao().insertuser(user)
                    finish()
                } else {
                    Snackbar.make(it, "name and age and Phone can not empty", Snackbar.LENGTH_SHORT).show()
                }
            }
        }
    }
}
