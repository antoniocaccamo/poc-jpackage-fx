package me.antoniocaccamo.player.ui;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HelloWorldView implements FxmlView<HelloWorldViewModel>, Initializable {

    private static final Logger logger = LogManager.getLogger(HelloWorldView.class);

    @FXML
    private TextField locationURL;

    @FXML
    private Button buttonGO;

    @FXML
    private WebView webView;

    @InjectViewModel
    private HelloWorldViewModel viewModel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        locationURL.textProperty().bindBidirectional(viewModel.locationURLProperty());
        viewModel.textFieldProperty().addListener((observable, oldValue, newValue) -> {
            logger.info("textfield changed to : {} ", newValue);
            if ( newValue != null ) {
                try {
                    URI uri = URI.create(newValue);
                    String location = uri.getScheme() == null ? "http://" + uri.toASCIIString(): uri.toASCIIString();
                    logger.info(location);
                    webView.getEngine().load(location);
                } catch ( Exception e) {
                    logger.error("error occurred :{}", e);
                }
            }
        });
        buttonGO.disableProperty().bind(viewModel.getCommandGO().executableProperty().not());
    }

    @FXML //Method that is called if the button is clicked
    public void buttonGOClicked() {
        viewModel.getCommandGO().execute();
    }
}