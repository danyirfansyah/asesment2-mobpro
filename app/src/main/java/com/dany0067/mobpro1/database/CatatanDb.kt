package com.dany0067.mobpro1.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dany0067.mobpro1.model.Catatan
import com.dany0067.mobpro1.model.Kontak

@Database(entities = [Catatan::class, Kontak::class], version = 1)
abstract class CatatanDb : RoomDatabase() {
    abstract val catatanDao: CatatanDao

    companion object {
        @Volatile
        private var INSTANCE: CatatanDb? = null

        fun getInstance(context: Context): CatatanDb {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        CatatanDb::class.java,
                        "catatan2.db"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
