package com.dany0067.mobpro1.model

import androidx.room.Embedded
import androidx.room.Relation

data class CatatanWithTelefon(
    @Embedded val catatan: Catatan,
    @Relation(
        parentColumn = "id",
        entityColumn = "catatanId"
    ) val kontak: Kontak
)
