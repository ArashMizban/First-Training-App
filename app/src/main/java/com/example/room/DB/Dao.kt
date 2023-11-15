package com.example.room.DB

import android.provider.SyncStateContract.Constants
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.room.Utils.Constans

@Dao
interface Dao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertuser (user : UserEntity)

    @Update
    fun userupdate (user: UserEntity)

    @Delete
    fun deleteuser (user: UserEntity)

    @Query( "SELECT * FROM ${Constans.USER_TABLE} ORDER BY userId DESC")
    fun getalluser() : MutableList<UserEntity>

    @Query( "SELECT * FROM ${Constans.USER_TABLE} where userId Like:id")
    fun getuser(id: Int):UserEntity

    @Query("DELETE FROM ${Constans.USER_TABLE}")
    fun getdeletealluser()
}