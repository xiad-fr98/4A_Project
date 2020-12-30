package com.example.projetandroid4a.presentation.main

sealed class LoginStatus

data class LoginSuccess(val email: String, val pwd: String) : LoginStatus()
object LoginError : LoginStatus()