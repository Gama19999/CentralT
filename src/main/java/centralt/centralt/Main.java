package centralt.centralt;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
        stage.getIcons().add(new Image("https://lh3.googleusercontent.com/a-/AOh14GgMXo97s6WQkT7wT4XxMgN05-SNgZHfq00A-Vj_pg=s83"));
        stage.setScene(scene);

        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}