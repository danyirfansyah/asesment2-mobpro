package com.dany0067.mobpro1.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.dany0067.mobpro1.model.Catatan
import com.dany0067.mobpro1.model.CatatanWithTelefon
import com.dany0067.mobpro1.model.Kontak
import kotlinx.coroutines.flow.Flow

@Dao
interface CatatanDao {

    @Insert
    suspend fun insert(catatan: Catatan): Long

    @Insert
    suspend fun insert(kontak: Kontak): Long

    @Update
    suspend fun update(catatan: Catatan)

    @Update
    suspend fun updateKontak(kontak: Kontak)

    @Transaction
    suspend fun updateCatatanWithKontak(catatan: Catatan, kontak: Kontak) {
        update(catatan)
        updateKontak(kontak)
    }

    @Transaction
    suspend fun insertCatatanWithKontak(catatan: Catatan, kontak: Kontak) {
        val catatanId = insert(catatan)
        kontak.catatanId = catatanId
        insert(kontak)
    }

    @Transaction
    @Query("SELECT * FROM catatan WHERE id = :id")
    suspend fun getCatatanWithKontak(id: Long): CatatanWithTelefon?

    @Transaction
    @Query("SELECT * FROM catatan")
    fun getCatatanWithKontak(): Flow<List<CatatanWithTelefon>>

    @Query("SELECT * FROM catatan WHERE id = :id")
    suspend fun getCatatanById(id: Long): Catatan?

    @Query("SELECT * FROM kontak WHERE catatanId = :catatanId")
    suspend fun getKontakByCatatanId(catatanId: Long): Kontak?

    @Query("DELETE FROM catatan WHERE id = :id")
    suspend fun deleteById(id: Long)

    @Query("DELETE FROM kontak WHERE catatanId = :catatanId")
    suspend fun deleteKontakByCatatanId(catatanId: Long)

    @Transaction
    suspend fun deleteCatatanWithKontak(id: Long) {
        deleteKontakByCatatanId(id)
        deleteById(id)
    }
}
