#include <iostream>

using namespace std;

void dump(int* intArray)
{
	for (int i = 0; i < 10; ++i)
	{
		cout << "intArray[" << i << "] = " << intArray[i] << endl;
	}
	cout << endl;
}

int bubbleSort(int* intArray)
{
	int count = 0;
	int temp;
	//outer loop
	for (int i = 0; i < 10; ++i)
	{
		//inner loop
		for (int j = 0; j < 10 - 1; ++j)
		{
			++count;
			if (intArray[j] > intArray[j + 1])
			{
				//swap values
				temp = intArray[j];
				intArray[j] = intArray[j + 1];
				intArray[j + 1] = temp;
			}
		}
	}
	return count;
}

void main()
{
	int count = 0;
	int intArray[] = { 9,8,7,6,5,4,3,2,1,0 };
	cout << "Before Sort" << endl;
	dump(intArray);
	
	cout << "After Sort" << endl;
	count = bubbleSort(intArray);

	dump(intArray);

	cout << "Times sorted: " << count << endl;

	system("pause");
}