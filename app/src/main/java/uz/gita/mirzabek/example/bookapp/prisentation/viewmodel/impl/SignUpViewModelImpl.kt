package uz.gita.mirzabek.example.bookapp.prisentation.viewmodel.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.gita.mirzabek.example.bookapp.data.local.pref.AppPreferences
import uz.gita.mirzabek.example.bookapp.data.remote.api.BookApi
import uz.gita.mirzabek.example.bookapp.data.remote.request.AuthRequest
import uz.gita.mirzabek.example.bookapp.prisentation.viewmodel.SignUpViewModel
import javax.inject.Inject

@HiltViewModel
class SignUpViewModelImpl @Inject constructor(private val authApi :BookApi,private val pref:AppPreferences) :SignUpViewModel,ViewModel(){
    override val openVerifyScreenLiveData=MutableLiveData<Unit>()
    override val progressLiveData=MutableLiveData<Boolean>()

    override fun register(phone: String, password: String, lastName: String, firstName: String) {
        progressLiveData.value=true
        viewModelScope.launch {
            val response=authApi.register(AuthRequest(phone,password,firstName,lastName))
            if (response.isSuccessful){
                if (response.isSuccessful){
                    response.body()?.let {
                        pref.token=it.token
                        pref.startScreen="CONTACT"
                        openVerifyScreenLiveData.value=Unit
                    }
                }
            }
        }
//        authApi.register(AuthRequest(phone,password,firstName,lastName))
//            .enqueue(object :Callback<AuthResponse.RegisterResponse>{
//                override fun onResponse(
//                    call: Call<AuthResponse.RegisterResponse>,
//                    response: Response<AuthResponse.RegisterResponse>
//                ) {
//                    progressLiveData.value=false
//                    if (response.isSuccessful){
//                        response.body()?.let {
//                            pref.token=it.token
//                            pref.startScreen="CONTACT"
//                            openVerifyScreenLiveData.value=Unit
//                        }
//                    }
//                }
//
//                override fun onFailure(call: Call<AuthResponse.RegisterResponse>, t: Throwable) {
//                    progressLiveData.value=false
//                    Log.d("TTT","${t.message}")
//                }
//
//            })
    }
}