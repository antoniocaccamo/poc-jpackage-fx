package me.antoniocaccamo.player;

import de.saxsys.mvvmfx.FluentViewLoader;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import de.saxsys.mvvmfx.ViewTuple;

import me.antoniocaccamo.player.ui.*;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Hello World Application");

    ViewTuple<HelloWorldView, HelloWorldViewModel> viewTuple = FluentViewLoader.fxmlView(HelloWorldView.class).load();

    Parent root = viewTuple.getView();
    stage.setScene(new Scene(root));
    stage.show();
    }
    
}
