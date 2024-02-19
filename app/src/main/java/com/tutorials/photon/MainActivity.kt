package com.tutorials.photon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.tutorials.photon.ui.theme.App_Nav
import com.tutorials.photon.ui.theme.PhotonTheme
import com.tutorials.photon.ui.theme.composableViews.MainSchoolData
import com.tutorials.photon.ui.theme.network.Service
import com.tutorials.photon.ui.theme.network.Util
import com.tutorials.photon.ui.theme.viewModel.SchoolViewModel

class MainActivity : ComponentActivity() {

    val service = Util.getRetrofitBuilder().create(Service::class.java)

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
                        SchoolViewModel(
                            service = service,
                        )
                    }
                    viewModel.getSchoolData()
                    viewModel.schoolData.observe(this) { res ->
                        when (res.isSuccessful) {
                            true -> {
                                println("in the activity ${res.body()}")

                                res.body()?.let {response ->
                                    setContent {
                                        App_Nav(data = response)

                                    }
                                }

                            }

                            false -> {

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