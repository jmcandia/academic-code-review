package edu.fixture.patitas;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public final class PatitasApp extends Application {
    @Override public void start(Stage stage) throws Exception {
        var root = FXMLLoader.load(PatitasApp.class.getResource("/edu/fixture/patitas/view/main-view.fxml"));
        stage.setTitle("Clínica Patitas");
        stage.setScene(new Scene(root, 850, 520));
        stage.show();
    }
}
