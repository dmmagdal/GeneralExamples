
class List {
	private Node front;								// reference to the front of the list
	private Node back;								// reference to the back of the list
	private Node cursor;							// reference to the cursor that traverses list 
	private int numItems;							// number of items contained in the list
	private int index;								// the index where the cursor is in the list (starts at 0, but is -1 if the cursor is undefined)

	// List constructor
	public List(){
		front = null;								// front, back, and cursor are all set to null
		back = front;		
		cursor = front;
		index = -1;									// index is -1 when cursor is undefined 
		numItems = 0;								// there are 0 items in the list
	}


	// Access functions


	/** shows how many items are in the list 
	@param takes no arguments
	@return returns the number of items in the list **/
	public int length(){
		return numItems;
	}

	/** shows where the cursor is at in the list by giving the cursor's index 
	@param takes no arguments
	@return returns the index of the cursor **/
	public int index(){
		return index;
	}

	/** returns the cursor element
	@param takes no arguments
	@return returns the data stored at the cursor **/
	public Object get(){
		if (isEmpty() || index < 0){				// if the list is empty or the index is less than 0
			// throw new UndefinedCursorException();	// throw the exception
			return null;							// comment out above line. Return Null for call in Matrix.java line 111 "while (row[i].get() != null){"
		}
		else{										// otherwise, return cursor's data
			return cursor.data;
		}
	}

	/** returns the front element
	@param takes no arguments
	@return returns the data stored at the front **/
	public Object front(){
		return front.data;
	}

	/** returns the back element
	@param takes no arguments
	@return returns the data stored at the back **/
	public Object back(){
		return back.data;
	}

	/** returns true iff List and L are exactly the same integer sequence
	@param takes the argument of List l
	@return true if the lists are the same, false otherwise**/
	public boolean equals(Object x){
		boolean result;
		if (x instanceof List){
			List l = (List) x;
			result = true;							// boolean value to store if the lists are equal or not
			moveFront();							// move the respective cursors to the front of the lists
			l.moveFront();
			if (length() != l.length()){			// if the length of the two lists are not the same, equal is false
				result = false;
			}
			else{									// otherwise, traverse both lists
				while (cursor != null && result == true){// while the cursor traverses the list
					if (!get().equals(l.get())){	// if at any point the data of the two doesn't match
						result = false;				// equal is false
					}
					moveNext();						// increment both nodes through their respective lists
					l.moveNext();
				}
			}
			cursor = null;							// clear the cursor of this list and its index
			index = -1;
		}
		else{
			result = false;
		}
		return result;
	}


	// Manipulation functions


	/** clears out the List
	@param takes no arguments
	@return returns nothing **/
	public void clear(){
		while (!isEmpty()){
			deleteFront();
		}
	}

	/** if the list is not empty, place the cursor to the front element, otherwise do nothing 
	@param takes no arguments 
	@return returns nothing **/
	public void moveFront(){
		if (!isEmpty()){
			cursor = front;
			index = 0;
		}
	}

	/** if the list is not empty, place the cursor to the back element, otherwise do nothing 
	@param takes no arguments 
	@return returns nothing **/
	public void moveBack(){
		if (!isEmpty()){
			cursor = back;
			index = length()-1;
		}
	}

	/** if the cursor is defined and not at the front, place the cursor one step closer to the front of the list.
	if the cursor is defined and at the front, the cursor becomes undefined. if the cursor is undifined, do nothing 
	@param takes no arguments 
	@return returns nothing **/
	public void movePrev(){
		if (cursor != null && !cursor.equals(front)){
			cursor = cursor.prev;
			index--;
		}
		else if (cursor != null && cursor.equals(front)){
			cursor = null;
			index = -1;
		}
		// else the cursor is undefined (cursor = null)
	}

	/** if the cursor is defined and not at the back, place the cursor one step closer to the back of the list.
	if the cursor is defined and at the back, the cursor becomes undefined. if the cursor is undifined, do nothing 
	@param takes no arguments 
	@return returns nothing **/
	public void moveNext(){
		if (cursor != null && !cursor.equals(back)){
			cursor = cursor.next;
			index++;
		}
		else if (cursor != null && cursor.equals(back)){
			cursor = null;
			index = -1;
		}
		// else the cursor is undefined (cursor = null)
	}

