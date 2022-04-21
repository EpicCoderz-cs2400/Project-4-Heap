import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.ArrayList; // import the ArrayList class
public class DriverHeap {

    public static void main(String[] args) {
        ArrayList<Integer> inputData = new ArrayList<>();

        try {
            File randomData = new File("src\\data_random.txt");
            Scanner fileScanner = new Scanner(randomData);
            while(fileScanner.hasNextLine()){
                inputData.add(Integer.valueOf(fileScanner.nextLine()));
            }
            fileScanner.close();

            
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        Integer[] entries = new Integer[inputData.size()];
        entries = inputData.toArray(entries);

        MaxHeap<Integer> sequHeap = new MaxHeap<>();
        sequHeap.setHeap(entries);

        MaxHeap<Integer> optimalHeap = new MaxHeap<>(entries);
        
        File heapOut = new File("heap_results.txt");

        try {
            FileWriter heapWriter = new FileWriter("heap_results.txt");


            heapWriter.write("Heap built using sequential insertions: ");
            for(int i = 1; i < 11; i++){
                heapWriter.write(sequHeap.getElementAt(i) + ", ");
            }
            heapWriter.write("\nNumber of swaps in the heap creation: ");
            heapWriter.write(sequHeap.getSwaps());
            for (int i = 0; i < 10; i++) {
                sequHeap.removeMax();
            }
            heapWriter.write("\nHeap after 10 removals: ");
            for(int i = 1; i < 11; i++){
                heapWriter.write(sequHeap.getElementAt(i) + ", ");
            }

            heapWriter.write("\n\nHeap built using optimal method: ");
            for(int i = 1; i < 11; i++){
                heapWriter.write(optimalHeap.getElementAt(i) + ", ");
            }
            heapWriter.write("\nNumber of swaps in the heap creation: ");
            heapWriter.write(optimalHeap.getSwaps());
            for (int i = 0; i < 10; i++) {
                optimalHeap.removeMax();
            }
            heapWriter.write("\nHeap after 10 removals: ");
            for(int i = 1; i < 11; i++){
                heapWriter.write(optimalHeap.getElementAt(i) + ", ");
            }          
            heapWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
}
