package com.groep6.pfor.util;

import javafx.scene.media.Media;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Playlist {

    private List<Media> songs = new ArrayList<>();
    private boolean shuffle = true;
    private int currentIndex = 0;

    public Playlist(boolean shuffle) {
        this.shuffle = shuffle;
    }

    public Playlist() {

    }

    public void add(String path) {
        Media media = new Media(Paths.get(path).toUri().toString());
        songs.add(media);
        if (shuffle) Collections.shuffle(songs);
    }

    public Media getSong(int index) {
        return songs.get(index);
    }

    public Media next() {
        Media media = songs.get(currentIndex);

        if (hasNext()) currentIndex++;

        return media;
    }

    public boolean hasNext() {
        return songs.size() > currentIndex;
    }

}
