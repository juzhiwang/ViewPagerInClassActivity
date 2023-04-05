package edu.temple.viewpagerinclasssctivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize the TextFragment with a parameter
        val textFragment = TextFragment.newInstance("Your parameter here")

        // Add the TextFragment to the container in the activity's layout
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, textFragment)
            commit()
        }
    }
}
