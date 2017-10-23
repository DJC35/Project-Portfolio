/*
 * Unit 3 Student starter project
 * 
 * To complete this quiz you must code the following 2 member functions 
 * of the LinkedList class.
 *
 *		1) ~LinkedList(): Destructor function. When called, it should delete 
 *						  every link contained in the list.
 *		2) LinkedList<T>* findAll(T target): This function returns a LinkedList<T>
 *						  containing a copy of all of the occurances of 'target'
 *						  For example, if the orginal LinkedList<T> contained the 
 *						  word 'pizza' 3 times, this function would return a LinkedList<T>
 *						  containing 3 links, each containing the word 'pizza'
 *
 *						  NOTE: see the 'White Board' for the expected output.
 */


#include <iostream>
#include <string>
#include <fstream>
#include <cstdlib>

#include "LinkedList.h"

using namespace std;

int main(int argc, char** argv) {

	string word;
	string target;

	LinkedList<string> linkedList;

	// opens the file
	ifstream inputFileStream(argv[1]);

	if (!inputFileStream) {
		cerr << "Could not open the text file!" << endl;
		system("pause");
		return EXIT_FAILURE;
	}

	// read in the data and ad it to the hash table
	while (inputFileStream >> word) {
		linkedList.addToHead(word);
	}

	// sanity test
	linkedList.dump();
	system("pause");

	// search for all occurances of 'IAN'
	cout << endl << endl;
	target = "IAN";

	// go and look for 'IAN'
	LinkedList<string>* resultsOfFindAll = linkedList.findAll(target);

	if (resultsOfFindAll->isEmpty())
		cout << target << " does not appear in the list, sorry" << endl;
	else {
		cout << "There should be 3 IAN's" << endl;
		resultsOfFindAll->dump();
	}

	// Search for all occurances of 'JOHN'
	cout << endl << endl;
	target = "JOHN";

	// go and look for 'JOHN'
	resultsOfFindAll = linkedList.findAll(target);

	if (resultsOfFindAll->isEmpty())
		cout << target << " does not appear in the list, sorry" << endl;
	else {
		cout << "There should be 4 JOHN'S's" << endl;
		resultsOfFindAll->dump();
	}

	// tests the destructor
	cout << endl << endl;
	delete resultsOfFindAll;
	cout << endl << endl;
	system("pause");
}