package com.example.gsonkotlinxserializationtest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.gsonkotlinxserializationtest.ui.theme.GsonKotlinxSerializationTestTheme
import com.google.gson.Gson
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class User (
    val name: String,
    val email: String,
    val age: Int = 20
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GsonKotlinxSerializationTestTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    val jsonString = """
                        {
                            "name" : "whjung",
                            "email" : "whjung@example.com"
                        }
                        """.trimIndent()

//                    val user = Gson().fromJson(jsonString, User::class.java)  //gson
                    val user = Json.decodeFromString<User>(jsonString)          //serialization

                    println(user)
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GsonKotlinxSerializationTestTheme {
        Greeting("Android")
    }
}