package com.groep6.pfor.util;

import java.nio.file.Paths;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.util.ArrayList;
import java.util.List;

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

	public void play() {
		mediaPlayer = new MediaPlayer(playlist.next());
		mediaPlayer.setVolume(volume);

//		if (repeat) {
//			mediaPlayer.setOnEndOfMedia(new Runnable() {
//				@Override
//				public void run() {
//					mediaPlayer.seek(Duration.ZERO);
//				}
//			});
//		}

		mediaPlayer.setOnEndOfMedia(new Runnable() {
			@Override
			public void run() {
				play();
			}
		});

		mediaPlayer.play();
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
