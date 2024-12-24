package com.fadlurahmanfdev.example.data

import kotlinx.serialization.Serializable

@Serializable
data class ExampleModel(
    val testString:String,
    val testInt:Int,
    val testLong:Long,
    val testFloat:Float,
)
