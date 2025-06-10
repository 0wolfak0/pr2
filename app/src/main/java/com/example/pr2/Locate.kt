package com.example.pr2

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.tasks.OnSuccessListener

class Locate : AppCompatActivity() {

    private lateinit var fusedLocationClient: FusedLocationProviderClient

    // Define the permission request launcher
    private val requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {
                // Permission granted, now get the location
                getLocation()
            } else {
                // Permission denied
                Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_locate)

        // Handle system bar insets for edge-to-edge layout
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize the FusedLocationProviderClient
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        // Button to trigger location retrieval
        val locationButton: Button = findViewById(R.id.locationButton)
        locationButton.setOnClickListener {
            // Check if the location permission is granted
            if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                // Get location if permission is granted
                getLocation()
            } else {
                // Request the permission if not granted
                requestPermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
            }
        }
    }

    // Function to get the current location
    private fun getLocation() {
        fusedLocationClient.lastLocation
            .addOnSuccessListener(this, OnSuccessListener { location ->
                if (location != null) {
                    // Location found, display or use it
                    val latitude = location.latitude
                    val longitude = location.longitude
                    Toast.makeText(this, "Location: $latitude, $longitude", Toast.LENGTH_LONG).show()
                } else {
                    // Location is null, could not fetch
                    Toast.makeText(this, "Location not available", Toast.LENGTH_SHORT).show()
                }
            })
    }
}
