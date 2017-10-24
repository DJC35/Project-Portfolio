#include <ostream>
#include <iomanip>

using namespace std;
#ifndef RECTANGLE_H
#define RECTANGLE_H

/*
 * Rectangle creates a rectangle according to length and width
 * also giving the area and perimeter of the rectangle
 * using given fields length, and width
 *
 * @author Dylan Connor
 */
class Rectangle {
private:
	double length;
	double width;

public:
	static int numberOfRectangles;

	/*
	 * Constructor for the rectangle object using values length and width
	 *
	 * @param length - the length value
	 * @param width - the width value
	 */
	Rectangle(double length = 0, double width = 0);

	//Copy Constructor
	Rectangle(const Rectangle& rectangle);

	//Destructor
	~Rectangle();

	/*
	 * Mutator to set length to the parameter's value
	 *
	 * @param length - the value of the rectangle's length
	 */
	void setLength(double length);

	/*
	 * Mutator to set width to the parameter's value
	 *
	 * @param width - the value of the rectangle's width
	 */
	void setWidth(double width);

	/*
	 * Accessor for the length value
	 *
	 * @return the value of length in the rectangle
	 */
	double getLength() const;

	/*
	 * Accessor for the width value
	 *
	 * @return the value of width in the rectangle
	 */
	double getWidth() const;

	/*
	 * Calculates the area of a rectangle
	 * using the formula area = length * width
	 *
	 * @return the area value of a rectangle
	 */
	double area() const;

	/*
	 * Calculates the perimeter of a rectangle
	 * using the formula perimeter = 2 * (length + width)
	 *
	 * @return the perimeter value of a rectangle
	 */
	double perimeter() const;

	/*
	 * Adds 2 Rectangles and returns their sum
	 *
	 * @param rhs - the rectangle on the right side of the addition operator
	 *
	 * @return the sum of the 2 rectangles
	 */
	Rectangle& operator+(const Rectangle& rhs);

	/*
	 * Adds a Rectangle and a value, then returns their sum
	 *
	 * @param value - the value on the right side of the addition operator
	 *
	 * @return the sum of the rectangle and value
	 */
	Rectangle& operator+(const int value);

	/*
	 * Subtracts 2 Rectangles and returns their difference
	 *
	 * @param rhs - the rectangle on the right side of the subtraction operator
	 *
	 * @return the difference of the 2 rectangles
	 */
	Rectangle& operator-(const Rectangle& rhs);
	
	/*
	 * Subtracts a Rectangle and a value, then returns their difference
	 *
	 * @param value - the value on the right side of the subtraction operator
	 *
	 * @return the difference of the rectangle and value
	 */
	Rectangle& operator-(const int value);

	//Increment - Decrement
	/* Pre
	 * Increments the length and width values of a rectangle
	 * and returns the result
	 *
	 * @return the incremented length and width values
	 */
	Rectangle& operator++();

	/* Post
	 * Increments the length and width values of a rectangle
	 * and returns the result
	 * 
	 * @return the incremented length and width values
	 */
	Rectangle& operator++(int value);

	/* Pre
	 * Decrements the length and width values of a rectangle
	 * and returns the result
	 *
	 * @return the decremented length and width values
	 */
	Rectangle& operator--();

	/* Post
	 * Decrements the length and width values of a rectangle
	 * and returns the result
	 *
	 * @return the decremented length and width values
	 */
	Rectangle& operator--(int value);

	/*
	 * Compares 2 Rectangles to each other
	 *
	 * returns true if both area values are the same
	 * else returns false
	 */
	bool operator==(const Rectangle& rhs);

	/*
	 * Compares 2 Rectangles to each other
	 *
	 * returns true if area values are not the same
	 * else returns false
	 */
	bool operator!=(const Rectangle& rhs);
	
	/*
	 * Compares 2 Rectangles to each other
	 *
	 * returns true if the invoker's area is less than or equal to the right hand side's area
	 * else returns false
	 */
	bool operator<=(const Rectangle& rhs);
	
	/*
	 * Compares 2 Rectangles to each other
	 *
	 * returns true if invoker's area is less than the right hand side's area
	 * else returns false
	 */
	bool operator<(const Rectangle& rhs);
	
	/*
	 * Compares 2 Rectangles to each other
	 *
	 * returns true if invoker's area is greater than or equal to the right hand side's area
	 * else returns false
	 */
	bool operator>=(const Rectangle& rhs);
	
	/*
	 * Compares 2 Rectangles to each other
	 *
	 * returns true if invoker's area is greater than the right hand side's area
	 * else returns false
	 */
	bool operator>(const Rectangle& rhs);

	/*
	 * Specifies how and what to insert into the stream
	 *
	 * @param stream os - stream we will insert into
	 * @param object rectangle - object to be inserted into the stream
	 *
	 * @return the stream allowing chaining
	 */
	friend ostream& operator<< (ostream& os, const Rectangle& rectangle)
	{
		os << "Length: " << setw(3) << setfill('0') << rectangle.getLength() 
		   << " Width: " << setw(3) << setfill('0') << rectangle.getWidth() 
		   << " Area: " << setw(3) << setfill('0') << rectangle.area() 
		   << " Perimeter: " << setw(3) << setfill('0') << rectangle.perimeter();
		return os;
	}
};

#endif