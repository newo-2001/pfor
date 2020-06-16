package com.groep6.pfor.util;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class SoundEffectManager {

    private static MediaPlayer mediaPlayer;
    private static double volume = 0.1;

    public static void play(String filePath) {
        mediaPlayer = new MediaPlayer(getMedia(filePath));
        mediaPlayer.setVolume(volume);

        mediaPlayer.play();
    }

    public static Media getMedia(String filePath) {
        return new Media(SoundEffectManager.class.getResource(filePath).toString());
    }

    public static void setVolume(double volume) {
        SoundEffectManager.volume = volume;
    }

}
