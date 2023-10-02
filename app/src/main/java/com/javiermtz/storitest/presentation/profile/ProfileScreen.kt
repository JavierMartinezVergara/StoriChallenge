package com.javiermtz.storitest.presentation.profile

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun DashboardScreen(navHostController: NavHostController, ) {
}

@Composable
fun DashboardItem(text: String, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .clickable(onClick = onClick),
            elevation = 4.dp
        ) {
            Text(
                text = text,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                style = MaterialTheme.typography.h6
            )
        }
    }
}

@Preview
@Composable
fun DashboardScreenPreview() {
    DashboardItem(text = "ew") {

    }
}
