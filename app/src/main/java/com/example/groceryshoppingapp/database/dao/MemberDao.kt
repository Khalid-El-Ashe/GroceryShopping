package com.example.groceryshoppingapp.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.groceryshoppingapp.utiles.Member
import kotlinx.coroutines.flow.Flow

@Dao
interface MemberDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertMember(member: Member)

    @Delete
    suspend fun deleteMember(member: Member)

    @Query("select * from memberTable")
    fun selectMember(): Flow<List<Member>>
}