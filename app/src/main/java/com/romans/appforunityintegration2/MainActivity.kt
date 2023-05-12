package com.romans.appforunityintegration2

import android.app.Activity
import android.content.*
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.appforunityintegration2.databinding.ActivityMainBinding
import com.romans.myunitylibrary.*
import com.romans.testlibrary.TestLibrary
import com.unity3d.player.UnityPlayerActivity


class MainActivity : AppCompatActivity() {
    private var threadFlag = false
    private lateinit var binding: ActivityMainBinding
    lateinit var myLibrary : TestPlugin
    lateinit var myLibrary2 : TestLibrary
    private var iterator = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView (it.root) }
        myLibrary = TestPlugin()
        myLibrary2 = TestLibrary()

        binding.startThreadBtn.setOnClickListener {
            threadFlag = !threadFlag
            startTread()
//            myLibrary.testVariable2 = 4
//            AlertCallback.onPositive("lol")
//            PluginActivity
//            Toast.makeText(this, ""+loadInt("TEST_SAVE"), Toast.LENGTH_SHORT).show()

//            iterator += 1
//            saveInt("TEST_SAVE", iterator, this)
//            Toast.makeText(this, ""+iterator, Toast.LENGTH_SHORT).show()


//            dataWriter()
//            Toast.makeText(this, "WRITE Hello! this is shared data", Toast.LENGTH_SHORT).show()
        }

        binding.openUnityAppBtn.setOnClickListener {
            openUnityActivity()
        }

//        val intentFilter = IntentFilter()
//        intentFilter.addAction("Sum")
//
//        val receiver: BroadcastReceiver = object : BroadcastReceiver() {
//            override fun onReceive(context: Context, intent: Intent) {
//                if (intent.action == "Sum") {
//                    binding.textView.text = intent.getIntExtra("sum", 0).toString()
//                }
//            }
//        }
//        registerReceiver(receiver, intentFilter)

        binding.startServiceBtn.setOnClickListener {
//            startService(Intent(this@MainActivity, SumService::class.java).putExtra("length", 10))
//            myLibrary2.receiverStart(this)
//            myLibrary.setContext(this)
//            myLibrary.receiverStart()
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
                startService(Intent(this@MainActivity, SumService::class.java).putExtra("length", 10))
                Thread.sleep(2000)
            }
        }.start()
    }
}














