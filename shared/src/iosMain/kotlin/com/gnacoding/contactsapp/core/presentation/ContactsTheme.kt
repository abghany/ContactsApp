package com.gnacoding.contactsapp.core.presentation

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.gnacoding.contactsapp.ui.theme.DarkColorScheme
import com.gnacoding.contactsapp.ui.theme.LightColorScheme
import com.gnacoding.contactsapp.ui.theme.Typography

@Composable
actual fun ContactsTheme(
    darkTheme: Boolean,
    dynamicColor: Boolean,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme,
        typography = Typography,
        content = content
    )
}