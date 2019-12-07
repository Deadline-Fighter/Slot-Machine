import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.concurrent.TimeUnit;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws InterruptedException {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("core/view/slotMachine.fxml"));
            primaryStage.setTitle("Online Casino");
            primaryStage.setScene(new Scene(root, 619, 487));
            primaryStage.show();

        } catch (final Exception e) {
            TimeUnit.SECONDS.sleep(5);
            primaryStage.close();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}

