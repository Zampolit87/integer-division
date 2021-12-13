package ua.com.foxminded;

import static org.junit.jupiter.api.Assertions.*;
import static java.lang.System.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DivisionFormatterTest {

	private DivisionFormatter divisionFormatter;
	private IntegerDivision division;

	@BeforeEach
	public void setUp() {
		divisionFormatter = new DivisionFormatter();
		division = new IntegerDivision();
	}

	@Test
	public void givenDivisionResultOf1334and4_whenFormat_thenOutputDivisionResult() {
		StringBuilder expected = new StringBuilder();
		expected.append("_1334|4").append(lineSeparator());
		expected.append(" 12  |---").append(lineSeparator());
		expected.append(" --  |333").append(lineSeparator());
		expected.append(" _13").append(lineSeparator());
		expected.append("  12").append(lineSeparator());
		expected.append("  --").append(lineSeparator());
		expected.append("  _14").append(lineSeparator());
		expected.append("   12").append(lineSeparator());
		expected.append("   --").append(lineSeparator());
		expected.append("    2").append(lineSeparator());
		DivisionResult result = division.divide(1334, 4);

		String actual = divisionFormatter.format(result);

		assertEquals(expected.toString(), actual);
	}

	@Test
	public void givenDivisionResultOf4500000and10_whenFormat_thenOutputDivisionResult() {
		StringBuilder expected = new StringBuilder();
		expected.append("_4500000|10").append(lineSeparator());
		expected.append(" 40     |------").append(lineSeparator());
		expected.append(" --     |450000").append(lineSeparator());
		expected.append(" _50").append(lineSeparator());
		expected.append("  50").append(lineSeparator());
		expected.append("  --").append(lineSeparator());
		expected.append("   0").append(lineSeparator());
		DivisionResult result = division.divide(4500000, 10);

		String actual = divisionFormatter.format(result);

		assertEquals(expected.toString(), actual);
	}

	@Test
	public void givenDivisionResultOf123123and43_whenFormat_thenOutputDivisionResult() {
		StringBuilder expected = new StringBuilder();
		expected.append("_123123|43").append(lineSeparator());
		expected.append(" 86    |----").append(lineSeparator());
		expected.append(" --    |2863").append(lineSeparator());
		expected.append(" _371").append(lineSeparator());
		expected.append("  344").append(lineSeparator());
		expected.append("  ---").append(lineSeparator());
		expected.append("  _272").append(lineSeparator());
		expected.append("   258").append(lineSeparator());
		expected.append("   ---").append(lineSeparator());
		expected.append("   _143").append(lineSeparator());
		expected.append("    129").append(lineSeparator());
		expected.append("    ---").append(lineSeparator());
		expected.append("     14").append(lineSeparator());
		DivisionResult result = division.divide(123123, 43);

		String actual = divisionFormatter.format(result);

		assertEquals(expected.toString(), actual);
	}
}
