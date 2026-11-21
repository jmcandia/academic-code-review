package edu.fixture.notes

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class NoteRepositoryTest {
    @Test fun savesNonblankNote() { assertTrue(NoteRepository.save("Call home")) }
    @Test fun rejectsBlankNote() { assertFalse(NoteRepository.save("   ")) }
}
