
public class Index {
	
	public static class DLL {

		public DLL Head = null;
		public DLL Tail;
		
		public DLL previous;
		public int value;
		public DLL next;
		public int count = 0;

		public void addFirst(int v) {
			//Storing the current head to a temporvary head so we can assign this to the next of newly added elemet

			DLL currentHead = Head;
			DLL newEle = new DLL();


			//This is the first element
			if(count == 0) {
				newEle.previous = null;
				newEle.value  = v;
				newEle.next = null;
				Head = Tail = newEle;
			
			}
			else {
				newEle.previous = null;
				newEle.next = currentHead;
				newEle.value = v;
				
				currentHead.previous = newEle;
				Head = newEle;
				
			}
			count++;
			

		}

		public void removeFirst() {
			if(count > 0) {
					DLL currentHead = Head;
					DLL newHead;
					//This means we have only one element
					if(count == 1) {
						Head = null;
						Tail = null;
					}

					else {
						//capturing the new head which is second element of linked 

						newHead = currentHead.next;

						//
						currentHead.next = null;
						currentHead.previous = null;

						newHead.previous = null;

						Head = newHead;

					}
					count--;

			}
		}

		/*
		*To remove the last node..
		*/

		public void removeLast() {
			if(count > 0) {
					if(count == 1) {
						//Only one node exists
						Head = null;
						Tail = null;
					}
					else  {

							DLL lastPrevEle = Tail.previous;

							lastPrevEle.next = null; 	
							Tail.previous = null;
							
							Tail = lastPrevEle;
					}

				count--;

				if(count == 1) {
					Head = Tail;
					Tail = null;
				}
			}

		}

		public void addLast(int v) {
			if(count > 0 ) {
				DLL lastPrevEle = Tail.previous;
				
				DLL newEle = new DLL();
					newEle.value = v;
					newEle.previous = Tail;
					newEle.next = null;
				
				Tail.next = newEle;	
				Tail = newEle;
				count++;
			}
			else {
				addFirst(v);
			}

		}


 	public void print() {
			DLL current = Head;
			while(current != null) {
				System.out.println(current.value);
				current = current.next;
			}
		}
	}



	public static void main(String args[]) {
		DLL a = new DLL();
		a.addFirst(10); // 10
		a.addFirst(20); // 20 <-> 10

		a.addFirst(30); // 30 <-> 20 <-> 10
		a.addFirst(40); // 40 <-> 30 <-> 20 <-> 10

		a.removeLast(); // 40 <-> 30 <-> 20 

		a.removeFirst();  //  30 <-> 20 


		a.addFirst(140); //  140 <-> 30 <-> 20 
		a.addFirst(50);

	
				
		a.print(); // 50 <-> 140 <-> 30 <-> 20 Prints all the values
		
	}


}
