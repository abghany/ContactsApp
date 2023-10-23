package com.gnacoding.contactsapp.contacts.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
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
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(32.dp))
            if (newContact?.photoBytes == null) {
                Box(
                    modifier = Modifier
                        .size(80.dp)
                        .clip(RoundedCornerShape(100))
                        .background(MaterialTheme.colorScheme.secondaryContainer)
                        .clickable {
                            onEvent(ContactListEvent.OnAddPhotoClicked)
                        }
                        .border(
                            width = 1.dp,
                            color = MaterialTheme.colorScheme.onSecondaryContainer,
                            shape = RoundedCornerShape(100)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Rounded.Add,
                        contentDescription = "Add photo",
                        tint = MaterialTheme.colorScheme.onSecondaryContainer,
                        modifier = Modifier.size(24.dp)
                    )
                }
            } else {
                ContactPhoto(
                    contact = newContact,
                    modifier = Modifier
                        .size(80.dp)
                        .clickable {
                            onEvent(ContactListEvent.OnAddPhotoClicked)
                        }
                )
            }
            Spacer(modifier = Modifier.height(24.dp))
            ContactTextField(
                value = newContact?.firstName ?: "",
                placeholder = "First Name",
                leadingIcon = Icons.Filled.Person,
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
                leadingIcon = Icons.Filled.Person,
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
                leadingIcon = Icons.Filled.Mail,
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
                leadingIcon = Icons.Filled.Phone,
                error = state.phoneNumberError,
                onValueChanged = {
                    onEvent(ContactListEvent.OnPhoneNumberChanged(it))
                },
                modifier = Modifier.fillMaxWidth()
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.Bottom
            ) {
                TextButton(
                    onClick = { onEvent(ContactListEvent.DismissContact) },
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                ) {
                    Text("Cancel")
                }
                Spacer(modifier = Modifier.width(8.dp))
                TextButton(
                    onClick = { onEvent(ContactListEvent.SaveContact) },
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                ) {
                    Text("Save")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactTextField(
    value: String,
    placeholder: String,
    leadingIcon: ImageVector,
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
            leadingIcon = {
                Icon(imageVector = leadingIcon, contentDescription = placeholder)
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