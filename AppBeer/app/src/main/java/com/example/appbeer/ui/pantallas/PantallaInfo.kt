package com.example.appbeer.ui.pantallas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun PantallaInfo(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize()
        .padding(20.dp), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //queremos volver atras

        Button(onClick = {navController.popBackStack()},
            modifier = Modifier.align(Alignment.Start)
        ) {Text("Volver")}
        Spacer(modifier = Modifier.height(24.dp))
        Text("Desarrollado por Jimmy", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(12.dp))
        Text("ESta app te busca las mejores cervezas del mundo",
            style = MaterialTheme.typography.labelMedium)


        }
    }
