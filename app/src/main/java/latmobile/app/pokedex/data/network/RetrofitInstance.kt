package latmobile.app.pokedex.data.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

const val API_BASE_URL = "https://pokeapi.co/api/v2/"

object RetrofitInstance {

    private val interceptorLogging = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val client = OkHttpClient.Builder()
        .addInterceptor(interceptorLogging)
        .connectTimeout(1, TimeUnit.MINUTES)
        .readTimeout(1, TimeUnit.MINUTES)
        .writeTimeout(1, TimeUnit.MINUTES)
        .callTimeout(1, TimeUnit.MINUTES)
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(API_BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service: AppService = retrofit.create(AppService::class.java)

}