package com.groep6.pfor.util;

import javafx.scene.media.Media;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Bastiaan Jansen
 */
public class Playlist {

    private final List<Media> songs = new ArrayList<>();
    private boolean shuffle = true;
    private boolean repeat = true;
    private int currentIndex = 0;

    /**
     * @param shuffle
     * @param repeat
     */
    public Playlist(boolean shuffle, boolean repeat) {
        this.shuffle = shuffle;
        this.repeat = repeat;
    }

    public Playlist() {}

    /**
     * @param path
     */
    public void add(String path) {
        Media media = new Media(Playlist.class.getResource(path).toString());
        songs.add(media);
        if (shuffle) Collections.shuffle(songs);
    }

    /**
     * @param index
     * @return media object
     */
    public Media getSong(int index) {
        return songs.get(index);
    }

    /**
     * @return Get next media object from playlist
     */
    public Media next() {
        Media media = songs.get(currentIndex);

        if (hasNext()) currentIndex++;
        else if (repeat) currentIndex = 0;

        return media;
    }

    public boolean hasNext() {
        return songs.size() > currentIndex + 1;
    }

}
