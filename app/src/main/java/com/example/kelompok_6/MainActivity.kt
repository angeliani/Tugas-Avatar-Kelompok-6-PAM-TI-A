package com.example.kelompok_6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

// warna
val PinkBackground = Color(0xFFFDF1F4)
val PinkPrimary = Color(0xFFE91E63)
val PinkLight = Color(0xFFF8BBD0)
val PinkButton = Color(0xFFFF4081)
val White = Color.White
val TextDark = Color.DarkGray

// data class user
data class UserData(
    val namaDepan: String,
    val namaBelakang: String,
    val namaPanggilan: String,
    val email: String,
    val password: String,
    val noHp: String,
    val alamat: String
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = PinkBackground
                ) {
                    AppNavigator()
                }
            }
        }
    }
}

@Composable
fun AppNavigator() {
    var halaman by remember { mutableStateOf("register") }
    var userData by remember { mutableStateOf<UserData?>(null) }

    when (halaman) {
        "register" -> HalamanRegister(
            keLogin = { halaman = "login" },
            onRegisterSuccess = {
                userData = it
                halaman = "login"
            }
        )
        "login" -> HalamanLogin(
            keRegister = { halaman = "register" },
            onLoginSuccess = { halaman = "avatar" }
        )
        "avatar" -> AvatarScreen(
            onNext = { halaman = "profil" }
        )
        "profil" -> {
            val dataTampil = userData ?: UserData(
                "Angeliani", "Junitaviana", "Angel", "angeliani@student.ub.ac.id", "123", "081234567890", "Malang"
            )
            HalamanProfilUser(
                userData = dataTampil,
                onBackClick = { halaman = "avatar" },
                onLogoutClick = { halaman = "login" }
            )
        }
    }
}
