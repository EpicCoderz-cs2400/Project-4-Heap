import java.util.Arrays;
/**
   A class that implements the ADT maxheap by using an array.
 
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public final class MaxHeap<T extends Comparable<? super T>>
             implements MaxHeapInterface<T>
{
   private T[] heap;      // Array of heap entries; ignore heap[0]
   private int lastIndex; // Index of last entry and number of entries
   private boolean integrityOK = false;
	private static final int DEFAULT_CAPACITY = 25;
	private static final int MAX_CAPACITY = 10000;
   
   public MaxHeap()
   {
      this(DEFAULT_CAPACITY); // Call next constructor
   } // end default constructor
   
   public MaxHeap(int initialCapacity)
   {
      // Is initialCapacity too small?
      if (initialCapacity < DEFAULT_CAPACITY)
         initialCapacity = DEFAULT_CAPACITY;
      else // Is initialCapacity too big?
         checkCapacity(initialCapacity);
      
      // The cast is safe because the new array contains null entries
      @SuppressWarnings("unchecked")
      T[] tempHeap = (T[])new Comparable[initialCapacity + 1];
      heap = tempHeap;
      lastIndex = 0;
      integrityOK = true;
   } // end constructor

   public void add(T newEntry)
   {
      checkIntegrity();        // Ensure initialization of data fields
      int newIndex = lastIndex + 1;
      int parentIndex = newIndex / 2;
      while ( (parentIndex > 0) && newEntry.compareTo(heap[parentIndex]) > 0)
      {
         heap[newIndex] = heap[parentIndex];
         newIndex = parentIndex;
         parentIndex = newIndex / 2;
      } // end while
   
      heap[newIndex] = newEntry;
      lastIndex++;
      ensureCapacity();

   } // end add
   
   public T removeMax()
   {
      //Check data and inputs

      //replace root with last index
      T prevRoot = heap[1];
      T newRoot = heap[lastIndex];
      heap[1] = newRoot;

      //remove last entry
      heap[lastIndex] = null;
      lastIndex--;

      int parentIndex = 1;
      int leftChildIndex = parentIndex * 2;
      int rightChildIndex = parentIndex * 2 +1;

      //Compare untill done
      while (heap[leftChildIndex].compareTo(heap[parentIndex]) > 0 || heap[rightChildIndex].compareTo(heap[parentIndex]) > 0)
      {
         //Check left child first
         if (heap[leftChildIndex].compareTo(heap[parentIndex]) > 0)
         {
            T smaller = heap[parentIndex];
            T bigger = heap[leftChildIndex];
            heap[leftChildIndex] = smaller;
            heap[parentIndex] = bigger;

            parentIndex = leftChildIndex;
            leftChildIndex = parentIndex * 2;
            rightChildIndex = parentIndex * 2 + 1;
         }

         //Check right child
         if (heap[rightChildIndex].compareTo(heap[parentIndex]) > 0)
         {
            T smaller = heap[parentIndex];
            T bigger = heap[rightChildIndex];
            heap[rightChildIndex] = smaller;
            heap[parentIndex] = bigger;

            parentIndex = rightChildIndex;
            leftChildIndex = parentIndex * 2;
            rightChildIndex = parentIndex * 2 + 1;
         }
      }

      //return removed item
      return prevRoot;
   } // end removeMax

   public T getMax()
   {
		checkIntegrity();
      T root = null;
      if (!isEmpty())
         root = heap[1];
      return root;
   } // end getMax

   public boolean isEmpty()
   {
      return lastIndex < 1;
   } // end isEmpty

   public int getSize()
   {
      return lastIndex;
   } // end getSize

   public void clear()
   {
		checkIntegrity();
      while (lastIndex > -1)
      {
         heap[lastIndex] = null;
         lastIndex--;
      } // end while
      lastIndex = 0;
   } // end clear
   
   public T[] toArray()
   {
      return heap;
   }

   // Private methods

   private void checkIntegrity()
   {
      if (!integrityOK)
         throw new SecurityException("Heap is corrupt.");
   }

   private void checkCapacity(int capacity)
   {
      if (capacity > MAX_CAPACITY)
         throw new IllegalStateException("Attempt to create a heap whose capacity exceeds " +
                                         "allowed maximum of " + MAX_CAPACITY);
   }

   private void ensureCapacity()
   {
      if (lastIndex + 1 == heap.length && lastIndex * 2 < MAX_CAPACITY)
      {
         T[] newHeap = (T[])new Comparable[lastIndex * 2];
         heap = newHeap;
      }else if (lastIndex * 2 >= MAX_CAPACITY)
      {
         checkCapacity(lastIndex * 2);
      }
   }
} // end MaxHeap
