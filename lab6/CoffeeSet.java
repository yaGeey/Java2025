package lab6;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 * Custom implementation of Set interface based on doubly linked list.
 * This collection stores unique Coffee objects.
 * @param <T> the type of elements in this set (Coffee or its subclasses)
 */
public class CoffeeSet<T> implements Set<T> {
   /**
    * Node class represents a single element in the doubly linked list.
    * Each node contains data and references to previous and next nodes.
    */
   private class Node {
      T data;
      Node prev;
      Node next;

      /**
       * Creates a new node with given data.
       * @param data the element to store in this node
       */
      Node(T data) {
         this.data = data;
         this.prev = null;
         this.next = null;
      }
   }
   
   private Node head;
   private Node tail;
   private int size;
   
   public CoffeeSet() {
      this.head = null;
      this.tail = null;
      this.size = 0;
   }
   public CoffeeSet(T element) {
      this();
      add(element);
   }
   public CoffeeSet(Collection<? extends T> collection) {
      this();
      if (collection == null) {
         throw new NullPointerException("Collection cannot be null");
      }
      addAll(collection);
   }
   
   @Override
   public int size() {
      return size;
   }
   
   @Override
   public boolean isEmpty() {
      return size == 0;
   }
   
   /**
    * Returns true if this set contains the specified element.
    * @param o element whose presence is to be tested
    * @return true if this set contains the specified element
    */
   @Override
   public boolean contains(Object o) {
      if (o == null) return false;
      
      Node current = head;
      while (current != null) {
         if (current.data.equals(o)) {
            return true;
         }
         current = current.next;
      }
      return false;
   }
   
   @Override
   public Iterator<T> iterator() {
      return new Iterator<T>() {
         private Node current = head;
         private Node lastReturned = null;
         
         @Override
         public boolean hasNext() {
            return current != null;
         }
         
         @Override
         public T next() {
            if (!hasNext()) {
               throw new NoSuchElementException();
            }
            lastReturned = current;
            T data = current.data;
            current = current.next;
            return data;
         }
         
         @Override
         public void remove() {
            if (lastReturned == null) {
               throw new IllegalStateException();
            }
            removeNode(lastReturned);
            lastReturned = null;
         }
      };
   }
   
   @Override
   public Object[] toArray() {
      Object[] array = new Object[size];
      int index = 0;
      Node current = head;
      while (current != null) {
         array[index++] = current.data;
         current = current.next;
      }
      return array;
   }
   
   /**
    * Returns an array containing all elements in this set.
    * The runtime type of the returned array is that of the specified array.
    * 
    * @param <E> the component type of the array
    * @param a the array into which the elements are to be stored
    * @return an array containing all elements
    */
   @Override
   @SuppressWarnings("unchecked")
   public <E> E[] toArray(E[] a) {
      if (a.length < size) {
         a = (E[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size);
      }
      
      int index = 0;
      Node current = head;
      Object[] result = a;
      while (current != null) {
         result[index++] = current.data;
         current = current.next;
      }
      
      if (a.length > size) {
         a[size] = null;
      }
      
      return a;
   }
   
   /**
    * Adds the specified element to this set if it is not already present.
    * @param e element to be added
    * @return true if this set did not already contain the element
    */
   @Override
   public boolean add(T e) {
      if (e == null) throw new NullPointerException("Element cannot be null");
      if (contains(e)) return false;
      
      Node newNode = new Node(e);
      
      if (head == null) {
         // First element
         head = tail = newNode;
      } else {
         // Add to the end
         tail.next = newNode;
         newNode.prev = tail;
         tail = newNode;
      }
      
      size++;
      return true;
   }
   
   /**
    * Removes the specified element from this set if it is present.
    * @param o element to be removed
    * @return true if this set contained the element
    */
   @Override
   public boolean remove(Object o) {
      if (o == null) return false;
      
      Node current = head;
      while (current != null) {
         if (current.data.equals(o)) {
            removeNode(current);
            return true;
         }
         current = current.next;
      }
      return false;
   }
   
   /**
    * Helper method to remove a specific node from the list.
    * @param node the node to remove
    */
   private void removeNode(Node node) {
      if (node.prev == null) {
         // Removing head
         head = node.next;
      } else {
         node.prev.next = node.next;
      }
      
      if (node.next == null) {
         // Removing tail
         tail = node.prev;
      } else {
         node.next.prev = node.prev;
      }
      
      size--;
   }
   
   /**
    * Returns true if this set contains all elements of the specified collection.
    * @param c collection to be checked for containment
    * @return true if this set contains all elements
    */
   @Override
   public boolean containsAll(Collection<?> c) {
      for (Object element : c) {
         if (!contains(element)) {
            return false;
         }
      }
      return true;
   }
   
   /**
    * Adds all elements from the specified collection to this set.
    * @param c collection containing elements to be added
    * @return true if this set changed as a result
    */
   @Override
   public boolean addAll(Collection<? extends T> c) {
      boolean modified = false;
      for (T element : c) {
         if (add(element)) {
            modified = true;
         }
      }
      return modified;
   }
   
   /**
    * Retains only the elements that are contained in the specified collection.
    * @param c collection containing elements to be retained
    * @return true if this set changed as a result
    */
   @Override
   public boolean retainAll(Collection<?> c) {
      boolean modified = false;
      Node current = head;
      
      while (current != null) {
         Node next = current.next;
         if (!c.contains(current.data)) {
            removeNode(current);
            modified = true;
         }
         current = next;
      }
      
      return modified;
   }
   
   /**
    * Removes all elements that are contained in the specified collection.
    * @param c collection containing elements to be removed
    * @return true if this set changed as a result
    */
   @Override
   public boolean removeAll(Collection<?> c) {
      boolean modified = false;
      for (Object element : c) {
         if (remove(element)) {
            modified = true;
         }
      }
      return modified;
   }
   
   @Override
   public void clear() {
      head = null;
      tail = null;
      size = 0;
   }
   
   @Override
   public String toString() {
      if (isEmpty()) {
         return "[]";
      }
      
      StringBuilder sb = new StringBuilder("[");
      Node current = head;
      
      while (current != null) {
         sb.append(current.data);
         if (current.next != null) {
            sb.append(", ");
         }
         current = current.next;
      }
      
      sb.append("]");
      return sb.toString();
   }
}
