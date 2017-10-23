#include <iostream>
#include <string>
#include "Stack.h"

using namespace std;

void isEmptyTest(Stack<char>& stack)
{
	if (stack.isEmpty() == true)
		cout << "Stack is Empty" << endl;
	else
		cout << "Stack is NOT Empty" << endl;
}

void postFixConversion(char* algorithm)
{
	/* Operator Precendence
	 *	0-> empty stack
	 *	1-> Reserved for future use
	 *	2-> + -
	 *	3-> * /
	 *	4-> Unused
	 *	5-> Unused
	 */
	string inFix;
	int operatorPrecedence;
	int stackPrecedence = 0;
	Stack<char> stack(10);
	//Until Done loop
	for (int i = 0;; ++i)
		//Read char in array
		if ((algorithm[i] == '*') && (algorithm[i] == '/') && (algorithm[i] == '+') && (algorithm[i] == '-'))
		{
			stack.push(algorithm[i]);
			if (algorithm[i] == '*' || algorithm[i] == '/')
				operatorPrecedence = 3;
			if (algorithm[i] == '+' || algorithm[i] == '-')
				operatorPrecedence = 2;
		}
		else//if char is not + - * /, Add to string
		{
			
		}
		
		//Loop - if stack precedence >= operator precedence, move operator from stack to postfix string
			//determine precedence of operator on top of stack
		//else place operator on top of stack and change stack precendece to operator precedence
		//continue until no more characters in array
		//empty the stack and add to postfix string
		//END
}

void main()
{
	//Equation A+B*C+D/E
	char* equation = new char[9];

	equation[0] = 'A';
	equation[1] = '+';
	equation[2] = 'B';
	equation[3] = '*';
	equation[4] = 'C';
	equation[5] = '+';
	equation[6] = 'D';
	equation[7] = '/';
	equation[8] = 'E';

	postFixConversion(equation);

	system("pause");

}