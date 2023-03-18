package uz.gita.mirzabek.example.bookapp.data.local.room.daos

import androidx.room.*
import uz.gita.mirzabek.example.bookapp.data.remote.response.UserResponse


@Dao
interface UsersDao {

    @Insert
    fun insert(usersEntity: UserResponse): Long

    @Insert
    fun insertAll(users: List<UserResponse>)

    @Delete
    fun delete(usersEntity: UserResponse)

    @Update
    fun update(usersEntity: UserResponse)

    @Query("SELECT * FROM users ")
    fun getUsers(): List<UserResponse>

}