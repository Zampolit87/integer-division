package ua.com.foxminded;

import static java.lang.System.*;
import static ua.com.foxminded.IntegerDivision.*;

public class DivisionFormatter {
	
	private static final char SPACE = ' ';
	private static final char DASH = '-';

	public String format(DivisionResult divisionResult) {
		StringBuilder result = new StringBuilder();
		int amountOfSpaces = formatHeader(divisionResult, result);
		amountOfSpaces = formatSteps(divisionResult, result, amountOfSpaces);
		return formatRemainder(divisionResult, result, amountOfSpaces);
	}

	private int formatHeader(DivisionResult divisionResult, StringBuilder buildHeader) {
		int amountOfSpaces = 1;
		int dividend = divisionResult.getDividend();
		int divisor = divisionResult.getDivisor();
		int quotient = divisionResult.getQuotient();
		DivisionStep divisionStep = divisionResult.divisionSteps.get(0);

		buildHeader.append("_" + dividend + "|" + divisor).append(lineSeparator());
		buildHeader.append(repeatChar(SPACE, amountOfSpaces) + divisionStep.getSubtrahend());
		buildHeader.append(repeatChar(SPACE, countDigits(dividend) - countDigits(divisionStep.getSubtrahend())));
		buildHeader.append("|" + repeatChar(DASH, countDigits(quotient))).append(lineSeparator());
		buildHeader.append(
				repeatChar(SPACE, amountOfSpaces) + repeatChar(DASH, countDigits(divisionStep.getSubtrahend())));
		buildHeader.append(repeatChar(SPACE, countDigits(dividend) - countDigits(divisionStep.getSubtrahend())));
		buildHeader.append("|" + quotient).append(lineSeparator());

		return amountOfSpaces;
	}

	private int formatSteps(DivisionResult divisionResult, StringBuilder buildBody, int amountOfSpaces) {
		for (int i = 1; i < divisionResult.divisionSteps.size(); i++) {
			DivisionStep previousDivisionStep = divisionResult.divisionSteps.get(i - 1);
			DivisionStep divisionStep = divisionResult.divisionSteps.get(i);

			if (previousDivisionStep.getMinuend() == previousDivisionStep.getSubtrahend()
					&& previousDivisionStep.getSubtrahend() > 10) {
				amountOfSpaces = amountOfSpaces + countDigits(previousDivisionStep.getSubtrahend()) - 1;
			}
			buildBody.append(repeatChar(SPACE, amountOfSpaces) + "_" + divisionStep.getMinuend())
					.append(lineSeparator());
			buildBody.append(repeatChar(SPACE, ++amountOfSpaces) + divisionStep.getSubtrahend())
					.append(lineSeparator());
			buildBody.append(
					repeatChar(SPACE, amountOfSpaces) + repeatChar(DASH, countDigits(divisionStep.getSubtrahend())))
					.append(lineSeparator());
		}
		return amountOfSpaces;
	}

	private String formatRemainder(DivisionResult divisionResult, StringBuilder buildRemaind, int amountOfSpaces) {
		DivisionStep lastDivisionStep = divisionResult.divisionSteps.get(divisionResult.divisionSteps.size() - 1);
		amountOfSpaces = amountOfSpaces + countDigits(lastDivisionStep.getSubtrahend())
				- countDigits(divisionResult.getRemainder());
		buildRemaind.append(repeatChar(SPACE, amountOfSpaces) + divisionResult.getRemainder()).append(lineSeparator());

		return buildRemaind.toString();
	}

	private String repeatChar(char character, int times) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < times; i++) {
			result.append(character);
		}
		return result.toString();
	}
}
