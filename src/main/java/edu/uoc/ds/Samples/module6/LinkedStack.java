package edu.uoc.ds.samples.module6;


import edu.uoc.ds.adt.sequential.LinkedList;
import edu.uoc.ds.adt.sequential.List;
import edu.uoc.ds.adt.sequential.Stack;
import edu.uoc.ds.traversal.Iterator;

class LinkedStack<E>  implements Stack<E> {
	
   protected List<E> elems;


   public LinkedStack() {
	   elems =new LinkedList<>();
   }

   public int size() { return  elems.size(); }

   public boolean isEmpty() { return  elems.isEmpty(); }

   public void push(E elem) {
	   elems.insertBeginning(elem);
   }

   public E pop() {
	   return elems.deleteFirst();
   }

   public E peek() {
      return  elems.values().next();
   }

   public Iterator<E> values() {
   		return elems.values();
   }


   public String toString()
   {
      StringBuffer buffer = new StringBuffer();
      buffer.append("{STACK:");
      for (Iterator it = values(); it.hasNext(); ) {
         buffer.append(it.next());
         if (it.hasNext()) buffer.append(',');
      }
      buffer.append("}");
      return  buffer.toString();
   }
}
