package com.example.groceryshoppingapp.viewModel

import androidx.lifecycle.ViewModel
import com.example.groceryshoppingapp.utiles.*
import com.example.groceryshoppingapp.utiles.Constants.USER_COLLECTION
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(private val firebaseAuth: FirebaseAuth, private val db: FirebaseFirestore) : ViewModel() {

    private val _signUp = MutableStateFlow<Resource<User>>(Resource.Unspecified())
    val signUp: Flow<Resource<User>> = _signUp

    private val _validation = Channel<RegisterFieldsState>()
    val validation = _validation.receiveAsFlow()

    fun createAccountWithEmailAndPassword(user: User) {
        if (checkValidation(user = user)){
            runBlocking {
                _signUp.emit(Resource.Loading())
            }
            firebaseAuth.createUserWithEmailAndPassword(user.email, user.password).addOnSuccessListener {
                it.user?.let {
                    saveUserData(userUid = it.uid, user = user)
                }
            }.addOnFailureListener {
                _signUp.value = Resource.Error(it.message.toString())
            }
        } else {
            val registerFieldState = RegisterFieldsState(validateEmail(user.email), validatePassword(user.password))
            runBlocking {
                _validation.send(registerFieldState)
            }
        }
    }

    private fun saveUserData(userUid: String, user: User) {
        db.collection(USER_COLLECTION).document(userUid).set(user).addOnSuccessListener {
            _signUp.value = Resource.Success(data = user)
        }.addOnFailureListener {
            _signUp.value = Resource.Error(it.message.toString())
        }
    }

    private fun checkValidation(user: User): Boolean {
        val emailValidate = validateEmail(user.email)
        val passwordValidate = validatePassword(user.password)

        val shouldRegister =
            emailValidate is RegisterValidation.Success && passwordValidate is RegisterValidation.Success
        return shouldRegister
    }
}