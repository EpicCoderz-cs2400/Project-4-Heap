
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
public class UnitTesting {
    /* Unit Cases for Creating a Heap from 3 random numbers [A,B,C]:

    Case # | Case Description | # of swaps performed | Resulting Heap
    -----------------------------------------------------------------
    1      | A = B = C        | 0                    | [A,B,C]
    2      | A < B = C        | 1                    | [B,A,C]
    3      | A = B < C        | 1                    | [C,B,A]
    4      | A < B < C        | 1                    | [C,B,A]
    5      | A = C < B        | 1                    | [B,A,C]
    6      | A < C < B        | 1                    | [B,A,C]
    7      | B < A = C        | 0                    | [A,B,C]
    8      | B < A < C        | 1                    | [C,B,A]
    9      | B = C < A        | 0                    | [A,B,C]
    10     | B < C < A        | 0                    | [A,B,C]
    11     | C < A = B        | 0                    | [A,B,C]
    12     | C < A < B        | 1                    | [B,A,C]
    13     | C < B < A        | 0                    | [A,B,C]
     */

    /* Uint Cases for Removing from a Heap [A,B,C,D]:
    
    Case # | Case Description     | Resulting Heap
    ------------------------------------------
    R1     | D = B, D = C         | [D,B,C]
    R2     | D = B, D < C         | [C,B,D]
    R3     | D = B, c < D         | [D,B,C]
    R4     | D < B, D = C         | [B,D,C]
    R5     | D < B, C <= B        | [B,D,C]
    R6     | D < B, B < C         | [C,D,B]
    R7     | [A,B] Heap           | [B]
    R8     | [A,B,C] Heap, C <= B | [B,C]
    R9     | [A,B,C] Heap, B < C  | [C,B]
    R0     |[A,B,C,D,E] Heap, C<B | [B,D,C,E]

    case where resulting tree is empty
    ab tree
    abc tree
    */

    /*Unit Cases for Adding to a Heap:
    Empty Heap-
    Case # | Case Description | Resulting Heap
    ------------------------------------------
    A0     | +A               | [A]


    Singular Node Heap-
    Case # | Case Description | Resulting Heap
    ------------------------------------------
    A1     | +B, B = A        | [A,B]
    A2     | +B, B < A        | [A,B]
    A3     | +B, A < B        | [A,B]

    Heap with 2 Nodes-
    Case # | Case Description | Resulting Heap
    ------------------------------------------
    A4     | +C, C = A        | [A,B,C]
    A5     | +C, C < A        | [A,B,C]
    A6     | +C, A < C        | [C,B,A]
     */
    
     //Add Tests
     @Test
     public void testAddCaseA0 (){
         MaxHeap<Integer> heapCaseA0 = new MaxHeap<>();
         heapCaseA0.add(2);
         Integer[] expexted;
         expexted = new Integer[26];
         expexted[1] = 2;
         assertArrayEquals(expexted, heapCaseA0.toArray());
     }

     @Test
     public void testAddCaseA1 ()
     {
         MaxHeap<Integer> heapCaseA1 = new MaxHeap<>();
         heapCaseA1.add(2);
         heapCaseA1.add(2);

         Integer[] expexted;
         expexted = new Integer[26];
         expexted[1] = 2;
         expexted[2] = 2;

         assertArrayEquals(expexted, heapCaseA1.toArray());
     }

     @Test
     public void testAddCaseA2 ()
     {
         MaxHeap<Integer> heapCaseA2 = new MaxHeap<>();
         heapCaseA2.add(2);
         heapCaseA2.add(1);

         Integer[] expexted;
         expexted = new Integer[26];
         expexted[1] = 2;
         expexted[2] = 1;

         assertArrayEquals(expexted, heapCaseA2.toArray());
     }

     @Test
     public void testAddCaseA3 ()
     {
         MaxHeap<Integer> heapCaseA3 = new MaxHeap<>();
         heapCaseA3.add(2);
         heapCaseA3.add(1);

         Integer[] expexted;
         expexted = new Integer[26];
         expexted[1] = 2;
         expexted[2] = 1;

         assertArrayEquals(expexted, heapCaseA3.toArray());
     }

     @Test
     public void testAddCaseA4 ()
     {
         MaxHeap<Integer> heapCaseA4 = new MaxHeap<>();
         heapCaseA4.add(2);
         heapCaseA4.add(2);
         heapCaseA4.add(2);

         Integer[] expexted;
         expexted = new Integer[26];
         expexted[1] = 2;
         expexted[2] = 2;
         expexted[3] = 2;

         assertArrayEquals(expexted, heapCaseA4.toArray());
     }

