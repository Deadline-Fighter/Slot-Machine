import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainTest {

    @Test
    public void testMain() throws InterruptedException {

        Thread thread = new Thread(() -> {
            new JFXPanel();
                    Platform.runLater(() -> {
                        try {
                            new Main().start(new Stage());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            Assertions.fail();
                        }
                    });
        });
        thread.start();
        Thread.sleep(5000);
    }
}
