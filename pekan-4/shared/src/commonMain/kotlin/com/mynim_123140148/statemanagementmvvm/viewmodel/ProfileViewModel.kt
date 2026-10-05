package com.mynim_123140148.statemanagementmvvm.viewmodel

import androidx.lifecycle.ViewModel
import com.mynim_123140148.statemanagementmvvm.data.ProfileRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ProfileViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(
        ProfileUiState(profile = ProfileRepository.getInitialProfile())
    )
    val uiState: StateFlow<ProfileUiState> = _uiState.asStateFlow()

    fun startEditing() = _uiState.update { it.copy(isEditing = true) }

    fun cancelEditing() = _uiState.update { it.copy(isEditing = false) }

    /** Simpan perubahan nama & bio, lalu kembali ke tampilan profil. */
    fun saveProfile(name: String, bio: String) = _uiState.update {
        it.copy(
            profile = it.profile.copy(name = name.trim(), bio = bio.trim()),
            isEditing = false
        )
    }

    fun setDarkMode(enabled: Boolean) = _uiState.update { it.copy(isDarkMode = enabled) }
}
