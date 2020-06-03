package com.groep6.pfor.controllers;

import com.groep6.pfor.views.MenuView;
import com.groep6.pfor.views.View;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.swing.border.Border;
import java.util.ArrayList;
import java.util.List;

/**
 * With the ViewController it is easy to switch to different Views
 * @author Bastiaan Jansen
 */
public class ViewController {

    private static final int MIN_WIDTH = 1440;
    private static final int MIN_HEIGHT = 900;

    private static final ViewController INSTANCE = new ViewController();
    public static ViewController getInstance() { return INSTANCE; }

    private List<View> visitedViews = new ArrayList<>();
    private Stage stage;

    private ViewController() {}

    /**
     * @param stage
     */
    public void setPrimaryStage(Stage stage) {
        this.stage = stage;
        stage.setResizable(false);
        stage.setWidth(MIN_WIDTH);
        stage.setHeight(MIN_HEIGHT);
        //stage.setFullScreen(true);
    }

    /**
     * Show a specific view
     * @param view
     */
    public void showView(View view) {

        double width = stage.getWidth();
        double height = stage.getHeight();
        boolean isFullScreen = stage.isFullScreen();

        visitedViews.add(view);
        Pane root = view.getRoot();

        Scene scene = stage.getScene();

        if (scene != null) {
            scene.setRoot(root);
        } else {
            Scene newScene = new Scene(root);
            stage.setScene(newScene);
        }

//        if (isFullScreen) {
//            stage.setFullScreen(true);
//        } else {
            stage.setWidth(width);
            stage.setHeight(height);
//        }

        stage.show();
    }

    /**
     * @return primaryStage
     */
    public Stage getPrimaryStage() {
        return stage;
    }

    /**
     * Show previous view
     */
    public void showPreviousView() {
        if (visitedViews.size() < 2) return;
        showView(visitedViews.get(visitedViews.size() - 2));
    }

    public void setWidth(int width) {
        stage.setWidth(width);
    }

    public void setHeight(int height) {
        stage.setHeight(height);
    }

    public void setTitle(String title) {
        stage.setTitle(title);
    }
}
