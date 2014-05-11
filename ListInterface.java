package josephus;

/**
 ******************************************************************************
 *                    HOMEWORK, 15-121
 ******************************************************************************
 *                    The Josephus Game
 ******************************************************************************
 *
 * The basic List interface
 *
 *
 *****************************************************************************
 *
 *          DO NOT CHANGE ANYTHING IN THIS CLASS
 *****************************************************************************/

import java.util.*;

public interface ListInterface
{
  /*
	* Destroys the current list
	*/
	public void clear();

  /*
	* Returns the size of the list
	*/
	public int size();

  /*
	* Returns the list as a String
	*/
	public String toString();

  /*
	* Returns true if value is contained in the list
	*/
	public boolean contains(int value);

  /*
	* Returns true is the list is empty
	*/
	public boolean isEmpty();

  /*
	* Returns the value stored in the current node
	*/
	public int getData();

  /*
	* Removes and returns the node at specified index n.
	* An integer index could positive as well as negative..
	* In case of error, it throws an exception.
	*/
	public int removeAt(int n) throws NoSuchElementException;
}