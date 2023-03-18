package uz.gita.mirzabek.example.bookapp.data.local.pref

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppPreferences @Inject constructor(@ApplicationContext context: Context) {
    private  var pref: SharedPreferences= context.getSharedPreferences("MY_PREF", Context.MODE_PRIVATE)

    var startScreen: String
        set(value) = pref.edit().putString("START_SCREEN", value).apply()
        get() = pref.getString("START_SCREEN", "LOGIN")!!

    var token: String
        set(value) = pref.edit().putString("TOKEN", value).apply()
        get() = pref.getString("TOKEN", "")!!

    var accesToken:String
    set(value) = pref.edit().putString("ACCESSTOKEN",value).apply()
    get() = pref.getString("ACCESSTOKEN","")!!

    var accesToken1:String
    set(value) = pref.edit().putString("ACCESSTOKEN1",value).apply()
    get() = pref.getString("ACCESSTOKEN1","")!!


}