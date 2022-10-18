package com.example.criptobitsoproyectwz.data.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CriptoEntity::class, CriptoCoinEntity::class], version = 1)
abstract class CriptoDatabase : RoomDatabase() {
    abstract fun criptoDao(): CriptoDao
}
