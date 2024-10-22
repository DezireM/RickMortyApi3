package com.example.rickmortyapi.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.rickmortyapi.ui.fragment.character.CharacterFragment
import com.example.rickmortyapi.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, CharacterFragment())
                .commit()
        }
    }
}