package com.mumetngoding.dicodingapps.Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mumetngoding.dicodingapps.Model.MovieModel
import com.mumetngoding.dicodingapps.R
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val listMovie : MovieModel = intent.getParcelableExtra(EXTRA_DATA)

        tv_judul.text = listMovie.name
        tv_status.text = listMovie.status
        tv_bahasa.text = listMovie.leaguage
        tv_detail.text = listMovie.description
        tv_runtime.text = listMovie.runtime
        iv_poster.setImageResource(listMovie.photo!!)

    }

    companion object{
        var EXTRA_DATA = "0"
    }
}