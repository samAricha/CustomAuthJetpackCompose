package teka.android.customauth.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import teka.android.customauth.MyDataStoreRepository
import teka.android.customauth.authentication.AuthManager
import teka.android.customauth.data.remote.retrofit.RetrofitProvider
import teka.android.customauth.presentation.AuthViewModel
import teka.android.customauth.presentation.home.HomeScreen
import teka.android.customauth.presentation.login.LoginScreen
import teka.android.customauth.presentation.registration.RegisterScreen

@Composable
fun MainNavGraph(
    navController: NavHostController,
    dataStoreRepository: MyDataStoreRepository
) {
    val authService = RetrofitProvider.createAuthService()
    val authManager = AuthManager(authService, dataStoreRepository)
    val authViewModel = AuthViewModel(authManager)

    NavHost(
        navController = navController,
        startDestination = Screen.RegistrationScreen.route,
        route = MAIN_GRAPH_ROUTE
    ) {

        composable(route = Screen.LoginScreen.route) {
            LoginScreen(authViewModel = authViewModel)
        }

        composable(route = Screen.RegistrationScreen.route) {
            RegisterScreen(authViewModel = authViewModel)
        }

        composable(route = Screen.HomeScreen.route) {
            HomeScreen(authViewModel = authViewModel)
        }

    }
}