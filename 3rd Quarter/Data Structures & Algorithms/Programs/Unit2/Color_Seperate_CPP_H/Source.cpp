#include <iostream>
#include "Color.h"

using namespace std;

/*
 * Creates multiple Color objects and tests formatting,
 * how they add together, subtract from eachother, increment,
 * decrement, and if one is the same as another
 *
 * @author Dylan Connor
 */
void main()
{
	Color c1;
	Color c2(1700, 203, 159);
	Color c3(144, 260,-4);

	cout << "We have " << Color::count << " created\n" << endl;

	Color c4;
	Color c5;
	Color c6;

	//c1-c3 are as declared above
	cout << "c1 = " << c1 << endl;
	cout << "c2 = " << c2 << endl;
	cout << "c3 = " << c3 << endl;
	
	c4 = c3 + c2;
	c5 = c4 - 20;

	//c4 adds two colors and c5 subtracts two colors
	cout << "c3 + c2 = " << c4 << endl;
	cout << "c4 - 20 = " << c5 << endl;

	c2 = --c2;
	c3 = ++c3;

	//c3 is incremented once and c2 is decremented once
	cout << "++c3 = " << c3 << endl;
	cout << "--c2 = " << c2 << endl;

	c6 = c3;
	//is c1 same as c2 and is c3 same as c6
	if (c1 == c2)
	{
		cout << "c1 == c2 : True" << endl;
	}
	else
	{
		cout << "c1 == c2 : False" << endl;
	}

	if (c3 == c6)
	{
		cout << "c3 == c6 : True" << endl;
	}
	else 
	{
		cout << "c3 == c6 : False" << endl;
	}
	cout << "\nWe have " << Color::count << " created" << endl;

	system("pause");
}