package com.devspace.recyclerview

import android.content.Context
import android.graphics.PorterDuffColorFilter
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.graphics.PorterDuff
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class DogDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dog_detail)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tvName = findViewById<TextView>(R.id.tv_name)
        val tvBreed = findViewById<TextView>(R.id.tv_breed)
        val image = findViewById<ImageView>(R.id.image)
        val tvAge = findViewById<TextView>(R.id.tv_age)
        val tvWeight = findViewById<TextView>(R.id.tv_weight)
        val tvGender = findViewById<TextView>(R.id.tv_gender)
        val tvVaccine = findViewById<TextView>(R.id.tv_vaccine)
        val tvGoodKids = findViewById<TextView>(R.id.tv_kids)
        val tvGoodDogs = findViewById<TextView>(R.id.tv_dog)
        val tvBio = findViewById<TextView>(R.id.tv_bio)

        val name = intent.getStringExtra("name")
        val breed = intent.getStringExtra("breed")
        val age = intent.getStringExtra("age")
        val weight = intent.getStringExtra("weight")
        val gender = intent.getStringExtra("gender")
        val vaccine = intent.getStringExtra("vaccine")
        val goodKids = intent.getStringExtra("goodKids")
        val goodDogs = intent.getStringExtra("goodKids")
        val bio = intent.getStringExtra("bio")
        val icon = intent.getIntExtra("icon", R.drawable.cocker)

        tvName.text = name
        tvBreed.text = breed
        tvAge.text = age
        tvWeight.text = weight
        tvGender.text = gender
        tvVaccine.text = vaccine
        tvGoodDogs.text = goodDogs
        tvGoodKids.text = goodKids
        tvBio.text = bio
        image.setImageResource(icon)

        val heartIcon = findViewById<ImageView>(R.id.img_favorite)
        var isLiked = false

        heartIcon.setOnClickListener {
            isLiked = !isLiked

            val color = if (isLiked) R.color.red else R.color.gray
            heartIcon.setColorFilter(ContextCompat.getColor(this, color), PorterDuff.Mode.SRC_IN)
        }

    }
}