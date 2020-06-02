package com.groep6.pfor.controllers;

import java.nio.file.Paths;

import com.groep6.pfor.util.IObserver;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

/**
 * Media controller to play, loop and stop audio files.
 * @author Mitchell van Rijswijk
 */
public class MediaController extends Controller {

	private static final MediaController INSTANCE = new MediaController();
	private MediaPlayer mediaPlayer;
	private double volume = 0.1;
	private boolean playing = false;
	private List<Media> mediaList = new ArrayList<>();

	private MediaController() {}

	public static MediaController getInstance() {
		return INSTANCE;
	}

	/**
	 * Plays music
	 * @param media
	 * @param repeat
	 */
	public void play(Media media, boolean repeat) {
		playing = true;
		mediaPlayer = new MediaPlayer(media);
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
				playing = false;
				playNext();
			}
		});

		mediaPlayer.play();
	}

	public void addToQueue(String filePath) {
		Media media = getMedia(filePath);
		mediaList.add(media);

		if (!playing) playNext();
	}

	public void playNext() {
		if (mediaList.size() <= 0) return;

		play(mediaList.get(0), false);
		mediaList.remove(0);
	}

	public Media getMedia(String filePath) {
		Media media = new Media(Paths.get(filePath).toUri().toString());
		return media;
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
	
	@Override
	public void registerObserver(IObserver view) {}

}
