package com.cognizant.proficiencyassignment.helper

import android.view.View

class Utility {
    companion object{
        fun showProgressBar(view: View) {
            view?.visibility = View.VISIBLE
        }

        fun hideProgressBar(view: View) {
            if (view?.visibility == View.VISIBLE)
                view?.visibility = View.GONE
        }
    }
}