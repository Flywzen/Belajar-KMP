package com.mynim_123140148.latihan2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// Stateless TextField component (state di-hoist ke parent)
@Composable
fun LabeledTextField(
    label: String,
    value: String,                      // State dari parent
    onValueChange: (String) -> Unit,    // Callback ke parent
    modifier: Modifier = Modifier,
    keyboardType: KeyboardType = KeyboardType.Text
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        modifier = modifier.fillMaxWidth()
    )
}

// Parent yang menyimpan state
@Composable
fun RegistrationForm() {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .safeContentPadding()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Registration Form",
            style = MaterialTheme.typography.headlineMedium
        )

        LabeledTextField(
            label = "Name",
            value = name,
            onValueChange = { name = it }
        )

        LabeledTextField(
            label = "Email",
            value = email,
            onValueChange = { email = it },
            keyboardType = KeyboardType.Email
        )

        Spacer(Modifier.height(8.dp))

        // Preview data
        Card(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = "Preview",
                    style = MaterialTheme.typography.labelLarge
                )
                Text(
                    text = "Hello, ${name.ifBlank { "..." }}!",
                    style = MaterialTheme.typography.titleLarge
                )
                Text("Name: ${name.ifBlank { "-" }}")
                Text("Email: ${email.ifBlank { "-" }}")
            }
        }
    }
}

@Composable
@Preview
fun App() {
    MaterialTheme {
        RegistrationForm()
    }
}
