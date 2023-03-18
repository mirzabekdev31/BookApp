package uz.gita.mirzabek.example.bookapp.prisentation.viewmodel.impl
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.gita.bookappauth.utils.ConnectionUtil
import uz.gita.mirzabek.example.bookapp.data.local.pref.AppPreferences
import uz.gita.mirzabek.example.bookapp.data.remote.api.BookApi
import uz.gita.mirzabek.example.bookapp.data.remote.request.VerifyRequest
import uz.gita.mirzabek.example.bookapp.prisentation.viewmodel.VerifyViewModel
import javax.inject.Inject


@HiltViewModel
class VerifyViewModelImpl @Inject constructor(
    private val authApi:BookApi,
    private val pref:AppPreferences,
    private val connectionUtil: ConnectionUtil
    ) :VerifyViewModel,ViewModel(){
    override val openMainScreenLiveData=MutableLiveData<Unit>()

    override fun verify(code: String) {
        if (!connectionUtil.isConnected()){
            return
        }
        viewModelScope.launch {
            val response=authApi.verify("Bearer ${pref.token}", VerifyRequest(code))
            if (response.isSuccessful){
                response.body()?.let {
                    pref.accesToken=it.token
                    openMainScreenLiveData.value=Unit
                }
            }
        }

//        authApi.verify("Bearer ${pref.token}", VerifyRequest(code)).enqueue(object :Callback<AuthResponse.VerifyResponse>{
//            override fun onResponse(
//                call: Call<AuthResponse.VerifyResponse>,
//                response: Response<AuthResponse.VerifyResponse>
//            ) {
//                if (response.isSuccessful){
//                    response.body()?.let {
//                        pref.accesToken=it.token
//                        openMainScreenLiveData.value=Unit
//                    }
//                }
//            }
//
//            override fun onFailure(call: Call<AuthResponse.VerifyResponse>, t: Throwable) {
//
//            }
//
//        })
    }
}