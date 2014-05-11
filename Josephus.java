package josephus;

/**
 ******************************************************************************
 *                    HOMEWORK, 15-121
 ******************************************************************************
 *                    The Josephus Game
 ******************************************************************************
 *
 *  Solves the Josephus problem.
 *
 * Name:
 *
 *****************************************************************************/



public class Josephus
{

	/*
	* Solves the Josephus problem with the doubly circular LL
	* Returns the survivor's number
	* "size" is a list length
	* "rotation" is an elimination order
	*/
	public int josephusDCLL(int size, int rotation)
	{
		if(size <= 0){
			throw new IllegalArgumentException("Size of the list should be no less than 1.");
		}
		if(size == 1){
			return 1;
		}
		
		DoublyCircularLL dcll = new DoublyCircularLL(size);
		int cnt = size;
		while(cnt != 1){
			dcll.removeAt(rotation);
			//dcll.printDCLLInOrder();
			cnt--;
		}
		return dcll.head.data;
	}
}

