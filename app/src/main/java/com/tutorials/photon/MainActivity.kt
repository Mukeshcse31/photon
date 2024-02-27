package com.tutorials.photon

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.tutorials.photon.ui.theme.App_Nav
import com.tutorials.photon.ui.theme.PhotonTheme
import com.tutorials.photon.ui.theme.network.Repository
import com.tutorials.photon.ui.theme.network.Service
import com.tutorials.photon.ui.theme.network.Util
import com.tutorials.photon.ui.theme.viewModel.SchoolViewModel
import okhttp3.ResponseBody

class MainActivity : ComponentActivity() {

    private val service: Service = Util.getRetrofitBuilder().create(Service::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PhotonTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val viewModel = androidx.lifecycle.viewmodel.compose.viewModel {
                        SchoolViewModel(repository = Repository(service))
                    }
                    viewModel.getSchoolData()
                    viewModel.schoolData.observe(this) { response ->
                        response?.let {
                            setContent {
                                App_Nav(data = it)
                            }
                        }
                    }

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
    PhotonTheme {
        Greeting("Android")
    }
}