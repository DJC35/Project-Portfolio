#include <iostream>
#include <string>
#include "LinkedList.h"
#include <stdlib.h>

using namespace std;

int Hash(const string& id)
{
	unsigned int hashCode = 0;
	for (unsigned int i = 0; i < id.length(); ++i)
	{
		hashCode += (id[i] * 2047);
	}
	return hashCode;
}

void main()
{
	string input;

	for (int i = 0; i < 10; ++i) {
		cout << "Input a string: ";
		cin >> input;

		cout << "String's hashcode = " << Hash(input) % 100 << endl;
	}
	system("pause");
}