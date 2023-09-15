package com.gnacoding.contactsapp.ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import com.gnacoding.contactsapp.ui.theme.BackgroundDark
import com.gnacoding.contactsapp.ui.theme.BackgroundLight
import com.gnacoding.contactsapp.ui.theme.ErrorContainerDark
import com.gnacoding.contactsapp.ui.theme.ErrorContainerLight
import com.gnacoding.contactsapp.ui.theme.ErrorDark
import com.gnacoding.contactsapp.ui.theme.ErrorLight
import com.gnacoding.contactsapp.ui.theme.GreenContainerDark
import com.gnacoding.contactsapp.ui.theme.GreenContainerLight
import com.gnacoding.contactsapp.ui.theme.GreenPrimaryDark
import com.gnacoding.contactsapp.ui.theme.GreenPrimaryLight
import com.gnacoding.contactsapp.ui.theme.GreenSecondaryContainerDark
import com.gnacoding.contactsapp.ui.theme.GreenSecondaryContainerLight
import com.gnacoding.contactsapp.ui.theme.GreenSecondaryDark
import com.gnacoding.contactsapp.ui.theme.GreenSecondaryLight
import com.gnacoding.contactsapp.ui.theme.GreenTertiaryContainerDark
import com.gnacoding.contactsapp.ui.theme.GreenTertiaryContainerLight
import com.gnacoding.contactsapp.ui.theme.GreenTertiaryDark
import com.gnacoding.contactsapp.ui.theme.GreenTertiaryLight
import com.gnacoding.contactsapp.ui.theme.OnBackgroundDark
import com.gnacoding.contactsapp.ui.theme.OnBackgroundLight
import com.gnacoding.contactsapp.ui.theme.OnErrorContainerDark
import com.gnacoding.contactsapp.ui.theme.OnErrorContainerLight
import com.gnacoding.contactsapp.ui.theme.OnErrorDark
import com.gnacoding.contactsapp.ui.theme.OnErrorLight
import com.gnacoding.contactsapp.ui.theme.OnGreenContainerDark
import com.gnacoding.contactsapp.ui.theme.OnGreenContainerLight
import com.gnacoding.contactsapp.ui.theme.OnGreenDark
import com.gnacoding.contactsapp.ui.theme.OnGreenLight
import com.gnacoding.contactsapp.ui.theme.OnGreenSecondaryContainerDark
import com.gnacoding.contactsapp.ui.theme.OnGreenSecondaryContainerLight
import com.gnacoding.contactsapp.ui.theme.OnGreenSecondaryDark
import com.gnacoding.contactsapp.ui.theme.OnGreenSecondaryLight
import com.gnacoding.contactsapp.ui.theme.OnGreenTertiaryContainerDark
import com.gnacoding.contactsapp.ui.theme.OnGreenTertiaryContainerLight
import com.gnacoding.contactsapp.ui.theme.OnGreenTertiaryDark
import com.gnacoding.contactsapp.ui.theme.OnGreenTertiaryLight
import com.gnacoding.contactsapp.ui.theme.OnSurfaceDark
import com.gnacoding.contactsapp.ui.theme.OnSurfaceLight
import com.gnacoding.contactsapp.ui.theme.OnSurfaceVariantDark
import com.gnacoding.contactsapp.ui.theme.OnSurfaceVariantLight
import com.gnacoding.contactsapp.ui.theme.OutlineDark
import com.gnacoding.contactsapp.ui.theme.OutlineLight
import com.gnacoding.contactsapp.ui.theme.SurfaceDark
import com.gnacoding.contactsapp.ui.theme.SurfaceLight
import com.gnacoding.contactsapp.ui.theme.SurfaceVariantDark
import com.gnacoding.contactsapp.ui.theme.SurfaceVariantLight

val DarkColorScheme = darkColorScheme(
    primary = GreenPrimaryDark,
    secondary = GreenSecondaryDark,
    tertiary = GreenTertiaryDark,
    onPrimary = OnGreenDark,
    primaryContainer = GreenContainerDark,
    onPrimaryContainer = OnGreenContainerDark,
    onSecondary = OnGreenSecondaryDark,
    secondaryContainer = GreenSecondaryContainerDark,
    onSecondaryContainer = OnGreenSecondaryContainerDark,
    onTertiary = OnGreenTertiaryDark,
    onTertiaryContainer = OnGreenTertiaryContainerDark,
    tertiaryContainer = GreenTertiaryContainerDark,
    background = BackgroundDark,
    onBackground = OnBackgroundDark,
    surface = SurfaceDark,
    onSurface = OnSurfaceDark,
    surfaceVariant = SurfaceVariantDark,
    onSurfaceVariant = OnSurfaceVariantDark,
    error = ErrorDark,
    onError = OnErrorDark,
    errorContainer = ErrorContainerDark,
    onErrorContainer = OnErrorContainerDark,
    outline = OutlineDark,
)

val LightColorScheme = lightColorScheme(
    primary = GreenPrimaryLight,
    secondary = GreenSecondaryLight,
    tertiary = GreenTertiaryLight,
    onPrimary = OnGreenLight,
    primaryContainer = GreenContainerLight,
    onPrimaryContainer = OnGreenContainerLight,
    onSecondary = OnGreenSecondaryLight,
    secondaryContainer = GreenSecondaryContainerLight,
    onSecondaryContainer = OnGreenSecondaryContainerLight,
    onTertiary = OnGreenTertiaryLight,
    onTertiaryContainer = OnGreenTertiaryContainerLight,
    tertiaryContainer = GreenTertiaryContainerLight,
    background = BackgroundLight,
    onBackground = OnBackgroundLight,
    surface = SurfaceLight,
    onSurface = OnSurfaceLight,
    surfaceVariant = SurfaceVariantLight,
    onSurfaceVariant = OnSurfaceVariantLight,
    error = ErrorLight,
    onError = OnErrorLight,
    errorContainer = ErrorContainerLight,
    onErrorContainer = OnErrorContainerLight,
    outline = OutlineLight,
)