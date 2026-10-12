package com.mynim_123140148.composemultiplatform

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mynim_123140148.composemultiplatform.ui.InfoItem
import com.mynim_123140148.composemultiplatform.ui.ProfileCard
import com.mynim_123140148.composemultiplatform.ui.ProfileHeader

/** My Profile App (Pertemuan 3). Data masih hardcode; state & MVVM dibahas di Pertemuan 4. */
@Composable
@Preview
fun App() {
    MaterialTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            ProfileScreen()
        }
    }
}

@Composable
fun ProfileScreen() {
    var showContact by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .safeContentPadding()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ProfileHeader(
            name = "Muhammad Rafly Yahya Ramadhan",
            nim = "123140148"
        )

        Spacer(Modifier.height(24.dp))
        ProfileCard(title = "Bio") {
            Text(
                "Mahasiswa Teknik Informatika ITERA yang sedang belajar " +
                    "Kotlin Multiplatform dan Compose."
            )
        }

        Spacer(Modifier.height(16.dp))
        // Bonus: AnimatedVisibility
        AnimatedVisibility(visible = showContact) {
            ProfileCard(title = "Informasi Kontak") {
                InfoItem(icon = "✉", label = "Email", value = "muhammad.123140148@student.itera.ac.id")
                InfoItem(icon = "☎", label = "Phone", value = "+62 812-3456-7890")
                InfoItem(icon = "📍", label = "Location", value = "Lampung Selatan, Indonesia")
            }
        }

        Spacer(Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Button(
                onClick = { showContact = !showContact },
                modifier = Modifier.weight(1f)
            ) {
                Text(if (showContact) "Sembunyikan Kontak" else "Tampilkan Kontak")
            }
            OutlinedButton(onClick = { }, modifier = Modifier.weight(1f)) {
                Text("Follow")
            }
        }
    }
}
