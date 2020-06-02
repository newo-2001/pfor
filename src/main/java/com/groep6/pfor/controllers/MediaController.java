package com.groep6.pfor.controllers;

import java.nio.file.Paths;

import com.groep6.pfor.util.IObserver;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

/**
 * Media controller to play, loop and stop audio files.
 * @author Mitchell van Rijswijk
 *
 */
public class MediaController extends Controller {

	private static MediaPlayer mp;

	/**
	 * Plays music
	 * @param filePath
	 */
	public static void play(String filePath, double volume, boolean repeat) {
		Media sound = new Media(Paths.get(filePath).toUri().toString());
		mp = new MediaPlayer(sound);
		mp.setVolume(volume);

		if (repeat) {
			mp.setOnEndOfMedia(new Runnable() {
				public void run() {
					mp.seek(Duration.ZERO);
				}
			});
		}

		mp.play();
	}
	
	/**
	 * Stops currently playing sound file.
	 */
	public void stop() {
		mp.stop();
	}
	
	@Override
	public void registerObserver(IObserver view) {}

}
