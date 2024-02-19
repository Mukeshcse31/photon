package com.tutorials.photon.ui.theme.composableViews

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import com.tutorials.photon.ui.theme.network.School
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
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
            Row {

                Text(text = schoolList[index].dbn)
                Spacer(modifier = Modifier.width(4.dp))
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
                Spacer(modifier = Modifier.width(12.dp))
            }
        }
    }
}

@Composable
fun DetailsScreen(
    schoolNames: School?
) {

    schoolNames ?: return
    Column {

        Text(
            text = schoolNames.name,
            color = colorResource(id = R.color.black),
            style = MaterialTheme.typography.headlineLarge,
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = schoolNames.overview,
            color = colorResource(id = R.color.black),
            style = MaterialTheme.typography.titleMedium,
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = schoolNames.academicopportunities1,
            color = colorResource(id = R.color.black),
            style = MaterialTheme.typography.bodyLarge,
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = schoolNames.academicopportunities2,
            color = colorResource(id = R.color.black),
            style = MaterialTheme.typography.bodyMedium,
        )

    }
}