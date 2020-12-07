package com.codingwithmitch.kotlinrecyclerviewexample.models

import java.io.Serializable

data class BlogPost(
    var title: String,
    var body: String,
    var image: String,
    var username: String
) : Serializable {
    override fun toString(): String {
        return "BlogPost(title='$title', image='$image', username='$username')"
    }
}
























