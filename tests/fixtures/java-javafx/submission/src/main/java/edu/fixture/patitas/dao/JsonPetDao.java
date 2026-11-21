package edu.fixture.patitas.dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import edu.fixture.patitas.model.Pet;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public final class JsonPetDao implements PetDao {
    private static final Path FILE = Path.of("pets.json");
    private static final Type PET_LIST = new TypeToken<List<Pet>>() {}.getType();
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Override public List<Pet> readAll() throws IOException {
        if (Files.notExists(FILE)) return new ArrayList<>();
        try (var reader = Files.newBufferedReader(FILE)) {
            List<Pet> pets = gson.fromJson(reader, PET_LIST);
            return pets == null ? new ArrayList<>() : pets;
        }
    }

    @Override public void writeAll(List<Pet> pets) throws IOException {
        try (var writer = Files.newBufferedWriter(FILE)) { gson.toJson(pets, PET_LIST, writer); }
    }
}
