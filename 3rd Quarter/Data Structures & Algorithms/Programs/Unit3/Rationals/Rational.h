#include <ostream>
using namespace std;

#ifndef RATIONAL_H
#define RATIONAL_H

/* Creates an object called Rational that can be added. subtracted,
 * multiplied, and divided by as well as incremented and decremented
 *
 * @author Dylan Connor
 */
class Rational
{
private:
	int numerator;
	int denominator;

public:
	static int numberOfRational;

	/* Constructor
	 * Creates an object called Rational with two parameters
	 *
	 * @param numerator - numerator of rational
	 * @param denominator - denominator of rational
	 */
	Rational(int numerator = 0, int denominator = 1);

	/* Copy Constructor
	 *
	 * @return a deep copy of the given rational
	 */
	Rational(const Rational& r);

	/* Destructor
	 * Removes a rational from memory
	 */
	~Rational();

	/* Mutator for the numerator
	 * @param numerator - numerator of the rational fraction
	 */
	void setNumerator(int numerator);

	/* Mutator for the denominator
	 * @param denominator - denominator of the rational fraction
	 */
	void setDenominator(int denominator);

	// Retrieves value of numerator of the object
	int getNumerator()const;

	//Retrieves value of denominator of the object
	int getDenominator()const;

	/* Operator+ allows user to add two Rationals together
	 * if denominators are not the same, multiply both Rationals
	 * by the other's denominator
	 *
	 * @param rhs - rational being added to invoker
	 */
	Rational operator+(Rational& rhs);

	/* Operator- allows user to subtract two Rationals
	 * if denominators are not the same, multiply both Rationals
	 * by the other's denominator
	 *
	 * @param rhs - rational being subtracted from invoker
	 */
	Rational operator-(Rational& rhs);

	/* Operator* allows user to multiply two Rationals
	 * multiply numerators by numerators and denominators by denominators
	 *
	 * @param rhs - rational being multiplied into invoker
	 */
	Rational operator*(Rational& rhs);

	/* Operator/ allows user to divide two Rationals
	 * Division uses the reciprocal of the rhs Rational and multiplies
	 * both rationals
	 * Reciprocal = flipped numerator and denominator
	 *
	 * @param rhs - rational being divided from invoker
	 */
	Rational operator/(const Rational& rhs);

	//Pre-increment adds one to numerator
	Rational operator++();

	//Post-increment adds one to numerator
	Rational operator++(int);
	
	//Pre-decrement subtracts one from numerator
	Rational operator--();
	
	//Post-decrement subtracts one from numerator
	Rational operator--(int);

	/* Formats a Rational for being inserted into an ostream
	 * Allows chaining in stream
	 * @param rational - object to be inserted to stream
	 */
	friend ostream& operator<<(ostream& os, const Rational& rational)
	{
		os << rational.getNumerator() << "/" << rational.getDenominator();
		return os;
	}

	///Reduces fraction to simplest form
	void simplify(int numerator, int denominator);
};
#endif