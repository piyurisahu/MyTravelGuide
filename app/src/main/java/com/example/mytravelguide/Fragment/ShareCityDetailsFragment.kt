package com.example.mytravelguide.Fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.mytravelguide.R

/**
 * A simple [Fragment] subclass.
 * Use the [ShareCityDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShareCityDetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_share_place_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val button = view.findViewById<Button>(R.id.sendButton)
        view.findViewById<TextView>(R.id.cityDescription).text = arguments?.getString("description")

        button.setOnClickListener {
            val emailText = view.findViewById<EditText>(R.id.emailText)
            val subjectText = view.findViewById<EditText>(R.id.subjectEditText)
            val messageEditText = view.findViewById<TextView>(R.id.cityDescription)
            val emailIntent = Intent(Intent.ACTION_SEND)
            emailIntent.action = Intent.ACTION_SEND

            emailIntent.data = Uri.parse("mailto:")
            emailIntent.type = "text/plain"
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, subjectText.text.toString())
            emailIntent.putExtra(Intent.EXTRA_EMAIL, emailText.text.toString())
            emailIntent.putExtra(Intent.EXTRA_TEXT, messageEditText.text.toString())

            startActivity(Intent.createChooser(emailIntent, "Choose email program"))
        }
    }


}
