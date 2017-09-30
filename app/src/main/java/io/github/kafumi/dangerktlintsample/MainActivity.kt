package io.github.kafumi.dangerktlintsample

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.format.DateFormat
import kotlinx.android.synthetic.main.activity_main.*
import java.util.Date

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()

        registerReceiver(timeTicker, IntentFilter(Intent.ACTION_TIME_TICK))
        updateDisplayTime()
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(timeTicker)
    }

    private fun updateDisplayTime() {
        timeText.text=DateFormat.getTimeFormat(this).format(Date())
    }

    private val timeTicker = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            if (intent.action == Intent.ACTION_TIME_TICK) {
                updateDisplayTime();
            }
        }
    }
}
