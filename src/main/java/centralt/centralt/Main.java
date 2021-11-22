package centralt.centralt;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("app-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240); // 320, 240
        stage.setTitle("Central Telefónica");
        stage.setMaximized(true);
        stage.getIcons().add(new Image("https://lh3.googleusercontent.com/a-/AOh14GjrRvvLhcweenK-smCS2hbWSe6Q9XnQfPkTj9ZDbA=s83"));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}