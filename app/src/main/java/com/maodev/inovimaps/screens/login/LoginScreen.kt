package com.maodev.inovimaps.screens.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.maodev.inovimaps.R
import com.maodev.inovimaps.core.components.InoviMapText
import com.maodev.inovimaps.core.components.InoviMapsPasswordTextField
import com.maodev.inovimaps.core.components.InoviMapsTextField


@Composable
fun LoginScreen(
    navigateToMapScreen: () -> Unit,
    loginViewModel: LoginViewModel = viewModel(),
) {
    val uiState by loginViewModel.uiState.collectAsStateWithLifecycle()
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ) {
            InoviMapText(
                text = stringResource(R.string.login_screen_app_title),
                textStyle = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.height(120.dp))
            InoviMapsTextField(
                modifier = Modifier,
                label = stringResource(R.string.login_screen_textfield_label_email),
                emailValue = uiState.email,
                placeholder = stringResource(R.string.login_screen_textfield_placeholder_email),
                onEmailChange = { loginViewModel.onEmailChanged(it) }
            )
            InoviMapsPasswordTextField(
                modifier = Modifier,
                label = stringResource(R.string.login_screen_textfield_label_password),
                passwordValue = uiState.password,
                onPasswordChange = { loginViewModel.onPasswordChanged(it) })
            Spacer(modifier = Modifier.height(15.dp))
            Button(
                modifier = Modifier.padding(vertical = 12.dp),
                onClick = { navigateToMapScreen() },
                shape = MaterialTheme.shapes.extraSmall
            ) {
                InoviMapText(
                    text = stringResource(R.string.login_screen_text_button),
                    textStyle = MaterialTheme.typography.bodyLarge
                )
            }
        }


    }

}