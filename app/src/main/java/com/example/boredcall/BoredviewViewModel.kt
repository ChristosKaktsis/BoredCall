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
    private val _description = MutableLiveData<String>()
    private val _status = MutableLiveData<String>()
    private val _isBusy = MutableLiveData<Boolean>()
    val activity : LiveData<BoredActivity> = _activity
    val description : LiveData<String> = _description
    val status : LiveData<String> = _status
    val isBusy : LiveData<Boolean> = _isBusy

    init {
    }

    fun getActivity(){
        viewModelScope.launch {
            _isBusy.value = true

            try {

                _activity.value = BoredApi.retrofitService.getBoredActivity()
                _description.value = _activity.value?.activity
            }
            catch (e:Exception){
                Log.d("error","${e.message}")
            }
            finally {
                _isBusy.value = false
            }
        }
    }
}