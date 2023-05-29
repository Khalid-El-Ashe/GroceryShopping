package com.example.groceryshoppingapp.ui.compose.customItems

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.groceryshoppingapp.R
import androidx.compose.ui.unit.sp
import com.example.groceryshoppingapp.ui.theme.CardBackground
import com.example.groceryshoppingapp.ui.theme.Text1
import com.example.groceryshoppingapp.ui.theme.TextCard
import com.example.groceryshoppingapp.utiles.Drink

@Composable
fun Drinks() {
    LazyVerticalGrid(columns = GridCells.Fixed(3), modifier = Modifier.fillMaxSize()) {
        items(listOfDrinks) {
            CustomDrinkItem(drink = it)
        }
    }
}

val listOfDrinks = listOf(
    Drink(0,"50G", R.drawable.ic_d1, "Khao Shong Ag...", 470.00),
    Drink(1,"50G", R.drawable.ic_d2, "Khao Shong...", 450.00),
    Drink(2,"100G", R.drawable.ic_d3, "Nescafe Gold", 1700.00),
    Drink(3,"50G", R.drawable.ic_d4, "Nescafe Classic", 470.00),
    Drink(4,"100G", R.drawable.ic_d5, "Nescafe Latte", 950.00),
    Drink(5,"50G", R.drawable.ic_d1, "Khao Shong Ag...", 470.00),
    Drink(6,"50G", R.drawable.ic_d2, "Khao Shong...", 450.00),
    Drink(7,"100G", R.drawable.ic_d3, "Nescafe Gold", 1700.00),
    Drink(8,"50G", R.drawable.ic_d4, "Nescafe Classic", 470.00),
    Drink(9,"100G", R.drawable.ic_d5, "Nescafe Latte", 950.00),
    Drink(10,"50G", R.drawable.ic_d1, "Khao Shong Ag...", 470.00),
    Drink(11,"50G", R.drawable.ic_d2, "Khao Shong...", 450.00),
    Drink(12,"100G", R.drawable.ic_d3, "Nescafe Gold", 1700.00),
    Drink(13,"50G", R.drawable.ic_d4, "Nescafe Classic", 470.00),
    Drink(14,"100G", R.drawable.ic_d5, "Nescafe Latte", 950.00),
    Drink(15,"50G", R.drawable.ic_d1, "Khao Shong Ag...", 470.00),
    Drink(16,"50G", R.drawable.ic_d2, "Khao Shong...", 450.00),
    Drink(17,"100G", R.drawable.ic_d3, "Nescafe Gold", 1700.00),
    Drink(18,"50G", R.drawable.ic_d4, "Nescafe Classic", 470.00),
    Drink(19,"100G", R.drawable.ic_d5, "Nescafe Latte", 950.00)
)

@Composable
fun CustomDrinkItem(drink: Drink) {
    Card(
        modifier = Modifier
            .width(104.dp)
            .height(144.dp)
            .padding(start = 10.dp, top = 15.dp, end = 10.dp, bottom = 10.dp)
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
                    text = drink.drinkGram,
                    fontSize = 8.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextCard,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            Image(
                painter = painterResource(id = drink.drinkImage),
                contentDescription = "Drink Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .align(Alignment.Center)
                    .height(50.dp)
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp)
                    .align(Alignment.BottomStart)
            ) {

                Text(
                    text = drink.drinkName,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Text1
                )

                Text(
                    text = "Rs.${drink.drinkSalary}",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black
                )
            }
        }
    }
}
