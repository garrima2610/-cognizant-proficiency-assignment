package com.cognizant.proficiencyassignment.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cognizant.proficiencyassignment.R
import com.cognizant.proficiencyassignment.adapter.CountryListAdapter
import com.cognizant.proficiencyassignment.helper.Utility
import com.cognizant.proficiencyassignment.model.BaseModel
import com.cognizant.proficiencyassignment.viewmodel.CountryViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class CountryDetailListFragment : Fragment() {
    private val productListModel: CountryViewModel by viewModel()
    private lateinit var progressBar: ProgressBar
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_country_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        getCountryList()
    }

    private fun initViews(){
        progressBar = view?.findViewById(R.id.progress_circular)!!
        recyclerView = view?.findViewById(R.id.recyclerView)!!
    }

    private fun getCountryList(){
        recyclerView!!.layoutManager = LinearLayoutManager(view!!.context, RecyclerView.VERTICAL, false)
        Utility.showProgressBar(progressBar)
        productListModel.getProducts()
        productListModel.listOfProducts.observe(this, Observer(function = fun(list: BaseModel?) {
            Utility.hideProgressBar(progressBar)
            list?.let {
                var productListAdapter: CountryListAdapter = CountryListAdapter(list.rows, activity)
                recyclerView.adapter = productListAdapter
            }
        }))
    }
}
