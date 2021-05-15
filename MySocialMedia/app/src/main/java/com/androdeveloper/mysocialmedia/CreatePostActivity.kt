package com.androdeveloper.mysocialmedia

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.androdeveloper.mysocialmedia.daos.PostDao
import com.androdeveloper.mysocialmedia.databinding.ActivityCreatePostBinding

class CreatePostActivity : AppCompatActivity() {
    lateinit var binding:ActivityCreatePostBinding
    lateinit var postDao: PostDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreatePostBinding.inflate(layoutInflater)
        setContentView(binding.root)
        postDao = PostDao()
        binding.buttonPost.setOnClickListener {
            val inputPost = binding.inputText.text.toString().trim()
            if (inputPost.isNotEmpty()){
                postDao.addPosts(inputPost)
                finish()
            }
        }


    }
}