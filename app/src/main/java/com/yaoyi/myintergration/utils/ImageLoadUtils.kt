package com.yaoyi.myintergration.utils

//import com.bumptech.glide.load.engine.DiskCacheStrategy
import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.yaoyi.myintergration.R

/**
 * Created by c on 2018/1/24.
 */
class ImageLoadUtils {
    companion object{
        fun display(context: Context, imageView: ImageView?, url: String) {
            if (imageView == null) {
                throw IllegalArgumentException("argument error")
            }
            val options =  RequestOptions()
            options.diskCacheStrategy(DiskCacheStrategy.ALL)
                    .error(R.drawable.ic_empty_picture)
                    .centerCrop()
                    .placeholder(R.drawable.ic_image_loading)


//            Glide.with(context)
//                    //加载url
//                    .load(url)
//                    //缓存策略
//                    .diskCacheStrategy(DiskCacheStrategy.ALL)
//                    //居中裁剪
//                    .centerCrop()
//                    //用 ic_image_loading 占位符来替代
//                    .placeholder(R.drawable.ic_image_loading)
//                    //错误使用 ic_empty_picture替代
//                    .error(R.drawable.ic_empty_picture)
//                    //使用阴影
//                    .crossFade()
//                    .into(imageView)

            Glide.with(context)
                    //加载url
                    .load(url)
                    .apply(options)
                    //使用阴影
                    .transition( DrawableTransitionOptions().crossFade())
                    .into(imageView)



        }
        fun displayHigh(context: Context, imageView: ImageView?, url: String){
            if (imageView == null) {
                throw IllegalArgumentException("argument error")
            }
            val options =  RequestOptions()
            options.diskCacheStrategy(DiskCacheStrategy.ALL)
                    .error(R.drawable.ic_empty_picture)
                    .centerCrop()
                    .placeholder(R.drawable.ic_image_loading)
                    .format(DecodeFormat.PREFER_ARGB_8888)

//            Glide.with(context)
//                    //加载url
//                    .load(url)
//                    //作为bitmap
//                    .asBitmap()
//                    //解码格式设置
//                    .format(DecodeFormat.PREFER_ARGB_8888)
//                    //缓存策略
//                    .diskCacheStrategy(DiskCacheStrategy.ALL)
//                    //居中裁剪
//                    .centerCrop()
//                    //用 ic_image_loading 占位符来替代
//                    .placeholder(R.drawable.ic_image_loading)
//                    //错误使用 ic_empty_picture替代
//                    .error(R.drawable.ic_empty_picture)
//                    .into(imageView)
            Glide.with(context)
                    .asBitmap()
                    .load(url)
                    .apply(options)
                    .into(imageView)
        }
    }
}