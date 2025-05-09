package com.dany0067.mobpro1.util

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dany0067.mobpro1.database.CatatanDb
import com.dany0067.mobpro1.ui.screen.DetailViewModel
import com.dany0067.mobpro1.ui.screen.MainViewModel

class ViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val dao = CatatanDb.getInstance(context)
        val catatanDao = dao.catatanDao

        return when {
            modelClass.isAssignableFrom(MainViewModel::class.java) -> {
                MainViewModel(catatanDao) as T
            }
            modelClass.isAssignableFrom(DetailViewModel::class.java) -> {
                DetailViewModel(catatanDao) as T
            }
            else -> throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}
