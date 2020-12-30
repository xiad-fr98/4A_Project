package com.example.projetandroid4a.data.local.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.projetandroid4a.domain.entity.User

@Entity
data class UserLocal(
    @ColumnInfo(name = "email") val email: String,
    @ColumnInfo(name = "pwd") val pwd: String
){
    @PrimaryKey(autoGenerate = true) var uid: Int? = null
}

fun UserLocal.toEntity(): User {
    return User(
        email = email,
        pwd = pwd
    )
}


fun User.toData() : UserLocal{
    return UserLocal(
        email = email,
        pwd = pwd
    )
}
