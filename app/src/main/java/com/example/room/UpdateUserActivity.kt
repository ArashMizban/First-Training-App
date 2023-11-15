package com.example.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.example.room.DB.UserDataBase
import com.example.room.DB.UserEntity
import com.example.room.Utils.Constans
import com.example.room.databinding.ActivityUpdateUserBinding
import com.google.android.material.snackbar.Snackbar

class UpdateUserActivity : AppCompatActivity() {

    lateinit var binding: ActivityUpdateUserBinding

    private val userDB: UserDataBase by lazy {
        Room.databaseBuilder(this, UserDataBase::class.java, Constans.USER_DATABASE)
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    private lateinit var userEntity: UserEntity
    private var userID = 0
    private var defualtname = ""
    private var defualtage = 0
    private var defualtphone = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intent.extras?.let {
            userID = it.getInt(Constans.BUNDLE_USER_ID)
        }
        binding.apply {
            defualtname = userDB.userdao().getuser(userID).userName
            defualtage = userDB.userdao().getuser(userID).userAge
            defualtphone = userDB.userdao().getuser(userID).Phonenumber
            nameEdittext.setText(defualtname)
            AgeText.setText(defualtage.toString())

         //delete
            deleteBtn.setOnClickListener {
                userEntity = UserEntity(userID , defualtname , defualtage , defualtphone)
                userDB.userdao().deleteuser(userEntity)
                finish()
            }
            updateBtn.setOnClickListener {
                val name = nameEdittext.text.toString()
                val age = AgeText.text.toString()
                val phone = phoneText.text.toString()

                if (name.isNotEmpty() || age.isNotEmpty()) {
                    userEntity = UserEntity(userID , name , age.toInt() , phone.toInt())
                    userDB.userdao().userupdate(userEntity)
                    finish()
                }else{
                    Snackbar.make(it , "name and age and Phone can not empty" , Snackbar.LENGTH_SHORT).show()
                }
            }
        }
    }
}