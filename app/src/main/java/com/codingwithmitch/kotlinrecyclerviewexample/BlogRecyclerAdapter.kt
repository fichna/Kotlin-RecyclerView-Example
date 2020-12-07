package com.codingwithmitch.kotlinrecyclerviewexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.codingwithmitch.kotlinrecyclerviewexample.models.BlogPost
import kotlinx.android.synthetic.main.layout_blog_list_item.view.*

class BlogRecyclerAdapter(
    private val items: List<BlogPost>,
    private val onTap: (blogPost: BlogPost, imageView: ImageView) -> Unit
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_blog_list_item, parent, false)
        return BlogViewHolder(view, onTap)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is BlogViewHolder -> {
                holder.bind(items[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class BlogViewHolder(itemView: View, private val onTap: (blogPost: BlogPost, imageView: ImageView) -> Unit) :
        RecyclerView.ViewHolder(itemView) {

        private val blogCard: CardView = itemView.card
        private val blogImage: ImageView = itemView.blogImage
        private val blogTitle: TextView = itemView.blogTitle
        private val blogAuthor: TextView = itemView.blogAuthor

        fun bind(blogPost: BlogPost) {
            blogCard.setOnClickListener {
                onTap(blogPost, blogImage)
            }
            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(blogPost.image)
                .into(blogImage)
            blogTitle.text = blogPost.title
            blogAuthor.text = blogPost.username
        }
    }
}
