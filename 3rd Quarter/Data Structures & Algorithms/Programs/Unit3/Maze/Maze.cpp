#include <iostream>
#include <fstream>
#include <string>

#include "Stack.h"
#include "Point2D.h"

using namespace std;

/*
 * Prints out the maze's different points
 * param maze - the maze container
 */
void dump(char maze[10][10])
{
	for (int i = 0; i < 10; ++i)
	{
		for (int j = 0; j < 10; ++j)
		{
			cout << maze[i][j];
		}
		cout << endl;
	}
}

/*
 * Moves the "player" to another point in the maze below the previous point
 * param maze - the maze container
 * param currentPoint - the position of the "player"
 */
void moveDown(char maze[10][10], Point2D& currentPosition)
{
	maze[currentPosition.getX()][currentPosition.getY()] = '.';
	maze[currentPosition.getX()][currentPosition.getY() + 1] = 'V';
	currentPosition.setY(currentPosition.getY() + 1);
}

/*
 * Moves the "player" to another point in the maze to the left of the previous point
 * param maze - the maze container
 * param currentPoint - the position of the "player"
 */
void moveLeft(char maze[10][10], Point2D& currentPosition)
{
	maze[currentPosition.getX()][currentPosition.getY()] = '.';
	maze[currentPosition.getX() - 1][currentPosition.getY()] = '<';
	currentPosition.setX(currentPosition.getX() - 1);
}

/*
 * Moves the "player" to another point in the maze to the right of the previous point
 * param maze - the maze container
 * param currentPoint - the position of the "player"
 */
void moveRight(char maze[10][10], Point2D& currentPosition)
{
	maze[currentPosition.getX()][currentPosition.getY()] = '.';
	maze[currentPosition.getX() + 1][currentPosition.getY()] = '>';
	currentPosition.setX(currentPosition.getX() + 1);
}

/*
 * Moves the "player" to another point in the maze above the previous point
 * param maze - the maze container
 * param currentPoint - the position of the "player"
 */
void moveUp(char maze[10][10], Point2D& currentPosition)
{
	maze[currentPosition.getX()][currentPosition.getY()] = '.';
	maze[currentPosition.getX()][currentPosition.getY() - 1] = '^';
	currentPosition.setY(currentPosition.getY() - 1);
}

/*
 * checks to see if the "player" can move down
 * param maze - the maze container
 * param currentPoint - the position of the "player"
 */
bool canMoveDown(char maze[10][10], Point2D& currentPosition)
{
if (maze[currentPosition.getX()][currentPosition.getY() + 1] == '_')
	{
		return true;
	}
	else
	{
		maze[currentPosition.getX()][currentPosition.getY()] = '<';
		return false;
	}
}

/*
 * checks to see if the "player" can move left
 * param maze - the maze container
 * param currentPoint - the position of the "player"
 */
bool canMoveLeft(char maze[10][10], Point2D& currentPosition)
{
	if (maze[currentPosition.getX() - 1][currentPosition.getY()] == '_')
	{
		return true;
	}
	else
	{
		maze[currentPosition.getX()][currentPosition.getY()] = '>';
		return false;
	}
}

/*
 * checks to see if the "player" can move right
 * param maze - the maze container
 * param currentPoint - the position of the "player"
 */
bool canMoveRight(char maze[10][10], Point2D& currentPosition)
{
	if (maze[currentPosition.getX() + 1][currentPosition.getY()] == '_')
	{
		return true;
	}
	else
	{
		maze[currentPosition.getX()][currentPosition.getY()] = '^';
		return false;
	}
}

/*
 * checks to see if the "player" can move up
 * param maze - the maze container
 * param currentPoint - the position of the "player"
 */
bool canMoveUp(char maze[10][10], Point2D& currentPosition)
{
	if (maze[currentPosition.getX()][currentPosition.getY() - 1] == '_')
	{
		return true;
	}
	else
	{
		return false;
	}
}

/*
 * checks to see if the "player" can move at all
 * param maze - the maze container
 * param currentPoint - the position of the "player"
 */
bool canMove(char maze[10][10], Point2D& currentPosition)
{
	//Move down
	if (canMoveDown(maze, currentPosition) == true)
	{
		moveDown(maze, currentPosition);
		return true;
	}
	//Move Left
	else if (canMoveLeft(maze, currentPosition) == true)
	{
		moveLeft(maze, currentPosition);
		return true;
	}
	//Move Right
	else if (canMoveRight(maze, currentPosition) == true)
	{
		moveRight(maze, currentPosition);
		return true;
	}
	//Move Up
	else if (canMoveUp(maze, currentPosition) == true)
	{
		moveUp(maze, currentPosition);
		return true;
	}
	else
	{
		cout << "Stuck!" << endl;
		return false;
	}
}

/* Reads a maze from a text file and runs a "player" through it
 *
 * @author Dylan Connor
 */
void main(int argc, char** argv)
{
	char maze[10][10];
	string mazeLine;
	Stack<Point2D> mazeHistory(25);

	Point2D startPoint(0,1);
	mazeHistory.push(startPoint);

	Point2D currentPosition = startPoint;
	Point2D endPoint(9,10);

	// Test is there are two arguments (Program name,File name)
	if (argc != 2) {
		cerr << "Usage: " << argv[0] << " data-file" << endl;
		system("pause");
	}

	// open the file
	ifstream inputFileStream(argv[1]);

	// if file is unable to open
	if (!inputFileStream) {
		cerr << "Could not open the text file!" << endl;
		system("pause");
	}
	int count = 0;

	// read in the data and add it to the hash table
	while (!inputFileStream.eof()) {
		while (count < 10)
		{
			getline(inputFileStream, mazeLine);
			for (int j = 0; j < 10; ++j)
			{
				maze[count][j] = mazeLine[j];
			}
			++count;
		}
	}
	
	// close the file
	inputFileStream.close();

	//print maze
	maze[currentPosition.getX()][currentPosition.getY()] = 'V';
	dump(maze);
	system("pause");

	while ((currentPosition.getX() != endPoint.getX()) && (currentPosition.getY() != endPoint.getY()))
	{
		if (canMove(maze,currentPosition) == false)
		{
			maze[currentPosition.getX()][currentPosition.getY()] = '.';
			mazeHistory.pop();
			currentPosition = mazeHistory.peek();
			
			maze[currentPosition.getX()][currentPosition.getY()] = 'V';
			dump(maze);
		}
		else if(canMove(maze, currentPosition) == true)
		{
			canMove(maze, currentPosition);
			dump(maze);
			mazeHistory.push(currentPosition);
		}
		else if ((currentPosition.getX()== startPoint.getX())&&(currentPosition.getY() == startPoint.getY()))
		{
			dump(maze);
			cout << "Maze is impossible!" << endl;
		}
		system("pause");
	}
	dump(maze);
	cout << "Congrats, You beat the maze!" << endl;
	system("pause");
}