package com.groep6.pfor;

import com.groep6.pfor.util.Renderer;
import com.groep6.pfor.util.Vector2f;
import com.groep6.pfor.exceptions.IncorrentPasswordException;
import com.groep6.pfor.models.Lobby;
import com.groep6.pfor.models.LobbyPlayer;
import com.groep6.pfor.exceptions.IncorrentPasswordException;
import com.groep6.pfor.models.Lobby;
import com.groep6.pfor.models.LobbyPlayer;
import com.groep6.pfor.exceptions.IncorrentPasswordException;
import com.groep6.pfor.models.Lobby;
import com.groep6.pfor.models.LobbyPlayer;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch();
    }

    private static Renderer renderer;

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("Hello World!");

        renderer = new Renderer(primaryStage, new Vector2f(1280, 720));

        Lobby lobby = new Lobby("password");

        try {
            LobbyPlayer person1 = lobby.join("Person1", "password");
            LobbyPlayer person2 = lobby.join("Person2", "wrongpassword");
            LobbyPlayer person3 = lobby.join("Person3", "password");
        } catch (IncorrentPasswordException exception) {
            System.out.println(exception.getMessage());
        }

        System.out.println(lobby.getCode());

    }
}
