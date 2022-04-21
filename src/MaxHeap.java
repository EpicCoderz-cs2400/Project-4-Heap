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
   private int creationSwaps;
   
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

   public int add(T newEntry)
   {
      checkIntegrity();        // Ensure initialization of data fields
      int newIndex = lastIndex + 1;
      int parentIndex = newIndex / 2;
      int swaps = 0;


      while ( (parentIndex > 0) && newEntry.compareTo(heap[parentIndex]) > 0)
      {
         heap[newIndex] = heap[parentIndex];
         newIndex = parentIndex;
         parentIndex = newIndex / 2;
         swaps++;
      } // end while

      heap[newIndex] = newEntry;
      lastIndex++;
      ensureCapacity();
      return swaps;

   } // end add
   
   public T removeMax()
   {
      //Check data and inputs
      checkIntegrity();

      //replace root with last index
      T prevRoot = heap[1];
      T newRoot = heap[lastIndex];
      heap[1] = newRoot;

      //remove last entry
      heap[lastIndex] = null;
      lastIndex--;

      int parentIndex = 1;
      int leftChildIndex = parentIndex * 2;
      int rightChildIndex = (parentIndex * 2) + 1;

      //Compare untill done

      //while not at a leaf node
      while (leftChildIndex <= lastIndex)
      {
         //does a right child exist if not make a placholder = to current
         T rightChild;
         if (lastIndex < rightChildIndex){
            rightChild = heap[parentIndex];
         } else {
            rightChild = heap[rightChildIndex];
         }
         //if current node is bigger than left or right children, all done
         if (heap[leftChildIndex].compareTo(heap[parentIndex]) <= 0 && rightChild.compareTo(heap[parentIndex]) <= 0)
         {
            break;
         }

         //either left, right, or both are bigger than current node

         //find max of left and right child and replace with larger (favor left)
         //If left is bigger or equal to right replace left else replace right
         if (heap[leftChildIndex].compareTo(rightChild) >= 0)
         {
            T smaller = heap[parentIndex];
            T bigger = heap[leftChildIndex];
            heap[leftChildIndex] = smaller;
            heap[parentIndex] = bigger;
            parentIndex = leftChildIndex;
         } else
         {
            T smaller = heap[parentIndex];
            T bigger = heap[rightChildIndex];
            heap[rightChildIndex] = smaller;
            heap[parentIndex] = bigger;
            parentIndex = rightChildIndex;
         }

         leftChildIndex = parentIndex * 2;
         rightChildIndex = parentIndex * 2 + 1;
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

   public int reheap(int index)
   {
      int swaps = 0;

      T rightChild;
      if ((index * 2 + 1) > lastIndex){
         rightChild = heap[index];
      } else {
         rightChild = heap[index * 2 + 1];
      }
      T leftChild = heap[index *2];

      if (leftChild.compareTo(heap[index]) <= 0 && rightChild.compareTo(heap[index]) <= 0){
         return swaps;
      }

      if(leftChild.compareTo(rightChild) >= 0){
         heap[index * 2] = heap[index];
         heap[index] = leftChild;
         swaps++;
      } else {
         heap[index * 2 + 1] = heap[index];
         heap[index] = rightChild;
         swaps++;
      }

      if (index * 4 <= lastIndex){
         swaps += reheap(index*2);
      } else if ((index *2 + 1)*2 <= lastIndex){
         swaps += reheap(index*2 + 1);
      }

      return swaps;
   }

   //sequential method
   public void setHeap(T[] entries)
   {
      for(int i = 0; i < entries.length; i++)
      {
         creationSwaps += add(entries[i]);
      }
   }

   public int getSwaps()
   {
      return creationSwaps;
   }
   //optimal method
   public MaxHeap(T[] entries)
   {
      this(entries.length);
      
      for(int i = 0; i < entries.length; i++)
      {
         heap[i+1] = entries[i];
      }
      lastIndex = entries.length;

      int startIndex = lastIndex / 2;

      for (int i = startIndex; i > 0; i-- ){
         creationSwaps += reheap(i);
      }
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
      if (lastIndex >= heap.length-1)
      {
         int newSize = lastIndex * 2;
         checkCapacity(newSize);
         heap = Arrays.copyOf(heap, newSize);
      }
   }
} // end MaxHeap
