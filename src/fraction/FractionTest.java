package fraction;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FractionTest {

	double delta;

	@BeforeEach
	public void setUp() {
		this.delta = 0.000001;
	}

	@Test
	void testFraction() {

		// test scenario 3
		Fraction fraction = new Fraction(-2, -8);
		assertEquals(2, fraction.numerator);
		assertEquals(8, fraction.denominator);

		// test scenario 4
		fraction = new Fraction(-2, 8);
		assertEquals(-2, fraction.numerator);
		assertEquals(8, fraction.denominator);

	}

	@Test
	void testReduceToLowestForm() {

		// test scenario 3
		Fraction fraction = new Fraction(4, -8);
		fraction.reduceToLowestForm();

		assertEquals(-1, fraction.numerator);
		assertEquals(2, fraction.denominator);

		// test scenario 4
		fraction = new Fraction(240, 160);
		fraction.reduceToLowestForm();

		assertEquals(3, fraction.numerator);
		assertEquals(2, fraction.denominator);

		// test scenario 5
		fraction = new Fraction(0, 3);
		fraction.reduceToLowestForm();

		assertEquals(0, fraction.numerator);
		assertEquals(1, fraction.denominator);

		// test scenario 6
		fraction = new Fraction(-4, 10);
		fraction.reduceToLowestForm();

		assertEquals(-2, fraction.numerator);
		assertEquals(5, fraction.denominator);

	}

	@Test
	void testAdd() {

		// test scenario 3
		Fraction fraction1 = new Fraction(4, 32);
		Fraction fraction2 = new Fraction(4, 32);
		Fraction newFraction = fraction1.add(fraction2);
		assertEquals(1, newFraction.numerator);
		assertEquals(4, newFraction.denominator);
		assertNotSame(newFraction, fraction1);
		assertNotSame(newFraction, fraction2);

		// test scenario 4
		fraction1 = new Fraction(4, -16);
		fraction2 = new Fraction(-5, 8);
		newFraction = fraction1.add(fraction2);
		assertEquals(-7, newFraction.numerator);
		assertEquals(8, newFraction.denominator);
		assertNotSame(newFraction, fraction1);
		assertNotSame(newFraction, fraction2);
	}

	@Test
	void testSubtract() {

		// test scenario 3
		Fraction fraction1 = new Fraction(4, 16);
		Fraction fraction2 = new Fraction(8, 32);
		Fraction newFraction = fraction1.subtract(fraction2);
		assertEquals(0, newFraction.numerator);
		assertEquals(1, newFraction.denominator);

		// test scenario 4
		fraction1 = new Fraction(5, 10);
		fraction2 = new Fraction(-3, 10);
		newFraction = fraction1.subtract(fraction2);
		assertEquals(4, newFraction.numerator);
		assertEquals(5, newFraction.denominator);
	}

	@Test
	void testMul() {

		// test scenario 3
		Fraction fraction1 = new Fraction(4, -16);
		Fraction fraction2 = new Fraction(5, 16);
		Fraction newFraction = fraction1.mul(fraction2);
		assertEquals(-5, newFraction.numerator);
		assertEquals(64, newFraction.denominator);

		// test scenario 4
		fraction1 = new Fraction(0, 9);
		fraction2 = new Fraction(3, 45);
		newFraction = fraction1.mul(fraction2);
		assertEquals(0, newFraction.numerator);
		assertEquals(1, newFraction.denominator);
	}

	@Test
	void testDiv() {

		// test scenario 3
		Fraction fraction1 = new Fraction(0, 16);
		Fraction fraction2 = new Fraction(5, 16);
		Fraction newFraction = fraction1.div(fraction2);
		assertEquals(0, newFraction.numerator);
		assertEquals(1, newFraction.denominator);

		// test scenario 4
		fraction1 = new Fraction(5, 9);
		fraction2 = new Fraction(5, 9);
		newFraction = fraction1.div(fraction2);
		assertEquals(1, newFraction.numerator);
		assertEquals(1, newFraction.denominator);
	}

	@Test
	void testDecimal() {

		// test scenario 3
		Fraction fraction1 = new Fraction(1, 3);
		double dec = fraction1.decimal();
		assertEquals(0.333333333333, dec, this.delta);

		// test scenario 4
		fraction1 = new Fraction(-1, 1);
		dec = fraction1.decimal();
		assertEquals(-1.0, dec, this.delta);
	}

	@Test
	void testSqr() {

		// test scenario 3
		Fraction fraction1 = new Fraction(-2, 3);
		fraction1.sqr();
		assertEquals(4, fraction1.numerator);
		assertEquals(9, fraction1.denominator);

		// test scenario 4
		fraction1 = new Fraction(0, 16);
		fraction1.sqr();
		assertEquals(0, fraction1.numerator);
		assertEquals(1, fraction1.denominator);
	}

	@Test
	void testAverageFraction() {

		// test scenario 2
		Fraction fraction1 = new Fraction(1, 2);
		Fraction otherFraction = new Fraction(-2, 4);
		Fraction avgFraction = fraction1.average(otherFraction);

		assertEquals(0, avgFraction.numerator);
		assertEquals(1, avgFraction.denominator);

		// test scenario 3
		fraction1 = new Fraction(1, -2);
		otherFraction = new Fraction(-3, 4);
		avgFraction = fraction1.average(otherFraction);

		assertEquals(-5, avgFraction.numerator);
		assertEquals(8, avgFraction.denominator);

		// test scenario 4
		fraction1 = new Fraction(10, 20);
		otherFraction = new Fraction(30, 60);
		avgFraction = fraction1.average(otherFraction);

		assertEquals(1, avgFraction.numerator);
		assertEquals(2, avgFraction.denominator);
	}

	@Test
	void testAverageFractionArray() {

		// test scenario 2
		Fraction fraction1 = new Fraction(3, 4);
		Fraction fraction2 = new Fraction(3, 5);
		Fraction fraction3 = new Fraction(3, 6);

		Fraction[] fractions = {};
		Fraction avgFraction = Fraction.average(fractions);

		assertEquals(0, avgFraction.numerator);
		assertEquals(1, avgFraction.denominator);

		// test scenario 3
		fraction1 = new Fraction(3, -4);
		fraction2 = new Fraction(-3, 5);
		fraction3 = new Fraction(3, -6);

		fractions = new Fraction[] { fraction1, fraction2, fraction3 };
		avgFraction = Fraction.average(fractions);

		assertEquals(-37, avgFraction.numerator);
		assertEquals(60, avgFraction.denominator);

		// test scenario 4
		fraction1 = new Fraction(3, 1);

		fractions = new Fraction[] { fraction1 };
		avgFraction = Fraction.average(fractions);

		assertEquals(3, avgFraction.numerator);
		assertEquals(1, avgFraction.denominator);

	}

	@Test
	void testAverageIntArray() {

		// test scenario 2
		int[] ints = {};
		Fraction avgFraction = Fraction.average(ints);

		assertEquals(0, avgFraction.numerator);
		assertEquals(1, avgFraction.denominator);

		// test scenario 3
		ints = new int[] { -3 };
		avgFraction = Fraction.average(ints);

		assertEquals(-3, avgFraction.numerator);
		assertEquals(1, avgFraction.denominator);

		// test scenario 4
		ints = new int[] { -1, -2, 3, -4 };
		avgFraction = Fraction.average(ints);

		assertEquals(-1, avgFraction.numerator);
		assertEquals(1, avgFraction.denominator);
	}

	@Test
	void testEqualsObject() {

		// test scenario 3
		Fraction fraction1 = new Fraction(3, 4);
		String str = "2";

		assertFalse(fraction1.equals(str));

		// test scenario 4
		fraction1 = new Fraction(-0, 16);
		Fraction fraction2 = new Fraction(-0, 4);
		assertEquals(fraction1, fraction2);
	}

	@Test
	void testToString() {

		// test scenario 2
		Fraction fraction1 = new Fraction(0, 5);
		String str = fraction1.toString();
		assertEquals("0/5", str);

		// test scenario 3
		fraction1 = new Fraction(-2, -3);
		str = fraction1.toString();
		assertEquals("2/3", str);

		// test scenario 4
		fraction1 = new Fraction(8, 1);
		str = fraction1.toString();
		assertEquals("8/1", str);
	}

}
