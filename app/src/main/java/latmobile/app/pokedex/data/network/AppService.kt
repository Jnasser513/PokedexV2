package latmobile.app.pokedex.data.network

import latmobile.app.pokedex.data.dto.PokeListResponse
import latmobile.app.pokedex.data.dto.PokemonResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AppService {

    @GET("pokemon")
    suspend fun getPokemonList(@Query("limit") limit: Int, @Query("offset") offset: Int): Response<PokeListResponse>

}