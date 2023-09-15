package com.gnacoding.contactsapp.contacts.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gnacoding.contactsapp.contacts.domain.Contact
import com.gnacoding.contactsapp.contacts.presentation.ContactListEvent
import com.gnacoding.contactsapp.contacts.presentation.ContactListState
import com.gnacoding.contactsapp.core.presentation.SimpleBottomSheet

@Composable
fun AddContactSheet(
    state: ContactListState,
    newContact: Contact?,
    isOpen: Boolean,
    onEvent: (ContactListEvent) -> Unit,
    modifier: Modifier = Modifier,
) {
    SimpleBottomSheet(
        visible = isOpen,
        modifier = modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.TopStart
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(64.dp))
                if (newContact?.photoBytes == null) {
                    Box(
                        modifier = Modifier
                            .size(152.dp)
                            .clip(RoundedCornerShape(32))
                            .background(MaterialTheme.colorScheme.secondaryContainer)
                            .clickable {
                                onEvent(ContactListEvent.OnAddPhotoClicked)
                            }
                            .border(
                                width = 1.dp,
                                color = MaterialTheme.colorScheme.onSecondaryContainer,
                                shape = RoundedCornerShape(32)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.Add,
                            contentDescription = "Add photo",
                            tint = MaterialTheme.colorScheme.onSecondaryContainer,
                            modifier = Modifier.size(40.dp)
                        )
                    }
                } else {
                    ContactPhoto(
                        contact = newContact,
                        modifier = Modifier
                            .size(152.dp)
                            .clickable {
                                onEvent(ContactListEvent.OnAddPhotoClicked)
                            }
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))
                ContactTextField(
                    value = newContact?.firstName ?: "",
                    placeholder = "First Name",
                    error = state.firstNameError,
                    onValueChanged = {
                        onEvent(ContactListEvent.OnFirstNameChanged(it))
                    },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                ContactTextField(
                    value = newContact?.lastName ?: "",
                    placeholder = "Last Name",
                    error = state.lastNameError,
                    onValueChanged = {
                        onEvent(ContactListEvent.OnLastNameChanged(it))
                    },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                ContactTextField(
                    value = newContact?.email ?: "",
                    placeholder = "Email",
                    error = state.emailError,
                    onValueChanged = {
                        onEvent(ContactListEvent.OnEmailChanged(it))
                    },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                ContactTextField(
                    value = newContact?.phoneNumber ?: "",
                    placeholder = "Phone Number",
                    error = state.phoneNumberError,
                    onValueChanged = {
                        onEvent(ContactListEvent.OnPhoneNumberChanged(it))
                    },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(32.dp))
                Button(
                    onClick = {
                        onEvent(ContactListEvent.SaveContact)
                    },
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Text(text = "Save")
                }
            }

            IconButton(
                onClick = { onEvent(ContactListEvent.DismissContact) }
            ) {
                Icon(
                    imageVector = Icons.Rounded.Close,
                    contentDescription = "Close"
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactTextField(
    value: String,
    placeholder: String,
    error: String?,
    onValueChanged: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        OutlinedTextField(
            value = value,
            placeholder = {
                Text(text = placeholder)
            },
            onValueChange = onValueChanged,
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier.fillMaxWidth()
        )
        if (error != null) {
            Text(
                text = error,
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.error
            )
        }
    }
}