package com.devspace.recyclerview

import android.content.Intent
import android.os.Bundle
import android.util.Log
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

        adapter.setOnClickListener { dogs ->
            val intent = Intent(this, DogDetailActivity::class.java)
            //Passando os valores para a proxima tela
            intent.putExtra("name", dogs.name)
            intent.putExtra("breed", dogs.breed)
            intent.putExtra("icon", dogs.icon)
            intent.putExtra("age", dogs.age)
            intent.putExtra("gender", dogs.gender)
            intent.putExtra("weight", dogs.weight)
            intent.putExtra("vaccine", dogs.vaccine)
            intent.putExtra("goodKids", dogs.goodKids)
            intent.putExtra("goodDogs", dogs.goodDogs)
            intent.putExtra("bio", dogs.bio)

            startActivity(intent)
        }

    }
}

private val dogs = listOf(
    Dogs(
        "Tico",
        "Pug",
        "3 years old",
        "MALE",
        "13 KG",
        "YES",
        "NO",
        "YES",
        "Tico is a friendly and curious dog with a playful spirit and a calm temperament. He enjoys long walks, cuddling on the couch, and learning new tricks. Tico gets along well with children and other dogs, making him an ideal family companion. He’s house-trained, vaccinated, and responds well to basic commands. Tico is happiest when he’s around people and part of the action, but he also appreciates quiet moments and a good nap in a sunny spot.",
        R.drawable.pug
    ),
    Dogs(
        "Luna",
        "Golden Retriever",
        "3 years old",
        "MALE",
        "13 KG",
        "NO",
        "YES",
        "YES",
        "Luna is a calm and loyal dog. He enjoys running in open spaces and is known for being easy to train. Luna gets along well with children and other dogs, making daily life full of joy. He may not be vaccinated, but he is full of personality and charm.",
        R.drawable.golden
    ),
    Dogs(
        "Bolt",
        "Husky Siberiano",
        "2 years old",
        "MALE",
        "38 KG",
        "NO",
        "NO",
        "NO",
        "Bolt is a playful and gentle dog. He enjoys playing with toys and is known for loving attention. Bolt may need more time with kids and other dogs, but his energy and personality shine through.",
        R.drawable.husky
    ),
    Dogs(
        "Maya",
        "Beagle",
        "1 years old",
        "FEMALE",
        "35 KG",
        "YES",
        "YES",
        "NO",
        "Maya is a energetic and clever dog. She enjoys playing with toys and is known for being great on walks. Maya gets along well with children and brings joy to any household. She’s vaccinated and playful.",
        R.drawable.beagle
    ),
    Dogs(
        "Rex",
        "Pastor Alemão",
        "4 years old",
        "MALE",
        "25 KG",
        "NO",
        "YES",
        "YES",
        "Rex is a curious and clever dog. He enjoys playing with toys and is known for loving attention. Rex is great with kids and other pets, a true guardian with a big heart.",
        R.drawable.pastor_alemao
    ),
    Dogs(
        "Nina",
        "Shih Tzu",
        "6 years old",
        "FEMALE",
        "40 KG",
        "NO",
        "YES",
        "NO",
        "Nina is a curious and loyal dog. She enjoys playing with toys and is known for having a big heart. Although she’s not vaccinated, her love and companionship are unmatched.",
        R.drawable.shitzu
    ),
    Dogs(
        "Ziggy",
        "Yorkshire Terrier",
        "5 years old",
        "MALE",
        "6 KG",
        "YES",
        "YES",
        "YES",
        "Ziggy is a playful and clever dog. He enjoys cuddling on the couch and is known for loving attention. Ziggy is great with kids and other dogs, making him a perfect companion for both active and relaxed homes. He’s house-trained, vaccinated, and always eager to be near his people.",
        R.drawable.yorkshire
    ),
    Dogs(
        "Mel",
        "Labrador Retriever",
        "4 years old",
        "MALE",
        "40 KG",
        "YES",
        "YES",
        "YES",
        "Mel is a affectionate and loyal dog. He enjoys running in open spaces and is known for being easy to train. Mel gets along well with children and other pets. Vaccinated, but always charming.",
        R.drawable.labrador
    ),
    Dogs(
        "Thor",
        "Rottweiler",
        "6 years old",
        "MALE",
        "40 KG",
        "YES",
        "NO",
        "YES",
        "Thor is a affectionate and clever dog. He enjoys playing with toys and is known for loving attention. Thor needs a quieter home with children and other pets. Vaccinated, but always charming.",
        R.drawable.rottweiler
    ),
    Dogs(
        "Bela",
        "Bulldog Inglês",
        "3 years old",
        "MALE",
        "31 KG",
        "YES",
        "YES",
        "NO",
        "Bela is a calm and clever dog. He enjoys running in open spaces and is known for being great on walks. Bela gets along well with children and other pets. Vaccinated, but always charming.",
        R.drawable.buldog
    ),
    Dogs(
        "Pipoca",
        "Dálmata",
        "2 years old",
        "FEMALE",
        "28 KG",
        "NO",
        "NO",
        "NO",
        "Pipoca is a affectionate and friendly dog. She enjoys napping in sunny spots and is known for having a big heart. Pipoca needs a quieter home with children and other pets. Not yet vaccinated, but always charming.",
        R.drawable.dalmata
    ),

    Dogs(
        "Bruce",
        "Boxer",
        "3 years old",
        "FEMALE",
        "10 KG",
        "NO",
        "YES",
        "NO",
        "Bruce is a affectionate and clever dog. She enjoys cuddling on the couch and is known for loving attention. Bruce gets along well with children and other pets. Not yet vaccinated, but always charming.",
        R.drawable.boxer
    ),
    Dogs(
        "Lola",
        "Pinscher Miniatura",
        "3 years old",
        "FEMALE",
        "19 KG",
        "NO",
        "NO",
        "NO",
        "Lola is a energetic and friendly dog. She enjoys playing with toys and is known for having a big heart. Lola needs a quieter home with children and other pets. Not yet vaccinated, but always charming.",
        R.drawable.pinscher
    ),
    Dogs(
        "Scooby",
        "Doberman",
        "1 years old",
        "MALE",
        "24 KG",
        "NO",
        "NO",
        "NO",
        "Scooby is a affectionate and friendly dog. He enjoys playing with toys and is known for loving attention. Scooby needs a quieter home with children and other pets. Not yet vaccinated, but always charming.",
        R.drawable.doberman
    ),
    Dogs(
        "Amora",
        "Cocker Spaniel",
        "2 years old",
        "FEMALE",
        "40 KG",
        "NO",
        "YES",
        "NO",
        "Amora is a affectionate and clever dog. She enjoys cuddling on the couch and is known for loving attention. Amora gets along well with children and other pets. Not yet vaccinated, but always charming.",
        R.drawable.cocker
    ),
    Dogs(
        "Fred",
        "Akita Inu",
        "2 years old",
        "FEMALE",
        "30 KG",
        "YES",
        "NO",
        "YES",
        "Fred is a energetic and loyal dog. She enjoys napping in sunny spots and is known for having a big heart. Fred needs a quieter home with children and other pets. Vaccinated, but always charming.",
        R.drawable.akita
    ),
    Dogs(
        "Pandora",
        "Maltês",
        "7 years old",
        "MALE",
        "34 KG",
        "NO",
        "NO",
        "NO",
        "Pandora is a playful and gentle dog. He enjoys napping in sunny spots and is known for having a big heart. Pandora needs a quieter home with children and other pets. Not yet vaccinated, but always charming.",
        R.drawable.maltes
    ),
    Dogs(
        "Theo",
        "Chihuahua",
        "6 years old",
        "FEMALE",
        "27 KG",
        "NO",
        "YES",
        "NO",
        "Theo is a affectionate and loyal dog. She enjoys cuddling on the couch and is known for loving attention. Theo gets along well with children and other pets. Not yet vaccinated, but always charming.",
        R.drawable.chihuahua
    ),
    Dogs(
        "Cacau",
        "Border Collie",
        "7 years old",
        "FEMALE",
        "33 KG",
        "NO",
        "YES",
        "NO",
        "Cacau is a calm and loyal dog. She enjoys cuddling on the couch and is known for being easy to train. Cacau gets along well with children and other pets. Not yet vaccinated, but always charming.",
        R.drawable.border
    ),

    Dogs(
        "Jade",
        "Poodle",
        "3 years old",
        "MALE",
        "7 KG",
        "YES",
        "YES",
        "YES",
        "Jade is a curious and friendly dog. He enjoys running in open spaces and is known for loving attention. Jade gets along well with children and other pets. Vaccinated, but always charming.",
        R.drawable.poodle
    )
)