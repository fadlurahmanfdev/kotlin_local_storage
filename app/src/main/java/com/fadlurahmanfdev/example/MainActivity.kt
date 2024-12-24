package com.fadlurahmanfdev.example

import android.os.Bundle
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
        featureSharedPreference.saveObjectSerialization("asa", ExampleModel(test = "1"), ExampleModel.serializer())
    }
}