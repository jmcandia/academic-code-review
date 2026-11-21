module edu.fixture.patitas {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    opens edu.fixture.patitas to javafx.fxml;
    opens edu.fixture.patitas.controller to javafx.fxml;
    opens edu.fixture.patitas.model to com.google.gson, javafx.base;
    exports edu.fixture.patitas;
    exports edu.fixture.patitas.model;
    exports edu.fixture.patitas.dao;
    exports edu.fixture.patitas.repository;
}
