#include <iostream>

#ifndef QUEUE_H
#define QUEUE_H
using namespace std;

class Queue
{
private:
	int in;
	int out;
	int queue[5];

public:
	Queue()
	{
		in = out = -1;
	}

	int in(int input)
	{
		if (out - 5 == in)
		{
			return NULL;
		}

		out++;
		queue[out] = input;
	}

	int out()
	{
		int output;
		if(in == out)
		{
			return NULL;
		}
		else
		{
			out++;
			output = queue[out];
			return output;
		}
	}
};
#endif