package com.example.rr.mvvmkotlin.app

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.rr.mvvmkotlin.app.databinding.ArticleItemBinding

class ArticleAdapter(val mArticles: List<Article>, val mContext: Context) : RecyclerView.Adapter<ArticleAdapter.BindingHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingHolder =
        BindingHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.article_item, parent, false))

    override fun onBindViewHolder(holder: BindingHolder, position: Int) {
        val binding: ArticleItemBinding = holder.binding
        binding.avm = ArticleViewModel(mArticles[position], mContext)
    }

    override fun getItemCount(): Int = mArticles.size

    class BindingHolder(val binding: ArticleItemBinding) : RecyclerView.ViewHolder(binding.contactCard)

}