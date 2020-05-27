package com.groep6.pfor;

import com.groep6.pfor.controllers.ViewController;
import com.groep6.pfor.util.Renderer;
import com.groep6.pfor.util.Vector2f;
import com.groep6.pfor.exceptions.IncorrentPasswordException;
import com.groep6.pfor.models.Lobby;
import com.groep6.pfor.models.LobbyPlayer;
import com.groep6.pfor.views.MenuView;
import com.groep6.pfor.views.View;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
    private static Renderer renderer;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("Hello World!");

        renderer = new Renderer(primaryStage, new Vector2f(1280, 720));

        ViewController viewController = new ViewController(primaryStage);

        View menuView = new MenuView(primaryStage);

        primaryStage.setScene(menuView.getScene());
        primaryStage.show();


    }
}
