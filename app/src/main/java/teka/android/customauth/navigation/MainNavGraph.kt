package teka.android.customauth.navigation

import android.content.Context
import android.preference.PreferenceManager
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import teka.android.customauth.data.remote.authentication.AuthManager
import teka.android.customauth.data.remote.retrofit.RetrofitProvider
import teka.android.customauth.presentation.login.LoginScreen
import teka.android.customauth.presentation.login.LoginViewModel
import teka.android.customauth.presentation.registration.RegisterScreen
import teka.android.customauth.presentation.registration.RegisterViewModel

@Composable
fun MainNavGraph(
    navController: NavHostController,
    applicationContext: Context
) {
    val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext)
    val authService = RetrofitProvider.createAuthService()
    val authManager = AuthManager(authService, sharedPreferences)

    NavHost(
        navController = navController,
        startDestination = Screen.RegistrationScreen.route,
        route = MAIN_GRAPH_ROUTE
    ) {

        composable(route = Screen.LoginScreen.route) {
            LoginScreen(LoginViewModel(authManager))
        }

        composable(route = Screen.RegistrationScreen.route) {
            RegisterScreen(RegisterViewModel(authManager))
        }

    }
}