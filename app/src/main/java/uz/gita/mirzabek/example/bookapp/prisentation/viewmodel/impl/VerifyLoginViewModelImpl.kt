package uz.gita.mirzabek.example.bookapp.prisentation.viewmodel.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.gita.mirzabek.example.bookapp.domain.usecase.VerifyLoginUseCase
import uz.gita.mirzabek.example.bookapp.prisentation.viewmodel.VerifyLoginViewModel
import javax.inject.Inject


@HiltViewModel
class VerifyLoginViewModelImpl @Inject constructor(private val useCase:VerifyLoginUseCase):VerifyLoginViewModel,ViewModel(){
    override val openMainScreenLiveData=MutableLiveData<Unit>()

    override fun verifyLogin(code: String) {
        viewModelScope.launch {
            useCase.verifyLogin(code)
            openMainScreenLiveData.value=Unit
        }

//        authApi.verifyLogin("Bearer ${pref.token}", VerifyLoginRequest(code)).enqueue(object :Callback<AuthResponse.VerifyLoginResponse>{
//            override fun onResponse(
//                call: Call<AuthResponse.VerifyLoginResponse>,
//                response: Response<AuthResponse.VerifyLoginResponse>
//            ) {
//                if(response.isSuccessful){
//                    response.body()?.let {
//                        pref.accesToken1=it.token
//                        openMainScreenLiveData.value=Unit
//                    }
//                }
//            }
//
//            override fun onFailure(call: Call<AuthResponse.VerifyLoginResponse>, t: Throwable) {
//
//            }
//
//        })
    }

}