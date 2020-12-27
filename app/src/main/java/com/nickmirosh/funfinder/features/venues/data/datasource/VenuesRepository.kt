
package nikolay.miroshnychenko.beat_test_task.data.datasource

import com.nickmirosh.funfinder.features.venues.data.datasource.IVenuesRepository
import com.nickmirosh.funfinder.features.venues.domain.VenueAndReasons

class VenuesRepository (private val remoteDataSource: VenuesRemoteDataSource): IVenuesRepository {

    override suspend fun getRecommendedVenues(latLng: String, radius: Int): List<VenueAndReasons> {
            return remoteDataSource.getRecommendedVenues(latLng, radius)
    }
}