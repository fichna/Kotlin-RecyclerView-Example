package com.codingwithmitch.kotlinrecyclerviewexample

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.codingwithmitch.kotlinrecyclerviewexample.models.BlogPost
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    companion object {
        const val DATA = "data"
    }

    private var blogPost: BlogPost? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        blogPost = intent.extras?.get(DATA) as? BlogPost
        initDetail()
    }

    private fun initDetail() {
        blogPost?.also {
            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
            Glide.with(this)
                .applyDefaultRequestOptions(requestOptions)
                .load(it.image)
                .into(blogImage)
            blogTitle.text = it.title
            blogAuthor.text = it.username
            blogContent.text = it.body
        }
    }
}