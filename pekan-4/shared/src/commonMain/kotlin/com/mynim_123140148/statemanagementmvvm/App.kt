package com.mynim_123140148.statemanagementmvvm

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mynim_123140148.statemanagementmvvm.ui.AppTheme
import com.mynim_123140148.statemanagementmvvm.ui.EditProfileScreen
import com.mynim_123140148.statemanagementmvvm.ui.ProfileScreen
import com.mynim_123140148.statemanagementmvvm.viewmodel.ProfileViewModel

@Composable
@Preview
fun App(viewModel: ProfileViewModel = viewModel { ProfileViewModel() }) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    AppTheme(darkTheme = uiState.isDarkMode) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Box(Modifier.safeContentPadding()) {
            if (uiState.isEditing) {
                EditProfileScreen(
                    initialName = uiState.profile.name,
                    initialBio = uiState.profile.bio,
                    onSave = viewModel::saveProfile,
                    onCancel = viewModel::cancelEditing
                )
            } else {
                ProfileScreen(
                    uiState = uiState,
                    onEditClick = viewModel::startEditing,
                    onDarkModeChange = viewModel::setDarkMode
                )
            }
            }
        }
    }
}
