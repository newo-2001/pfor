package com.groep6.pfor;

import com.groep6.pfor.controllers.ViewController;
import com.groep6.pfor.util.Renderer;
import com.groep6.pfor.views.MenuView;
import com.groep6.pfor.views.RecruitmentView;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    private static Renderer renderer;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Get ViewController instance and set primaryStage
        ViewController viewController = ViewController.getInstance();
        viewController.setPrimaryStage(primaryStage);

        // Set default view
        //viewController.showView(new RecruitmentView(viewController.getPrimaryStage()));
        viewController.showView(new MenuView(viewController.getPrimaryStage()));

    }
}