     @Test
     public void testAddCaseA5 ()
     {
         MaxHeap<Integer> heapCaseA5 = new MaxHeap<>();
         heapCaseA5.add(2);
         heapCaseA5.add(2);
         heapCaseA5.add(1);

         Integer[] expexted;
         expexted = new Integer[26];
         expexted[1] = 2;
         expexted[2] = 2;
         expexted[3] = 1;

         assertArrayEquals(expexted, heapCaseA5.toArray());
     }

     @Test
     public void testAddCaseA6 ()
     {
         MaxHeap<Integer> heapCaseA6 = new MaxHeap<>();
         heapCaseA6.add(2);
         heapCaseA6.add(1);
         heapCaseA6.add(3);

         Integer[] expexted;
         expexted = new Integer[26];
         expexted[1] = 3;
         expexted[2] = 1;
         expexted[3] = 2;

         assertArrayEquals(expexted, heapCaseA6.toArray());
     }


     //Remove Tests
     @Test
     public void testRemoveCaseR1 ()
     {
         MaxHeap<Integer> heapCaseR1 = new MaxHeap<>();
         heapCaseR1.add(10);
         heapCaseR1.add(2);
         heapCaseR1.add(2);
         heapCaseR1.add(2);

         Integer[] expected;
         expected = new Integer[26];
         expected[1] = 2;
         expected[2] = 2;
         expected[3] = 2;

         Integer root = 10;

         assertEquals(root, heapCaseR1.removeMax());
         assertArrayEquals(expected, heapCaseR1.toArray());
     }
    
     @Test
     public void testRemoveCaseR2 ()
     {
         MaxHeap<Integer> heapCaseR2 = new MaxHeap<>();
         heapCaseR2.add(10);
         heapCaseR2.add(2);
         heapCaseR2.add(3);
         heapCaseR2.add(2);

         Integer[] expected;
         expected = new Integer[26];
         expected[1] = 3;
         expected[2] = 2;
         expected[3] = 2;

         Integer root = 10;

         assertEquals(root, heapCaseR2.removeMax());
         assertArrayEquals(expected, heapCaseR2.toArray());
     }
    
     @Test
     public void testRemoveCaseR3 ()
     {
         MaxHeap<Integer> heapCaseR3 = new MaxHeap<>();
         heapCaseR3.add(10);
         heapCaseR3.add(3);
         heapCaseR3.add(2);
         heapCaseR3.add(3);

         Integer[] expected;
         expected = new Integer[26];
         expected[1] = 3;
         expected[2] = 3;
         expected[3] = 2;

         Integer root = 10;

         assertEquals(root, heapCaseR3.removeMax());
         assertArrayEquals(expected, heapCaseR3.toArray());
     }
    
     @Test
     public void testRemoveCaseR4 ()
     {
         MaxHeap<Integer> heapCaseR4 = new MaxHeap<>();
         heapCaseR4.add(10);
         heapCaseR4.add(3);
         heapCaseR4.add(2);
         heapCaseR4.add(2);

         Integer[] expected;
         expected = new Integer[26];
         expected[1] = 3;
         expected[2] = 2;
         expected[3] = 2;

         Integer root = 10;

         assertEquals(root, heapCaseR4.removeMax());
         assertArrayEquals(expected, heapCaseR4.toArray());
     }
    
     @Test
     public void testRemoveCaseR5 ()
     {
         MaxHeap<Integer> heapCaseR5 = new MaxHeap<>();
         heapCaseR5.add(10);
         heapCaseR5.add(3);
         heapCaseR5.add(1);
         heapCaseR5.add(2);

         Integer[] expected;
         expected = new Integer[26];
         expected[1] = 3;
         expected[2] = 2;
         expected[3] = 1;

         Integer root = 10;

         assertEquals(root, heapCaseR5.removeMax());
         assertArrayEquals(expected, heapCaseR5.toArray());
     }
    
     @Test
     public void testRemoveCaseR6 ()
     {
         MaxHeap<Integer> heapCaseR6 = new MaxHeap<>();
         heapCaseR6.add(10);
         heapCaseR6.add(3);
         heapCaseR6.add(4);
         heapCaseR6.add(2);

         Integer[] expected;
         expected = new Integer[26];
         expected [1] = 4;
         expected [2] = 3;
         expected [3] = 2;

         Integer root = 10;

         assertEquals(root, heapCaseR6.removeMax());
         assertArrayEquals(expected, heapCaseR6.toArray());
     }
    
