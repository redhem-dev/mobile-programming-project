package com.example.quickbasket.model.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quickbasket.model.repositories.FavouriteRepository
import com.example.quickbasket.model.repositories.UserRepository
import kotlinx.coroutines.launch

class ProfileViewModel(
    private val userRepository: UserRepository,
    private val favouriteRepository: FavouriteRepository
) : ViewModel() {

    var userUiState by mutableStateOf(UsersUiState())
        private set

    var favouriteUiState by mutableStateOf(FavouritesUiState(favouritesDetails = this.toFavouritesDetails()))
        private set


    fun fetchUserData(userId: Int) {
        viewModelScope.launch {
            userRepository.getOneStream(userId).collect { user ->
                user?.let {
                    userUiState = user.toUserUiState()
                }
            }
        }
    }


    fun logout(onLogout: () -> Unit) {
        userUiState = UsersUiState()  // Reset user UI state
        favouriteUiState = FavouritesUiState(favouritesDetails = this.toFavouritesDetails())
        onLogout()
    }

    fun fetchFavouriteProducts(userId: Int) {
        viewModelScope.launch {
            favouriteRepository.getFavourites(userId).forEach { favourites ->
                favouriteUiState = FavouritesUiState(favouritesList = favourites.map { it.toToursDetails() })
            }
        }
    }

    fun fetchPreviousTours(userId:Int) {
        viewModelScope.launch {
            tourRepository.getUserPreviousTours(userId).collect { tours ->
                toursUiState = ToursUiState(toursList = tours.filter { it.id >= 5 }.map { it.toToursDetails() })
            }
        }
    }

    fun cancelReservation(userId: Int, tourId: Int) {
        viewModelScope.launch {
            reservationRepository.deleteByUserIdAndTourId(userId, tourId)
            fetchBookedTours(userId)
        }
    }
}
