package com.example.groceryshoppingapp.ui.compose

import android.annotation.SuppressLint
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.example.groceryshoppingapp.R
import com.example.groceryshoppingapp.ui.theme.CircularColor2
import com.example.groceryshoppingapp.ui.theme.SplashColor
import com.example.groceryshoppingapp.ui.theme.TaskBarColor
import com.example.groceryshoppingapp.ui.theme.Text2
import com.example.groceryshoppingapp.utiles.Product
import com.example.groceryshoppingapp.utiles.Resource
import com.example.groceryshoppingapp.viewModel.ProductViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Destination
@Composable
fun AddItemScreen(navigator: DestinationsNavigator) {

    val context = LocalContext.current
    val viewmodel = hiltViewModel<ProductViewModel>()

    val selectedImageUri = remember { mutableStateOf<Uri?>(null) }
    val launcher =
        rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
            selectedImageUri.value = uri
        }

    val scop = rememberCoroutineScope()

    var prodGram by remember {
        mutableStateOf("")
    }
    var prodName by remember {
        mutableStateOf("")
    }
    var prodPrice by remember {
        mutableStateOf("")
    }

    var productType by remember {
        mutableStateOf("")
    }

    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        TopAppBar(
            contentColor = Color.White,
            backgroundColor = SplashColor,
            title = {
                Box(modifier = Modifier.fillMaxSize()) {
                    Text(
                        text = "Add Item to Shopping",
                        modifier = Modifier.align(Alignment.CenterStart)
                    )
                }
            },
            navigationIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_back),
                    contentDescription = "Back", modifier = Modifier
                        .padding(start = 10.dp)
                        .clickable {
                            navigator.navigateUp()
                        }
                )
            }
        )

        Box(
            modifier = Modifier
                .width(150.dp)
                .height(200.dp)
                .padding(top = 20.dp)
                .background(color = SplashColor, shape = RoundedCornerShape(20.dp))
                .clickable {
                    launcher.launch("image/*")
                }
        ) {
            if (selectedImageUri.value != null) {
                Image(
                    painter = rememberImagePainter(data = selectedImageUri.value),
                    contentScale = ContentScale.Crop,
                    contentDescription = "Selected Image",
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(shape = RoundedCornerShape(20.dp))
                )
            } else {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_broken_image_24),
                    contentDescription = "Add Image",
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(50.dp)
                        .clickable {
                            launcher.launch("image/*")
                        },
                    tint = TaskBarColor
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value = prodName,
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text),
            onValueChange = { name -> prodName = name },
            label = {
                Text(
                    text = "Product Name",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            },
            shape = RoundedCornerShape(5.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = SplashColor,
                unfocusedBorderColor = SplashColor
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, end = 15.dp, top = 10.dp)
        )

        OutlinedTextField(
            value = prodGram,
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            onValueChange = { name -> prodGram = name },
            label = {
                Text(
                    text = "Product Gram",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            },
            shape = RoundedCornerShape(5.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = SplashColor,
                unfocusedBorderColor = SplashColor
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, end = 15.dp, top = 10.dp)
        )

        OutlinedTextField(
            value = prodPrice,
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            onValueChange = { name -> prodPrice = name },
            label = {
                Text(
                    text = "Product Price",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            },
            shape = RoundedCornerShape(5.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = SplashColor,
                unfocusedBorderColor = SplashColor
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, end = 15.dp, top = 10.dp)
        )

        OutlinedTextField(
            value = productType,
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text),
            onValueChange = { type -> productType = type },
            label = {
                Text(
                    text = "Product Type",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            },
            shape = RoundedCornerShape(5.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = SplashColor,
                unfocusedBorderColor = SplashColor
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, end = 15.dp, top = 10.dp)
        )

        Spacer(modifier = Modifier.height(50.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(start = 15.dp, end = 15.dp)
                .clickable {
                    if (selectedImageUri.value == null || prodName.isEmpty() || prodGram.isEmpty() || prodPrice.isEmpty() || productType.isEmpty()) {
                        Toast
                            .makeText(
                                context,
                                "You must fill in all the fields",
                                Toast.LENGTH_SHORT
                            )
                            .show()
                    } else {
                        val product = Product(
                            productName = prodName,
                            productGram = prodGram,
                            productPrice = prodPrice,
                            productImage = selectedImageUri.value.toString()
                        )
                        viewmodel.addProductToFirebase(product = product, type = productType)
                    }
                }
                .background(color = SplashColor, shape = RoundedCornerShape(5.dp))

        ) {

            Row(
                modifier = Modifier
                    .fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Save to Products Shopping",
                    style = TextStyle(
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                    )
                )
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        Box(modifier = Modifier.fillMaxWidth()) {
            if (viewmodel.state.isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .align(Alignment.Center),
                    color = SplashColor
                )
            }

            viewmodel.state.error?.let { error ->
                Toast.makeText(context, error.toString(), Toast.LENGTH_SHORT).show()
            }
        }

    }
}

//@Composable
//fun Greeting5(name: String) {
//    AddItemScreen()
//}
//
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    GroceryShoppingAppTheme {
//        Greeting5("Android")
//    }
//}