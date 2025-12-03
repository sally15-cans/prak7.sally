package com.sally.prak7sally

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import androidx.recyclerview.widget.LinearLayoutManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

import com.sally.prak7sally.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root) // Pass binding.root instead of R.layout.activity_main


        binding.recyclerBooks.layoutManager = LinearLayoutManager(this)

        RetrofitClient.instance.getBooks().enqueue(object : Callback<List<Book>> {
            override fun onResponse(call: Call<List<Book>>, response: Response<List<Book>>) {

                val books = response.body() ?: emptyList()


                binding.recyclerBooks.adapter = BookAdapter(books) { book ->
                    val i = Intent(this@MainActivity, DetailActivity::class.java)
                    i.putExtra("title", book.title)
                    i.putExtra("date", book.releaseDate)
                    i.putExtra("cover", book.cover)
                    i.putExtra("desc", book.description)
                    startActivity(i)
                }
            }

            override fun onFailure(call: Call<List<Book>>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }
}
