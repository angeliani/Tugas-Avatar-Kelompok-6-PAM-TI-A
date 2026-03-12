package com.example.kelompok_6

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AvatarScreen(onNext: () -> Unit) {
    var showBrow by remember { mutableStateOf(true) }
    var showEye by remember { mutableStateOf(true) }
    var showNose by remember { mutableStateOf(true) }
    var showMouth by remember { mutableStateOf(true) }
    var showEarrings by remember { mutableStateOf(true) }
    var showHairpin by remember { mutableStateOf(true) }
    var showNecklace by remember { mutableStateOf(true) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Avatar App", color = White, fontWeight = FontWeight.Bold, fontSize = 20.sp) },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = PinkPrimary),
                actions = {
                    IconButton(onClick = { onNext() }) {
                        Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "Profil", tint = White)
                    }
                }
            )
        },
        containerColor = PinkBackground
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier.fillMaxWidth().fillMaxHeight(0.5f),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier.fillMaxHeight(0.9f).aspectRatio(1f).clip(CircleShape).background(PinkLight),
                    contentAlignment = Alignment.Center
                ) {
                    Image(painter = painterResource(id = R.drawable.face_base), contentDescription = "Face Base", modifier = Modifier.fillMaxSize())
                    if (showBrow) Image(painter = painterResource(R.drawable.brow), contentDescription = null, modifier = Modifier.fillMaxSize())
                    if (showEye) Image(painter = painterResource(R.drawable.eye), contentDescription = null, modifier = Modifier.fillMaxSize())
                    if (showNose) Image(painter = painterResource(R.drawable.nose), contentDescription = null, modifier = Modifier.fillMaxSize())
                    if (showMouth) Image(painter = painterResource(R.drawable.mouth), contentDescription = null, modifier = Modifier.fillMaxSize())
                    if (showEarrings) Image(painter = painterResource(R.drawable.earrings), contentDescription = null, modifier = Modifier.fillMaxSize())
                    if (showHairpin) Image(painter = painterResource(R.drawable.hairpin), contentDescription = null, modifier = Modifier.fillMaxSize())
                    if (showNecklace) Image(painter = painterResource(R.drawable.necklace), contentDescription = null, modifier = Modifier.fillMaxSize())
                }
            }

            Column(
                modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(horizontal = 24.dp, vertical = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CheckboxCard(title = "Wajah") {
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                        AvatarCheckbox("Brow", showBrow) { showBrow = it }
                        AvatarCheckbox("Eye", showEye) { showEye = it }
                        AvatarCheckbox("Nose", showNose) { showNose = it }
                        AvatarCheckbox("Mouth", showMouth) { showMouth = it }
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                CheckboxCard(title = "Aksesoris") {
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                        AvatarCheckbox("Earrings", showEarrings) { showEarrings = it }
                        AvatarCheckbox("Hairpin", showHairpin) { showHairpin = it }
                        AvatarCheckbox("Necklace", showNecklace) { showNecklace = it }
                    }
                }
            }
        }
    }
}

@Composable
fun CheckboxCard(title: String, content: @Composable () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = White), elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = title, fontSize = 14.sp, fontWeight = FontWeight.Bold, color = PinkPrimary)
            Spacer(modifier = Modifier.height(8.dp))
            content()
        }
    }
}

@Composable
fun AvatarCheckbox(label: String, checked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Checkbox(checked = checked, onCheckedChange = onCheckedChange, colors = CheckboxDefaults.colors(checkedColor = PinkPrimary))
        Text(text = label, fontSize = 12.sp, color = TextDark)
    }
}