package com.example.mytravelguide.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.mytravelguide.R


/**
 * A simple [Fragment] subclass.
 * Use the [descriptionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DescriptionFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                          savedInstanceState: Bundle?): View? {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_description_layout, container, false)
}
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments
        view.findViewById<TextView>(R.id.descriptionText).text = arguments?.getString("description")
        view.findViewById<TextView>(R.id.hotelText).text = arguments?.getString("hotel")
        view.findViewById<TextView>(R.id.weatherText).text = arguments?.getString("weather")
        view.findViewById<TextView>(R.id.stateText).text = arguments?.getString("state")

    }

}
