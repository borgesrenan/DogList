package com.devspace.recyclerview

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Create data class
        //Create list from data class type
        //Create Adapter
        //Set Adapter
        //Linear Layout Manager

        val rvList = findViewById<RecyclerView>(R.id.rv_list)
        val adapter = DogsListAdapter()
        val ivList = findViewById<ImageView>(R.id.iv_list)
        val ivGrid = findViewById<ImageView>(R.id.iv_grid)

        rvList.adapter = adapter
        //Ordem que os items serao mostrados
        rvList.layoutManager = LinearLayoutManager(this)
        //Aqui a lista e submetida
        adapter.submitList(dogs)

        ivGrid.setOnClickListener {
            rvList.layoutManager = GridLayoutManager(this, 2)
        }

        ivList.setOnClickListener {
            rvList.layoutManager = LinearLayoutManager(this)
        }
    }
}

private val dogs = listOf(
    Dogs("Tico", "Pug", R.drawable.pug),
    Dogs("Luna", "Golden Retriever", R.drawable.golden),
    Dogs("Bolt", "Husky Siberiano", R.drawable.husky),
    Dogs("Maya", "Beagle", R.drawable.beagle),
    Dogs("Rex", "Pastor Alemão", R.drawable.pastor_alemao),
    Dogs("Nina", "Shih Tzu", R.drawable.shitzu),
    Dogs("Ziggy", "Yorkshire Terrier", R.drawable.yorkshire),
    Dogs("Mel", "Labrador Retriever", R.drawable.labrador),
    Dogs("Thor", "Rottweiler", R.drawable.rottweiler),
    Dogs("Bela", "Bulldog Inglês", R.drawable.buldog),
    Dogs("Pipoca", "Dálmata", R.drawable.dalmata),
    Dogs("Bruce", "Boxer", R.drawable.boxer),
    Dogs("Lola", "Pinscher Miniatura", R.drawable.pinscher),
    Dogs("Scooby", "Doberman", R.drawable.doberman),
    Dogs("Amora", "Cocker Spaniel", R.drawable.cocker),
    Dogs("Fred", "Akita Inu", R.drawable.akita),
    Dogs("Pandora", "Maltês", R.drawable.maltes),
    Dogs("Theo", "Chihuahua", R.drawable.chihuahua),
    Dogs("Cacau", "Border Collie", R.drawable.border),
    Dogs("Jade", "Poodle", R.drawable.poodle)
)