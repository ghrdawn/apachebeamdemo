package com.beam.example;

import java.io.Serializable;

public class ColorCode implements Serializable {
	private static final long serialVersionUID = 8133230214238641391L;

	public ColorCode() {

	}

	public ColorCode(String color, String value) {
		this.color = color;
		this.value = value;
	}

	private String color;
	private String value;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
