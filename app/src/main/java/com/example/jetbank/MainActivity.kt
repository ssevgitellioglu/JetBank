package com.example.jetbank

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.jetbank.network.NetworkStatusChecker
import com.example.jetbank.ui.component.NoInternetDialog
import com.example.jetbank.ui.navigation.AppNavigation
import com.example.jetbank.ui.theme.JetBankTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val context = LocalContext.current
            val internetFlow = NetworkStatusChecker.networkChecker(context)
            NoInternetDialog(internetFlow)
            JetBankTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innetPadding ->
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innetPadding),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        val navController= rememberNavController()
                        AppNavigation(navController)
                    }
                }
            }
        }
    }
}

