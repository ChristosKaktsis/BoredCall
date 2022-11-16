package com.example.boredcall

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.boredcall.network.BoredActivity
import com.example.boredcall.network.BoredApi
import kotlinx.coroutines.launch

class BoredviewViewModel : ViewModel() {
    private val _activity = MutableLiveData<BoredActivity>()
    private val _status = MutableLiveData<String>()
    val activity : LiveData<BoredActivity> = _activity
    val status : LiveData<String> = _status
   /* init {
        getActivity()
    }
    */
    fun getActivity(){
        viewModelScope.launch {
            try {
                _activity.value = BoredApi.retrofitService.getBoredActivity()
                _status.value = " ${activity.value?.activity}"
            }
            catch (e:Exception){
                Log.d("error","${e.message}")
            }
        }
    }
}