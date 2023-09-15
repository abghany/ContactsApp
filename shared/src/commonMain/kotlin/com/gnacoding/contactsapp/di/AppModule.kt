package com.gnacoding.contactsapp.di

import com.gnacoding.contactsapp.contacts.domain.ContactDataSource

expect class AppModule {
    val contactDataSource: ContactDataSource
}