package uz.gita.mirzabek.example.bookapp.data.remote

import com.readystatesoftware.chuck.ChuckInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.gita.mirzabek.example.bookapp.app.App

//object ApiClient {
//
//
//    private val myClient = OkHttpClient.Builder()
//        .addInterceptor(ChuckInterceptor(App.instance))
//        .build()
//
//    val retrofit = Retrofit.Builder()
//        .baseUrl("http://143.198.48.222:82")
//        .client(myClient)
//        .addConverterFactory(GsonConverterFactory.create())
//        .build()
//}