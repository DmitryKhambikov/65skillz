package com.dkhambikov.android_j0

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dkhambikov.android_j0.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var abTitle: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            val contactListFragment = ContactListFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentLayout, contactListFragment).commit()
        } else{ abTitle = savedInstanceState.getBoolean(KEY_TITLE) }
        if(abTitle){
            supportActionBar?.title = "Детали контактов"
        }
        else {
            supportActionBar?.title = "Список контактов"
        }


    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean(KEY_TITLE, abTitle)
    }
    companion object{
        @JvmStatic private val KEY_TITLE = "TITLE"
    }
}