package org.giriraj.Exceptions;

import java.time.LocalDateTime;

import lombok.*;

@Getter
@Setter
public class MyErrorDetails {

	private LocalDateTime timeStamps;
	private String message;
	private String description;

	public MyErrorDetails(LocalDateTime timeStamps, String message, String description) {
		this.timeStamps = timeStamps;
		this.message = message;
		this.description = description;
	}
}
