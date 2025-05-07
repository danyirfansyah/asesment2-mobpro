package com.dany0067.mobpro1.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dany0067.mobpro1.database.CatatanDao
import com.dany0067.mobpro1.model.Catatan
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewModel(private val dao: CatatanDao) : ViewModel() {

    fun insert(nama: String, nim: String, kelas: String) {
        val catatan = Catatan(
            nama = nama,
            NIM   = nim,
            kelas = kelas
        )

        viewModelScope.launch(Dispatchers.IO) {
            dao.insert(catatan)
        }
    }

    suspend fun getCatatan(id: Long): Catatan? {
        return dao.getCatatanById(id)
    }

    fun update(id: Long, nama: String, NIM: String, kelas: String) {
        val catatan = Catatan(
            id  = id,
            nama   = nama,
            NIM = NIM,
            kelas = kelas
        )

        viewModelScope.launch(Dispatchers.IO) {
            dao.update(catatan)
        }
    }

    fun delete(id: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            dao.deleteById(id)
        }
    }

}