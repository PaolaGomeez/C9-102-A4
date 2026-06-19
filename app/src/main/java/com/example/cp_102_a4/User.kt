package com.example.cp_102_a4 // <-- Asegúrate de que use el paquete a4

import androidx.compose.runtime.snapshots.SnapshotStateList

data class User(
    val fullName: String,
    val age: Int,
    val birthday: String,
    val address: String,
    val username: String,
    val isVerified: Boolean,
    val likesCount: Int
) {
    fun getAgeGroup(age: Int): String {
        return when (age) {
            in 0..12 -> "Child"
            in 13..17 -> "Teenager"
            in 18..59 -> "Adult"
            else -> "Senior"
        }
    }

    fun updateProfile(newUsername: String, newAge: Int): User {
        return copy(
            username = newUsername,
            age = newAge
        )
    }

    fun addFriend(friendList: SnapshotStateList<String>, newFriend: String) {
        if (newFriend.isNotBlank() && !friendList.contains(newFriend)) {
            friendList.add(newFriend)
        }
    }

    fun removeFriend(friendList: SnapshotStateList<String>, friendName: String) {
        friendList.remove(friendName)
    }
}