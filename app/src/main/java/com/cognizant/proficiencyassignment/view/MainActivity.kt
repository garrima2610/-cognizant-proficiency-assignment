package com.cognizant.proficiencyassignment.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cognizant.proficiencyassignment.R
import com.cognizant.proficiencyassignment.viewmodel.CountryViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val productListModel: CountryViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(R.id.frag_container, CountryDetailListFragment()).commit()
    }
}