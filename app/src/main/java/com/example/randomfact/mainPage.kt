package com.example.randomfact

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.example.randomfact.data.mainViewModel

@Composable
fun mainPage(viewModel: mainViewModel) {
    val fact = viewModel.fact
    Column(
        Modifier
            .fillMaxSize()
            .padding(10.dp)) {
        fact?.let {
            Image(
                painter = rememberAsyncImagePainter(model = it.value.image),
                contentDescription = "",
                modifier = Modifier.fillMaxWidth()
            )
            Row(Modifier.fillMaxWidth()) {
                Text(text = "Intresting fact about:", fontWeight = FontWeight.Light, fontSize = 15.sp)
                Text(text = it.value.name.toString(), fontSize = 20.sp)
            }
            Text(text = it.value.fact.toString())
            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = { viewModel.getrandomFact() }) {
                Text(text = "Discover more")
            }
        }
        if (fact.value.name == null){
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator(strokeWidth = 3.dp)
            }
        }
    }

}