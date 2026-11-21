package edu.fixture.patitas.repository;

import edu.fixture.patitas.dao.JsonPetDao;
import edu.fixture.patitas.dao.PetDao;
import edu.fixture.patitas.model.Pet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class PetRepository {
    private final PetDao dao;
    private final List<Pet> pets = new ArrayList<>();

    public PetRepository() { this(new JsonPetDao()); }
    public PetRepository(PetDao dao) { this.dao = dao; }
    public List<Pet> load() throws IOException {
        pets.clear(); pets.addAll(dao.readAll()); return all();
    }
    public List<Pet> all() { return Collections.unmodifiableList(pets); }
    public void add(Pet pet) throws IOException {
        pets.add(pet); dao.writeAll(pets);
    }
    public boolean delete(Pet pet) throws IOException {
        return pets.remove(pet);
    }
}
