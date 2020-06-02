package com.groep6.pfor.controllers;

import java.nio.file.Paths;

import com.groep6.pfor.util.IObserver;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * Media controller to play, loop and stop audio files.
 * @author Mitchell van Rijswijk
 *
 */
public class MediaController extends Controller {

	/**
	 * Plays a sound file.
	 * 
	 */
	public static void play(String filePath) {
		Media sound = new Media(Paths.get(filePath).toUri().toString());
		MediaPlayer mp = new MediaPlayer(sound);
		mp.setVolume(0.1);
		mp.setAutoPlay(true);
	}
	
	/**
	 * Stops currently playing sound file.
	 * 
	 */
	public void stop() {
		
	}
	
	@Override
	public void registerObserver(IObserver view) {}

}
