package com.groep6.pfor;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.groep6.pfor.models.City;
import com.groep6.pfor.util.FileReader;
import com.groep6.pfor.util.parsers.CityParser;
import com.groep6.pfor.util.parsers.templates.CityDTO;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("Hello World!");

        /*Lobby lobby = new Lobby("password");

        try {
            LobbyPlayer person1 = lobby.join("Person1", "password");
            LobbyPlayer person2 = lobby.join("Person2", "wrongpassword");
            LobbyPlayer person3 = lobby.join("Person3", "password");
        } catch (IncorrentPasswordException exception) {
            System.out.println(exception.getMessage());
        }

        System.out.println(lobby.getCode());*/
        City[] cities = new CityParser().parseFile("test.json");
        for (City city : cities) {
            System.out.println(city);
        }
    }
}
