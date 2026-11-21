package edu.fixture.patitas.dao;

import edu.fixture.patitas.model.Pet;
import java.io.IOException;
import java.util.List;

public interface PetDao {
    List<Pet> readAll() throws IOException;
    void writeAll(List<Pet> pets) throws IOException;
}
