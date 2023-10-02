package com.javiermtz.storitest.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons.Filled
import androidx.compose.material.icons.filled.Business
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.domain.models.MovementData
import com.example.domain.models.ProfileData
import com.javiermtz.storitest.R
import com.javiermtz.storitest.ui.theme.BlackColor
import com.javiermtz.storitest.ui.theme.RobotoLight
import com.javiermtz.storitest.ui.theme.WhiteColor

@Composable
fun UserScreen(
    navController: NavHostController,
    profileViewModel: ProfileViewModel = hiltViewModel(),
    profileDataClient: ProfileData
) {
    Box(
        modifier = Modifier.fillMaxSize().background(color = WhiteColor)
            .semantics { testTag = "home-screen" }
    ) {
        Column(verticalArrangement = Arrangement.SpaceEvenly) {
            HeaderDashboard()
            if (profileDataClient.movements.isEmpty()) {
                Column() {
                    AppointmentsEmpty(
                        modifier = Modifier.fillMaxHeight(.9f),
                        stringResource(id = R.string.no_movements_available),
                        Filled.Business
                    )
                }
            }
            LazyColumn(modifier = Modifier.fillMaxWidth().fillMaxHeight(.9f)) {
                items(profileDataClient.movements) {
                    ClientCard(it)
                }
            }
        }
    }
}

@Composable
fun ClientCard(movement: MovementData) {
    Card(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth(),
        backgroundColor = Color.White,
        elevation = 12.dp,
        shape = RoundedCornerShape(24.dp)
    ) {
        Column {
            Image(
                painter = painterResource(id = R.drawable.bg_appointment),
                contentDescription = "",
                modifier = Modifier.width(20.dp).height(20.dp)
            )
            Row(modifier = Modifier.fillMaxSize()) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(.8f)
                        .padding(8.dp)
                ) {
                    Text(
                        text = movement.account,
                        fontSize = 20.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = movement.date,
                        fontSize = 16.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                    Text(text = movement.concept)
                    Text(text = movement.amount)
                    Spacer(modifier = Modifier.height(24.dp))
                }
                Column(
                    modifier = Modifier.fillMaxSize().padding(vertical = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Row {
                        Text(
                            text = "2.0",
                            fontSize = 16.sp,
                            color = Color.Black,
                            fontWeight = FontWeight.Bold
                        )
                        Image(
                            painter = painterResource(id = R.drawable.bg_appointment),
                            contentDescription = "",
                            modifier = Modifier.width(20.dp).height(20.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun AppointmentsEmpty(modifier: Modifier = Modifier, text: String, icon: ImageVector) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(64.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = text,
            modifier = Modifier.padding(horizontal = 32.dp),
            style = TextStyle(
                fontFamily = RobotoLight,
                color = BlackColor,
                fontSize = 16.sp,
                textAlign = TextAlign.Center
            )
        )
    }
}
