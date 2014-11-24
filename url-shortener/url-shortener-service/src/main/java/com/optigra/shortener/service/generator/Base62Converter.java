package com.optigra.shortener.service.generator;

import org.springframework.stereotype.Component;

@Component("base62Converter")
public class Base62Converter {
	private final int LENGTH_OF_URL_CODE = 6;

	public String convertTo62Base(long id) {
		String[] elements = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
				"k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
				"w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8",
				"9", "0", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
				"K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
				"W", "X", "Y", "Z" };
		
		String convertedString = "";
		int numOfDiffChars = elements.length;
		if (id < numOfDiffChars + 1 && id > 0) {
			convertedString = elements[(int) (id - 1)];
		} else if (id > numOfDiffChars) {
			long mod = 0;
			long multiplier = 0;
			boolean determinedTheLength = false;
			for (int j = LENGTH_OF_URL_CODE; j >= 0; j--) {
				multiplier = (long) (id / Math
						.pow(numOfDiffChars, j));
				if (multiplier > 0 && id >= numOfDiffChars) {
					convertedString += elements[(int) multiplier];
					determinedTheLength = true;
				} else if (determinedTheLength && multiplier == 0) {
					convertedString += elements[0];
				} else if (id < numOfDiffChars) {
					convertedString += elements[(int) mod];
				}

				mod = (long) (id % Math.pow(numOfDiffChars, j));
				id = mod;
			}

		}
		return convertedString;
	}

}