package com.beam.example;

import java.io.Serializable;

public class Colors implements Serializable {
	private static final long serialVersionUID = 8519602843252666187L;
	
	private String color;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}
