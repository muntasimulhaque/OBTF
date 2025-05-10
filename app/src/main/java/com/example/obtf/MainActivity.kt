package com.example.obtf

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

class MainActivity : AppCompatActivity() {
    private lateinit var noteEditor: EditText
    private val noteFile: File by lazy {
        File(filesDir, "note.txt")
    }
    private var isTextChanged = false
    private val textWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        override fun afterTextChanged(s: Editable?) {
            isTextChanged = true
            saveNote()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        noteEditor = findViewById(R.id.noteEditor)
        noteEditor.addTextChangedListener(textWatcher)
        loadNote()
    }

    private fun loadNote() {
        try {
            if (noteFile.exists()) {
                val content = noteFile.readText()
                noteEditor.setText(content)
                noteEditor.setSelection(content.length)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    private fun saveNote() {
        if (!isTextChanged) return

        try {
            FileOutputStream(noteFile).use { output ->
                output.write(noteEditor.text.toString().toByteArray())
            }
            isTextChanged = false
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    override fun onPause() {
        super.onPause()
        saveNote()
    }
} 