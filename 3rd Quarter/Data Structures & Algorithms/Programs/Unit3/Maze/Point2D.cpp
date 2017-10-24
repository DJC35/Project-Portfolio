#include "Point2D.h"

int Point2D::count = 0;

Point2D::Point2D(int x, int y)
{
	this->x = x;
	this->y = y;
	count++;
}

Point2D::~Point2D() { count--; }

void Point2D::setX(int x) { this->x = x; }

void Point2D::setY(int y) { this->y = y; }

int Point2D::getX() const { return this->x; }

int Point2D::getY() const { return this->y; }

Point2D& Point2D::operator+(const Point2D rhs)const
{
	return Point2D(this->getX() + rhs.getX(),
		this->getY() + rhs.getY());
}

Point2D& Point2D::operator-(const Point2D rhs)const
{
	return Point2D(this->getX() - rhs.getX(),
		this->getY() - rhs.getY());
}