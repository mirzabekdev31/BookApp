package uz.gita.mirzabek.example.bookapp.di

import android.content.Context
import com.readystatesoftware.chuck.ChuckInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.gita.mirzabek.example.bookapp.data.remote.api.BookApi
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @[Provides Singleton]
    fun getOkHTTPClient(@ApplicationContext context: Context): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(ChuckInterceptor(context))
        .build()


    @[Provides Singleton]
    fun getRetrofit(client: OkHttpClient):Retrofit=Retrofit.Builder()
        .baseUrl("http://143.198.48.222:82")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    fun getBookApi(retrofit: Retrofit):BookApi=retrofit.create(BookApi::class.java)

}
