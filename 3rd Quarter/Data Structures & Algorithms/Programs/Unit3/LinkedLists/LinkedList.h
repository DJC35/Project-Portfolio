#include <iostream>
#include <stdlib.h>

using namespace std;

#ifndef LINKED_LIST_H
#define LINKED_LIST_H

/* Demonstrates the use of LinkedLists as containers
 *
 * @author Dylan Connor
 */
template<class T>
class LinkedList
{

public:
	/* Data container. IT has two fields:
	 *		1) data to be stored int the LinkedList container
	 *		2) pointer to the next link if it exists else NULL
	 */
	struct Link
	{
		T data;
		Link* pNext;

		Link(T value, Link* pointer)//:data(value),pNext(pointer) 
									//This is an initializer list (only works for Constructors)
									//and it does the same thing as the code below
		{
			data = value;
			pNext = pointer;
		}
	};
private:
	Link* head;
	Link* tail;

public:

	/* Constructor for a LinkedList object
	 * Creates a container and initializes the head and tail to NULL
	 * Signifying and empty list
	 */
	LinkedList()
	{
		this->head = NULL;
		this->tail = NULL;
	}

	bool addToTail(T value)
	{
		//Check to see if list is empty
		if (isEmpty())
		{
			//  1) create a new link
			//  2) assign head and tail pointer to the link's address
		
			head = tail = new Link(value,NULL);//Assignments can be chained together
		}
		else 
		{
			//  1) Create a new link
			//  2) assign pNext of the last link to the new link's address
			//  3) assign tail to the new links address also

			tail = tail->pNext = new Link(value, NULL);
		}
		return true;
	}

	bool addToHead(T value)
	{
		if (isEmpty())
		{
			head = tail = new Link(value, NULL);
		}
		else
		{
			head = new Link(value, head);
		}
		return true;
	}

	/* Determine if the LinkedList is empty
	 *
	 * return true if empty, else false
	 */
	bool isEmpty() { return (head == NULL && tail == NULL) ? true : false; }

	//Print out Linked List
	void dump()
	{
		//create a temporary pointer to iterate through the list
		Link* pWorking = head;

		while (pWorking != NULL)
		{
			cout << pWorking << "->" << pWorking->data << endl;

			//Advancing the pointer
			pWorking = pWorking->pNext;
		}
		cout << endl;
	}

	//Add to a specific position in List
	bool insertAt(int position, T value)
	{
		//create temporary pointer to iterate through the list
		Link* pWorking = head;

		if (position <= 1)
		{
			addToHead(value);
			return true;
		}
		else {
			//walk out to desired position in list
			for (int i = 1; i < position - 1; ++i)
			{
				pWorking = pWorking->pNext;
				if (pWorking->pNext == NULL)
				{
					addToTail(value);
					return true;
				}
			}

			//insert new link at the given position
			pWorking->pNext = new Link(value, pWorking->pNext);
			return true;
		}
	}

	//Remove from head of List
	bool deleteHead()
	{
		if (isEmpty() == true)//Check if the list is empty
			return false;

		Link* pWorking = head;

		head = pWorking->pNext;
		delete pWorking;

		if (head == NULL)
			tail = head;

		return true;
	}

	//Remove from head of List
	bool deleteTail()
	{
		if (isEmpty() == true)//Check if the list is empty
			return false;

		Link* pWorking = head;

		while (pWorking->pNext != tail)
		{
			pWorking = pWorking->pNext;
		}
		tail = pWorking;

		pWorking = pWorking->pNext;

		tail->pNext = NULL;

		if (head == NULL)
		{	
			tail = head;
			return false;
		}
		else
			delete pWorking;

		return true;
	}

	//Remove from given position in list - Bugged, doesn't remove from middle
	void deleteAt(int position)
	{
		Link* pWorking = head;

		if (position <= 1) {
			deleteHead();
		}
		else {
			for (int i = 1; i < position - 1; ++i)
			{
				pWorking = pWorking->pNext;

				if (pWorking->pNext == NULL) {
					deleteTail();
				}
			}
			head->pNext = pWorking->pNext;
			delete pWorking;
		}
	}
	
	//search for a link with a specific value
	Link* search(T value)
	{
		Link* pWorking = head;
		
		while (pWorking->pNext != NULL)
		{
			if (pWorking->data == value)
			{
				return pWorking;
			}
			pWorking = pWorking->pNext;
		}
		return NULL;
	}
};
#endif