#include "Rational.h"

int Rational::numberOfRational = 0;

Rational::Rational(int numerator, int denominator)
{
	this->numerator = numerator;
	this->denominator = denominator;
	if (denominator == 0)
		this->denominator = 1;

	simplify(this->numerator, this->denominator);

	numberOfRational++;
}

Rational::Rational(const Rational& r)
{
	this->numerator = r.getNumerator();
	this->denominator = r.getDenominator();
	if (r.getDenominator() == 0)
		this->denominator = 1;

	simplify(this->numerator, this->denominator);

	numberOfRational++;
}

Rational::~Rational() { numberOfRational--; }

void Rational::setNumerator(int numerator) { this->numerator = numerator; }

void Rational::setDenominator(int denominator)
{
	this->denominator = denominator;
	if (denominator = 0)
		this->denominator = 1;
}

int Rational::getNumerator()const { return this->numerator; }

int Rational::getDenominator()const { return this->denominator; }

Rational Rational::operator+(Rational& rhs)
{
	if (this->denominator != rhs.denominator)
	{
		int tempdenom = this->getDenominator();
		setNumerator(this->getNumerator() * rhs.getDenominator());
		setDenominator(this->getDenominator() * rhs.getDenominator());
		rhs.setNumerator(rhs.getNumerator() * tempdenom);
		rhs.setDenominator(rhs.getDenominator() * tempdenom);
	}
	return Rational(this->getNumerator() + rhs.getNumerator(),
		this->getDenominator());
}

Rational Rational::operator-(Rational& rhs)
{
	if (this->denominator != rhs.denominator)
	{
		int tempdenom = this->getDenominator();
		setNumerator(this->getNumerator() * rhs.getDenominator());
		setDenominator(this->getDenominator() * rhs.getDenominator());
		rhs.setNumerator(rhs.getNumerator() * tempdenom);
		rhs.setDenominator(rhs.getDenominator() * tempdenom);
	}
	return Rational(this->getNumerator() - rhs.getNumerator(),
		this->getDenominator());
}

Rational Rational::operator*(Rational& rhs)
{
	return Rational((this->getNumerator() * rhs.getNumerator()),
		(this->getDenominator() * rhs.getDenominator()));
}

Rational Rational::operator/(const Rational& rhs)
{
	return Rational((this->getNumerator() * rhs.getDenominator()),
		(this->getDenominator() * rhs.getNumerator()));
}

Rational Rational::operator++() { return Rational(this->numerator + 1, this->denominator); }

Rational Rational::operator++(int) { return Rational(this->numerator + 1, this->denominator); }

Rational Rational::operator--() { return Rational(this->numerator - 1, this->denominator); }

Rational Rational::operator--(int) { return Rational(this->numerator - 1, this->denominator); }

void Rational::simplify(int numerator, int denominator)
{
	int maximum, p, q, i;

	if (numerator>denominator) 
		maximum = numerator;
	else 
		maximum = denominator;

	p = numerator;
	q = denominator;

	for (i = 2; i <= maximum / 2; i++)
	{
		if (numerator%i == 0 && denominator%i == 0)
		{
			numerator /= i;
			denominator /= i;
		}
	}

	if (numerator%2 == 0 && denominator%2 == 0)
	{
		numerator /= 2;
		denominator /= 2;
	}
	setNumerator(numerator);
	setDenominator(denominator);
}