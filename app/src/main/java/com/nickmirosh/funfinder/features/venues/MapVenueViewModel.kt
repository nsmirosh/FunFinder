package com.nickmirosh.funfinder.features.venues

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.nickmirosh.funfinder.features.venues.data.FourSquareApi

import com.nickmirosh.funfinder.features.venues.domain.Venue
import kotlinx.coroutines.*
import nikolay.miroshnychenko.beat_test_task.data.datasource.VenuesRemoteDataSource
import nikolay.miroshnychenko.beat_test_task.data.datasource.VenuesRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MapVenueViewModel() : ViewModel() {
    private var foodVenues = ArrayList<Venue>()

    private val mutableVenuesLiveData: MutableLiveData<List<Venue>> = MutableLiveData()
    val venuesLiveData: LiveData<List<Venue>> get() = mutableVenuesLiveData

    fun getRecommendedVenues(latLng: String, radius: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val stuff = buildRepo().getRecommendedVenues("50.4501, 30.5234", 1000)
        }
    }

    private fun buildRepo (): VenuesRepository {
        val dataSource = VenuesRemoteDataSource(buildRetrofit())
        return VenuesRepository(dataSource)
    }


    private fun buildRetrofit(): FourSquareApi {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor { chain ->
                val originalRequest = chain.request()
                val newUrl = originalRequest.url.newBuilder()
                    .addQueryParameter(
                        "client_id",
                        "FR4R2GZO4R3X0TRVA4OE3ODTNQHL5PLS3NY42LSCMD1IVNTH"
                    )
                    .addQueryParameter(
                        "client_secret",
                        "ANGF2UU2A21JXIAT0PAAM0MDRHX0V5ZXJZ1ACD5OVSH5OLNC"
                    )
                    .addQueryParameter("v", "20201118")
                    .build();

                val requestBuilder = originalRequest.newBuilder()
                    .url(newUrl)

                chain.proceed(requestBuilder.build())
            }
            .addInterceptor(logging)
            .build()


        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl("https://api.foursquare.com/v2/")
            .client(okHttpClient)
            .build()


        return retrofit.create(FourSquareApi::class.java)
    }
}
