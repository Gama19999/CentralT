package centralt.centralt;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class PortadaView extends Application {
    @FXML
    Button initPrograma;

    Scene cover, program;

    @Override
    public void start(Stage stage) throws Exception {
        Parent rootProgram = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("app-view.fxml")));
        Parent rootCover = FXMLLoader.load(Objects.requireNonNull(PortadaView.class.getResource("cover-view.fxml")));

        cover = new Scene(rootCover);
        program = new Scene(rootProgram);

        stage.setTitle("Central Telefónica");
        stage.setMaximized(true);
        stage.getIcons().add(new Image("https://lh3.googleusercontent.com/a-/AOh14GgMXo97s6WQkT7wT4XxMgN05-SNgZHfq00A-Vj_pg=s83"));
        stage.setScene(cover);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    @FXML
    public void pressedInitPrograma(ActionEvent e) throws IOException {
        Stage stage = (Stage) initPrograma.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("app-view.fxml")));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
