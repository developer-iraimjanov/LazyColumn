package uz.iraimjanov.lazycolumn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dagger.hilt.android.AndroidEntryPoint
import uz.iraimjanov.lazycolumn.model.ContactResponse
import uz.iraimjanov.lazycolumn.ui.theme.LazyColumnTheme
import uz.iraimjanov.lazycolumn.utils.makeCall
import uz.iraimjanov.lazycolumn.viewmodel.MainViewModel

@ExperimentalMaterial3Api
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyColumnTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val list = viewModel.getResponse

                    viewModel.getAllContact()

                    LazyColumn {
                        items(items = list) { contactResponse ->
                            Item(contactResponse = contactResponse, onClick = {
                                makeCall(this@MainActivity, it.number)
                            })
                        }
                    }

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LazyColumnTheme {
    }
}