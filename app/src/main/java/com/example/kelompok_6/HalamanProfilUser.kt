package com.example.kelompok_6

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HalamanProfilUser(
    userData: UserData,
    onBackClick: () -> Unit,
    onLogoutClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PinkBackground)
            .padding(16.dp)
            .padding(top = 24.dp)
    ) {
        IconButton(onClick = onBackClick) {
            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = PinkPrimary)
        }
        Text("Profile", fontSize = 28.sp, fontWeight = FontWeight.Bold, color = PinkPrimary, modifier = Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.height(20.dp))
        Icon(Icons.Default.AccountCircle, contentDescription = "Avatar", modifier = Modifier.size(100.dp).align(Alignment.CenterHorizontally), tint = PinkPrimary)
        Spacer(modifier = Modifier.height(20.dp))

        Card(shape = RoundedCornerShape(16.dp), modifier = Modifier.fillMaxWidth(), colors = CardDefaults.cardColors(containerColor = White)) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Informasi Pribadi", fontWeight = FontWeight.Bold, color = PinkPrimary)
                Spacer(modifier = Modifier.height(10.dp))
                ProfileItem("First Name", userData.namaDepan)
                ProfileItem("Last Name", userData.namaBelakang)
                ProfileItem("Username", userData.namaPanggilan)
                ProfileItem("Email", userData.email)
                ProfileItem("Password", "********")
                HorizontalDivider(modifier = Modifier.padding(vertical = 12.dp))
                Text("Kontak", fontWeight = FontWeight.Bold, color = PinkPrimary)
                Spacer(modifier = Modifier.height(8.dp))
                ProfileItem("No. HP", userData.noHp)
                ProfileItem("Alamat", userData.alamat)
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = onLogoutClick,
            modifier = Modifier.fillMaxWidth().height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = PinkButton)
        ) {
            Text("Logout")
        }
    }
}

@Composable
fun ProfileItem(label: String, value: String) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        Text(label, fontWeight = FontWeight.Bold, color = TextDark)
        Text(value, color = PinkPrimary)
    }
}