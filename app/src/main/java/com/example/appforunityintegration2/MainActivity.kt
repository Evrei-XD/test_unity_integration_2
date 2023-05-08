package com.example.appforunityintegration2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appforunityintegration2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var threadFlag = false
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView (it.root) }

        binding.startThreadBtn.setOnClickListener {
            threadFlag = !threadFlag
            startTread()
        }
    }

    private fun startTread() {
        Thread {
            while (threadFlag) {
                System.err.println("Tread")
                //TODO делать что-то из библиотеки
                Thread.sleep(1000)
            }
        }.start()
    }
}