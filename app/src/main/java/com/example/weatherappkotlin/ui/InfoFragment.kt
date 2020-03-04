package com.example.weatherappkotlin.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.weatherappkotlin.R
import kotlinx.android.synthetic.main.fragment_info.*

/**
 * A simple [Fragment] subclass.
 */
class InfoFragment : Fragment() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        ic_close.setOnClickListener({
            val fm = activity?.supportFragmentManager
            val transaction = fm?.beginTransaction()
            transaction?.remove(this)
            transaction?.commit()
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_info, container, false)
    }


}
