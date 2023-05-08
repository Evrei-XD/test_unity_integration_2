package com.example.appforunityintegration2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.appforunityintegration2.databinding.ActivityMainBinding
import com.unity3d.player.UnityPlayerActivity

class MainActivity : AppCompatActivity() {
    private var threadFlag = false
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView (it.root) }

        binding.startThreadBtn.setOnClickListener {
            threadFlag = !threadFlag
            startTread()
        }

        binding.openUnityAppBtn.setOnClickListener {
            openUnityActivity()
        }
    }

    private fun openUnityActivity() {
        val i = Intent(this, UnityPlayerActivity::class.java)
        startActivity(i)
        finish()
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














