package com.mynim_123140148.statemanagementmvvm.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mynim_123140148.statemanagementmvvm.viewmodel.ProfileUiState

/** Tampilan profil (stateless): semua data & aksi datang dari parent. */
@Composable
fun ProfileScreen(
    uiState: ProfileUiState,
    onEditClick: () -> Unit,
    onDarkModeChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    val profile = uiState.profile
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ProfileHeader(name = profile.name, nim = profile.nim)

        Spacer(Modifier.height(24.dp))
        ProfileCard(title = "Bio") {
            Text(profile.bio.ifBlank { "Belum ada bio." })
        }

        Spacer(Modifier.height(16.dp))
        ProfileCard(title = "Informasi Kontak") {
            InfoItem(icon = "✉", label = "Email", value = profile.email)
            InfoItem(icon = "☎", label = "Phone", value = profile.phone)
            InfoItem(icon = "📍", label = "Location", value = profile.location)
        }

        Spacer(Modifier.height(16.dp))
        ProfileCard(title = "Tampilan") {
            DarkModeToggle(
                isDarkMode = uiState.isDarkMode,
                onCheckedChange = onDarkModeChange
            )
        }

        Spacer(Modifier.height(24.dp))
        Button(onClick = onEditClick, modifier = Modifier.fillMaxWidth()) {
            Text("Edit Profile")
        }
    }
}
