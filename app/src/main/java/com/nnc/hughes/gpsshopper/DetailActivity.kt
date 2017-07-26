package com.nnc.hughes.gpsshopper

import android.content.Context
import android.content.Intent
import kotlinx.android.synthetic.main.activity_detail.*
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.nnc.hughes.gpsshopper.Models.Roster
import android.widget.TextView
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {


    lateinit var player: Roster
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        player = intent.getParcelableExtra("player")
        name.text = player.name
        position.text = player.position
        Picasso.with(this).load(player.imageUrl).into(imageView)
    }
}
