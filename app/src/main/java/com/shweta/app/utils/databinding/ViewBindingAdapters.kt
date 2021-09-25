package com.shweta.app.utils.databinding

import android.graphics.drawable.Drawable
import android.net.Uri
import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.core.view.isGone
import androidx.core.view.isInvisible
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.request.RequestOptions
import com.shweta.app.R

/**
 * Set view's visibility gone.
 * @param isGone true to make view gone
 */
@BindingAdapter("showUnlessGone")
fun showUnlessGone(view: View, isGone: Boolean) {
    view.isGone = isGone
}

/**
 * Set view's visibility invisible.
 * @param isInvisible true to make view invisible
 */
@BindingAdapter("showUnlessInvisible")
fun showUnlessInvisible(view: View, isInvisible: Boolean) {
    view.isInvisible = isInvisible
}

/**
 * Load image into [imageView] from the [imageUri].
 */
@BindingAdapter(value = ["imageUri", "placeholder", "isCircle"], requireAll = false)
fun imageUri(imageView: ImageView, imageUri: Uri?, placeholder: Drawable?, isCircle: Boolean = false) {
    val requestBuilder = Glide.with(imageView.context).load(imageUri)
    if(isCircle) {
        requestBuilder.apply(
            RequestOptions().transform(CenterCrop()).circleCrop().placeholder(placeholder)
                .diskCacheStrategy(DiskCacheStrategy.DATA)).into(imageView)
    }
    requestBuilder.into(imageView)
}

/**
 * Load image into [imageView] from the [imageUrl].
 */
@BindingAdapter(value = ["imageUrl", "placeholder", "isCircle"], requireAll = false)
fun imageUrl(imageView: ImageView, imageUrl: String?, placeholder: Drawable?, isCircle: Boolean = false) {
    imageUri(imageView, imageUrl?.toUri(), placeholder, isCircle)
}
