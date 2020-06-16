package com.groep6.pfor.controllers;

import com.groep6.pfor.Config;
import com.groep6.pfor.views.View;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Stack;

/**
 * With the ViewController it is easy to switch to different Views
 * @author Bastiaan Jansen
 */
public class ViewController {

    private static final int MIN_WIDTH = 1280;
    private static final int MIN_HEIGHT = 720;

    private static final ViewController INSTANCE = new ViewController();
    public static ViewController getInstance() { return INSTANCE; }

    private final Stack<View> visitedViews = new Stack<>();
    private Stage stage;

    private ViewController() {}

    /**
     * @param stage
     */
    public void setPrimaryStage(Stage stage) {
        this.stage = stage;
        //stage.setResizable(false);
        stage.setWidth(MIN_WIDTH);
        stage.setHeight(MIN_HEIGHT);
        stage.setFullScreen(true);
    }

    public View getCurrentView() {
        System.out.println(visitedViews.firstElement());
        return visitedViews.firstElement();
    }

    /**
     * Show a specific view
     * @param view
     */
    public void showView(View view, boolean preventPush) {
    	
    	stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);

        double width = stage.getWidth();
        double height = stage.getHeight();
        boolean isFullScreen = stage.isFullScreen();

        if (!preventPush) visitedViews.push(view);

        if (Config.DEBUG) {
            for (View newView: visitedViews) {
                System.out.println(newView.toString());
            }
            System.out.println("------------");
        }
        
        Pane root = view.getRoot();

        Scene scene = stage.getScene();

        if (scene != null) {
            scene.setRoot(root);
        } else {
            Scene newScene = new Scene(root);
            stage.setScene(newScene);
        }

        if (isFullScreen) {
            stage.setFullScreen(true);
        } else {
            stage.setWidth(width);
            stage.setHeight(height);
        }

        stage.show();
    }

    public void showView(View view) {
        showView(view, false);
    }
    
    public void toggleFullscreen() {
    	if (stage.isFullScreen()) {
    		stage.setFullScreen(false);
    		return;
    	}
    	stage.setFullScreen(true);
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
        if (visitedViews.size() <= 1) return;
        visitedViews.pop();
        showView(visitedViews.peek(), true);
    }
    
    public Stack<View> getVisitedViews() {
    	return visitedViews;
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
