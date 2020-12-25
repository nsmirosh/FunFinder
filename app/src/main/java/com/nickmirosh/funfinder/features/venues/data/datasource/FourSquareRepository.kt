
package nikolay.miroshnychenko.beat_test_task.data.datasource

import com.nickmirosh.funfinder.features.venues.data.datasource.FourSquareDataSource
import com.nickmirosh.funfinder.features.venues.domain.Venue
import io.reactivex.Single
import retrofit2.Call

class FourSquareRepository (private val remoteDataSource: FourSquareRemoteDataSource) :
    FourSquareDataSource {

    override fun getRecommendedVenues(latLng: String, radius: Int): Call<Any> {
        return remoteDataSource.getRecommendedVenues(latLng, radius)
    }
}