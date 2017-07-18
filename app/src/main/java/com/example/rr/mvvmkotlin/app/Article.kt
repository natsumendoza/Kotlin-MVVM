package com.example.rr.mvvmkotlin.app

/**
 * Created by Jay-Ar Gabriel on 7/18/2017.
 */
data class Article (
        var title: String,
        var excerpt: String,
        var highlight: Boolean,
        var imageUrl: String,
        var commentsNumber: Int,
        var read: Boolean = true)