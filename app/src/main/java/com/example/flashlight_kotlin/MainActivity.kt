package com.example.flashlight_kotlin

import android.content.Context
import android.hardware.camera2.CameraManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import android.widget.ToggleButton

class MainActivity : AppCompatActivity() {


    lateinit var toggleButton: ToggleButton
    lateinit var touchStatus: TextView
    lateinit var cameraManager: CameraManager
    lateinit var cameraId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toggleButton = findViewById(R.id.idBtnSwitch)
        touchStatus = findViewById(R.id.idTVTorchStatus)

        cameraManager = getSystemService(Context.CAMERA_SERVICE) as CameraManager

        cameraId = cameraManager.cameraIdList[0]

        toggleButton.setOnClickListener {
            try {
                if (toggleButton.isChecked) {
                    cameraManager.setTorchMode(cameraId, true)
                    Toast.makeText(this@MainActivity, "Torch turned on..", Toast.LENGTH_LONG)
                        .show()

                    touchStatus.setText("ON")
                } else {
                    cameraId = cameraManager.cameraIdList[0]
                    cameraManager.setTorchMode(cameraId, false)
                    Toast.makeText(this@MainActivity, "Torch turned off..", Toast.LENGTH_LONG)
                        .show()
                    // toggleButton.isChecked
                    touchStatus.setText("OFF")
            }


            }catch (e : Exception){
                Toast.makeText(this@MainActivity, "Torch Light Not Available" + e, Toast.LENGTH_LONG)

            }
        }
    }
}