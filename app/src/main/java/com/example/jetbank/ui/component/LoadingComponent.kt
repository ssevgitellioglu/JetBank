package com.example.jetbank.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.jetbank.R

@Composable
fun LoadingAnimation(modifier: Modifier=Modifier){
    val isPlaying by remember { mutableStateOf(true) }
    val speed by remember { mutableFloatStateOf(1f) }

    val composition by rememberLottieComposition(
        spec = LottieCompositionSpec.RawRes(R.raw.bank)
    )
    val progress by animateLottieCompositionAsState(
        composition=composition,
        iterations = LottieConstants.IterateForever,
        isPlaying = isPlaying,
        speed = speed,
        restartOnPlay = false
    )
    Box(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.background)
        .padding(50.dp)
    ){
        LottieAnimation(composition=composition,
            progress={ progress },
            modifier=Modifier.fillMaxSize().padding(50.dp),
            alignment = Alignment.Center)
    }
}