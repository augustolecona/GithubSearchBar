package com.example.githubsearchbar.view

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.example.githubsearchbar.models.Proyecto
import com.example.githubsearchbar.R
import kotlinx.android.synthetic.main.activity_proyect_view.*
import java.lang.Exception

class ProyectView : AppCompatActivity() {




    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_proyect_view)
        var proyecto: Proyecto? = null
        try{
         proyecto = intent.getSerializableExtra("proyect") as Proyecto
        }
        catch (e:Exception){
            Log.e("#ERROR", e.message)
        }

        if (proyecto!= null) {
            if (proyecto.owner!!.avatarUrl!=null)Glide.with(this).load(proyecto.owner!!.avatarUrl).into(userprofile)
            if (proyecto.owner!!.login!=null)   username.text = "User: ${proyecto.owner!!.login}"
            if (proyecto.name!=null)            proyectname.text = "Proyect: ${proyecto.name}"
            if (proyecto.forksCount!=null)      forks.text = "Forks: ${proyecto.forksCount.toString()}"
            if (proyecto.stargazersCount!=null) stars.text = "Stars: ${proyecto.stargazersCount.toString()}"
            if (proyecto.description!=null)     proyectDes.text = "About: ${proyecto.description}"
            if (proyecto.url!= null)             url.text = "Proyect repository: ${proyecto.url}"
        }




    }
}