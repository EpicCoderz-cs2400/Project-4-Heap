
import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class UnitTesting {
    /* Unit Cases for Creating a Heap from 3 random numbers [A,B,C]:

    Case # | Case Description | # of swaps performed | Resulting Heap
    -----------------------------------------------------------------
    1      | A = B = C        | 0                    | [A,B,C]
    2      | A < B = C        | 1                    | [B,A,C]
    3      | A = B < C        | 1                    | [C,B,A]
    4      | A < B < C        | 2                    | [C,A,B]
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
    
    Case # | Case Description | Resulting Heap
    ------------------------------------------
    R1     | D = B, D = C     | [D,B,C]
    R2     | D = B, D < C     | [C,B,D]
    R3     | D = B, c < D     | [D,B,C]
    R4     | D < B, B = C     | [B,D,C]
    R5     | D < B, C < B     | [B,D,C]
    R6     | D < B, B < C     | [C,D,B]
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
    A6     | +C, A < C, B = C | [C,B,A]
    A7     | +C, A < C, B < C | [C,B,A]
    A8     | +C, A < C, C < B | [B,C,A]
     */
    
     //Add Tests
     @Test
     public void testAddCaseA0 (){
         MaxHeap<Integer> heapCaseA0 = new MaxHeap<>();
         heapCaseA0.add(1);
         assertEquals([1], heapCaseA0.toArray());
     }


}
