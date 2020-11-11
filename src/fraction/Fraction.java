package fraction;

/**
 * Represents a fraction with associated methods
 * @author Tianxiao Zhang, Eugene Chong
 *
 */
public class Fraction {
	
	// initialize the instance variables
	int numerator = 0;
	int denominator = 0;
	
	/**
	 * create a Fraction with the given numerator and denominator
	 * @param numerator, denominator
	 */
	public Fraction(int numerator, int denominator) {
		//set the values of the numerator and the denominator
		this.numerator = numerator;
		this.denominator = denominator;
		
		//properly format the numbers
		//if both negative, switch both to positive
		if (this.denominator < 0 && this.numerator < 0) {
			this.denominator = -this.denominator;
			this.numerator = -this.numerator;
		//if only denominator is negative, 
		//switch denominator to positive and numerator to negative
		}else if (this.denominator < 0){
			this.denominator = -this.denominator;
			this.numerator = -this.numerator;
		}
	}
	
	/*
	 * reduce the current fraction by eliminating common factors
	 */
	public void reduceToLowestForm() {
		
		// if the numerator is 0, change the denominator to 1
		if (this.numerator == 0) {	
			this.denominator = 1;
		} else {
		//find the greatest common factor
		int gcd = 1;
		for(int i = 1; i <= Math.abs(this.denominator) && i <= Math.abs(this.numerator); i++) {
            if(this.denominator%i==0 && this.numerator%i==0) {
                gcd = i;
            }
		}
		//reduce both numbers by the scale of gcd
		this.denominator = this.denominator/gcd;
		this.numerator = this.numerator/gcd;		
		}
	}
	
	/**
	 * add the current fraction to the given otherFraction
	 * @param otherFraction
	 */
	public Fraction add(Fraction otherFraction) {
		
		//find the new denominator
		int dtemp = this.denominator*otherFraction.denominator;
		//find the new numerator
		int ntemp = this.numerator*otherFraction.denominator + this.denominator*otherFraction.numerator;
		
		Fraction added = new Fraction(ntemp, dtemp);
		added.reduceToLowestForm();
		return added;
	}
	
	/**
	 * subtract the current fraction to the given otherFraction
	 * @param otherFraction
	 */
	public Fraction subtract(Fraction otherFraction) {
		//find the new denominator
		int dtemp = this.denominator*otherFraction.denominator;
		//find the new numerator
		int ntemp = this.numerator*otherFraction.denominator - this.denominator*otherFraction.numerator;
		
		Fraction subtracted = new Fraction(ntemp, dtemp);
		subtracted.reduceToLowestForm();
		return subtracted;
	}
	
	/**
	 * multiply the current fraction by the given otherFraction
	 * @param otherFraction
	 */
	public Fraction mul(Fraction otherFraction) {
		//find the new denominator
		int dtemp = this.denominator*otherFraction.denominator;
		//find the new numerator
		int ntemp = this.numerator*otherFraction.numerator;
		
		Fraction multiplied = new Fraction(ntemp, dtemp);
		multiplied.reduceToLowestForm();
		return multiplied;
	}
	
	/**
	 * divide the current fraction by the given otherFraction
	 * @param otherFraction
	 */
	public Fraction div(Fraction otherFraction) {
		//find the new denominator
		int dtemp = this.denominator*otherFraction.numerator;
		//find the new numerator
		int ntemp = this.numerator*otherFraction.denominator;
		
		Fraction divided = new Fraction(ntemp, dtemp);
		divided.reduceToLowestForm();
		return divided;
	}
	
	/*
	 * return this fraction in decimal form
	 */
	public double decimal() {
		double result = (double) numerator;
		result = result/this.denominator;
		return result;
	}
	
	/*
	 * square the current fraction
	 */
	public void sqr() {
		//modifies the value of the current variables
		this.numerator = this.numerator * this.numerator;
		this.denominator = this.denominator * this.denominator;
		this.reduceToLowestForm();
	}
	
	/**
	 * average the current fraction with the given otherFraction
	 * @param otherFraction
	 */
	public Fraction average(Fraction otherFraction) {
		//add them first, and then divide by 2 (multiply by 1/2)
		Fraction added = this.add(otherFraction);
		//create a fraction of 1/2
		Fraction half = new Fraction(1, 2);
		//multiply the product by 1/2
		Fraction result = added.mul(half);
		
		result.reduceToLowestForm();
		return result;
	}
	
	/**
	 * static method to average all of the fractions in the given array
	 * @param Fraction[]fractions
	 **/
	public static Fraction average(Fraction[] fractions) {
		
		int len = fractions.length;
		//if the array is empty, returns 0
		if (len == 0) {
			return new Fraction(0, 1);
		}
		
		Fraction first = fractions[0];
		//calculate the sum of all fractions in the list
		for(int i = 1; i < len; i++) {
			first = first.add(fractions[i]);
		}
		//divide the sum by the number of elements (multiply by 1/number of elements)
		first = first.mul(new Fraction(1, len));
		
		first.reduceToLowestForm();
		return first;
	}
	
	/**
	 * static method to average all integers in the given array
	 * @param int[] ints
	 */
	public static Fraction average(int[] ints) {
		
		int len = ints.length;
		//if the array is empty, returns 0
		if (len == 0) {
			return new Fraction(0, 1);
		}
		int first = ints[0];
		//average is calculated by sum divided by size (sum as numerator, size as denominator)
		for(int i = 1; i < len; i++) {
			first += ints[i];
		}
		Fraction result = new Fraction(first, len);
		result.reduceToLowestForm();
		return result;
		
	}
	
	/**
	 * overridden method to compare the 
	 * given object (as a fraction) to the current fraction, for equality
	 * @param object
	 */
	public boolean equals(Object object) {
		//check whether the object can be casted to a Fraction
		if (!(object instanceof Fraction)) {
			return false;
		} 
		// Cast the object into a fraction
		Fraction f = (Fraction) object;
		f = new Fraction(f.numerator, f.denominator);
		f.reduceToLowestForm();
		
		// assign two new variables, so that we dont modify the current Fraction
		int den = this.denominator;
		int num = this.numerator;
		
		Fraction copy = new Fraction(num, den);
		copy.reduceToLowestForm();
		
		return (copy.denominator == f.denominator && copy.numerator == f.numerator);	
	}
	
	/**
	 * overridden method to return a string representation of the current fraction
	 */
	public String toString() {
		//first convert the numerator and the denominator to strings
		String num = Integer.toString(this.numerator); 
		String dem = Integer.toString(this.denominator); 
		return num+"/"+dem;
	}
}
