package romanconverter.utils;


import java.util.LinkedHashMap;
import java.util.Map;

import exceptions.NotRomanNumeralException;
import exceptions.NumberOutOfRangeException;

public final class RomanConverterUtil {
	
	// romanNumerals contains Roman numerals and the equivalent integer
	private static final Map<String, Integer> romanNumerals;
	
	private RomanConverterUtil() {
	}

	/**
	 * converts integers to Roman values
	 * @param intEntry
	 * @return Roman number
	 * @throws NumberOutOfRangeException
	 */
	public static String getRomanNumber(int intEntry) throws NumberOutOfRangeException {
		if (intEntry < 1 || intEntry >= 4000) {
			throw new NumberOutOfRangeException("Number " + intEntry + " is out of range (1, 3999)");
		}

		String result = "";
		for (Map.Entry<String, Integer> entry : romanNumerals.entrySet()) {
			int repeatTimes = intEntry / entry.getValue();
			result += generateNumerals(entry.getKey(), repeatTimes);
			intEntry = intEntry % entry.getValue();
		}
		return result;
	}
	
	/**
	 * converts strings to integers, then to Roman values
	 * @param stringIntEntry
	 * @return Roman number
	 * @throws NumberOutOfRangeException
	 */
	public static String getRomanNumber(String stringIntEntry) throws NumberOutOfRangeException {
		return getRomanNumber(Integer.parseInt(stringIntEntry));
	}

	/**
	 * repeat the Roman literal as much as it exists in the integer
	 * for example in 2016 there is 2 M, the result of this function will be the string "MM"
	 * @param str
	 * @param times
	 * @return string containing as much literals as it exists in the integer
	 */
	private static String generateNumerals(String str, int times) {
		if (str == null) {
			return "";
		}
		final StringBuilder sb = new StringBuilder();
		for (int i = 0; i < times; i++) {
			sb.append(str);
		}
		return sb.toString();
	}
	
	/**
	 * converts integers to Roman values
	 * @param romanNumeral
	 * @return Integer
	 * @throws NotRomanNumeralException
	 */
	public static int getIntNumber(String romanNumeral) throws NotRomanNumeralException {
		int result = 0;
		String lastLiteral = "I";
		if (romanNumeral == null || romanNumeral.isEmpty()) {
			throw new NotRomanNumeralException();
		}
		for (int i = romanNumeral.length() - 1; i >= 0; i--) {
			String romanChar = Character.toString(romanNumeral.charAt(i));
			if (!romanNumerals.containsKey(romanChar)) {
				throw new NotRomanNumeralException();
			}
			if (romanNumerals.get(romanChar) >= romanNumerals.get(lastLiteral)) {
				result += romanNumerals.get(romanChar);
			} else {
				result -= romanNumerals.get(romanChar);
			}
			lastLiteral = romanChar;
		}

		return result;
	}
	
	// statically initialize romanNumerals
	static {
		romanNumerals = new LinkedHashMap<String, Integer>();
		
		romanNumerals.put("M", 1000);
		romanNumerals.put("CM", 900);
		romanNumerals.put("D", 500);
		romanNumerals.put("CD", 400);
		romanNumerals.put("C", 100);
		romanNumerals.put("XC", 90);
		romanNumerals.put("L", 50);
		romanNumerals.put("XL", 40);
		romanNumerals.put("X", 10);
		romanNumerals.put("IX", 9);
		romanNumerals.put("V", 5);
		romanNumerals.put("IV", 4);
		romanNumerals.put("I", 1);
	}

}
