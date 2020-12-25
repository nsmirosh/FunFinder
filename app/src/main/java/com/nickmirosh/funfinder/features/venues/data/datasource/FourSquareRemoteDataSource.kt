package nikolay.miroshnychenko.beat_test_task.data.datasource

import com.nickmirosh.funfinder.features.venues.data.FourSquareApi
import com.nickmirosh.funfinder.features.venues.data.datasource.FourSquareDataSource
import retrofit2.Call


class FourSquareRemoteDataSource(private val fourSquareApi: FourSquareApi) :
    FourSquareDataSource {

    override fun getRecommendedVenues(latLng: String, radius: Int): Call<Any> {
        return fourSquareApi.getRecommendedVenues(latLng, FOOD_CATEGORY_ID,  radius)
    }

    companion object {
        private const val FOOD_CATEGORY_ID = "4d4b7105d754a06374d81259"
    }
}