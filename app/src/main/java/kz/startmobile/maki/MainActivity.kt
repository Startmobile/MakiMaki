package kz.startmobile.maki

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import kz.startmobile.maki.uicomponents.MakiMakiTheme
import kz.startmobile.maki.uicomponents.bottom_nav.CustomBottomNavigation
import kz.startmobile.maki.uicomponents.search_bar.MaterialSearchBar

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MakiMakiTheme {
                // A surface container using the 'background' color from the theme
                Scaffold(
//                    modifier = Modifier.fillMaxSize(),
                    //color = MaterialTheme.colors.background
                    bottomBar = { CustomBottomNavigation() }
                ) {
                   // Greeting("Android")
                    MaterialSearchBar()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MakiMakiTheme {
        Greeting("Android")
    }
}