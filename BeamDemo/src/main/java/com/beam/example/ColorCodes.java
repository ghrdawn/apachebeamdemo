package com.beam.example;

import java.io.Serializable;
import java.util.List;

public class ColorCodes implements Serializable {
	private static final long serialVersionUID = 5934861774931719057L;
	
	private List<ColorCode> colors;

	public List<ColorCode> getColors() {
		return colors;
	}

	public void setColors(List<ColorCode> colors) {
		this.colors = colors;
	}
}
