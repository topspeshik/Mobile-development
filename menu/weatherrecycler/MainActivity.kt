package com.example.weatherrecycler

import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.english -> switchLanguage("en")
            R.id.russian -> switchLanguage("ru")
        }
        return true
    }

    fun switchLanguage(lang:String){
        val locale = Locale(lang)
        Locale.setDefault(locale)
        val config = resources.configuration
        config.setLocale(locale)
//        baseContext.applicationContext.createConfigurationContext(config)
//        baseContext.resources.displayMetrics.setTo(resources.displayMetrics)
        resources.updateConfiguration(config, resources.displayMetrics)
        this.recreate()
    }
}