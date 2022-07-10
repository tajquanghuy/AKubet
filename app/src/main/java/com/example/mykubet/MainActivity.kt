package com.example.mykubet

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intent = Intent(this, HomeActivity::class.java)
        findViewById<Button>(R.id.btnHome).setOnClickListener {
            intent.putExtra( KEY_INTENT, 1)
            startActivity(intent)
        }
        findViewById<Button>(R.id.btnSupport).setOnClickListener {
            intent.putExtra( KEY_INTENT, 2)
            startActivity(intent)
        }
        findViewById<Button>(R.id.btnRegister).setOnClickListener {
            intent.putExtra( KEY_INTENT, 3)
            startActivity(intent)
        }
    }

    companion object{
        const val KEY_INTENT = "KEY_INTENT"
        const val KEY_HOME = 1
        const val KEY_SUPPORT = 2
        const val KEY_REGISTER = 3
    }
}