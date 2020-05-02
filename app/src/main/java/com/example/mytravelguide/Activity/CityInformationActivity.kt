package com.example.mytravelguide.Activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.mytravelguide.Communicator.FragmentCommunicator
import com.example.mytravelguide.Fragment.DescriptionFragment
import com.example.mytravelguide.Fragment.ImageFragment
import com.example.mytravelguide.Fragment.ShareCityDetailsFragment
import com.example.mytravelguide.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class CityInformationActivity : AppCompatActivity(), FragmentCommunicator {
    var bundle = Bundle()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_citi_information)
        val bottomNavigation: BottomNavigationView = findViewById(R.id.navigationView)
        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
//        setSupportActionBar(toolbar)
        if (savedInstanceState == null) {
            bottomNavigation.selectedItemId = R.id.navigationImage
            val imageFragment = ImageFragment()
            bundle = intent.extras!!
            imageFragment.arguments = bundle
            openFragment(imageFragment)
        }
    }



    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {
        when (it.itemId) {

           R.id.navigationDescription -> {
                val descriptionFragment =
                    DescriptionFragment()
               descriptionFragment.arguments = bundle;
               openFragment(descriptionFragment)
                return@OnNavigationItemSelectedListener true
            }

            R.id.navigationImage -> {
                val imageFragment =
                    ImageFragment()
                imageFragment.arguments = bundle;
                openFragment(imageFragment)
                return@OnNavigationItemSelectedListener true
            }

            R.id.navigationBack -> {
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigationSharing -> {
                val shareCityDetailsFragment = ShareCityDetailsFragment()
                shareCityDetailsFragment.arguments = bundle
                openFragment(shareCityDetailsFragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameContainer, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
    fun setUpToolbar() {
        // Hide action bar
        val actionBar = supportActionBar
        actionBar!!.hide()
    }

    override fun passData(editTextInput: String, fragName: String) {
    }
}
