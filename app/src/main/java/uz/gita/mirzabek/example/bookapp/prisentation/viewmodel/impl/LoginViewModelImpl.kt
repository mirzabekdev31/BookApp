package uz.gita.mirzabek.example.bookapp.prisentation.viewmodel.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import uz.gita.mirzabek.example.bookapp.domain.usecase.LoginScreenUseCase
import uz.gita.mirzabek.example.bookapp.prisentation.viewmodel.LoginViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModelImpl @Inject constructor(private val useCase: LoginScreenUseCase) :LoginViewModel,ViewModel(){


    override val openRegesterScreenLiveData=MutableLiveData<Unit>()
    override val openVerifyLoginScreenLiveData=MutableLiveData<Unit>()
    override val notConnectionLiveData=MutableLiveData<Unit>()
    override val progressLiveData=MutableLiveData<Boolean>()

    override fun openSignUpScreenLiveData() {
        openRegesterScreenLiveData.value=Unit
    }

    override fun login(phone: String, password: String) {
        viewModelScope.launch {
            useCase.login(phone,password).collect().let {
                openVerifyLoginScreenLiveData.value=Unit
            }
        }
//        if (!isConnected()){
//            notConnectionLiveData.value=Unit
//            return
//        }
//        progressLiveData.value=true
//        val response=authApi.login(pref.token,LoginRequest(phone,password))
//        if (response.isSuccessful){
//            response.body()?.let {
//                pref.token=it.token
//            }
//        }
//        authApi.login(pref.token, LoginRequest(phone,password))
//            .enqueue(object :Callback<AuthResponse.LoginResponse>{
//                override fun onResponse(
//                    call: Call<AuthResponse.LoginResponse>,
//                    response: Response<AuthResponse.LoginResponse>
//                ) {
//                    progressLiveData.value=false
//                    if (response.isSuccessful){
//                        response.body()?.let {
//                            pref.token=it.token
//                            pref.startScreen="CONTACT"
//                            openVerifyLoginScreenLiveData.value=Unit
//                        }
//                    }
//                }
//
//                override fun onFailure(call: Call<AuthResponse.LoginResponse>, t: Throwable) {
//                    progressLiveData.value=false
//                }
//            })

    }
}