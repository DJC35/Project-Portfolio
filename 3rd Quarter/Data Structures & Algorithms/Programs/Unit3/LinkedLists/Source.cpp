#include <iostream>
#include "LinkedList.h"
#include "Rectangle.h"
#include <stdlib.h>
#include <ostream>

using namespace std;

int Rectangle::numberOfRectangles = 0;

void main()
{
	LinkedList<Rectangle> list;
	LinkedList<char> list2;
	LinkedList<char> list3;

	for (int i = 10; i < 50; i += 10)
	{
		list.addToHead(Rectangle(i/2, i + 3));
	}
	list.dump();

	list2.addToTail('E');
	list2.addToTail('B');
	list2.addToTail('c');
	list2.addToTail('V');
	list2.addToTail('A');
	
	list2.dump();
	system("pause");

	LinkedList<char>::Link* pList = list2.search('c');
	
	if (pList == NULL) 
	{
		cout << "Link with this value does not exist.\n\nValid List:" << endl;
		list2.dump();
	}
	else
	{
		list3.addToTail(pList->data);
		list3.dump();
	}
	system("pause");
}