package app.model.core;

import app.constants.ScreenMessage;

public class Screen {

	private String message;
	
	public Screen() {
		super();
		this.message = ScreenMessage.EMPTY_SCREEN_MESSAGE;
	}

	public String message() {
		return message;
	}
	
	public void updateMessage(String message) {
		this.message = message;
	}
}
