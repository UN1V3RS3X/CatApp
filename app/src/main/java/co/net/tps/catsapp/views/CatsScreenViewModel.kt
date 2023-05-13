package co.net.tps.catsapp.views

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CatsScreenViewModel : ViewModel() {

    private val _cats = MutableLiveData(ArrayList<Cat>(arrayListOf()))
    val cats: LiveData<ArrayList<Cat>> = _cats


    fun getCats(){
        val quotesApi = RetrofitHelper.getInstance().create(CatsApi::class.java)
        // launching a new coroutine
        viewModelScope.launch {
            val result = quotesApi.getCats()

            result.enqueue(object : Callback<List<Cat>> {
                override fun onFailure(call: Call<List<Cat>>, t: Throwable) {
                    Log.d("yamid", "fail: "+t.message)
                }

                override fun onResponse(call: Call<List<Cat>>, response: Response<List<Cat>>) {
//                    Log.d("yamid", "response: "+ response.body()!![0])
                    var list = response.body()!!
                    var listaFinal : ArrayList<Cat> = arrayListOf()
                    for (cat in list){
                        listaFinal.add(Cat(cat.getName(), cat.getOrigin(), cat.getAffectionLevel(), cat.getIntelligence(), cat.getImage()))
                    }
                    _cats.value = listaFinal
                }

            })


        }
    }

}