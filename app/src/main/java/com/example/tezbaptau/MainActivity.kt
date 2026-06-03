package com.example.tezbaptau

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Авиарежим баптауын ашу (Wi-Fi + мобильді интернетті бірден өшіреді)
        findViewById<Button>(R.id.btnAirplane).setOnClickListener {
            openSettings(Settings.ACTION_AIRPLANE_MODE_SETTINGS)
        }

        // Локация (GPS) баптауын ашу
        findViewById<Button>(R.id.btnLocation).setOnClickListener {
            openSettings(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
        }

        // Wi-Fi баптауын ашу
        findViewById<Button>(R.id.btnWifi).setOnClickListener {
            openSettings(Settings.ACTION_WIFI_SETTINGS)
        }
    }

    private fun openSettings(action: String) {
        try {
            startActivity(Intent(action).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK
            })
        } catch (e: Exception) {
            Toast.makeText(this, "Бұл бетті ашу мүмкін болмады", Toast.LENGTH_SHORT).show()
        }
    }
}
