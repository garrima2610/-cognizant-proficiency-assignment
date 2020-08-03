package com.cognizant.proficiencyassignment.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cognizant.proficiencyassignment.R
import com.cognizant.proficiencyassignment.model.Rows

class CountryListAdapter(
    private val productList: List<Rows>,
    context: Context?
) :
    RecyclerView.Adapter<CountryListAdapter.ViewHolder>() {
    private var onItemClickListener: ItemClickListener? = null
    private lateinit var mContext: Context

    init {
        context?.let {
            mContext = it
        }
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val v =
            LayoutInflater.from(p0?.context).inflate(R.layout.item_recycler_country_list, p0, false)
        return ViewHolder(v);
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        if (productList[position].title != null) {
            viewHolder.tv_title.visibility = View.VISIBLE
            viewHolder.tv_title?.text = productList[position].title
        } else {
            viewHolder.tv_title.visibility = View.GONE
        }

        if (productList[position].description != null) {
            viewHolder.tv_description.visibility = View.VISIBLE
            viewHolder.tv_description?.text = productList[position].description
        } else {
            viewHolder.tv_description.visibility = View.GONE
        }

        if (productList[position].imageHref != null) {
            viewHolder.iv_image.visibility = View.VISIBLE
            Glide.with(mContext)
                .load(productList[position].imageHref)
                .placeholder(R.drawable.ic_launcher_background)
                .into(viewHolder.iv_image)
        } else {
            viewHolder.iv_image.visibility = View.GONE
        }

        if (productList[position].imageHref == null
            && productList[position].description == null
            && productList[position].title == null
        ) {
            viewHolder.horizontal_view.visibility = View.GONE
        } else {
            viewHolder.horizontal_view.visibility = View.VISIBLE
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tv_title = itemView.findViewById<TextView>(R.id.tv_title)
        val tv_description = itemView.findViewById<TextView>(R.id.tv_description)
        val iv_image = itemView.findViewById<ImageView>(R.id.iv_image)
        val horizontal_view = itemView.findViewById<View>(R.id.horizontal_view)
    }


    fun setItemClickListener(clickListener: ItemClickListener) {
        onItemClickListener = clickListener
    }

    interface ItemClickListener {
        fun onItemClick(view: View, position: Int)
    }
}