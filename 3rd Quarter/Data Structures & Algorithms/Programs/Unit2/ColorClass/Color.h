#include <ostream>
#include <iomanip>

#ifndef COLOR_H
#define COLOR_H
using namespace std;

/*
 * Color creates a color based on the RedGreenBlue style
 * with given fields red, green, and blue
 *
 * @author Dylan Connor
 */
class Color
{
private:
	int red;
	int green;
	int blue;

public:

	/*
	 * Constructor for the color object using RGB values
	 *
	 * @param red - the red color value
	 * @param green - the green color value
	 * @param blue - the blue color value
	 */
	Color(int red = 0, int green = 0, int blue = 0)
	{
		setRed(red);
		setGreen(green);
		setBlue(blue);
	}
	//Copy Constructor
	Color(const Color& color)
	{
		setRed(color.getRed());
		setGreen(color.getGreen());
		setBlue(color.getBlue());
	}
	~Color(){}

	/*
	 * Mutator to set red to the parameter's value
	 *
	 * @param red - the value of the shade of red
	 */
	void setRed(int red){this->red = limitColorComponent(red);}

	/*
	 * Mutator to set green to the parameter's value
	 *
	 * @param green - the value of the shade of green
	 */
	void setGreen(int green){this->green = limitColorComponent(green);}

	/*
	 * Mutator to set blue to the parameter's value
	 *
	 * @param blue - the value of the shade of blue
	 */
	void setBlue(int blue){this->blue = limitColorComponent(blue);}

	/*
	 * Accessor for the red value
	 *
	 * @return the value of red in the color
	 */
	int getRed()const{return this->red;}

	/*
	 * Accessor for the green value
	 *
	 * @return the value of green in the color
	 */
	int getGreen()const{return this->green;}

	/*
	 * Accessor for the blue value
	 *
	 * @return the value of blue in the color
	 */
	int getBlue()const{return this->blue;}

	/*
	 * Specifies how and what to insert into the stream
	 *
	 * @param stream os - stream we will insert into
	 * @param object color - object to be inserted into the stream
	 *
	 * @return the stream allowing chaining
	 */
	friend ostream& operator<< (ostream& os, const Color& color)
	{
		os << setw(3) << setfill('0') << color.getRed() << ":" << setw(3) << setfill('0') << color.getGreen() << ":" << setw(3) << setfill('0') << color.getBlue();
		return os;
	}

	/*
	 * Adds 2 Colors and returns their sum
	 *
	 * @param rhs - the color on the right side of the addition operator
	 *
	 * @return the sum of the 2 colors
	 */
	Color& operator+(const Color& rhs)
	{
		this->setRed(this->getRed() + rhs.getRed());
		this->setGreen(this->getGreen() + rhs.getGreen());
		this->setBlue(this->getBlue() + rhs.getBlue());

		return *this;
	}

	Color& operator+(int value)
	{
		this->setRed(this->getRed() + value);
		this->setGreen(this->getGreen() + value);
		this->setBlue(this->getBlue() + value);

		return *this;
	}

	/*
	 * Subtracts 2 Colors and returns their difference
	 *
	 * @param rhs - the color on the right side of the addition operator
	 *
	 * @return the difference of the 2 colors
	 */
	Color& operator-(const Color& rhs)
	{
		this->setRed(this->getRed() - rhs.getRed());
		this->setGreen(this->getGreen() - rhs.getGreen());
		this->setBlue(this->getBlue() - rhs.getBlue());

		return *this;
	}

	Color& operator-(int value)
	{
		this->setRed(this->getRed() - value);
		this->setGreen(this->getGreen() - value);
		this->setBlue(this->getBlue() - value);

		return *this;
	}

	/*
	 * Increments the red, green, and blue values of a color
	 * and returns the result
	 *
	 * @return the incremented color values
	 */
	Color& operator++()
	{
		this->setRed(this->getRed() + 1);
		this->setGreen(this->getGreen() + 1);
		this->setBlue(this->getBlue() + 1);

		return *this;
	}

	Color& operator++(int value)
	{
		this->setRed(this->getRed() + 1);
		this->setGreen(this->getGreen() + 1);
		this->setBlue(this->getBlue() + 1);

		return *this;
	}

	/*
	 * Decrements the red, green, and blue values of a color
	 * and returns the result
	 *
	 * @return the decremented color values
	 */
	Color& operator--()
	{
		this->setRed(this->getRed() - 1);
		this->setGreen(this->getGreen() - 1);
		this->setBlue(this->getBlue() - 1);

		return *this;
	}

	Color& operator--(int value)
	{
		this->setRed(this->getRed() - 1);
		this->setGreen(this->getGreen() - 1);
		this->setBlue(this->getBlue() - 1);

		return *this;
	}

	/*
	 * Compares 2 Colors' values to each other
	 *
	 * returns true if all values are the same
	 * else returns false
	 */
	bool operator==(const Color& rhs)const
	{
		return (this->getRed() == rhs.getRed()) &&
			   (this->getGreen() == rhs.getGreen()) &&
			   (this->getBlue() == rhs.getBlue());
	}

	int limitColorComponent(int colorComponent)
	{
		if (colorComponent > 255)
			return 255;
		if (colorComponent < 0)
			return 0;
		else
			return colorComponent;
	}
};
#endif