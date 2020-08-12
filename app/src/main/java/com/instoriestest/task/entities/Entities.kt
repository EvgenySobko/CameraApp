package com.instoriestest.task.entities

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

data class Chat(
    val image: Drawable,
    val user: User,
    val message: ChatMessage,
    val time: String
): Serializable

data class ChatMessage(
    val message: String,
    val fromMe: Boolean
)

data class User(
    val name: String
)