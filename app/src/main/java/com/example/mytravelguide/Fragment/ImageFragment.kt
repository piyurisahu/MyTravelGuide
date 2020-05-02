package com.example.mytravelguide.Fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.mytravelguide.R

/**
 * A simple [Fragment] subclass.
 * Use the [ImageFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ImageFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_image_layout, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val city = arguments?.getString("city")
        val image = arguments?.getInt("image")
        val cityImage = view.findViewById<ImageView>(R.id.cityImage)
        cityImage.setImageResource(image!!)

        val heading = view.findViewById<TextView>(R.id.placesToVisitLabel)
        heading.text = "Places to visit in $city"

        val arrayOfPlaces = getArray(city)
        val placeView = view.findViewById<ListView>(R.id.placesToVisitList)
        placeView.adapter = context?.let { ArrayAdapter<String>(it, android.R.layout.simple_list_item_activated_1, arrayOfPlaces) }


    }


    private fun getArray(city: String?): Array<String> {
        if(city.equals("Kansas City"))
        {
            return resources.getStringArray(R.array.kansasCityArray)
        }
        if(city.equals("Philadelphia"))
        {
            return resources.getStringArray(R.array.bostonArray)
        }
        if(city.equals("Boston"))
        {
            return resources.getStringArray(R.array.bostonArray)
        }
        if(city.equals("Chicago"))
        {
            return resources.getStringArray(R.array.chicagoArray)
        }
        if(city.equals("Warrensburg"))
        {
            return resources.getStringArray(R.array.warrensburgArray)
        }
        if(city.equals("New York"))
        {
            return resources.getStringArray(R.array.warrensburgArray)
        }
        if(city.equals("Los Angeles"))
        {
            return resources.getStringArray(R.array.warrensburgArray)
        }
        return resources.getStringArray(R.array.noPlaceArray)
    }


}
