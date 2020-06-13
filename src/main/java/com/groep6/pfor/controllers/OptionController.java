package com.groep6.pfor.controllers;

import com.groep6.pfor.util.IObserver;

public class OptionController extends Controller {

	@Override
	public void registerObserver(IObserver view) {
		game.registerObserver(view);
	}

}
