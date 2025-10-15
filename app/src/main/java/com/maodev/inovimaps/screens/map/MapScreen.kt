package com.maodev.inovimaps.screens.map

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import com.maodev.inovimaps.core.components.InoviMapText

@Composable
fun MapScreen() {
    var isSattelite by remember { mutableStateOf(false) }
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(LatLng(5.71434, -72.93391), 10f)
    }
    val mapProperties by remember { derivedStateOf { MapProperties(mapType = if (isSattelite) MapType.NORMAL else MapType.HYBRID) } }
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            GoogleMap(
                modifier = Modifier
                    .height(600.dp)
                    .padding(top = 32.dp, bottom = 16.dp),
                cameraPositionState = cameraPositionState,
                properties = mapProperties
            ) {
                Marker(
                    position = LatLng(5.71434, -72.93391)
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,

            ) {
                InoviMapText(modifier=Modifier.weight(1f),text = "Change map type:", textStyle = MaterialTheme.typography.bodyLarge)
                Switch(checked = isSattelite, onCheckedChange = { isSattelite = it })
            }
        }
    }
}