package com.example.projetandroid4a.presentation.main

sealed class LoginStatus

data class LoginSuccess(val pseudo: String, val passwd: String) : LoginStatus()
object LoginError : LoginStatus()