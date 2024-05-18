package com.example.unicum.utils

sealed class UIComponent {
    data class Toast(val message: String): UIComponent()
}