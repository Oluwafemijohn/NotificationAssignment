package com.example.notification

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import kotlinx.android.synthetic.main.activity_second.*

class MainActivity : AppCompatActivity() {


    lateinit var moveToNextActivity: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var message:TextView
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        moveToNextActivity = findViewById(R.id.moveToNextActivity)
      var btn = findViewById<Button>(R.id.SendNotification)

        btn.setOnClickListener{
            showNotification("Femi" ,"Good")
        }


        var intent = Intent(this, SecondActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        moveToNextActivity.setOnClickListener{
            sendMessage()
        }


    }

    fun showNotification(title: String, message: String) {
        val mNotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            val channel = NotificationChannel("YOUR_CHANNEL_ID",
                    "YOUR_CHANNEL_NAME",
                    NotificationManager.IMPORTANCE_DEFAULT)
            channel.description = "YOUR_NOTIFICATION_CHANNEL_DESCRIPTION"
            mNotificationManager.createNotificationChannel(channel)
        }
        val mBuilder = NotificationCompat.Builder(applicationContext, "YOUR_CHANNEL_ID")
                .setSmallIcon(R.mipmap.ic_launcher) // notification icon
                .setContentTitle(title) // title for notification
                .setContentText(message)// message for notification
                .setAutoCancel(true) // clear notification after click
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("data","Active");
        val pi = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
        mBuilder.setContentIntent(pi)
        mNotificationManager.notify(0, mBuilder.build())
    }

    private fun sendMessage() {
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
    }




}
