package com.example.groceryshoppingapp.ui.compose.categories


import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.groceryshoppingapp.R
import com.example.groceryshoppingapp.ui.theme.BackgroundContainer
import com.example.groceryshoppingapp.ui.theme.SplashColor
import com.example.groceryshoppingapp.ui.theme.Text2
import com.example.groceryshoppingapp.utiles.Product
import com.example.groceryshoppingapp.viewModel.ProductViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun VegetablesScreen(navigator: DestinationsNavigator) {
    val viewmodel = hiltViewModel<ProductViewModel>()

    val products by viewmodel.products.collectAsState()
    val context = LocalContext.current

    Box(modifier = Modifier.fillMaxSize()) {
        TopAppBar(
            contentColor = Color.White,
            backgroundColor = SplashColor,
            title = {
                Box(modifier = Modifier.fillMaxSize()) {
                    Text(text = "Vegetables", modifier = Modifier.align(Alignment.CenterStart))
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
            },
            modifier = Modifier.align(Alignment.TopCenter)
        )

        LaunchedEffect(Unit) {
            viewmodel.getVegetablesProductFromFirebase()
        }

        if (viewmodel.state.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center),
                color = SplashColor
            )
        } else {
            ProductList(products = products.data, modifier = Modifier.align(Alignment.TopCenter).padding(top = 70.dp))
        }


        viewmodel.state.error?.let { error ->
            Toast.makeText(context, error.toString(), Toast.LENGTH_SHORT).show()
            Log.d("TAG", "VegetablesScreen: $error")
        }

    }
}

@Composable
private fun ProductList(
    products: List<Product>?,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        items(products ?: emptyList()) { product ->
            ProductItem(product = product)
        }
    }
}


@OptIn(ExperimentalCoilApi::class)
@Composable
private fun ProductItem(product: Product) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .padding(start = 5.dp, end = 5.dp)
            .background(color = BackgroundContainer, shape = RoundedCornerShape(10.dp))
    ) {
        val context = LocalContext.current
        val imageBitmap = (product.productImage!!)

        if (imageBitmap != null) {
            Image(
                painter = rememberImagePainter(data = product.productImage),
                contentScale = ContentScale.Crop,
                contentDescription = "Vegetables Image",
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .clip(shape = RoundedCornerShape(5.dp))
                    .background(color = SplashColor)
                    .padding(5.dp)
                    .width(100.dp)
                    .height(110.dp)
            )
        } else {
            Icon(
                painter = painterResource(id = R.drawable.baseline_broken_image_24),
                contentDescription = "Image Placeholder",
                tint = Color.LightGray,
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .clip(shape = RoundedCornerShape(5.dp))
                    .background(color = SplashColor)
                    .padding(5.dp)
                    .width(100.dp)
                    .height(110.dp)
            )
        }

        Column(
            modifier = Modifier.align(Alignment.Center),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = product.productName!!,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = Text2,
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "${product.productGram} Gram",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Salary: ${product.productPrice}",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = SplashColor,
            )
        }
    }
}


//@OptIn(ExperimentalCoilApi::class)
//class ContentUriFetcher(private val context: Context) : UriFetcher(context) {
//    override fun handles(data: Uri): Boolean {
//        // Return true if you want this fetcher to handle the provided Uri
//        // You can customize the logic here based on your requirements
//        return data.scheme == ContentResolver.SCHEME_CONTENT
//    }
//
//    override suspend fun fetch(
//        pool: BitmapPool,
//        data: Uri,
//        size: Size,
//        options: Options
//    ): FetchResult {
//        val inputStream = context.contentResolver.openInputStream(data)
//        val drawable = Drawable.createFromStream(inputStream, data.toString())
//        val bitmap = (drawable as? BitmapDrawable)?.bitmap
//        return SourceResult(bitmap?.asImageBitmap(), dataSource = DataSource.DISK)
//    }
//}


//@OptIn(ExperimentalCoilApi::class)
//@Composable
//suspend fun loadImageFromContentUri(uriString: String): ImageBitmap? {
//    val context = LocalContext.current
//    val imageLoader = ImageLoader.Builder(context)
//        .components(fun ComponentRegistry.Builder.() {
//            add(ContentUriFetcher(context))
//        })
//        .build()
//
//    return try {
//        val imageRequest = ImageRequest.Builder(context)
//            .data(Uri.parse(uriString))
//            .build()
//
//        val drawable = (imageLoader.execute(imageRequest).drawable as BitmapDrawable?)?.bitmap
//        drawable?.asImageBitmap()
//    } catch (e: Exception) {
//        // Handle the exception
//        null
//    }
//}

//@Composable
//suspend fun ContentUriImage(
//    uriString: String,
//    contentDescription: String,
//    modifier: Modifier = Modifier,
//    imageSize: Dp
//) {
//    val imageBitmap = loadImageFromContentUri(uriString)
//
//    imageBitmap?.let {
//        Image(
//            bitmap = it,
//            contentDescription = contentDescription,
//            contentScale = ContentScale.Crop,
//            modifier = modifier
//                .size(imageSize)
//        )
//    }
//}