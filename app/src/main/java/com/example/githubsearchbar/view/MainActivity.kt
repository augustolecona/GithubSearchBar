package com.example.githubsearchbar.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.githubsearchbar.DynamicView
import com.example.githubsearchbar.R
import com.example.githubsearchbar.WebServices.NetworkHelper.createGitHubAPI
import com.example.githubsearchbar.database.DatabaseHelper
import com.example.githubsearchbar.models.Proyecto
import com.example.githubsearchbar.view.adapters.ProyectslistAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketException
import java.net.UnknownHostException


class MainActivity : AppCompatActivity() {

    private val Disposable= ArrayList<Disposable>()
    private var counter= 0
    lateinit var recycleView: RecyclerView
    var proyectos = ArrayList<Proyecto>()
    lateinit var adapter: ProyectslistAdapter
    lateinit var textView: TextView
    lateinit var progressbarlayout: View
    lateinit var searchView: SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        castViews()
        var dataBaseHelper =
            DatabaseHelper(this)
        adapter = ProyectslistAdapter(
            this,
            proyectos,
            dataBaseHelper
        )
        recycleView.adapter = adapter


        adapter.onItemClick = { proyect ->
            val intent = Intent(this, ProyectView::class.java)
            intent.putExtra("proyect", proyect)
            startActivity(intent)
        }


        RxJavaPlugins.setErrorHandler { throwable ->
            throwable.printStackTrace()
            progressbarlayout.visibility = View.INVISIBLE
            showError(throwable)

        }

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                progressbarlayout.visibility = View.VISIBLE
                getProyectos(query)
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                //   adapter.getFilter().filter(newText)
                if (newText!!.length >= 3) {
                    // searchView.visibility = View.INVISIBLE
                    progressbarlayout.visibility = View.VISIBLE
                    getProyectos(newText)
                }
                else{
                    for (dis in Disposable) {
                        dis.dispose()
                    }
                    progressbarlayout.visibility = View.INVISIBLE
                    proyectos.clear()
                    adapter.notifyDataSetChanged()

                }
                return false
            }

        })

    }

    private fun castViews() {
        textView = findViewById(R.id.textView)
        recycleView = findViewById<RecyclerView>(R.id.recyclerView)
        recycleView.setHasFixedSize(true)
        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        recycleView.setLayoutManager(linearLayoutManager)

        progressbarlayout = findViewById(R.id.llProgressBar)
        searchView = findViewById(R.id.searchView)
    }

    private fun getProyectos(query: String?) {
        for (dis in Disposable) {
            dis.dispose()
        }

        var obs = createGitHubAPI().getProyectos(query)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError {
                var t = 0
            }
            .doOnNext { data ->

                try {
                    if (data.items.isEmpty()) Toast.makeText(
                        this,
                        "No results for $query",
                        Toast.LENGTH_LONG
                    ).show()

                    proyectos.clear()
                    proyectos.addAll(data.items)
                    adapter.notifyDataSetChanged()

                    //    searchView.visibility = View.VISIBLE
                    progressbarlayout.visibility = View.INVISIBLE
                } catch (e: Exception) {
                    //    searchView.visibility = View.VISIBLE
                    progressbarlayout.visibility = View.INVISIBLE
                    Log.e("#ERROR", e.message)
                }
            }

        .subscribe()

        Disposable.add(obs)

    }

    private fun showError(throwable: Throwable) {
        if (throwable is HttpException) {

            val code = (throwable as HttpException).code().toString()
            when (code) {
                "403" -> {
                    Toast.makeText(
                        this,
                        "You have reached the limit of intents.. please try again in a couple of minutes ",
                        Toast.LENGTH_LONG
                    ).show()
                }
                "404" -> {
                    Toast.makeText(
                        this,
                        "We can't find that page ",
                        Toast.LENGTH_LONG
                    ).show()
                }
                "409" -> {

                }
                "400, 422" -> {
                    Toast.makeText(
                        this,
                        "There's something wrong  with your search",
                        Toast.LENGTH_LONG
                    ).show()
                }

                else -> {

                }
            }
        } else {
            if (throwable is ConnectException || throwable is SocketException || throwable is UnknownHostException) {
                Toast.makeText(
                    this,
                    "There's a problem with the network. Please verify your network ",
                    Toast.LENGTH_LONG
                ).show()

            } else {
                Toast.makeText(
                    this,
                    "Something went wrong =( ",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.dynamicview -> {
                val intent = Intent(this, DynamicView::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


}