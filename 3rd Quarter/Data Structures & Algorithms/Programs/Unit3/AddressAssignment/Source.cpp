#include <iostream>

using namespace std;

void main()
{
	int* x;
	int y = 5;

	x = &y;//Assigns x the address of y
	
	x++;
	if (*x == y++)
		cout << "True!" << endl;
	else
		cout << "False!" << endl;

	system("pause");
}