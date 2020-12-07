package com.codingwithmitch.kotlinrecyclerviewexample

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var blogAdapter: BlogRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        recycler_view.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            val topSpacingDecorator = CustomSpacingItemDecoration(30)
            addItemDecoration(topSpacingDecorator)
            blogAdapter =
                BlogRecyclerAdapter(DataSource.createDataSet()) { blogPost, imageView, titleView, authorView ->
                    val detailIntent = Intent(context, DetailActivity::class.java)
                    detailIntent.putExtra(DetailActivity.DATA, blogPost)
                    val imageViewPair =
                        androidx.core.util.Pair<View, String>(imageView, "image_transition")
                    val titleViewPair =
                        androidx.core.util.Pair<View, String>(titleView, "title_transition")
                    val authorViewPair =
                        androidx.core.util.Pair<View, String>(authorView, "author_transition")
                    val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                        this@MainActivity,
                        imageViewPair, titleViewPair, authorViewPair
                    )
                    startActivity(detailIntent, options.toBundle())
                }
            adapter = blogAdapter
        }
    }
}
