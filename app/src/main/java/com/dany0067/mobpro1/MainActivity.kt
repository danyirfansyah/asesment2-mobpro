package com.dany0067.mobpro1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.dany0067.mobpro1.navigation.SetupNavGraph
import com.dany0067.mobpro1.ui.theme.Mobpro1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Mobpro1Theme {
                SetupNavGraph()
            }

        }
    }
}

