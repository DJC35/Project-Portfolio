#include <ostream>

using namespace std;

#ifndef POINT_2D_H
#define POINT_2D_H

/*
 * Point2D models a point on a 2 dimensional plane
 * using the fields x and y
 *
 * @author Dylan Connor
 */
class Point2D
{
private:
	int x;
	int y;
	
public:

	static int count;

	/*
	 * Constructor for the Point2D allowing the user
	 * to pass 0, 1, or 2 parameters.
	 * if no parameters are given, both x and y are initialized to 0
	 * if 1 parameter is passed then x is assigned the given parameter and y initializes as 0
	 * if 2 parameters are passed then x is assigned the first, and y the second
	 */
	Point2D(int x = 0, int y = 0);
	
	~Point2D();

	/*
	 * Mutator to set the value of x to the user specified value
	 *
	 * @param integer x is the user specified value for field x
	 */
	void setX(int x);

	/*
	* Mutator to set the value of y to the user specified value
	*
	* @param integer y is the user specified value for field y
	*/
	void setY(int y);

	/*
	 * Accessor for the field x
	 *
	 * @return value of x
	 */
	int getX() const;

	/*
	 * Accessor for the field y
	 *
	 * @return value of y
	 */
	int getY() const;

	/*
	 * Adds 2 Point2Ds and returns their sum
	 *
	 * @param rhs - the point on the right side of the addition operator
	 *
	 * @return the sum of the 2 points
	 */
	Point2D& operator+(const Point2D rhs)const;

	/*
	 * Subtracts 2 Point2Ds and returns their difference
	 *
	 * @param rhs - the point on the right side of the addition operator
	 *
	 * @return the difference of the 2 points
	 */
	Point2D& operator-(const Point2D rhs)const;

	/*
	 * Specifies how and what to insert into the stream
	 * The key word friend specifies
     *  1) that the lhs and rhs do not have to be of the same data type
	 *  2) the function is a free function and not a class member
	 *  3) the function has access to the class fields regardless of
	 *     the access modifiers
	 *
	 * @param stream os - stream we will insert into
	 * @param object p - object to be inserted into the stream
	 *
	 * @return the stream allowing chaining
	 */
	friend ostream& operator<< (ostream& os, const Point2D& p)
	{
		os << "(" << p.getX() << ", " << p.getY() << ")";
		return os;
	}
	
};

#endif