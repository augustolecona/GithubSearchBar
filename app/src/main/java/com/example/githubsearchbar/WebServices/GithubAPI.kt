package com.example.githubsearchbar.WebServices

import com.example.githubsearchbar.models.Proyecto
import com.google.gson.annotations.SerializedName
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import java.io.Serializable
import java.util.*


interface GithubAPI {


    @GET("search/repositories")
    fun getProyectos( @Query("q", encoded = false) query: String? ): Observable<items>
}


class items: Serializable {

    @SerializedName("items")
    var items: ArrayList<Proyecto> = arrayListOf()
    private set

}
