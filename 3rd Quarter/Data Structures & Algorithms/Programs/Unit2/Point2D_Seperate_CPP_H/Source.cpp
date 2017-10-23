#include <iostream>
#include "Point2D.h"

using namespace std;

int square(int x) {return x * x;}

/*
 * Demonstrates the use of classes in C++
 *
 * @author Dylan Connor
 */
void main()
{   
	
	Point2D p1;
	Point2D p2(7, 8);
	Point2D p3(9, 10);
	Point2D p4;

	cout << "We have " << Point2D::count << " created" << endl;

	p1 = p2 + p3; 
	p4 = p3 - p2;
	
	cout << p1 << endl;
	cout << p2 << endl;
	cout << p3 << endl;
	cout << p4 << endl;

	system("pause");
}