#include <iostream>
#include <cstdlib>

#include "CircularBuffer.h"

using namespace std;

void main() {

	int returnValue;			// utility variable
	int bufferCapacity = 7;		// capacity of the buffer

	// create a Queue capacity of 7
	CircularBuffer<int> buffer(bufferCapacity);


	// attempt to remove a value from an empty Queue
	returnValue = buffer.out();
		if (returnValue == NULL)
			cout << "Buffer is empty" << endl;
		else
			cout << returnValue << endl;

	// add 3 values. 1, 2, 3
		for (int i = 1; i <= 3; ++i)
			buffer.in(i);
	
	// take 2 of them out
	// this shoud take out the '1'
	returnValue = buffer.out();
	if (returnValue == NULL)
		cout << "Buffer is empty" << endl;
	else
		cout << returnValue << endl;

	// this should take out the '2'
	returnValue = buffer.out();
	if (returnValue == NULL)
		cout << "Buffer is empty" << endl;
	else
		cout << returnValue << endl;

	// add another value to the queue. The queue will now have 2 values 
	// which are a 3 and a 4
	buffer.in(4);


	// now lets try to remove 3 values from a queue that has only 2 values
	for (int i = 1; i <= 3; ++i) {

		returnValue = buffer.out();				// returnValue is either a valid value or a NULL
		if (returnValue == NULL)
			cout << "Buffer is empty" << endl;
		else
			cout << returnValue << endl;
	}
	system("pause");

	// try to overflow the buffer by pushing 10 values into it
	int x = 100;
	for (int i = 0; i < 10; ++i) {
		if (!buffer.in(x))
			cout << "Tried to push a " << x << "But the buffer is full" << endl;
		x += 100;
	}

	// now lets empty the Queue
	for (int i = 1; i < bufferCapacity; ++i) {

		returnValue = buffer.out();				// returnValue is either a valid value or a NULL
		if (returnValue == NULL)
			cout << "Buffer is empty" << endl;
		else
			cout << returnValue << endl;
	}

	cout << "Job Done" << endl;

	system("pause");
}