package ua.com.foxminded;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IntegerDivisionTest {

	private IntegerDivision division;

	@BeforeEach
	public void setUp() {
		division = new IntegerDivision();
	}

	@Test
	void given78945and4_whenDivide_then19736() {
		DivisionResult expected = new DivisionResult(78945, 4, 19736, 1);
		expected.getDivisionSteps().add(new DivisionStep(7, 4));
		expected.getDivisionSteps().add(new DivisionStep(38, 36));
		expected.getDivisionSteps().add(new DivisionStep(29, 28));
		expected.getDivisionSteps().add(new DivisionStep(14, 12));
		expected.getDivisionSteps().add(new DivisionStep(25, 24));

		DivisionResult actual = division.divide(78945, 4);

		assertEquals(expected, actual);
	}

	@Test
	public void givenDividendLessThenDivisor_whenDivide_thenZeroResult() {
		DivisionResult expected = new DivisionResult(9, 15, 0, 9);
		expected.getDivisionSteps().add(new DivisionStep(0, 0));

		DivisionResult actual = division.divide(9, 15);

		assertEquals(expected, actual);
	}

	@Test
	public void givenDivisorIsZero_whenDivide_thenThrowException() {
		assertThrows(IllegalArgumentException.class, () -> {
			division.divide(2, 0);
		});
	}

	@Test
	public void givenDivisorLessThanZero_whenDivide_thenThrowException() {
		assertThrows(IllegalArgumentException.class, () -> {
			division.divide(25, -5);
		});
	}

	@Test
	public void givenDividendlessZero_whenDivide_thenThrowException() {
		assertThrows(IllegalArgumentException.class, () -> {
			division.divide(-25, 5);
		});
	}
}
