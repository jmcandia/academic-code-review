package edu.fixture.patitas.controller;

import edu.fixture.patitas.model.Pet;
import edu.fixture.patitas.repository.PetRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.util.Locale;

public final class MainController {
    @FXML private TextField nameInput;
    @FXML private TextField ageInput;
    @FXML private TextField weightInput;
    @FXML private TextField searchInput;
    @FXML private TableView<Pet> petTable;
    @FXML private TableColumn<Pet, String> nameColumn;
    @FXML private TableColumn<Pet, Integer> ageColumn;
    @FXML private Label message;

    private final PetRepository repository = new PetRepository();
    private final ObservableList<Pet> pets = FXCollections.observableArrayList();
    private final FilteredList<Pet> filteredPets = new FilteredList<>(pets, pet -> true);

    @FXML public void initialize() {
        nameColumn.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getName()));
        ageColumn.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("age"));
        petTable.setItems(filteredPets);
        searchInput.textProperty().addListener((obs, oldValue, newValue) -> {
            String query = newValue == null ? "" : newValue.trim().toLowerCase(Locale.ROOT);
            filteredPets.setPredicate(pet -> query.isEmpty() || pet.getName().toLowerCase(Locale.ROOT).contains(query));
        });
        try { pets.setAll(repository.load()); }
        catch (IOException ex) { message.setText("Could not load pets: " + ex.getMessage()); }
    }

    @FXML private void handleRegister() {
        try {
            String name = nameInput.getText();
            if (name == null || name.isBlank()) { message.setText("Name is required"); return; }
            int age = Integer.parseInt(ageInput.getText().trim());
            double weight = Double.parseDouble(weightInput.getText().trim());
            if (weight <= 0) { message.setText("Weight must be positive"); return; }
            Pet pet = new Pet(name, age, weight);
            repository.add(pet);
            pets.setAll(repository.all());
            message.setText("Pet registered");
        } catch (NumberFormatException ex) { message.setText("Enter a valid age and weight"); }
        catch (IllegalArgumentException ex) { message.setText(ex.getMessage()); }
        catch (IOException ex) { message.setText("Could not save pet: " + ex.getMessage()); }
    }

    @FXML private void handleDelete() {
        Pet selected = petTable.getSelectionModel().getSelectedItem();
        if (selected == null) { message.setText("Select a pet first"); return; }
        try {
            repository.delete(selected);
            pets.setAll(repository.all());
        } catch (IOException ex) { message.setText("Could not delete pet: " + ex.getMessage()); }
    }
}
