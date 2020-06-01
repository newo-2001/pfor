package com.groep6.pfor.controllers;

import com.groep6.pfor.util.IObserver;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * Media controller to play, loop and stop audio files.
 * @author Mitchell van Rijswijk
 *
 */
public class MediaController extends Controller {
	
	MediaPlayer mp;

	/**
	 * Plays a sound file.
	 * 
	 */
	public void play(String filePath) {
		Media sound = new Media("filePath");
		mp = new MediaPlayer(sound);
		mp.setVolume(0.3);
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
