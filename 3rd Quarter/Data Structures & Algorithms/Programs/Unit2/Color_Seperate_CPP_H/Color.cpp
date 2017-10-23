#include "Color.h"

int Color::count = 0;

Color::Color(int red, int green, int blue)
{
	setRed(red);
	setGreen(green);
	setBlue(blue);
	count++;
}

Color::Color(const Color& color)
{
	setRed(color.getRed());
	setGreen(color.getGreen());
	setBlue(color.getBlue());
	count++;
}
Color::~Color() { count--; }

void Color::setRed(int red) { this->red = limitColorComponent(red); }

void Color::setGreen(int green) { this->green = limitColorComponent(green); }

void Color::setBlue(int blue) { this->blue = limitColorComponent(blue); }

int Color::getRed()const { return this->red; }

int Color::getGreen()const { return this->green; }

int Color::getBlue()const { return this->blue; }

Color& Color::operator+(const Color& rhs)
{
	this->setRed(this->getRed() + rhs.getRed());
	this->setGreen(this->getGreen() + rhs.getGreen());
	this->setBlue(this->getBlue() + rhs.getBlue());

	return *this;
}

Color& Color::operator+(int value)
{
	this->setRed(this->getRed() + value);
	this->setGreen(this->getGreen() + value);
	this->setBlue(this->getBlue() + value);

	return *this;
}

Color& Color::operator-(const Color& rhs)
{
	this->setRed(this->getRed() - rhs.getRed());
	this->setGreen(this->getGreen() - rhs.getGreen());
	this->setBlue(this->getBlue() - rhs.getBlue());

	return *this;
}

Color& Color::operator-(int value)
{
	this->setRed(this->getRed() - value);
	this->setGreen(this->getGreen() - value);
	this->setBlue(this->getBlue() - value);

	return *this;
}

Color& Color::operator++()
{
	this->setRed(this->getRed() + 1);
	this->setGreen(this->getGreen() + 1);
	this->setBlue(this->getBlue() + 1);

	return *this;
}

Color& Color::operator++(int value)
{
	this->setRed(this->getRed() + 1);
	this->setGreen(this->getGreen() + 1);
	this->setBlue(this->getBlue() + 1);

	return *this;
}

Color& Color::operator--()
{
	this->setRed(this->getRed() - 1);
	this->setGreen(this->getGreen() - 1);
	this->setBlue(this->getBlue() - 1);

	return *this;
}

Color& Color::operator--(int value)
{
	this->setRed(this->getRed() - 1);
	this->setGreen(this->getGreen() - 1);
	this->setBlue(this->getBlue() - 1);

	return *this;
}

bool Color::operator==(const Color& rhs)const
{
	return (this->getRed() == rhs.getRed()) &&
		(this->getGreen() == rhs.getGreen()) &&
		(this->getBlue() == rhs.getBlue());
}

int Color::limitColorComponent(int colorComponent)
{
	if (colorComponent > 255)
		return 255;
	if (colorComponent < 0)
		return 0;
	else
		return colorComponent;
}