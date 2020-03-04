package com.example.weatherappkotlin.ui


import android.opengl.Visibility
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.weatherappkotlin.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import kotlinx.android.synthetic.main.fragment_info.*
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment(), OnMapReadyCallback {

    private lateinit var googleMap: GoogleMap
    override fun onMapReady(map: GoogleMap?) {
        if (map != null) {
            googleMap = map
        }
        googleMap.setOnMapClickListener {
            val infoFragment = InfoFragment()
            val fm = activity?.supportFragmentManager
            val transaction = fm?.beginTransaction()
            transaction?.add(R.id.main_fragment_layout, infoFragment)
            transaction?.commit()

            btn_add.hide()
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        gmap.onCreate(savedInstanceState)
        gmap.onResume()
        gmap.getMapAsync(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)

    }

}
