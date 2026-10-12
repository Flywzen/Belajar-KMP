package com.mynim_123140148.latihan2.latihan

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

// Latihan 3: Todo App dengan ViewModel — implementasi MVVM pattern (slide P4 hal. 31)
data class Todo(val id: Int, val text: String, val done: Boolean)

data class TodoUiState(
    val todos: List<Todo> = emptyList(),
    val input: String = ""
)

// 2. ViewModel
class TodoViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(TodoUiState())
    val uiState: StateFlow<TodoUiState> = _uiState.asStateFlow()

    fun onInputChange(text: String) {
        _uiState.update { it.copy(input = text) }
    }

    fun addTodo() {
        _uiState.update { state ->
            if (state.input.isBlank()) {
                state // input kosong, ga usah ditambahin
            } else {
                state.copy(
                    todos = state.todos + Todo(id = state.todos.size, text = state.input.trim(), done = false),
                    input = "" // kosongin input setelah ditambah
                )
            }
        }
    }

    fun toggleTodo(id: Int) {
        _uiState.update { state ->
            state.copy(
                todos = state.todos.map { todo ->
                    if (todo.id == id) todo.copy(done = !todo.done) else todo
                }
            )
        }
    }
}

// 3. View (Compose UI): cuma nampilin state dan neruskan event ke ViewModel
@Composable
fun Handson3Screen(viewModel: TodoViewModel = viewModel { TodoViewModel() }) {
    val uiState by viewModel.uiState.collectAsState()

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Latihan 3: Todo App dengan ViewModel")

        Row(
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                value = uiState.input,
                onValueChange = viewModel::onInputChange,
                label = { Text("Mau ngapain hari ini?") },
                singleLine = true,
                modifier = Modifier.weight(1f)
            )
            Button(onClick = viewModel::addTodo) { Text("Tambah") }
        }

        if (uiState.todos.isEmpty()) {
            Text("Belum ada tugas yang dicatat.")
        } else {
            // App.kt membungkus layar dengan verticalScroll, jadi LazyColumn perlu tinggi maksimum
            // yang terbatas (kalau tidak, Compose melempar error "infinite height constraints").
            LazyColumn(modifier = Modifier.fillMaxWidth().heightIn(max = 400.dp)) {
                items(uiState.todos, key = { it.id }) { todo ->
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Checkbox(
                            checked = todo.done,
                            onCheckedChange = { viewModel.toggleTodo(todo.id) }
                        )
                        Text(todo.text)
                    }
                }
            }
        }
    }
}
