package com.cnfwsy.spider.core.util;

import java.util.regex.Pattern;

public class DigitUtils {

	private static boolean isDigitA(char ch)

	{

		return Character.isDigit(ch);

	}

	private static boolean isDigitB(char ch)

	{

		Pattern pattern = Pattern.compile("[0-9]");

		return pattern.matcher(String.valueOf(ch)).matches();

	}

	private static boolean isDigitC(char ch)

	{

		if (ch < 48 || ch > 57)

			return false;

		else

			return true;

	}

	private static boolean isDigitD(char ch)

	{

		try

		{

			int i = Integer.parseInt(String.valueOf(ch));

			return true;

		}

		catch (NumberFormatException e)

		{

			e.printStackTrace();

			return false;

		}

	}
}
