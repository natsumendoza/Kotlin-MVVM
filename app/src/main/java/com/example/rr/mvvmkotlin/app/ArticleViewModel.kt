package com.example.rr.mvvmkotlin.app

import android.content.Context
import android.databinding.BaseObservable
import android.databinding.Bindable
import android.databinding.BindingAdapter
import android.graphics.Color
import android.support.v4.content.ContextCompat
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide

class ArticleViewModel(val mArticle: Article, val mContext: Context) : BaseObservable() {

    @Bindable
    fun getTitle(): String = mArticle.title

    fun setTitle(title: String): Unit {
        mArticle.title = title
        notifyPropertyChanged(BR.title)
    }

    fun getCardBackgroundColor(): Int =
            if (mArticle.highlight)
                ContextCompat.getColor(mContext, R.color.highlight)
            else
                Color.parseColor("#ffffff")

    fun getCommentsButtonVisibility(): Int = if (mArticle.commentsNumber == 0) View.GONE else View.VISIBLE

    fun getCommentsNumber(): Int = mArticle.commentsNumber

    fun getExcerpt(): String = mArticle.excerpt

    fun getImageUrl(): String = mArticle.imageUrl

    companion object {
        @BindingAdapter("image")
        @JvmStatic
        fun loadImage(view: ImageView, url: String) {
            Glide.with(view.context).load(url).centerCrop().into(view)
        }
    }

    fun setRead(read: Boolean): Unit {
        if (read && !mArticle.read) {
            setTitle("READ: ${getTitle()}")
        }
        mArticle.read = read
    }

    fun onReadMoreClicked(): View.OnClickListener =
            View.OnClickListener { v ->
                Toast.makeText(v.context, "Opens article detail", Toast.LENGTH_SHORT).show()
                setRead(true)
            }

    fun onCommentsClicked(): View.OnClickListener =
            View.OnClickListener { v ->
                Toast.makeText(v.context, "Opens comments detail", Toast.LENGTH_SHORT).show()
            }

}