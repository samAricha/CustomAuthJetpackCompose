package teka.android.customauth

import android.os.Bundle
import android.preference.PreferenceManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
                    color = MaterialTheme.colorScheme.background
                ) {
                    val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext)
                    val authService = RetrofitProvider.createAuthService()
                    val authManager = AuthManager(authService, sharedPreferences)
                    LoginScreen(LoginViewModel(authManager))
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CustomAuthTheme {
        Greeting("Android")
    }
}