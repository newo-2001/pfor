package com.groep6.pfor.controllers;

import com.groep6.pfor.views.MenuView;
import com.groep6.pfor.views.View;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

/**
 * With the ViewController it is easy to switch to different Views
 * @author Bastiaan Jansen
 */
public class ViewController {

    private static final ViewController INSTANCE = new ViewController();
    public static ViewController getInstance() { return INSTANCE; }

    private List<View> visitedViews = new ArrayList<>();
    private Stage stage;

    private ViewController() {
        
    }

    /**
     * @param stage
     */
    public void setPrimaryStage(Stage stage) {
        this.stage = stage;
    }

    /**
     * Show a specific view
     * @param view
     */
    public void showView(View view) {
        visitedViews.add(view);
        Scene scene = view.getScene();
        stage.setScene(scene);
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
