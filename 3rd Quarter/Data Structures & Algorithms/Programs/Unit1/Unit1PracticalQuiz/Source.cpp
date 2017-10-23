#include <iostream>
#include <string>
#include <iomanip>
using namespace std;

// prototypes
void  input(string& employeeName, float& hoursWorkedPerWeek);
float calculatePay(float hoursWorkedPerWeek);
void display(string& employeesName, float netPay);

/*
 * Prompts user input for employee information, 
 * calculates netPay of an employee, and then displays the information.
 *
 * @author Dylan Connor
 */ 
void main() {
	// variable declarations
	string employeesName;
	float netPay;
	float hoursWorkedPerWeek;

	// your code goes here to…
	// INPUT
	input(employeesName, hoursWorkedPerWeek);
	// PROCESS
	netPay = calculatePay(hoursWorkedPerWeek);
	// OUTPUT
	display(employeesName, netPay);
	system("pause");
}
/*
 * Prompts user for employeesName and hoursWorkedPerWeek
 *
 * @param hoursWorkedPerWeek
 * @param employeeName
 */
void input(string& employeesName, float& hoursWorkedPerWeek)
{
	cout << "Enter employee name: ";
	cin >> employeesName;

	cout << "Enter hours worked this week: ";
	cin >> hoursWorkedPerWeek;
}
/*
 * Calculates netPay based on hoursWorkedPerWeek and returns the result
 *
 * @param hoursWorkedPerWeek
 * @return
 */
float calculatePay(float hoursWorkedPerWeek)
{
	float hourlyWage = 10.00;
	float result;
	float grossPay;
	float overtimePay;
	float overtimeHours;

	if (hoursWorkedPerWeek > 40)
	{
		overtimeHours = hoursWorkedPerWeek - 40;
		overtimePay = (0.5*hourlyWage)*overtimeHours;
		grossPay = hourlyWage * 40;
		result = grossPay + overtimePay;
	}
	else
	{
		grossPay = hourlyWage * hoursWorkedPerWeek;
		result = grossPay;
	}

	return result-(result*.25);
}
/*
 * Displays the given parameters as Employee Name netPay
 *
 * @param employeesName
 * @param netPay
 */
void display(string& employeesName, float netPay)
{
	cout << showpoint << fixed << setprecision(2) << setfill('#') << employeesName << " $" << setw(10) << netPay << endl;
}