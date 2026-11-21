package edu.fixture.notes

object NoteRepository {
    val notes = mutableListOf<String>()
    fun save(note: String): Boolean {
        notes.add(note)
        return true
    }
}
