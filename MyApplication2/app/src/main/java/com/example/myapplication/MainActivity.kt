package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import com.apollographql.apollo.ApolloCall
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Input
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.exception.ApolloException
//import com.apollographql.apollo.ApolloCall
//import com.apollographql.apollo.ApolloClient
//import com.apollographql.apollo.api.Response
//import com.apollographql.apollo.exception.ApolloException
import com.example.myapplication.ui.main.MainFragment
import graphql.apollo.*
import graphql.apollo.type.ViewModelLogin
import graphql.apollo.type.ViewModelUploadFile
import graphql.apollo.type.ViewModelUserInput
//import graphql.apollo.GetContinentsQuery
import okhttp3.OkHttpClient
import org.jetbrains.annotations.NotNull


class MainActivity : AppCompatActivity() {

    private val BASE_URL = "http://ec2-3-210-210-169.compute-1.amazonaws.com:5000/graphql"
    private lateinit var client: ApolloClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
       client = setUpApolloClient()
        var data : LoginQuery.Login?
        var model = ViewModelLogin("PAssword.123","agalanaw2" )


        client.newBuilder().build().query(
            LoginQuery(model)
        ).enqueue(object : ApolloCall.Callback<LoginQuery.Data>(){
            override fun onFailure(e: ApolloException) {
                //data = e
            }

            override fun onResponse(response: Response<LoginQuery.Data>) {
                data = response.data?.login
            }

        })

        // poner breakpoint para verificar que datos contiene data, en data debe estar lo que definieron en la query para visualizar
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow()
        }
    }

    /**
     * Basic set up for graphql API, OkHttp is used for graphql with apollo client
     */
    private fun setUpApolloClient(): ApolloClient {

        val okHttp = OkHttpClient
            .Builder()
        return ApolloClient.builder()
            .serverUrl(BASE_URL)
            .okHttpClient(okHttp.build())
            .build()
    }
}
