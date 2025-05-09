package com.dany0067.mobpro1.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dany0067.mobpro1.database.CatatanDao
import com.dany0067.mobpro1.model.CatatanWithTelefon
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class MainViewModel(dao: CatatanDao) : ViewModel() {
    val data: StateFlow<List<CatatanWithTelefon>> = dao.getCatatanWithKontak().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(),
        initialValue = emptyList()
    )
}
