using namespace std;

#ifndef STACK_H
#define STACK_H
template<class T>
class Stack
{
private: 
	int index;
	T* container;
	int capacity;

public:
	Stack<T>(int capacity)
	{
		this->capacity = capacity;
		this->index = capacity - 1;

		container = new T[this->capacity];
	}

	~Stack<T>() { delete[] this->container; }

	void push(T c) { this->container[index--] = c; }

	T peek() { return container[this->index + 1]; }

	void pop() { this->index++; }

	bool isEmpty() { return(this->index == this->capacity - 1) ? true : false; }
};
#endif