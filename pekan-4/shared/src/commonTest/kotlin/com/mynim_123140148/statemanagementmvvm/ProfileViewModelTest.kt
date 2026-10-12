package com.mynim_123140148.statemanagementmvvm

import com.mynim_123140148.statemanagementmvvm.viewmodel.ProfileViewModel
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ProfileViewModelTest {

    @Test
    fun saveProfile_updatesNameAndBio_andLeavesEditMode() {
        val vm = ProfileViewModel()
        vm.startEditing()
        assertTrue(vm.uiState.value.isEditing)

        vm.saveProfile("  Budi  ", "  Bio baru  ")

        val state = vm.uiState.value
        assertEquals("Budi", state.profile.name)
        assertEquals("Bio baru", state.profile.bio)
        assertFalse(state.isEditing)
    }

    @Test
    fun cancelEditing_keepsOriginalProfile() {
        val vm = ProfileViewModel()
        val original = vm.uiState.value.profile
        vm.startEditing()
        vm.cancelEditing()
        assertEquals(original, vm.uiState.value.profile)
        assertFalse(vm.uiState.value.isEditing)
    }

    @Test
    fun setDarkMode_isStoredInViewModel() {
        val vm = ProfileViewModel()
        assertFalse(vm.uiState.value.isDarkMode)
        vm.setDarkMode(true)
        assertTrue(vm.uiState.value.isDarkMode)
    }
}
