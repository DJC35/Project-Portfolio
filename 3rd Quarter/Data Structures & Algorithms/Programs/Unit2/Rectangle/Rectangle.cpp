#include "Rectangle.h"

int Rectangle::numberOfRectangles = 0;

Rectangle::Rectangle(double length, double width)
{
	this->setLength(length);
	this->setWidth(width);
	++numberOfRectangles;
}

//Copy Constructor
Rectangle::Rectangle(const Rectangle& rectangle)
{
	this->setLength(rectangle.getLength());
	this->setWidth(rectangle.getWidth());
	++numberOfRectangles;
}

//Destructor
Rectangle::~Rectangle() { --numberOfRectangles; }

void Rectangle::setLength(double length) { this->length = length; }

void Rectangle::setWidth(double width) { this->width = width; }

double Rectangle::getLength() const { return this->length; }

double Rectangle::getWidth() const { return this->width; }

double Rectangle::area() const { return this->getLength()*this->getWidth(); }

double Rectangle::perimeter() const { return 2 * (this->getLength() + this->getWidth()); }

Rectangle& Rectangle::operator+(const Rectangle& rhs)
{
	return Rectangle(this->getLength() + rhs.getLength(),
					 this->getWidth() + rhs.getWidth());
}

Rectangle& Rectangle::operator+(const int value)
{
	return Rectangle(this->getLength() + value,
					 this->getWidth() + value);
}

Rectangle& Rectangle::operator-(const Rectangle& rhs)
{
	return Rectangle(this->getLength() - rhs.getLength(),
					 this->getWidth() - rhs.getWidth());
}

Rectangle& Rectangle::operator-(const int value)
{
	return Rectangle(this->getLength() - value,
					 this->getWidth() - value);
}

Rectangle& Rectangle::operator++()
{
	this->setLength(this->getLength() + 1);
	this->setWidth(this->getWidth() + 1);

	return *this;
}

Rectangle& Rectangle::operator++(int value)
{
	Rectangle temp(*this);

	this->setLength(this->getLength() + 1);
	this->setWidth(this->getWidth() + 1);

	return temp;
}

Rectangle& Rectangle::operator--()
{
	this->setLength(this->getLength() - 1);
	this->setWidth(this->getWidth() - 1);

	return *this;
}

Rectangle& Rectangle::operator--(int value)
{
	Rectangle temp(*this);

	this->setLength(this->getLength() - 1);
	this->setWidth(this->getWidth() - 1);

	return temp;
}

bool Rectangle::operator==(const Rectangle& rhs)
{
	return this->area() == rhs.area();
}

bool Rectangle::operator!=(const Rectangle& rhs)
{
	return this->area() != rhs.area();
}

bool Rectangle::operator<=(const Rectangle& rhs)
{
	return this->area() <= rhs.area();
}

bool Rectangle::operator<(const Rectangle& rhs)
{
	return this->area() < rhs.area();
}

bool Rectangle::operator>=(const Rectangle& rhs)
{
	return this->area() >= rhs.area();
}

bool Rectangle::operator>(const Rectangle& rhs)
{
	return this->area() > rhs.area();
}