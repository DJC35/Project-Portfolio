#include <iostream>;
#include <string>;
#include <iomanip>;

using namespace std;

/*
 * Shows different ways to format output using set precision,
 * scientific, set width, fixed, left justify, right jsutify, and more.
 * @author Dylan Connor
 */
void main()
{
	int x = 1234;
	float y = 56.78;

	//not formatted
	cout << "X=" << x << "Y=" << y << endl;

	//set width and x left, y right
	cout << setw(10) << left << "X=" << x;
	cout << setw(10) << right << "Y=" << y << endl;

	//x right, y left
	cout << setw(10) << right << "X=" << x;
	cout << setw(10) << left << "Y=" << y << endl;

	//using fill char
	cout << setfill('*');
	cout << setw(10) << right << "X=" << x;
	cout << setw(10) << left << "Y=" << y << endl;

	//repeat in scientific notation
	cout << scientific;
	cout << setw(15) << right << "X=" << x;
	cout << setw(15) << left << "Y=" << y << endl;

	//not scientific notation, uses decimals with 3 spaces to the right of point.
	cout<< fixed << showpoint << setprecision(3);
	cout << setw(10) << right << "X=" << x;
	cout << setw(10) << left << "Y=" << y << endl;

	system("pause");
}