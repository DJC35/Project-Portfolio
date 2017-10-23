#include "Rational.h"
#include <iostream>

using namespace std;

void main() {	
	Rational r1(1,3);
	Rational r2(1,4);
	Rational r3(2,4);
	Rational r4(1,7);
	Rational r5(1,8);
	Rational r6;
	Rational r7(2);

	cout << "Insertion Stream test: " << r2 << endl;

	cout << "Parameterless Operator Test: " << r6 << endl;

	cout << "Single Parameter Test: " << r7 << endl;
	
	cout << "r7.getNumerator() = " << r7.getNumerator() << endl;

	cout << "r2.getDenominator() = " << r2.getDenominator() << endl;

	// Evaluate and display
	cout << "\tOperator+() Test" << endl;
	r5 = r1 + r2;
	cout << r5 << " = " << r1 << " + " << r2 << endl;

	cout << "\tOperator-() Test" << endl;
	r5 = r1 - r2;
	cout << r5 << " = " << r1 << " - " << r2 << endl;

	cout << "\tOperator*() Test" << endl;
	r5 = r1 * r2;
	cout << r5 << " = " << r1 << " * " << r2 << endl;

	cout << "\tOperator/() Test" << endl;
	r5 = r1 / r2;
	cout << r5 << " = " << r1 << " / " << r2 << endl;

	//Increment and Decrement
	cout << "Before Post-Inc " << r1;
	r1 = r1++;
	cout << " After Post-Inc " << r1 << endl;

	cout << "Before Pre-Inc " << r2;
	r2 = ++r2;
	cout << " After Pre-Inc " << r2 << endl;

	cout << "Before Post-Dec " << r3;
	r3 = r3--;
	cout << " After Post-Dec " << r3 << endl;

	cout << "Before Pre-Dec " << r4;
	r4 = --r4;
	cout << " After Pre-Dec " << r4 << endl;

	cout << "There are " << Rational::numberOfRational << " rationals created." << endl;
	
	system("pause");
	}