	/** insert new element into the list. if the list is not empty, the insertion takes place at the front of the list
	@param takes an int that serves as the data for the new node
	@return returns nothing **/
	public void prepend(Object data){
		Node n = new Node(data);
		if (!isEmpty()){							// if the list isn't empty, simply insert the new node at the front and set it as the new front
			front.setPrev(n);
			n.setNext(front);
			front = n;
		}		
		else{										// otherwise the list is empty, so do the same thing except also set the back to the new node
			n.setNext(front);
			front = n;
			back = n;
		}
		numItems++;									// increment the number of items
	}

	/** insert new element into the list. if the list is not empty, the insertion takes place at the back of the list
	@param takes an int that serves as the data for the new node
	@return returns nothing **/
	public void append(Object data){
		Node n = new Node(data);
		if (!isEmpty()){							// if the list isn't empty, simply insert the new node at the front and set it as the new front
			back.setNext(n);
			n.setPrev(back);
			back = n;
		}
		else{										// otherwise the list is empty, so do the same thing except also set the front to the new node
			n.setPrev(back);
			back = n;
			front = n;
		}
		numItems++;									// increment the number of items
	}

	/** insert new element before the cursor
	@param takes an int which is the new data for the element to be inserted
	@return returns nothing **/
	public void insertBefore(Object data){
		if (!isEmpty() && index >= 0){				// if the list isn't empty and the index is greater than zero
			Node n = new Node(data);				// inistialize the new node
			n.setPrev(cursor.prev);					// set the node's previous reference to the cursor's previous reference
			n.setNext(cursor);						// set the node's next reference to the cursor
			if (cursor.equals(front)){				// if the cursor is the front node
				front = n;							// set front to n
			}
			else{
				cursor.prev.setNext(n);				// set the next reference of the cursor's previous node to the new node
			}
			cursor.setPrev(n);						// set the cursor's previous reference to the new node
			index++;
			numItems++;								// increment the number of items
		}
	}

	/** insert new element after the cursor
	@param takes an int which is the new data for the element to be inserted
	@return returns nothing **/
	public void insertAfter(Object data){
		if (!isEmpty() && index >= 0){				// if the list isn't empty and the index is greater than zero
			Node n = new Node(data);				// inistialize the new node
			n.setNext(cursor.next);					// set the node's next reference to the cursor's next reference
			n.setPrev(cursor);						// set the node's previous reference to the cursor
			if (cursor.equals(back)){				// if the cursor is the back node
				back = n;							// set back to be n
			}
			else{
				cursor.next.setPrev(n);				// set the previous reference of the cursor's next node to the new node
			}
			cursor.setNext(n);						// set the cursor's next reference to the new node
			numItems++;								// increment the number of items
		}
	}

	/** deleted the front element
	@param takes no arguments
	@return returns nothing **/
	public void deleteFront(){
		if (!isEmpty()){							// if the list isn't empty
			if (front.getNext() == null){			// if the front is the only node in the list
				front = null;						// set front and back equal to null
				back = front;						
				cursor = null;						// clear the cursor and its index
				index = -1;
			}
			else{
				front = front.next;					// set the front to the next element and set the reference to the 
				front.setPrev(null);				// previous node to null
			}
			numItems--;								// decrement the number of items
		}
	}

	/** deleted the back element
	@param takes no arguments
	@return returns nothing **/
	public void deleteBack(){
		if (!isEmpty()){							// if the list isn't empty
			if (back.getPrev() == null){			// if the back is the only node in the list
				back = null;						// set back and front equal to null
				front = back;
				cursor = null;						// clear the cursor and its index
				index = -1;
			}
			else{
				back = back.prev;					// set the back to the previous element and set the reference to the 
				back.setNext(null);					// next node to null
			}
			numItems--;								// decrement the number of items
		}
	}

