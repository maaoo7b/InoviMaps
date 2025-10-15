package com.maodev.inovimaps.core.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.maodev.inovimaps.R


@Composable
fun InoviMapsTextField(
    modifier: Modifier = Modifier,
    label: String,
    emailValue: String,
    placeholder: String,
    colors: TextFieldColors = OutlinedTextFieldDefaults.colors(
        focusedTextColor = MaterialTheme.colorScheme.onPrimary,
        unfocusedTextColor=MaterialTheme.colorScheme.onPrimary,
        focusedPlaceholderColor = MaterialTheme.colorScheme.onPrimary,
        unfocusedLabelColor = MaterialTheme.colorScheme.onPrimary,
        unfocusedBorderColor = MaterialTheme.colorScheme.onPrimary,
        cursorColor = MaterialTheme.colorScheme.onPrimary
    ),
    onEmailChange: (String) -> Unit
) {
    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp, vertical = 8.dp),
        value = emailValue,
        onValueChange = { onEmailChange(it) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        placeholder = { InoviMapText(text=placeholder) },
        label = { Text(text = label) },
        colors = colors,
        singleLine = true,
    )


}

@Composable
fun InoviMapsPasswordTextField(
    modifier: Modifier = Modifier,
    label: String,
    passwordValue: String,
    colors: TextFieldColors = OutlinedTextFieldDefaults.colors(
        focusedTextColor = MaterialTheme.colorScheme.onPrimary,
        unfocusedTextColor=MaterialTheme.colorScheme.onPrimary,
        focusedPlaceholderColor = MaterialTheme.colorScheme.onPrimary,
        unfocusedLabelColor = MaterialTheme.colorScheme.onPrimary,
        unfocusedBorderColor = MaterialTheme.colorScheme.onPrimary,
        cursorColor = MaterialTheme.colorScheme.onPrimary),
    onPasswordChange: (String) -> Unit
) {
    var passwordHidden by remember { mutableStateOf(true) }
    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        value = passwordValue,
        onValueChange = { onPasswordChange(it) },
        label = { Text(text = label) },
        singleLine = true,
        colors=colors,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        visualTransformation = if (passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
        trailingIcon = {
            Icon(
                painter = if (passwordHidden) painterResource(R.drawable.visibility_on) else painterResource(
                    R.drawable.visibility_off
                ), contentDescription = null,
                modifier = Modifier.clickable { passwordHidden = !passwordHidden },
                tint = MaterialTheme.colorScheme.onPrimary
            )

        },
        shape = RoundedCornerShape(2.dp)
    )
}