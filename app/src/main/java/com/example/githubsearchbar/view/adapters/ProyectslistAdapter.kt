package com.example.githubsearchbar.view.adapters

import android.content.Context
import android.database.Cursor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.githubsearchbar.database.DatabaseHelper
import com.example.githubsearchbar.models.Proyecto
import com.example.githubsearchbar.R
import kotlinx.android.synthetic.main.proyectoview.view.*


class ProyectslistAdapter(
    val context: Context,
    val items: List<Proyecto>,
    val dataBaseHelper: DatabaseHelper
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var onItemClick: ((Proyecto) -> Unit)? = null

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.proyectoview, parent, false)
        )

    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        (holder as ViewHolder).bind(items[position], context)
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(proyectos: Proyecto, context: Context) {
            itemView.UserName.text = proyectos.owner!!.login
            Glide.with(context).load(proyectos.owner!!.avatarUrl).into(itemView.UserImage)
            itemView.reponame.text = proyectos.name.toString()



            val getProyect: Cursor = dataBaseHelper.existsProyectosFav(proyectos.id)!!
            //val proyecto = Proyecto()
            var proyect_exists = false

            while (getProyect.moveToNext()) {
                proyect_exists =   getProyect.getInt(0) >0
            }

            getProyect.close()
            if (proyect_exists)  itemView.other.setImageResource(R.drawable.favorite)
            else  itemView.other.setImageResource(R.drawable.addfav)

            itemView.other.setOnClickListener{

                val InsertUser: Boolean = dataBaseHelper.SaveProject(proyectos)
                if (InsertUser) {
                    itemView.other.setImageResource(R.drawable.favorite)
                } else {
                    //toastMessage("Soemthing went wrong")
                }
            }

        }

        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(items[adapterPosition])
            }
        }
    }

}

