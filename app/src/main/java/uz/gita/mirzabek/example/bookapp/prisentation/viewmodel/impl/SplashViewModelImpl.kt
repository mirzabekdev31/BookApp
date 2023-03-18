package uz.gita.mirzabek.example.bookapp.prisentation.viewmodel.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import uz.gita.mirzabek.example.bookapp.data.local.pref.AppPreferences
import uz.gita.mirzabek.example.bookapp.domain.usecase.SplashUseCase
import uz.gita.mirzabek.example.bookapp.domain.usecase.impl.SplashUseCaseImpl
import uz.gita.mirzabek.example.bookapp.prisentation.viewmodel.SplashViewModel
import java.util.concurrent.Executors
import javax.inject.Inject

@HiltViewModel
class SplashViewModelImpl @Inject constructor(private val useCase:SplashUseCase) :SplashViewModel,ViewModel(){

    override val openLoginScreenLiveData=MutableLiveData<Unit>()
    override val openContactScreenLiveData=MutableLiveData<Unit>()


    init {
        viewModelScope.launch {
            useCase.openScreen().collect{
                delay(2000)
                if (it==1){
                    openLoginScreenLiveData.postValue(Unit)
                }else{
                    openContactScreenLiveData.postValue(Unit)
                }
            }
        }
    }
}