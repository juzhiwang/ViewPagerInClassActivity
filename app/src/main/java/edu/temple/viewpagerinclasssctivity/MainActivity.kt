package edu.temple.viewpagerinclasssctivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {
    private var numberOfPages = 0
    private var currentNumber = 1

    private val newButton: Button by lazy {
        findViewById(R.id.newButton)
    }

    private val textViewNumber: TextView by lazy {
        findViewById(R.id.textView_number)
    }

    private val viewPager: ViewPager2 by lazy {
        findViewById(R.id.textView_number)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        newButton.setOnClickListener {
            currentNumber++
            textViewNumber.text = currentNumber.toString()

            numberOfPages++
            viewPager.adapter?.notifyItemInserted(numberOfPages)
        }

        viewPager.adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount() = numberOfPages

            override fun createFragment(position: Int) = TextFragment.newInstance(position.toString())
        }

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                currentNumber = position + 2
                textViewNumber.text = currentNumber.toString()
            }
        })
    }
}

