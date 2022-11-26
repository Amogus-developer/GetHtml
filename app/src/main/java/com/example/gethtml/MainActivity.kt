package com.example.news10

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.gethtml.R
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import java.io.IOException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        getHtml()
    }
    fun main(str: String){
        val threed = Thread {
            val textHtml = findViewById<TextView>(R.id.textHtml)
            val button = findViewById<ImageView>(R.id.Button)
            var doc: Document? = null
            try {
                doc = Jsoup.connect(str).get()
            } catch (e: IOException) {
                e.printStackTrace()
            }
            val html = doc!!.html()
            button.setOnClickListener {
                textHtml.setText(html.toString())
            }
        }
        threed.start()
    }
    fun getHtml(){
        val textHtmlPut = findViewById<TextView>(R.id.textHtmlPut)
        val button = findViewById<ImageView>(R.id.Button)
        button.setOnClickListener {
            val str = textHtmlPut.text.toString()
            main(str)
        }
    }
}
