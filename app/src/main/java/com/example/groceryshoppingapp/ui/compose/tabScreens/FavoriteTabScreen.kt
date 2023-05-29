package com.example.groceryshoppingapp.ui.compose.tabScreens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DeleteOutline
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.groceryshoppingapp.ui.theme.SplashColor
import com.example.groceryshoppingapp.ui.theme.Text1
import com.example.groceryshoppingapp.ui.theme.Text2
import com.example.groceryshoppingapp.utiles.Deal
import com.example.groceryshoppingapp.utiles.Member
import com.example.groceryshoppingapp.viewModel.GroceryViewModel
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun FavoriteScreen() {

    val viewModel = hiltViewModel<GroceryViewModel>()
    FavoritesViewModel(groceryViewModel = viewModel)

}

@Composable
fun FavoritesViewModel(groceryViewModel: GroceryViewModel) {

    val dealState = groceryViewModel.dealState.value
    val memberState = groceryViewModel.memberState.value

    Column(modifier = Modifier.fillMaxSize()) {
        LazyColumn {
            items(dealState.deals) { deal ->
                DealFaves(deal = deal, viewModel = groceryViewModel)
            }

            items(memberState.members) { member ->
                MemberFaves(member = member, viewModel = groceryViewModel)
            }
        }
    }
}

@Composable
fun DealFaves(deal: Deal, viewModel: GroceryViewModel) {
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(4.dp))
            .height(70.dp)
            .padding(5.dp)
    ) {
        Row(modifier = Modifier.fillMaxSize()) {
            Box() {
                Image(
                    painter = painterResource(id = deal.dealImage),
                    contentDescription = "Favorite Image",
                    modifier = Modifier
                        .align(
                            Alignment.TopStart
                        )
                        .width(70.dp)
                        .height(100.dp)
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(2f)
                    .padding(start = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = deal.dealName,

                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    modifier = Modifier.align(Alignment.Start)
                )

                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = deal.dealSalary.toString(),
                        fontWeight = FontWeight.Medium,
                        color = Text1,
                        fontSize = 15.sp,
                    )
                    Text(
                        text = deal.dealGram,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Medium,
                        color = Text2,
                        fontSize = 15.sp,
                        modifier = Modifier.weight(1f)
                    )
                }
            }

            Box(modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
                .clickable {
                    try {
                        viewModel.deleteDeal(deal = deal)
                    } catch (e: Exception) {
                        Toast
                            .makeText(context, e.message.toString(), Toast.LENGTH_SHORT)
                            .show()
                    }
                }) {
                Icon(
                    Icons.Default.DeleteOutline,
                    tint = SplashColor,
                    contentDescription = "Delete",
                    modifier = Modifier
                        .align(Alignment.Center)
                        .width(30.dp)
                        .height(30.dp)
                )
            }

        }
    }
}


@Composable
fun MemberFaves(member: Member, viewModel: GroceryViewModel) {
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(4.dp))
            .height(70.dp)
            .padding(5.dp)
    ) {
        Row(modifier = Modifier.fillMaxSize()) {
            Box() {
                Image(
                    painter = painterResource(id = member.memberImage),
                    contentDescription = "Favorite Image",
                    modifier = Modifier
                        .align(
                            Alignment.TopStart
                        )
                        .width(70.dp)
                        .height(100.dp)
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(2f)
                    .padding(start = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = member.memberName,

                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    modifier = Modifier.align(Alignment.Start)
                )

                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = member.memberSalary.toString(),
                        fontWeight = FontWeight.Medium,
                        color = Text1,
                        fontSize = 15.sp,
                    )
                    Text(
                        text = member.memberGram,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Medium,
                        color = Text2,
                        fontSize = 15.sp,
                        modifier = Modifier.weight(1f)
                    )
                }
            }

            Box(modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
                .clickable {
                    try {
                        viewModel.deleteMember(member = member)
                    } catch (e: Exception) {
                        Toast
                            .makeText(context, e.message.toString(), Toast.LENGTH_SHORT)
                            .show()
                    }
                }) {
                Icon(
                    Icons.Default.DeleteOutline,
                    tint = SplashColor,
                    contentDescription = "Delete",
                    modifier = Modifier
                        .align(Alignment.Center)
                        .width(30.dp)
                        .height(30.dp)
                )
            }

        }
    }
}


//@Composable
//fun Greeting5(name: String) {
////    DealFaves()
//}
//
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    GroceryShoppingAppTheme {
//        Greeting5("Android")
//    }
//}