package com.example.maps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val kronggahan = LatLng(-7.596030, 110.428610)
        mMap.addMarker(MarkerOptions().position(kronggahan).title("Kost Putra Sleman"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(kronggahan,17.0f))

        mMap.addMarker(MarkerOptions()
            .position(LatLng(-7.812480,110.363110))
            .title("alun alun yogyakarta")
            .rotation(3.5.toFloat())
        )
        mMap.addMarker(MarkerOptions()
            .position(LatLng(-7.774810, 110.383990))
            .title("Universitas Teknologi Yogyakarta")
        )
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is
            menuInflater.inflate(R.menu.maps_action, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here.
        val id = item.getItemId()

        if (id == R.id.normal_maps) {
            mMap.mapType = GoogleMap.MAP_TYPE_NORMAL
            return true
        }

        if (id == R.id.satellite_maps) {
            mMap.mapType = GoogleMap.MAP_TYPE_SATELLITE
            return true
        }
        if (id == R.id.terrain_maps) {
            mMap.mapType = GoogleMap.MAP_TYPE_TERRAIN
            return true
        }

        return super.onOptionsItemSelected(item)

    }




}
