package com.tutorials.photon.ui.theme.composableViews

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import com.tutorials.photon.ui.theme.network.School
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.tutorials.photon.R

@Composable
fun MainSchoolData(
    schoolList: List<School>,
    navController: NavController,
) {
    LazyColumn {
        items(count = schoolList.size) { index ->
            Row(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    modifier = Modifier.padding(end = 8.dp),
                    text = schoolList[index].dbn
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    modifier = Modifier.clickable {
                        // pass the clicked School data to the Details composable
                        navController.currentBackStackEntry?.savedStateHandle?.set(
                            "res",
                            schoolList[index]
                        )
                        navController.navigate("Details")

                    },
                    text = schoolList[index].name,
                    color = colorResource(id = R.color.black),
                    style = MaterialTheme.typography.titleMedium,
                )
                Spacer(modifier = Modifier.height(36.dp))
            }
        }
    }
}

@Composable
fun DetailsScreen(
    schoolNames: School?
) {
    val school = schoolNames ?: return
    Column {
        Text(
            text = school.name,
            color = colorResource(id = R.color.black),
            style = MaterialTheme.typography.headlineLarge,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = school.overview,
            color = colorResource(id = R.color.black),
            style = MaterialTheme.typography.titleMedium,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = school.academicopportunities1,
            color = colorResource(id = R.color.black),
            style = MaterialTheme.typography.bodyLarge,
        )
        Spacer(modifier = Modifier.height(8.dp))
        school.academicopportunities2?.let {
            Text(
                text = it,
                color = colorResource(id = R.color.black),
                style = MaterialTheme.typography.bodyMedium,
            )
        }
    }

    //TODO 1. Preview, 2.Espresso Test, 3. Unit tests
}

@Preview
@Composable
private fun ShowDetailsScreen() {
    DetailsScreen(
        School(
            dbn = "dbn",
            name = "School",
            overview = "Overview",
            academicopportunities1 = "academicopportunities1",
            academicopportunities2 = "academicopportunities2"
        )
    )
}