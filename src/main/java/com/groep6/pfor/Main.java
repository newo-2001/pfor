package com.groep6.pfor;

<<<<<<< HEAD
<<<<<<< HEAD
import com.groep6.pfor.util.Renderer;
import com.groep6.pfor.util.Vector2f;
=======
import com.groep6.pfor.exceptions.IncorrentPasswordException;
import com.groep6.pfor.models.Lobby;
import com.groep6.pfor.models.LobbyPlayer;
>>>>>>> 513951a6156f8a63b7ad90cc4f74d9188a7efaed
=======
import com.groep6.pfor.exceptions.IncorrentPasswordException;
import com.groep6.pfor.models.Lobby;
import com.groep6.pfor.models.LobbyPlayer;
>>>>>>> 513951a6156f8a63b7ad90cc4f74d9188a7efaed
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
            LobbyPlayer person2 = lobby.join("Person2", "sd");
            LobbyPlayer person3 = lobby.join("Person3", "password");
        } catch (IncorrentPasswordException exception) {
            System.out.println(exception.getMessage());
        }

        System.out.println(lobby.getCode());
    }
}
