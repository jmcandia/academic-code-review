package edu.fixture.notes

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val repository = NoteRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val input = findViewById<EditText>(R.id.noteInput)
        val message = findViewById<TextView>(R.id.message)
        val list = findViewById<TextView>(R.id.notesList)
        findViewById<Button>(R.id.saveButton).setOnClickListener {
            repository.save(input.text.toString())
            list.text = repository.notes.joinToString("\n")
            message.text = "Note saved"
            input.text.clear()
        }
    }
}
