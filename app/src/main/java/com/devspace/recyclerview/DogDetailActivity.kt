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

        val name = intent.getStringExtra("name")
        val breed = intent.getStringExtra("breed")
        val icon = intent.getIntExtra("icon", R.drawable.cocker)

        tvName.text = name
        tvBreed.text = breed
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