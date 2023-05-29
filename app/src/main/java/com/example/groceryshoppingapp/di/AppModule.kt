package com.example.groceryshoppingapp.di

import android.app.Application
import android.content.Context
import androidx.compose.ui.tooling.preview.Preview
import androidx.room.Room
import com.example.groceryshoppingapp.database.GroceryDatabase
import com.example.groceryshoppingapp.database.GroceryRepository
import com.example.groceryshoppingapp.utiles.Constants.INTRODUCTION_SP
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providerFirebaseAuth() = FirebaseAuth.getInstance()

    // i need to make instance of database store lib the Auth
    @Provides
    @Singleton
    fun providerFirebaseFireStoreDatabase() = Firebase.firestore

    @Provides
    @Singleton
    fun providerFirebaseStorage() = FirebaseStorage.getInstance()

    // i need to make instance of sharedPreferences to login one time and save the data login
    @Provides
    @Singleton
    fun providerIntroductionSharedPreferance(application: Application) =
        application.getSharedPreferences(INTRODUCTION_SP, Context.MODE_PRIVATE)

    @Provides
    @Singleton
    fun providerDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, GroceryDatabase::class.java, "grocery.db").build()

    @Provides
    @Singleton
    fun providerRepository(groceryDatabase: GroceryDatabase) = GroceryRepository(groceryDatabase)

    // in here i need to make instance of class firebase common
//    @Provides
//    @Singleton
//    fun providerFirebaseCommon(firebaseAuth: FirebaseAuth, firestore: FirebaseFirestore) =
//        FirebaseCommon(firestore, firebaseAuth)

//    @Provides
//    @Singleton
//    fun providerStorage() = FirebaseStorage.getInstance().reference

}