package com.codingwithmitch.kotlinrecyclerviewexample

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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
            blogAdapter = BlogRecyclerAdapter(DataSource.createDataSet()) { blogPost, imageView ->
                val detailIntent = Intent(context, DetailActivity::class.java)
                detailIntent.putExtra(DetailActivity.DATA, blogPost)

                startActivity(detailIntent)
/*                val imageViewPair =
                    androidx.core.util.Pair<View, String>(imageView, "YourTransitionName")
                val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    this@MainActivity,
                    imageViewPair
                )

                startActivity(detailIntent, options.toBundle())*/
            }
            adapter = blogAdapter
        }
    }
}
