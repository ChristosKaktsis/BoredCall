package com.example.boredcall.network

data class BoredActivity(
    val activity: String,
    val accessibility: Double,
    val type: String,
    val participants:Int,
    val price:Double,
    val link:String,
    val key: String
) {
}