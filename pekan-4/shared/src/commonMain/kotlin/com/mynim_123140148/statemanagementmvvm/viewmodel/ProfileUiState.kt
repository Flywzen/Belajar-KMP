package com.mynim_123140148.statemanagementmvvm.viewmodel

import com.mynim_123140148.statemanagementmvvm.data.Profile

/** Satu-satunya sumber kebenaran untuk UI Profile. */
data class ProfileUiState(
    val profile: Profile,
    val isEditing: Boolean = false,
    val isDarkMode: Boolean = false
)
