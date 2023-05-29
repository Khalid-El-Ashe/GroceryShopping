package com.example.groceryshoppingapp.ui.compose.customItems

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.groceryshoppingapp.R
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.groceryshoppingapp.ui.theme.CardBackground
import com.example.groceryshoppingapp.ui.theme.Text1
import com.example.groceryshoppingapp.ui.theme.TextCard
import com.example.groceryshoppingapp.utiles.Deal
import com.example.groceryshoppingapp.viewModel.GroceryViewModel
import kotlinx.coroutines.launch

@Composable
fun Deals() {
    val viewModel = hiltViewModel<GroceryViewModel>()
    LazyRow {
        items(listOfDeals) {
            CustomDealItem(deal = it, groceryViewModel = viewModel)
        }
    }
}

val listOfDeals = listOf(
    Deal(0, "1KG", R.drawable.ic_fd4, "Carrot", 490.00),
    Deal(1, "1KG", R.drawable.ic_fd5, "Mango - Bud", 210.00),
    Deal(2, "100G", R.drawable.ic_fd6, "Grapes - Green", 140.00),
    Deal(3, "1KG", R.drawable.ic_fd4, "Carrot", 490.00),
    Deal(4, "1KG", R.drawable.ic_fd5, "Mango - Bud", 210.00),
    Deal(5, "100G", R.drawable.ic_fd6, "Grapes - Green", 140.00)
)

@Composable
fun CustomDealItem(deal: Deal, groceryViewModel: GroceryViewModel) {

    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    Card(
        modifier = Modifier
            .width(120.dp)
            .height(170.dp)
            .padding(start = 10.dp, top = 15.dp, end = 10.dp)
            .shadow(elevation = 5.dp, shape = RoundedCornerShape(5.dp))
            .background(color = Color.White)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 5.dp, start = 5.dp, end = 5.dp, bottom = 10.dp)
        ) {
            Box(
                modifier = Modifier
                    .width(27.dp)
                    .height(15.dp)
                    .clip(RoundedCornerShape(2.dp))
                    .background(color = CardBackground)
                    .align(Alignment.TopStart)
            ) {
                Text(
                    text = deal.dealGram,
                    fontSize = 8.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextCard,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            Icon(
                Icons.Default.FavoriteBorder,
                contentDescription = "Favorite Image",
                tint = Text1,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .width(15.dp)
                    .height(13.dp)
                    .clickable {
                        try {
                            scope.launch {
                                groceryViewModel.upsertDeal(deal = deal)
                                Toast
                                    .makeText(
                                        context,
                                        "success add to favorite",
                                        Toast.LENGTH_SHORT
                                    )
                                    .show()
                            }
                        } catch (e: Exception) {
                            Toast
                                .makeText(context, e.message.toString(), Toast.LENGTH_SHORT)
                                .show()
                        }
                    })

            Image(
                painter = painterResource(id = deal.dealImage),
                contentDescription = "Deal Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .align(Alignment.Center)
                    .width(88.dp)
                    .height(67.dp)
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp)
                    .align(Alignment.BottomStart)
            ) {

                Text(
                    text = deal.dealName,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Text1
                )

                Text(
                    text = "Rs.${deal.dealSalary}",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black
                )
            }
        }
    }
}
