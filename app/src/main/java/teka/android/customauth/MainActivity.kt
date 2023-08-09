package teka.android.customauth

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import teka.android.customauth.authentication.AuthManager
import teka.android.customauth.data.remote.retrofit.RetrofitProvider
import teka.android.customauth.presentation.AuthViewModel
import teka.android.customauth.ui.theme.CustomAuthTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CustomAuthTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    val myDataStoreRepository = MyDataStoreRepository(applicationContext)

                    MainAppScreen(myDataStoreRepository)
                }
            }
        }
    }
}
