package com.sample;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {
	Pattern SPECIAL_REGEX_CHARS = Pattern.compile("[{}()\\[\\].+*?^$\\\\|]");

	private String escapeSpecialRegexChars(String str) {
		return SPECIAL_REGEX_CHARS.matcher(str).replaceAll("\\\\$0");
	}

	private int intValue(String value) {
		return Integer.parseInt(value);
	}

	private String getDelimiter(String customDels) {
		if (!customDels.startsWith("[")) {
			return customDels;
		}
		List<String> delimList = new ArrayList<String>();
		for (int i = 0; i < customDels.length(); i++) {
			int start = customDels.indexOf("[", i);
			int end = customDels.indexOf("]", start);
			if (start > -1 && end > -1) {
				delimList.add(escapeSpecialRegexChars(customDels.substring(start + 1, end)));
			}
			i = end;
		}
		return delimList.stream().collect(Collectors.joining("|"));
	}

	public int add(String numbers) {
		if ("".equals(numbers))
			return 0;
		else {
			String delimiters =  ",|\n";
			String input = numbers;
			if (numbers.startsWith("//")) {
				String[] values = numbers.split("\n");
				delimiters = getDelimiter(values[0].substring(2));				
				input = values[1];
			}
			String[] values = input.split(delimiters);
			List<Integer> numberList = new ArrayList<>();
			List<Integer> negativeList = new ArrayList<>();
			for (String value : values) {
				int intVal = intValue(value);
				if (intVal < 0) {
					negativeList.add(intVal);
				} else if (intVal <= 1000) {
					numberList.add(intVal);
				}
			}
			if (!negativeList.isEmpty()) {
				throw new IllegalArgumentException("negatives not allowed " + negativeList.toString());
			}

			int result = 0;
			for (Integer value : numberList) {
				result += value;
			}
			return result;
		}
	}
}
