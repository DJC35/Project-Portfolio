#include <iostream>
#include "Queue.h"

using namespace std;

void main()
{
	Queue *queueLine = new Queue();
	
	cout << "Simple Queue Demonstration\n";
	cout << "(Queue implemented as an Array - Queue data type is character.)\n\n";
	cout << "Creating a queue\n";

	queueLine->*in(1);
	cout << "First in queue: " << queueLine->*out() << endl;

	cout << "Testing adding to queue." << endl;
	for (int i = 0; i < 5; ++i)
	{
		queueLine->*in(i);
	}
	system("pause");

	cout << "Testing popping off queue." << endl;
	for (int i = 0; i < 5; ++i)
	{
		cout << "queueLine[" << i << "] = " << queueLine->*out() << endl;
	}
	system("pause");

	cout << "Testing how both run at same time." << endl;
	for (int i = 0; i < 10; ++i)
	{
		queueLine->*in(i);
		cout << "queueLine[" << i << "] = " << queueLine->*out() << endl;
	}
	system("pause");
}