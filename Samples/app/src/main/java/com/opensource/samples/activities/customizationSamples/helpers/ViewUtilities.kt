package com.opensource.samples.activities.customizationSamples.helpers

import android.content.Context
import android.view.LayoutInflater
import android.widget.Toast
import com.opensource.samples.databinding.ToastLayoutBinding

object ViewUtilities {

    fun showToast(context: Context, message: String) {
        val view = ToastLayoutBinding.inflate(LayoutInflater.from(context))
        view.toastDescriptionTv.text = message

        val toast = Toast(context)
        toast.duration = Toast.LENGTH_LONG
        toast.view = view.root
        toast.show()
    }
}