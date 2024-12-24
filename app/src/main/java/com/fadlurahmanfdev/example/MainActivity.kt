package com.fadlurahmanfdev.example

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.fadlurahmanfdev.example.data.ExampleModel
import com.fadlurahmanfdev.local_storage.FeatureSharedPreference

class MainActivity : AppCompatActivity() {
    lateinit var featureSharedPreference: FeatureSharedPreference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        featureSharedPreference = FeatureSharedPreference(applicationContext)

        featureSharedPreference.saveString("EXAMPLE_KEY_STRING_1", "example value string")
        val exampleString = featureSharedPreference.getString("EXAMPLE_KEY_STRING_1", null)
        Log.d(this::class.java.simpleName, "example saved string: $exampleString")

        val exampleString2 = featureSharedPreference.getString("EXAMPLE_KEY_STRING_2", "default value example string 2")
        Log.d(this::class.java.simpleName, "example saved string 2: $exampleString2")

        featureSharedPreference.saveInt("EXAMPLE_KEY_INT_1", 100)
        val exampleInt = featureSharedPreference.getInt("EXAMPLE_KEY_INT_1", -1)
        Log.d(this::class.java.simpleName, "example saved int: $exampleInt")

        val exampleInt2 = featureSharedPreference.getInt("EXAMPLE_KEY_INT_2", -1)
        Log.d(this::class.java.simpleName, "example saved int 2: $exampleInt2")


        featureSharedPreference.saveFloat("EXAMPLE_KEY_INT_1", 0.04f)
        val exampleFloat = featureSharedPreference.getFloat("EXAMPLE_KEY_FLOAT_1", -1.0f)
        Log.d(this::class.java.simpleName, "example saved float: $exampleFloat")

        val exampleFloat2 = featureSharedPreference.getFloat("EXAMPLE_KEY_FLOAT_2", -1.0f)
        Log.d(this::class.java.simpleName, "example saved float 2: $exampleFloat2")

        featureSharedPreference.saveObjectSerialization("EXAMPLE_KEY_OBJECT_1", ExampleModel(
            testString = "test string value",
            testInt = 100,
            testLong = 200L,
            testFloat = 0.04f,
        ), ExampleModel.serializer())
        val exampleObject = featureSharedPreference.getObjectSerialization("EXAMPLE_KEY_OBJECT_1", ExampleModel.serializer())
        Log.d(this::class.java.simpleName, "example saved object: $exampleObject")
    }
}