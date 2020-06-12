package com.groep6.pfor.util;

import java.nio.file.Paths;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * Media controller to play, loop and stop audio files.
 * @author Mitchell van Rijswijk
 */
public class MusicManager {

	private static MediaPlayer mediaPlayer;
	private double volume = 0.1;
	private Playlist playlist;

	public MusicManager(Playlist playlist) {
		this.playlist = playlist;
	}

	public void playPlaylist() {
		mediaPlayer = new MediaPlayer(playlist.next());
		mediaPlayer.setVolume(volume);

		mediaPlayer.setOnEndOfMedia(new Runnable() {
			@Override
			public void run() {
				playPlaylist();
			}
		});

		mediaPlayer.play();
	}
	
	public void play(String trackURL, double volume, boolean repeat) {
		Media media = new Media(Paths.get(trackURL).toUri().toString());
		mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setVolume(volume);
		mediaPlayer.play();
		if (repeat) mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
	}

	
	/**
	 * Stops currently playing sound file.
	 */
	public void stop() {
		mediaPlayer.stop();
	}

	public void pause() {
		mediaPlayer.pause();
	}

	public void resume() {
		mediaPlayer.play();
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

}
