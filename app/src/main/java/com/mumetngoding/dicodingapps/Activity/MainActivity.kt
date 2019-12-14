
package com.mumetngoding.dicodingapps.Activity

import android.content.Intent
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import com.mumetngoding.dicodingapps.Adapter.MovieAdapter
import com.mumetngoding.dicodingapps.Model.MovieModel
import com.mumetngoding.dicodingapps.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var adapter : MovieAdapter

    private lateinit var dataDescription: Array<String>
    private lateinit var dataPhoto: TypedArray
    private lateinit var movies: ArrayList<MovieModel>
    private lateinit var dataTitle: Array<String>
    private lateinit var dataLeaguage: Array<String>
    private lateinit var dataStatus: Array<String>
    private lateinit var dataRuntime: Array<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        prep()

        adapter = MovieAdapter(this, addItem())
        lv_list.adapter = adapter

        lv_list.onItemClickListener =
            AdapterView.OnItemClickListener { _, _, position, _->
                val listDataMovie =
                    MovieModel(0, "", "", "", "")
                listDataMovie.name = dataTitle[position]
                listDataMovie.photo = dataPhoto.getResourceId(position, position)
                listDataMovie.description = dataDescription[position]
                listDataMovie.status = dataStatus[position]
                listDataMovie.leaguage = dataLeaguage[position]
                listDataMovie.runtime = dataRuntime[position]

                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra(DetailActivity.EXTRA_DATA, listDataMovie)

                this@MainActivity.startActivity(intent)
            }


    }

    private fun addItem() : ArrayList<MovieModel> {

        movies = ArrayList()
        for (i in dataTitle.indices) {
            val movie = MovieModel()
            movie.photo = dataPhoto.getResourceId(i, -1)
            movie.name = dataTitle[i]
            movie.description = dataDescription[i]
            movies.add(movie)
        }

        return movies
    }

    private fun prep() {
        dataTitle = resources.getStringArray(R.array.data_title_movie)
        dataDescription = resources.getStringArray(R.array.data_description)
        dataPhoto = resources.obtainTypedArray(R.array.data_image_movie)
        dataLeaguage = resources.getStringArray(R.array.data_leaguage)
        dataStatus = resources.getStringArray(R.array.status)
        dataRuntime = resources.getStringArray(R.array.runtime)
    }
}