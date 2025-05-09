package com.dany0067.mobpro1.ui.screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dany0067.mobpro1.database.CatatanDao
import com.dany0067.mobpro1.model.Catatan
import com.dany0067.mobpro1.model.CatatanWithTelefon
import com.dany0067.mobpro1.model.Kontak
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewModel(private val dao: CatatanDao) : ViewModel() {

    fun insert(nama: String, nim: String, jenisKelamin: String, noHp: String, email: String) {
        val catatan = Catatan(
            nama = nama,
            NIM = nim,
            jenisKelamin = jenisKelamin
        )

        val kontak = Kontak(
            noHp = noHp,
            email = email,
            catatanId = 0L
        )

        viewModelScope.launch(Dispatchers.IO) {
            dao.insertCatatanWithKontak(catatan, kontak)
        }
    }

    fun update(id: Long, nama: String, nim: String, jenisKelamin: String, noHp: String, email: String) {
        val catatan = Catatan(
            id = id,
            nama = nama,
            NIM = nim,
            jenisKelamin = jenisKelamin
        )

        val kontak = Kontak(
            id = id,
            noHp = noHp,
            email = email,
            catatanId = id
        )

        viewModelScope.launch(Dispatchers.IO) {
            Log.d("DetailViewModel", "Updating Catatan: $catatan")
            Log.d("DetailViewModel", "Updating Kontak: $kontak")

            dao.updateCatatanWithKontak(catatan, kontak)
        }
    }

    fun delete(id: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            dao.deleteCatatanWithKontak(id)
        }
    }

    suspend fun getCatatanWithKontak(id: Long): CatatanWithTelefon? {
        return dao.getCatatanWithKontak(id)
    }
}
