package com.si.navi.here

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.here.sdk.core.GeoCoordinates
import com.here.sdk.mapview.MapError
import com.here.sdk.mapview.MapScene
import com.here.sdk.mapview.MapScheme
import com.here.sdk.mapview.MapView

class MainActivity : AppCompatActivity() {

    private lateinit var mapView: MapView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mapView = findViewById(R.id.map_view)
        mapView.onCreate(savedInstanceState)

        mapView.setOnReadyListener {  }
        mapView.mapScene.loadScene(MapScheme.GREY_DAY, object: MapScene.LoadSceneCallback {
            override fun onLoadScene(error: MapError?) {
                if (error == null) {
                    mapView.camera.lookAt(GeoCoordinates(52.530932, 13.384915), (1000 * 10.0))
                }
            }
        })
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }

}