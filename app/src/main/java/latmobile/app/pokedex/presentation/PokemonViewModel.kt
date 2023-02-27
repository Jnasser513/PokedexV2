package latmobile.app.pokedex.presentation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import latmobile.app.pokedex.data.dto.Pokemon
import latmobile.app.pokedex.data.network.RetrofitInstance
import java.io.IOException

class PokemonViewModel : ViewModel() {

    val pokemons = MutableLiveData<List<Pokemon>>()
    val cantidad = MutableLiveData("")

    fun getPokemonList() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val call = RetrofitInstance.service.getPokemonList(cantidad.value!!.toInt(), 1)
                val response = call.body()

                if (call.isSuccessful) {
                    response?.results.let {
                        Log.d("ENTRO", it.toString())
                        pokemons.postValue(it)
                    }
                } else {
                    when (call.code()) {
                        500 -> Log.d("ERROR", call.code().toString())
                        else -> Log.d("ERROR", call.code().toString())
                    }
                }
            } catch (e: IOException) {
                Log.d("ERROR", e.toString())
            }
        }
    }

}