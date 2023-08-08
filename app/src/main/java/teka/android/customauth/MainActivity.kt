package teka.android.customauth

import android.os.Bundle
import android.preference.PreferenceManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import teka.android.customauth.data.remote.authentication.AuthManager
import teka.android.customauth.data.remote.retrofit.RetrofitProvider
import teka.android.customauth.presentation.login.LoginScreen
import teka.android.customauth.presentation.login.LoginViewModel
import teka.android.customauth.ui.theme.CustomAuthTheme

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CustomAuthTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

//                    val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext)
//                    val authService = RetrofitProvider.createAuthService()
//                    val authManager = AuthManager(authService, sharedPreferences)
//                    LoginScreen(LoginViewModel(authManager))



                    MainAppScreen(applicationContext)
                }
            }
        }
    }
}
