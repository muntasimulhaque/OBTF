package com.example.obtf

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testNoteEditorExists() {
        onView(withId(R.id.noteEditor))
            .check(matches(isDisplayed()))
    }

    @Test
    fun testNoteEditorHint() {
        onView(withId(R.id.noteEditor))
            .check(matches(withHint(R.string.note_hint)))
    }

    @Test
    fun testNoteEditorInput() {
        val testText = "Test note content"
        
        onView(withId(R.id.noteEditor))
            .perform(typeText(testText))
            .check(matches(withText(testText)))
    }

    @Test
    fun testNoteEditorMultiline() {
        val testText = "Line 1\nLine 2\nLine 3"
        
        onView(withId(R.id.noteEditor))
            .perform(typeText(testText))
            .check(matches(withText(testText)))
    }
} 