package com.example.mytravelguide.Activity

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.androdocs.populatelistview.CustomAdapter
import com.example.mytravelguide.Model.City
import com.example.mytravelguide.R
import org.json.JSONArray
import java.io.InputStream


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        jsonReaderFunction()
        val toast: Toast = Toast.makeText(applicationContext,"Click on Image to know more about city",Toast.LENGTH_LONG)
        val view = toast.view
        view.setBackgroundColor(Color.CYAN)
        toast.show()
    }

    fun jsonReaderFunction() {
        val cityView = findViewById<ListView>(R.id.listView)
        val cityList = ArrayList<City>()



        try {
            val inputStream: InputStream = assets.open("cities_json.json")
            var cityArray = JSONArray(inputStream.bufferedReader().use { it.readText() })

            for (i in 0 until cityArray.length()) {
                val singleUser = cityArray.getJSONObject(i)
                val city= singleUser.getString("city")
                val hotel = singleUser.getString("hotel")
                val state = singleUser.getString("state")
                val description = singleUser.getString("description")
                val weather = singleUser.getString("weather")
                val image = singleUser.getString("image")
                val places = singleUser.getJSONArray("places")
                val placeList = ArrayList<String>()
                for (i in 0..places.length() - 1) {
                    placeList.add(places.getString(i))
                }
                val imageId= resources.getIdentifier(image, "drawable", packageName)

                cityList.add(
                        City(
                                city,
                                hotel,
                                description,
                                weather,
                                state,
                                imageId,
                                placeList
                        )
                )
            }

            cityView.adapter = CustomAdapter(this@MainActivity, cityList)
        } catch (ex: Exception) {
            Log.d("Look Here", ex.toString())
            Toast.makeText(this, "Error occured: ${ex.toString()}", Toast.LENGTH_LONG).show()
        }
    }

}
