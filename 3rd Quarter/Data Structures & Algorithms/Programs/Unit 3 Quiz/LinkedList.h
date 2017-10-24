/*
 * To complete this quiz you must code the following 2 member functions
 * of the LinkedList class.
 *
 *     1) ~LinkedList() : Destructor function.When called, it should delete
 *						  every link contained in the list.
 *     2) LinkedList<T>* findAll(T target) : This function returns a LinkedList<T>
 *						  containing a copy of all of the occurances of 'target'
 *						  For example, if the orginal LinkedList<T> contained the
 *						  word 'pizza' 3 times, this function would return a LinkedList<T>
 *						  containing 3 links, each containing the word 'pizza'
 *
 *						  NOTE : see the 'White Board' for the expected output.
 */

#include <stdlib.h>
#include <iostream>

using namespace std;

#ifndef _LINKED_LIST_
#define _LINKED_LIST_


/*
 * Creates a list of Links that contain two values:
 * 1)Data - a value given when a link is created
 *	  -is Templated
 * 2)pWorking - data that contains the next Link's memory address
 *
 * @author Dylan Connor
 */
template <class T>
class LinkedList {

public:

	/* Data container. It has 2 fields:
	 *		1) data to be stored in the LinkedList container
	 *		2) pointer to the next link if it exists else NULL
	 */
	struct Link {
		T data;
		Link* pNext;

		Link(T value, Link* pointer)  {
			data = value;
			pNext = pointer;
		}
	};

private:

	Link* head;
	Link* tail;

public:

	/*
	 * constructor, Creates a LinkedList container and 
	 * initializes the head and tail pointers to NULL
	 * signifying an empty list
	 */
	LinkedList() {
		this->head = NULL;
		this->tail = NULL;
	}

	/*
	 * Destructor, removes a LinkedList's Links from memory
	 * goes step by step from Head to Tail,
	 * and deletes each Link individually
	 */
	~LinkedList() {

		cout << "Beginning the  Destructor code" << endl;
		Link* pWorking = head;
		
		while (pWorking != NULL) {
			Link* pWorking2 = pWorking;
			pWorking = pWorking->pNext;
			delete pWorking2;
		}
		if (head == NULL)
			tail = NULL;
		
		cout << "Ending the  Destructor code" << endl;
	}

	bool addToTail(T value) {
	// is list empty
		if (isEmpty()) {
			//	1) create a new link
			//  2) assign the head and tail pointer to that Link's address
			head = new Link(value, NULL);
			tail = head;
		}
		else
			tail = tail->pNext = new Link(value, NULL);
		//  1) create a new link
		//  2) assign the last links pointer to that new link's address
		//  3) assign the tail to the new link's address also
		// create a new link
		// set 

		return true;
	}
	/*
	 * Determines if the LinkedList is empty or not
	 *
	 * returns true if it is empty else false
	 */
	bool isEmpty() { return (head == NULL && tail == NULL) ? true : false; }

	bool addToHead(T value) {

		if(isEmpty()) {
			head = tail = new Link( value, NULL);
			
		}
		else {
			head = new Link(value, head);
		}
		return true;
	}

	bool insertAt(int position, T value) {

		// are you inserting before the 1st position?
		if (position <= 1) {
			addToHead(value);
			return true;
		}

		Link* pWorking = head;

		// move the working pointer to the link just ahead of the desired position
		for (int i = 1; i < (position - 1); ++i) {
			pWorking = pWorking->pNext;

			// have you run out of links before arriving at the desired position?
			if (pWorking == NULL) {
				addToTail(value);
				return true;
			}
		}

		// ok, add it to the desired position
		pWorking->pNext = new Link(value, pWorking->pNext);
		return true;
	}

	bool deleteHead() {

		if (isEmpty())
			return false;

		Link* pWorking = head;

		head = pWorking->pNext;
		delete pWorking;

		if (head == NULL)
			tail = NULL;

		return true;
	}

	bool deleteTail() {

		if (isEmpty())
			return false;

		Link* pWorking = head;

		while (pWorking->pNext != tail)
			pWorking = pWorking->pNext;

		pWorking->pNext = NULL;
		delete tail;
		tail = pWorking;
		
		return true;
	}

	void dump() {

		// create a tempory pointer to iterate through the list
		Link* pWorking = head;

		while (pWorking != NULL) {
			cout << pWorking->data << ", ";
			
			// advance the pointer to the next link
			pWorking = pWorking->pNext;
		}
		cout << endl;
	}

	Link* search(T value) {
		
		Link* pWorking = head;

		while (pWorking != NULL) {
			if (pWorking->data == value)
				return pWorking;

			pWorking = pWorking->pNext;
		}
		return NULL;
	}

	/*
	 * Searches a LinkedList for a specific data value
	 * creates a new LinkedList to return the values that were found
	 *
	 * returns resultedLinkedList - a list composed of the targeted data values
	 */
	LinkedList<T>* findAll(T target) {
		
		LinkedList<T>* resultLinkedList = new LinkedList<T>();

		Link* pWorking = head;

		while (pWorking != NULL)
		{
			if (pWorking->data == target)
			{
				resultLinkedList->addToTail(pWorking->data);
			}
			pWorking = pWorking->pNext;
		}

		return resultLinkedList;
	}

	/*
	 * Extends the insertion stream operator to include LinkedLists
	 * Note: each data value is seperated by commas
	 *
	 * param os is the intended output stream
	 * param list is the LinkedList we intend to display
	 *
	 * returns a reference to the stream enabling chaining of items to 
	 *         insert into the output stream
	 */
	friend ostream& operator<<(ostream& os,  LinkedList const& list) {

		LinkedList::Link* pWorking = list.head;

		// test for an empty list
		if(pWorking != NULL)
			os << (*pWorking).data;

		while (pWorking != NULL) {
			os << ", " << (*pWorking).data;
			pWorking = (*pWorking).pNext;
		}

		return os;
	}
};

#endif