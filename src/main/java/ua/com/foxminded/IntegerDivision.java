package ua.com.foxminded;

class IntegerDivision {

	public DivisionResult divide(int dividend, int divisor) {
		if (divisor == 0) {
			throw new IllegalArgumentException("Can't divide by zero!");
		}
		if (divisor < 0 || dividend < 0) {
			throw new IllegalArgumentException("Enter positive numbers!");
		}
		DivisionResult divisionResult = new DivisionResult();
		divisionResult.setDividend(dividend);
		divisionResult.setDivisor(divisor);
		if (dividend < divisor) {
			DivisionStep divisionStep = new DivisionStep();
			divisionResult.divisionSteps.add(divisionStep);
			divisionResult.setRemainder(dividend);
			return divisionResult;
		}
		int result = 0;
		int temporaryDividend = 0;
		int[] dividendDigits = splitToDigits(dividend);
		for (int i = 0; i < dividendDigits.length; i++) {
			if (temporaryDividend < divisor) {
				temporaryDividend = temporaryDividend * 10 + dividendDigits[i];
				result = result * 10;
			}
			if (temporaryDividend >= divisor) {
				DivisionStep divisionProcess = new DivisionStep();
				divisionProcess.setMinuend(temporaryDividend);
				divisionProcess.setSubtrahend(temporaryDividend / divisor * divisor);
				divisionResult.divisionSteps.add(divisionProcess);
				result = result + (temporaryDividend / divisor);
				temporaryDividend = temporaryDividend - (temporaryDividend / divisor * divisor);
			}
		}
		divisionResult.setRemainder(temporaryDividend);
		divisionResult.setQuotient(result);
		return divisionResult;
	}

	public static int countDigits(int number) {
		int digitsAmount = 0;
		do {
			number = number / 10;
			digitsAmount++;
		} while (number != 0);
		return digitsAmount;
	}

	public static int[] splitToDigits(int number) {
		int[] digits = new int[countDigits(number)];
		for (int i = digits.length - 1; i >= 0; i--) {
			digits[i] = number % 10;
			number = number / 10;
		}
		return digits;
	}
}
