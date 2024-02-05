package at.ac.htl.myfirstapp.ui.layout

import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rxjava3.subscribeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import at.ac.htl.myfirstapp.model.Model
import at.ac.htl.myfirstapp.model.Store
import at.ac.htl.myfirstapp.ui.theme.MyFirstAppTheme
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

val TAG: String = MainView::class.java.simpleName

@ActivityScoped
class MainView @Inject constructor() {

    @Inject
    lateinit var store: Store

    fun compose(activity: ComponentActivity) {
        activity.setContent {
            MyFirstAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting(store)
                }
            }
        }
    }
}

@Composable
fun Greeting(store: Store, modifier: Modifier = Modifier) {
    val state = store.subject.subscribeAsState(initial = Model())
    Column {
        Text(
            text = "Hello ${state.value.greeting}!",
            modifier = modifier
        )
        Text(text = "Zweite Zeile")
        Button(onClick = {
            Log.i(TAG, "geclickt")
            store.next { it.greeting = "I was clicked" }
        }) {
            Text(text = "save")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val store = Store()

    MyFirstAppTheme {
        Greeting(store)
    }
}