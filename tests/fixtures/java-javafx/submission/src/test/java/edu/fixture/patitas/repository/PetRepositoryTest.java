package edu.fixture.patitas.repository;

import edu.fixture.patitas.dao.PetDao;
import edu.fixture.patitas.model.Pet;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class PetRepositoryTest {
    @Test void addPersistsTheUpdatedCollection() throws IOException {
        FakeDao dao = new FakeDao();
        PetRepository repository = new PetRepository(dao);
        repository.add(new Pet("Luna", 3, 8));
        assertEquals(1, dao.persisted.size());
    }

    @Test void deletePersistsTheUpdatedCollection() throws IOException {
        FakeDao dao = new FakeDao();
        PetRepository repository = new PetRepository(dao);
        Pet pet = new Pet("Luna", 3, 8);
        repository.add(pet);
        repository.delete(pet);
        assertTrue(dao.persisted.isEmpty());
    }

    private static final class FakeDao implements PetDao {
        private List<Pet> persisted = new ArrayList<>();
        public List<Pet> readAll() { return new ArrayList<>(persisted); }
        public void writeAll(List<Pet> pets) { persisted = new ArrayList<>(pets); }
    }
}
