package com.mynim_123140148.statemanagementmvvm.data

/** Model data profil. */
data class Profile(
    val name: String,
    val nim: String,
    val email: String,
    val bio: String
)

/** Sumber data awal (dummy, belum pakai database). */
object ProfileRepository {
    fun getInitialProfile(): Profile = Profile(
        name = "Muhammad Rafly Yahya Ramadhan",
        nim = "123140148",
        email = "muhammad.123140148@student.itera.ac.id",
        bio = "Mahasiswa Teknik Informatika ITERA yang sedang belajar Kotlin Multiplatform dan Compose."
    )
}
