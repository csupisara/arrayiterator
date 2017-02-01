package ku.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Ignore the null in the array, find only non-null elements.
 * @author supisara
 * @param <T> the type of elements in this iterator.
 */
public class ArrayIterator<T> implements Iterator<T>  {
	/** attribute for the array we want to iterate over */
	private T[ ] array;
	private int cursor;
	private T arrayElement;

	/**
	 * Initialize a new array iterator with the array to process.
	 * @param array is the array to iterate over
	 */
	public ArrayIterator(T[] array) { 
		this.array = array;
		this.cursor = 0;
		this.arrayElement = null;
	}

	/**
	 * Return the next non-null element from array, if any.
	 * @return the next non-null element in the array.
	 * @throws NoSuchElementException if there are no more elements
	 *        to return.
	 */
	public T next() {
		if (hasNext()){
			this.cursor++;
			this.arrayElement = array[cursor-1];			
			return this.arrayElement;
		}
		throw new NoSuchElementException();
	}

	/**
	 * Decide if there is another element available and move the cursor to the start of the next (non-null) element.  
	 *  @return true if another non-null array element, false if no more elements.
	 */
	@Override
	public boolean hasNext() {
		for (int i = this.cursor ; i < this.array.length ; i++){
			if (array[i] != null){
				this.cursor = i;
				return true;
			}
		}
		return false;
	}

	/**
	 * Remove most recent element returned by next() from the array by setting it to null.
	 *  @throws IllegalStateException if it was called without calling next(). or called more than once after calling next().
	 */
	public void remove(){
		if(this.arrayElement == null){
			throw new IllegalStateException();
		}

		if(this.arrayElement != null){
			this.arrayElement = null;
		}
	}	
}
