package com.sally.prak7sally

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.bumptech.glide.Glide

import com.sally.prak7sally.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {


    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityDetailBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val title = intent.getStringExtra("title")
        val date = intent.getStringExtra("date")
        val cover = intent.getStringExtra("cover")
        val desc = intent.getStringExtra("desc")


        binding.txtDetailTitle.text = title
        binding.txtDetailDate.text = date
        binding.txtDetailDesc.text = desc

        Glide.with(this)
            .load(cover ?: "")
            .into(binding.imgDetail)



    }
}
