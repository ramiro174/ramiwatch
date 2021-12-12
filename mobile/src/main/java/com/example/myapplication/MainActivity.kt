package com.example.ram2

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.myapplication.R
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.wearable.Node


class MainActivity : AppCompatActivity() {
    private lateinit var client: GoogleApiClient
    private var connectedNode: List<Node>? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.createNotificationChannel();
    }

    private fun createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = getString(R.string.channel_name)
            val descriptionText = getString(R.string.channel_description)
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel("CHANNEL_ID", name, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    public fun mandarNotificacion(desu:android.view.View)
    {
        var notif = NotificationCompat.Builder(this, "CHANNEL_ID")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("NOTIFICACIÓN")
            .setContentText("Esto es una notificación")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT).build();

        var notificationManagerCompat = NotificationManagerCompat.from(this);
        notificationManagerCompat.notify("",11 ,notif );

    }
}