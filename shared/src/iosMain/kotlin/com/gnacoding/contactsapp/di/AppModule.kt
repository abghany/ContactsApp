package com.gnacoding.contactsapp.di

import com.gnacoding.contactsapp.database.ContactDatabase
import com.gnacoding.contactsapp.contacts.data.SqlDelightContactDataSource
import com.gnacoding.contactsapp.contacts.domain.ContactDataSource
import com.gnacoding.contactsapp.core.data.DatabaseDriverFactory
import com.gnacoding.contactsapp.core.data.ImageStorage

actual class AppModule {

    actual val contactDataSource: ContactDataSource by lazy {
        SqlDelightContactDataSource(
            db = ContactDatabase(
                driver = DatabaseDriverFactory().create()
            ),
            imageStorage = ImageStorage()
        )
    }
}