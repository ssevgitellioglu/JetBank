package com.example.jetbank.ui.component


import android.util.Log
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.example.jetbank.R
import com.example.jetbank.network.isNetworkAvailable
import kotlinx.coroutines.flow.Flow


@Composable
fun NoInternetDialog(networkFlow: Flow<Boolean>) {
    val context = LocalContext.current
    val isConnected by networkFlow.collectAsState(initial = isNetworkAvailable(context))

    val showDialog = remember { mutableStateOf(!isConnected) }
    if (!isConnected) {
        AlertDialog(
            onDismissRequest = { Log.e("TAG", "NoInternetDialog") },
            title = {
                Text(text = stringResource(R.string.no_internet_connection))
            },
            text = {
                Text(text = stringResource(R.string.no_internet_connection_description))
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        if (isNetworkAvailable(context)) {
                            showDialog.value = false
                        }
                    }
                ) {
                    Text(text = stringResource(R.string.try_again))
                }
            }
        )
    }
}