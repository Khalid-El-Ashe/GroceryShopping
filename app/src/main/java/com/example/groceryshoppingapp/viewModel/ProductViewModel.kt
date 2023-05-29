package com.example.groceryshoppingapp.viewModel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.core.net.toUri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.groceryshoppingapp.utiles.Product
import com.example.groceryshoppingapp.utiles.Resource
import com.example.groceryshoppingapp.viewModel.state.AppState
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    val firebaseFirestore: FirebaseFirestore,
    val firebaseStorage: FirebaseStorage
) : ViewModel() {

    var state by mutableStateOf(AppState())
        private set

    val _products = MutableStateFlow<Resource<List<Product>>>(Resource.Unspecified())
    val products = _products.asStateFlow()

//    init {
//        getVegetablesProductFromFirebase()
//    }

    fun addProductToFirebase(product: Product, type: String) {
        viewModelScope.launch {
            state = state.copy(isLoading = true, error = null)

            try {
                // Upload the image to Firebase Storage
                val id = UUID.randomUUID().toString()
                val storageReference = firebaseStorage.reference.child("products/images/$id")
                val uploadTask = storageReference.putFile(product.productImage!!.toUri())
                uploadTask.addOnSuccessListener {
                    // Image uploaded successfully
                    Log.d("TAG", "addProductToFirebase: success to upload")

                    // Call the appropriate function based on the product type
                    if (type.equals("Vegetables") || type.equals("vegetables") || type.equals("خضراوات")) {
                        vegetables(product = product, type = type)
                    } else if (type.equals("Pharmacy") || type.equals("pharmacy") || type.equals("أدوية")) {
                        pharmacy(product = product, type = type)
                    } else if (type.equals("Meat") || type.equals("meat") || type.equals("لحوم")) {
                        meat(product = product, type = type)
                    } else if (type.equals("Household") || type.equals("household")) {
                        household(product = product, type = type)
                    } else if (type.equals("Houseware") || type.equals("houseware") || type.equals("أدوات منزلية")) {
                        houseware(product = product, type = type)
                    } else if (type.equals("Fruit") || type.equals("Fruit") || type.equals("فاكهة")) {
                        fruit(product = product, type = type)
                    } else if (type.equals("Fozen") || type.equals("Fozen") || type.equals("مجمدات")) {
                        frozen(product = product, type = type)
                    } else if (type.equals("Fish") || type.equals("Fish") || type.equals("أسماك")) {
                        fish(product = product, type = type)
                    } else if (type.equals("Drink") || type.equals("Drink") || type.equals("مشروبات")) {
                        drink(product = product, type = type)
                    } else {
                        state = state.copy(isLoading = false, error = "The Type Product to wrong")
                    }

                }.addOnFailureListener { exception ->
                    // Handle the failure
                    Log.e("TAG", "addProductToFirebase: ${exception.message.toString()}")
                }
            } catch (e: Exception) {
                Log.e("AddImageProduct", "addProductToFirebase: ${e.message.toString()}")
            }
        }
    }

    fun getVegetablesProductFromFirebase() {
        viewModelScope.launch {
            try {
                state = state.copy(isLoading = true, error = null)
                _products.emit(Resource.Loading())

                val querySnapshot = firebaseFirestore.collection("Category")
                    .document("Vegetables")
                    .collection("Vegetables Products")
                    .get()
                    .await()

                val vegetableProduct = querySnapshot.toObjects(Product::class.java)

                state = state.copy(isLoading = false, error = null)
                _products.emit(Resource.Success(data = vegetableProduct))
            } catch (e: Exception) {
                Log.e("TAG", "getVegetablesProductFromFirebase: ${e.message}")
                state = state.copy(isLoading = false, error = e.message.toString())
                _products.emit(Resource.Error(e.message.toString()))
            }
        }
    }

    fun getPharmacyProductFromFirebase() {
        viewModelScope.launch {
            try {
                state = state.copy(isLoading = true, error = null)
                _products.emit(Resource.Loading())

                val querySnapshot = firebaseFirestore.collection("Category").document("Pharmacy")
                    .collection("Pharmacy Products").get().await()

                val pharmacyProduct = querySnapshot.toObjects(Product::class.java)
                state = state.copy(isLoading = false, error = null)
                _products.emit(Resource.Success(data = pharmacyProduct))

            } catch (e: Exception) {
                Log.e("TAG", "getPharmacyProductFromFirebase: ${e.message.toString()}")
                state = state.copy(isLoading = false, error = e.message.toString())
                _products.emit(Resource.Error(e.message.toString()))
            }
        }
    }

    fun getMeatProductFirebase() {
        viewModelScope.launch {
            try {
                state = state.copy(isLoading = true, error = null)
                _products.emit(Resource.Loading())

                val querySnapshot = firebaseFirestore.collection("Category").document("Meat")
                    .collection("Meat Products").get().await()

                val meatProduct = querySnapshot.toObjects(Product::class.java)
                state = state.copy(isLoading = false, error = null)
                _products.emit(Resource.Success(data = meatProduct))

            } catch (e: Exception) {
                Log.e("TAG", "getMeatProductFirebase: ${e.message}")
                state = state.copy(isLoading = false, error = null)
                _products.emit(Resource.Error(e.message.toString()))
            }
        }
    }

    fun getHousewareProductFirebase() {
        viewModelScope.launch {
            try {
                state = state.copy(isLoading = true, error = null)
                _products.emit(Resource.Loading())

                val querySnapshot = firebaseFirestore.collection("Category").document("Houseware")
                    .collection("Houseware Products").get().await()

                val housewareProduct = querySnapshot.toObjects(Product::class.java)
                state = state.copy(isLoading = false, error = null)
                _products.emit(Resource.Success(data = housewareProduct))

            } catch (e: Exception) {
                Log.e("TAG", "getHousewareProductFirebase: ${e.message}")
                state = state.copy(isLoading = false, error = e.message.toString())
                _products.emit(Resource.Error(e.message.toString()))
            }
        }
    }

    fun getHouseholdProductFirebase() {
        viewModelScope.launch {
            try {
                state = state.copy(isLoading = true, error = null)
                _products.emit(Resource.Loading())

                val querySnapshot = firebaseFirestore.collection("Category").document("Household")
                    .collection("Household Products").get().await()

                val householdProduct = querySnapshot.toObjects(Product::class.java)
                state = state.copy(isLoading = false, error = null)
                _products.emit(Resource.Success(data = householdProduct))

            } catch (e: Exception) {
                Log.e("TAG", "getHouseholdProductFirebase: ${e.message}")
                state = state.copy(isLoading = false, error = e.message.toString())
                _products.emit(Resource.Error(e.message.toString()))
            }
        }
    }

    fun getFruitProductFirebase() {
        viewModelScope.launch {
            try {
                state = state.copy(isLoading = true, error = null)
                _products.emit(Resource.Loading())

                val querySnapshot = firebaseFirestore.collection("Category").document("Fruit")
                    .collection("Fruit Products").get().await()

                val fruitProduct = querySnapshot.toObjects(Product::class.java)
                state = state.copy(isLoading = false, error = null)
                _products.emit(Resource.Success(data = fruitProduct))

            } catch (e: Exception) {
                Log.e("TAG", "getFruitProductFirebase: ${e.message}")
                state = state.copy(isLoading = false, error = e.message.toString())
                _products.emit(Resource.Error(e.message.toString()))
            }
        }
    }

    fun getFrozenFoodProductFirebase() {
        viewModelScope.launch {
            try {
                state = state.copy(isLoading = true, error = null)
                _products.emit(Resource.Loading())

                val querySnapshot = firebaseFirestore.collection("Category").document("Frozen Food")
                    .collection("Frozen Food Products").get().await()

                val frozenProduct = querySnapshot.toObjects(Product::class.java)
                state = state.copy(isLoading = false, error = null)
                _products.emit(Resource.Success(data = frozenProduct))

            } catch (e: Exception) {
                Log.e("TAG", "getFrozenFoodProductFirebase: ${e.message}")
                state = state.copy(isLoading = false, error = e.message.toString())
                _products.emit(Resource.Error(e.message.toString()))
            }
        }
    }

    fun getFishProductFirebase() {
        viewModelScope.launch {
            try {
                state = state.copy(isLoading = true, error = null)
                _products.emit(Resource.Loading())

                val querySnapshot = firebaseFirestore.collection("Category").document("Fish")
                    .collection("Fish Products").get().await()

                val fishProduct = querySnapshot.toObjects(Product::class.java)
                state = state.copy(isLoading = false, error = null)
                _products.emit(Resource.Success(data = fishProduct))

            } catch (e: Exception) {
                Log.e("TAG", "getFishProductFirebase: ${e.message}")
                state = state.copy(isLoading = false, error = e.message.toString())
                _products.emit(Resource.Error(e.message.toString()))
            }
        }
    }

    fun getDrinkProductFirebase() {
        viewModelScope.launch {
            try {
                state = state.copy(isLoading = true, error = null)
                _products.emit(Resource.Loading())

                val querySnapshot = firebaseFirestore.collection("Category").document("Drink")
                    .collection("Drink Products").get().await()

                val drinkProduct = querySnapshot.toObjects(Product::class.java)
                state = state.copy(isLoading = false, error = null)
                _products.emit(Resource.Success(data = drinkProduct))

            } catch (e: Exception) {
                Log.e("TAG", "getDrinkProductFirebase: ${e.message}")
                state = state.copy(isLoading = false, error = e.message.toString())
                _products.emit(Resource.Error(e.message.toString()))
            }
        }
    }

    private fun chilled(product: Product, type: String) {
        firebaseFirestore.collection("Category").document("Chilled")
            .collection("Chilled Products")
            .document().set(product).addOnSuccessListener {
                viewModelScope.launch {
                    state = state.copy(isLoading = false, error = null)
                }
                Log.d(
                    "AddProduct",
                    "addProductToFirebase: success to add product to firebase"
                )
            }.addOnFailureListener {
                viewModelScope.launch {
                    state = state.copy(isLoading = false, error = it.message.toString())
                }
                Log.e(
                    "AddProductError",
                    "addProductToFirebase: ${it.message.toString()}"
                )
            }
    }


    private fun drink(product: Product, type: String) {
        firebaseFirestore.collection("Category").document("Drink")
            .collection("Drink Products")
            .document().set(product).addOnSuccessListener {
                viewModelScope.launch {
                    state = state.copy(isLoading = false, error = null)
                }
                Log.d(
                    "AddProduct",
                    "addProductToFirebase: success to add product to firebase"
                )
            }.addOnFailureListener {
                viewModelScope.launch {
                    state = state.copy(isLoading = false, error = it.message.toString())
                }
                Log.e(
                    "AddProductError",
                    "addProductToFirebase: ${it.message.toString()}"
                )
            }
    }


    private fun fish(product: Product, type: String) {
        firebaseFirestore.collection("Category").document("Fish")
            .collection("Fish Products")
            .document().set(product).addOnSuccessListener {
                viewModelScope.launch {
                    state = state.copy(isLoading = false, error = null)
                }
                Log.d(
                    "AddProduct",
                    "addProductToFirebase: success to add product to firebase"
                )
            }.addOnFailureListener {
                viewModelScope.launch {
                    state = state.copy(isLoading = false, error = it.message.toString())
                }
                Log.e(
                    "AddProductError",
                    "addProductToFirebase: ${it.message.toString()}"
                )
            }
    }


    private fun frozen(product: Product, type: String) {
        firebaseFirestore.collection("Category").document("Frozen Food")
            .collection("Frozen Food Products")
            .document().set(product).addOnSuccessListener {
                viewModelScope.launch {
                    state = state.copy(isLoading = false, error = null)
                }
                Log.d(
                    "AddProduct",
                    "addProductToFirebase: success to add product to firebase"
                )
            }.addOnFailureListener {
                viewModelScope.launch {
                    state = state.copy(isLoading = false, error = it.message.toString())
                }
                Log.e(
                    "AddProductError",
                    "addProductToFirebase: ${it.message.toString()}"
                )
            }
    }


    private fun fruit(product: Product, type: String) {
        firebaseFirestore.collection("Category").document("Fruit")
            .collection("Fruit Products")
            .document().set(product).addOnSuccessListener {
                viewModelScope.launch {
                    state = state.copy(isLoading = false, error = null)
                }
                Log.d(
                    "AddProduct",
                    "addProductToFirebase: success to add product to firebase"
                )
            }.addOnFailureListener {
                viewModelScope.launch {
                    state = state.copy(isLoading = false, error = it.message.toString())
                }
                Log.e(
                    "AddProductError",
                    "addProductToFirebase: ${it.message.toString()}"
                )
            }
    }

    private fun houseware(product: Product, type: String) {
        firebaseFirestore.collection("Category").document("Houseware")
            .collection("Houseware Products").document().set(product).addOnSuccessListener {
                viewModelScope.launch {
                    state = state.copy(isLoading = false, error = null)
                }
                Log.d(
                    "AddProduct",
                    "addProductToFirebase: success to add product to firebase"
                )
            }.addOnFailureListener {
                viewModelScope.launch {
                    state = state.copy(isLoading = false, error = it.message.toString())
                }
            }
    }

    private fun household(product: Product, type: String) {
        firebaseFirestore.collection("Category").document("Household")
            .collection("Household Products")
            .document().set(product).addOnSuccessListener {
                viewModelScope.launch {
                    state = state.copy(isLoading = false, error = null)
                }
                Log.d(
                    "AddProduct",
                    "addProductToFirebase: success to add product to firebase"
                )
            }.addOnFailureListener {
                viewModelScope.launch {
                    state = state.copy(isLoading = false, error = it.message.toString())
                }
                Log.e(
                    "AddProductError",
                    "addProductToFirebase: ${it.message.toString()}"
                )
            }
    }


    private fun meat(product: Product, type: String) {
        firebaseFirestore.collection("Category").document("Meat")
            .collection("Meat Products")
            .document().set(product).addOnSuccessListener {
                viewModelScope.launch {
                    state = state.copy(isLoading = false, error = null)
                }
                Log.d(
                    "AddProduct",
                    "addProductToFirebase: success to add product to firebase"
                )
            }.addOnFailureListener {
                viewModelScope.launch {
                    state = state.copy(isLoading = false, error = it.message.toString())
                }
                Log.e(
                    "AddProductError",
                    "addProductToFirebase: ${it.message.toString()}"
                )
            }
    }


    private fun pharmacy(product: Product, type: String) {
        firebaseFirestore.collection("Category").document("Pharmacy")
            .collection("Pharmacy Products")
            .document().set(product).addOnSuccessListener {
                viewModelScope.launch {
                    state = state.copy(isLoading = false, error = null)
                }
                Log.d(
                    "AddProduct",
                    "addProductToFirebase: success to add product to firebase"
                )
            }.addOnFailureListener {
                viewModelScope.launch {
                    state = state.copy(isLoading = false, error = it.message.toString())
                }
                Log.e(
                    "AddProductError",
                    "addProductToFirebase: ${it.message.toString()}"
                )
            }
    }

    private fun vegetables(product: Product, type: String) {
        firebaseFirestore.collection("Category").document("Vegetables")
            .collection("Vegetables Products")
            .document().set(product).addOnSuccessListener {
                viewModelScope.launch {
                    state = state.copy(isLoading = false, error = null)
                }
                Log.d(
                    "AddProduct",
                    "addProductToFirebase: success to add product to firebase"
                )
            }.addOnFailureListener {
                viewModelScope.launch {
                    state = state.copy(isLoading = false, error = it.message.toString())
                }
                Log.e(
                    "AddProductError",
                    "addProductToFirebase: ${it.message.toString()}"
                )
            }
    }
}