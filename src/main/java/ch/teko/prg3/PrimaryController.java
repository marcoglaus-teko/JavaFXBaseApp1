package ch.teko.prg3;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PrimaryController {

    @FXML
    private Button b1;

    @FXML
    private Button b2;

    @FXML
    private Button b3;

    @FXML
    void openBrowser(ActionEvent event) throws IOException {
        Runtime rt = Runtime.getRuntime();
        String[] urls = {"https://youtube.com", "https://google.ch", "https://coingecko.com"};

        String os = getEnvironment();
        System.out.println(os);

        Button button = (Button) event.getSource();
        System.out.println(button.getId());

        String url = "https://google.ch";

        if (button.getId().contains("1")) {
            url = urls[0];
        } else if (button.getId().contains("2")) {
            url = urls[1];
        } else if (button.getId().contains("3")) {
            url = urls[2];
        }

        if (os.contains("win")){
            rt.exec("rundll32 url.dll,FileProtocolHandler " + url);
        }
        else if (os.contains("mac"))
            rt.exec("open " + url);
    }

    private String getEnvironment() {
        return System.getProperty("os.name").toLowerCase();
    }
}
