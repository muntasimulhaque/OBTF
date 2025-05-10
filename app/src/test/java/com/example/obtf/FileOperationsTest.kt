package com.example.obtf

import org.junit.Test
import org.junit.Assert.*
import java.io.File
import java.io.FileOutputStream

class FileOperationsTest {
    
    @Test
    fun testFileCreation() {
        val tempFile = File.createTempFile("test", ".txt")
        assertTrue(tempFile.exists())
        tempFile.delete()
    }

    @Test
    fun testFileWriteAndRead() {
        val tempFile = File.createTempFile("test", ".txt")
        val testContent = "Test content"
        
        // Write content
        FileOutputStream(tempFile).use { output ->
            output.write(testContent.toByteArray())
        }
        
        // Read content
        val readContent = tempFile.readText()
        assertEquals(testContent, readContent)
        
        tempFile.delete()
    }

    @Test
    fun testFileAppend() {
        val tempFile = File.createTempFile("test", ".txt")
        val initialContent = "Initial content\n"
        val appendedContent = "Appended content"
        
        // Write initial content
        FileOutputStream(tempFile).use { output ->
            output.write(initialContent.toByteArray())
        }
        
        // Append content
        FileOutputStream(tempFile, true).use { output ->
            output.write(appendedContent.toByteArray())
        }
        
        // Read content
        val readContent = tempFile.readText()
        assertEquals(initialContent + appendedContent, readContent)
        
        tempFile.delete()
    }
} 