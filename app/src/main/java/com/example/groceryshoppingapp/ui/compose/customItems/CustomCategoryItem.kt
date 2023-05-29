package com.example.groceryshoppingapp.ui.compose.customItems

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.groceryshoppingapp.R
import com.example.groceryshoppingapp.ui.compose.destinations.*
import com.example.groceryshoppingapp.ui.compose.destinations.HouseholdScreenDestination
import com.example.groceryshoppingapp.ui.theme.CircularColor
import com.example.groceryshoppingapp.ui.theme.SplashColor
import com.example.groceryshoppingapp.ui.theme.Text1
import com.example.groceryshoppingapp.utiles.Categories
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
fun Categories(navigator: DestinationsNavigator) {

    LazyRow {
        items(categoriesList) {
            CustomCategoryItem(categories = it, navigator = navigator)
        }
    }
}

val categoriesList = listOf(
    Categories(R.drawable.ic_household, "Household"),
    Categories(R.drawable.ic_liquor, "Drinks"),
    Categories(R.drawable.ic_chilled, "Chilled"),
    Categories(R.drawable.ic_pharmacy, "Pharmacy"),
    Categories(R.drawable.ic_frozen, "Frozen Food"),
    Categories(R.drawable.ic_vegetables, "Vegetables"),
    Categories(R.drawable.ic_meat, "Meat"),
    Categories(R.drawable.ic_fish, "Fish"),
    Categories(R.drawable.ic_homeware, "Homeware"),
    Categories(R.drawable.ic_fruits, "Fruits")
)

@Composable
fun CustomCategoryItem(categories: Categories, navigator: DestinationsNavigator) {

    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 10.dp, top = 15.dp, end = 10.dp), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .clip(shape = CircleShape)
                .background(color = CircularColor)
                .width(70.dp)
                .height(70.dp)
                .clickable {
                    when (categories.title) {
                        "Household" -> {
                            navigator.navigate(HouseholdScreenDestination)
                        }
                        "Drinks" -> {
                            navigator.navigate(DrinkScreenDestination)
                        }
                        "Chilled" -> {
                            navigator.navigate(ChilledScreenDestination)
                        }
                        "Pharmacy" -> {
                            navigator.navigate(PharmacyScreenDestination)
                        }
                        "Frozen Food" -> {
                            navigator.navigate(FrozenScreenDestination)
                        }
                        "Vegetables" -> {
                            navigator.navigate(VegetablesScreenDestination)
                        }
                        "Meat" -> {
                            navigator.navigate(MeatScreenDestination)
                        }
                        "Fish" -> {
                            navigator.navigate(FishScreenDestination)
                        }
                        "Homeware" -> {
                            navigator.navigate(HomewareScreenDestination)
                        }
                        "Fruits" -> {
                            navigator.navigate(FruitsScreenDestination)
                        }
                    }
                }
        ) {
            Icon(
                painter = painterResource(id = categories.icon),
                tint = SplashColor,
                contentDescription = "category icon",
                modifier = Modifier.align(
                    Alignment.Center
                )
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = categories.title, fontWeight = FontWeight.Bold, fontSize = 12.sp, color = Text1)
    }
}