package at.htl.todo

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.State
import androidx.compose.runtime.rxjava3.subscribeAsState
import at.htl.todo.model.Model
import at.htl.todo.model.ModelStore
import at.htl.todo.ui.theme.TodoAndroidTheme
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainUiBuilder  {

    @Inject constructor(){}

    @Inject
    lateinit var modelStore: ModelStore

    fun buildContent(activity: ComponentActivity) {
        activity.setContent {
            TodoAndroidTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val state = modelStore.pipe.subscribeAsState(initial = Model())
                    Greeting(state)
                }
            }
        }
    }

}

@Composable
fun Greeting(state: State<Model>, modifier: Modifier = Modifier) {


    Text(
        text = "Hello ${state.value.todos.size}!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TodoAndroidTheme {
        //Greeting("Android")
    }
}


