package com.gnacoding.contactsapp.contacts.data

import com.gnacoding.contactsapp.contacts.domain.Contact
import com.gnacoding.contactsapp.core.data.ImageStorage
import database.ContactEntity

suspend fun ContactEntity.toContact(imageStorage: ImageStorage): Contact {
    return Contact(
        id = id,
        firstName = firstName,
        lastName = lastName,
        email = email,
        phoneNumber = phoneNumber,
        photoBytes = imagePath?.let { imageStorage.getImage(it) }
    )
}