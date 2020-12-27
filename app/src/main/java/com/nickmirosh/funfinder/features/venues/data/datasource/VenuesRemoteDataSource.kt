package nikolay.miroshnychenko.beat_test_task.data.datasource

import com.nickmirosh.funfinder.features.venues.data.FourSquareApi
import com.nickmirosh.funfinder.features.venues.data.datasource.IVenuesDataSource
import com.nickmirosh.funfinder.features.venues.domain.VenueAndReasons
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

const val FOOD_CATEGORY_ID = "4d4b7105d754a06374d81259"

class VenuesRemoteDataSource(private val fourSquareApi: FourSquareApi) : IVenuesDataSource {

    override suspend fun getRecommendedVenues(latLng: String, radius: Int): List<VenueAndReasons> {
        withContext(Dispatchers.IO) {
            val call = fourSquareApi.getRecommendedVenues(latLng, FOOD_CATEGORY_ID, 2, radius)
            val result = call.execute()
            if (result.isSuccessful) {
                val response = result.body()!!
                val venuesAndReasonsList = mutableListOf<VenueAndReasons>()
                for (value in response.groups.items) {
                    for (venueAndReason in value.items) {
                        venuesAndReasonsList.add(venueAndReason)
                    }
                }
                return@withContext venuesAndReasonsList
            } else {
                return@withContext emptyList()
            }
        }
        return emptyList()
    }
}