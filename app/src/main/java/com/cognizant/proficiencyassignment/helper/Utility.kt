package com.cognizant.proficiencyassignment.helper

import android.view.View

/**
 * Utility class to define genric funtionality to be used in the entire project
 */
class Utility {
    companion object{
        /**
         * Makes progress circular bar visible while loading list items
         */
        fun showProgressBar(view: View) {
            view?.visibility = View.VISIBLE
        }

        /**
         * hides progress circular bar after list items are loaded
         */
        fun hideProgressBar(view: View) {
            if (view?.visibility == View.VISIBLE)
                view?.visibility = View.GONE
        }
    }
}