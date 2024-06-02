package com.example.quickbasket.ui.screen.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.quickbasket.ui.screen.CatalogueScreen
import com.example.quickbasket.ui.screen.UpdateProfileScreen
import com.example.quickbasket.ui.screen.ProfileScreen
import com.example.quickbasket.ui.screen.SigninDestination
import com.example.quickbasket.ui.screen.SigninScreen
import com.example.quickbasket.ui.screen.SignupDestination
import com.example.quickbasket.ui.screen.SignupScreen
import com.example.quickbasket.ui.screen.SingleProductPage
import com.example.quickbasket.ui.screen.WelcomeDestination
import com.example.quickbasket.ui.screen.WelcomeScreen



@Composable
fun UserNavHost(
    navController: NavHostController
){
    NavHost(navController = navController, startDestination = WelcomeDestination.route){
        composable(route = SigninDestination.route){
            SigninScreen(
                navigateToSignUpPage ={ navController.navigate("${SignupDestination.route}")},
                navigateToCatalogue ={ navController.navigate("${HomeDestination.route}")},
                navigateToWelcomeDestination ={ navController.navigate("${SplashDestination.route}")}
            )
        }
        composable(route = SignUpDestination.route){
            SignUpPage(
                navigateToSignInPage ={ navController.navigate("${SignInDestination.route}")}
            )}
        composable(route = SplashDestination.route){
            SplashScreen(
                navigateToSignInPage ={ navController.navigate("${SignInDestination.route}")}
            ) }
        composable(route = HomeDestination.route) {
            HomeScreen(
                navigateToToursPage = { navController.navigate("${ToursDestination.route}") },
                navigateToAboutUsPage = { navController.navigate("${AboutDestination.route}") },
                navigateToProfilePage = { navController.navigate("${ProfileDestination.route}") }
            )
        }
        composable(route = AboutDestination.route) {
            AboutScreen(
                navigateToToursPage = { navController.navigate("${ToursDestination.route}") },
                navigateToHomePage = { navController.navigate("${HomeDestination.route}") },
                navigateToProfilePage = { navController.navigate("${ProfileDestination.route}") }
            )
        }
        composable(
            route = "${EditProfileDestination.route}/{userId}",
            arguments = listOf(navArgument("userId") { type = NavType.IntType })
        ) { navBackStackEntry ->
            val userId = navBackStackEntry.arguments?.getInt("userId") ?: return@composable
            EditProfileScreen(
                userId = userId,
                navigateToToursPage = { navController.navigate("${ToursDestination.route}") },
                navigateToHomePage = { navController.navigate("${HomeDestination.route}") },
                navigateToAboutUsPage = { navController.navigate("${AboutDestination.route}") },
                navigateToProfilePage = { navController.navigate("${ProfileDestination.route}") }
            )
        }
        composable(route = ProfileDestination.route) {
            ProfileScreen(
                navigateToToursPage = { navController.navigate("${ToursDestination.route}") },
                navigateToHomePage = { navController.navigate("${HomeDestination.route}") },
                navigateToAboutUsPage = { navController.navigate("${AboutDestination.route}")},
                onLogout = {},
                userId = 1
            )
        }
        composable(route = ToursDestination.route) {
            ToursScreen(
                navigateToProfilePage = { navController.navigate("${ProfileDestination.route}") },
                navigateToHomePage = { navController.navigate("${HomeDestination.route}") },
                navigateToAboutUsPage = { navController.navigate("${AboutDestination.route}") },
                navigateToViewTour = { navController.navigate("${TourViewDestination.route}/${it}") }
            )
        }
        composable(
            route = TourViewDestination.routeWithArgs,
            arguments = listOf(navArgument("tourId") { type = NavType.IntType })
        ) { navBackStackEntry ->
            val tourId = navBackStackEntry.arguments?.getInt("tourId") ?: return@composable
            ToursViewScreen(
                tourId = tourId,
                userId = 1,
                navigateToProfilePage = { navController.navigate(ProfileDestination.route) },
                navigateToToursPage = { navController.navigate("${ToursDestination.route}") },
                navigateToHomePage = { navController.navigate(HomeDestination.route) },
                navigateToAboutUsPage = { navController.navigate(AboutDestination.route) }
            )
        }


    }
}