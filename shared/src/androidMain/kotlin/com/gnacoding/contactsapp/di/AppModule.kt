package com.gnacoding.contactsapp.di

import android.content.Context
import com.gnacoding.contactsapp.contacts.data.SqlDelightContactDataSource
import com.gnacoding.contactsapp.contacts.domain.ContactDataSource
import com.gnacoding.contactsapp.core.data.DatabaseDriverFactory
import com.gnacoding.contactsapp.core.data.ImageStorage
import com.gnacoding.contactsapp.database.ContactDatabase

actual class AppModule(
    private val context: Context
) {

    actual val contactDataSource: ContactDataSource by lazy {
        SqlDelightContactDataSource(
            db = ContactDatabase(
                driver = DatabaseDriverFactory(context).create()
            ),
            imageStorage = ImageStorage(context)
        )
    }
}