package com.opensource.samples.activities.customizationSamples.helpers

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.opensource.samples.R
import com.opensource.samples.databinding.ProductLayoutBinding

class ProductAdapter(products: List<Product>, context: Context):
    ArrayAdapter<Product>(context, R.layout.product_layout, products) {

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val binding = if (convertView == null) {
                ProductLayoutBinding.inflate(LayoutInflater.from(context), parent, false)
            } else {
                ProductLayoutBinding.bind(convertView)
            }

            // Fetch product data for the given position
            val product = getItem(position)

            // Populate the view
            if (product != null) {
                binding.productName.text = product.title
                binding.productPrice.text = product.price.toString()
                binding.productDescription.text = product.description
                binding.productIv.setImageResource(R.drawable.ice_laptop_mac)
                binding.productStatusIv.setImageResource(R.drawable.ic_discount)
            } // Assuming 'name' is a property of your product object

            return binding.root
        }

}