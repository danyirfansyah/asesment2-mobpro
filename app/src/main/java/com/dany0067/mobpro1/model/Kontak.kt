package com.dany0067.mobpro1.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "kontak",
    foreignKeys = [
        ForeignKey(
            entity = Catatan::class,
            parentColumns = ["id"],
            childColumns = ["catatanId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Kontak(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val noHp: String,
    val email: String,
    var catatanId: Long // Kolom yang mengacu ke Catatan
)