     @Test
     public void testRemoveCaseR7 ()
     {
         MaxHeap<Integer> heapCaseR7 = new MaxHeap<>();
         heapCaseR7.add(10);
         heapCaseR7.add(3);

         Integer[] expected;
         expected = new Integer[26];
         expected [1] = 3;

         Integer root = 10;

         assertEquals(root, heapCaseR7.removeMax());
         assertArrayEquals(expected, heapCaseR7.toArray());
     }
    
     @Test
     public void testRemoveCaseR8 ()
     {
         MaxHeap<Integer> heapCaseR8 = new MaxHeap<>();
         heapCaseR8.add(10);
         heapCaseR8.add(3);
         heapCaseR8.add(2);

         Integer[] expected;
         expected = new Integer[26];
         expected [1] = 3;
         expected [2] = 2;

         Integer root = 10;

         assertEquals(root, heapCaseR8.removeMax());
         assertArrayEquals(expected, heapCaseR8.toArray());
     }
    
     @Test
     public void testRemoveCaseR9 ()
     {
         MaxHeap<Integer> heapCaseR9 = new MaxHeap<>();
         heapCaseR9.add(10);
         heapCaseR9.add(3);
         heapCaseR9.add(4);

         Integer[] expected;
         expected = new Integer[26];
         expected [1] = 4;
         expected [2] = 3;

         Integer root = 10;

         assertEquals(root, heapCaseR9.removeMax());
         assertArrayEquals(expected, heapCaseR9.toArray());
     }
    
     @Test
     public void testRemoveCaseR0 ()
     {
        MaxHeap<Integer> heapCaseR0 = new MaxHeap<>();
        heapCaseR0.add(10);
        heapCaseR0.add(4);
        heapCaseR0.add(3);
        heapCaseR0.add(3);
        heapCaseR0.add(2);

        Integer[] expected;
        expected = new Integer[26];
        expected [1] = 4;
        expected [2] = 3;
        expected [3] = 3;
        expected [4] = 2;

        Integer root = 10;

        assertEquals(root, heapCaseR0.removeMax());
        assertArrayEquals(expected, heapCaseR0.toArray());
     }
    
    
     //optimal insert tests
     @Test
     public void testOptimalCase4 ()
     {
         Integer[] input;
         input = new Integer[3];
         input[0] = 2;
         input[1] = 4;
         input[2] = 8;

         MaxHeap<Integer> heapCase4 = new MaxHeap<>(input);

         Integer[] expected;
         expected = new Integer[26];
         expected[1] = 8;
         expected[2] = 4;
         expected[3] = 2;

         int expSwaps = 1;

         assertArrayEquals(expected, heapCase4.toArray());
         assertEquals(expSwaps, heapCase4.getSwaps());
         
     }

     @Test
     public void testOptimalNew ()
     {
         Integer[] input = {10, 15, 8, 9, 11, 6, 4, 8, 19};

         MaxHeap<Integer> heapNew = new MaxHeap<>(input);

         Integer[] expected;
         expected = new Integer[26];
         expected[1] = 19;
         expected[2] = 15;
         expected[3] = 8;
         expected[4] = 10;
         expected[5] = 11;
         expected[6] = 6;
         expected[7] = 4;
         expected[8] = 8;
         expected[9] = 9;

         int expSwaps = 4;

         assertArrayEquals(expected, heapNew.toArray());
         assertEquals(expSwaps, heapNew.getSwaps());
         
     }
    
    
     //Sequential insert tests
     @Test
     public void testSequentialCase4 ()
     {
         Integer[] input;
         input = new Integer[3];
         input[0] = 2;
         input[1] = 4;
         input[2] = 8;

         MaxHeap<Integer> heapCase4 = new MaxHeap<>();
         heapCase4.setHeap(input);

         Integer[] expected;
         expected = new Integer[26];
         expected[1] = 8;
         expected[2] = 2;
         expected[3] = 4;

         int expSwaps = 2;

         assertArrayEquals(expected, heapCase4.toArray());
         assertEquals(expSwaps, heapCase4.getSwaps());
         
     }

     @Test
     public void testSequentialNew ()
     {
         Integer[] input = {10, 15, 8, 9, 11, 6, 4, 8, 19};

         MaxHeap<Integer> heapNew = new MaxHeap<>();
         heapNew.setHeap(input);

         Integer[] expected;
         expected = new Integer[26];
         expected[1] = 19;
         expected[2] = 15;
         expected[3] = 8;
         expected[4] = 11;
         expected[5] = 10;
         expected[6] = 6;
         expected[7] = 4;
         expected[8] = 8;
         expected[9] = 9;

         int expSwaps = 5;

         assertArrayEquals(expected, heapNew.toArray());
         assertEquals(expSwaps, heapNew.getSwaps());
         
     }
    

    }
