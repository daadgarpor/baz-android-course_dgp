package com.example.criptobitsoproyectwz.data.Room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CriptoEntity::class], version = 1)
abstract class CriptoDatabase : RoomDatabase(){
    abstract fun criptoDao(): CriptoDao
}