	/** delete the cursor element, making the cursor undefined
	@param takes nothing
	@return returns nothing **/
	public void delete(){
		if (!isEmpty() && index >= 0){				// if the list isn't empty and the index is greater than or equal to zero
			if (cursor.equals(front) && numItems > 1){	// if the cursor is at the front of the list and there is more than one item in the list
				front = front.next;				// move the front to the next item in the list
				front.setPrev(null);				// set the front's previous pointer to null 
			}
			else if (cursor.equals(front) && front.equals(back)){	// if the cursor is at the front and there is only one item in the list
				front = front.next;				// set the front/back = to null
				back = front;
			}
			else if (cursor.equals(back) && numItems > 1){	// if the ucursor is at the back of the list and there is more than one item in the list
				back = back.prev;					// move the back to the previous item in the list
				back.setNext(null);					// set the back's next pointer to null
			}
			else{									// otherwise the cursor is in the middle of the list
				cursor.prev.setNext(cursor.next);	// set the reference to the next node of the node previous to the crusor to the next node after the cursor
				cursor.next.setPrev(cursor.prev);	// set the reference to the previous node of the node next to the crusor to the previous node after the cursor
			}
			cursor = null;							// clear the cursor and the index
			index = -1;
			numItems--;								// decrement the number of items
		}
	}


	// Other functions


	/** overrides object's toString method. returns a string representation of this list consisting of a 
	space separated sequence of integers, with front on the left
	@param takes no arguments
	@return returns a string representation of the list **/
	public String toString(){
		String s = "";											// string to hold the list
		cursor = front;											// set the cursor to front
		while (cursor != null){									// while the cursor is not null
			s = s.concat(cursor.toString()+"\n");
			cursor = cursor.next;								// increment the cursor
		}
		cursor = null;											// clear the cursor and reset the index
		index = -1;
		return s;												// return the final string of the list
	}


	// Private functions


	/** tells if the list is empty or not 
	@param takes no argmuents
	@return returns true if the list is empty and false if it is not **/
	private boolean isEmpty(){
		boolean empty = false;						// initialize the boolean empty to false (assuming the list is not empty until proven otherwise (conditional below))
		if (front == null || numItems == 0){		// if the front is null or the number of elements equals zerp
			empty = true;							// empty equals true (the list is empty)
		}
		return empty;								// return the boolean
	}


	private class Node{
		private Object data;						// the data (Object) that is stored in the node
		private Node next;							// reference to the next node
		private Node prev;							// reference to the previous node

		// Node constructor
		private Node(Object entry){
			data = entry;
			next = null;
			prev = null;
		}

		/** retrieves the data stored in the node
		@param takes no arguments
		@return returns the data stored in the node **/
		private Object getData(){
			return data;
		}

		/** sets the data stored in the node
		@param takes the int argument which is the new data to be stored in the node
		@return returns nothing **/
		private void setData(Object newEntry){
			data = newEntry;
		}

		/** retrieves the reference to the next node
		@param takes no arguments
		@return returns the reference to the next node **/
		private Node getNext(){
			return next;
		}

		/** sets the reference to the next node
		@param takes the node argument which is the reference to the previous node
		@return returns nothing **/
		private void setNext(Node newNext){
			next = newNext;
		}

		/** retrieves the reference to the previous node
		@param takes no arguments
		@return returns the reference to the previous node **/
		private Node getPrev(){
			return prev;
		}

		/** sets the reference to the previous node
		@param takes the node argument which is the reference to the previous node
		@return returns nothing **/
		private void setPrev(Node newPrev){
			prev = newPrev;
		}

		/** returns a string of the data stored in the node
		@param takes no arguments
		@return returns a string of the data **/
		public String toString(){
			return data.toString();
		}

		/** returns a boolean of whether two nodes are equal
		@param takes in the argument of the data (Objcet x) in another node
		@return true if the object x and the data from this node are the same, falso otherwise **/
		public boolean equals(Object x){
			boolean equal = false;
			if (x instanceof Node){
				Node n = (Node)x;
				if (data.equals(n.data)){
					equal = true;
				}
			}
			return equal;
		}
	}
}
