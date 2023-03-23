import java.util.*;
import java.io.*;
import java.time.*;

public class sortingOutSorting{

	public static Integer[][] getArrays(String fileName, int n){
		

		//open a scanner for the file passed in

		try{

		    Scanner in = new Scanner(new File(fileName));

		    Integer[][] output = new Integer[100][n];

		    for (int i = 0; i < 100; i++){

		    	Integer[] arr = new Integer[n];

		    	String s = in.next();

		    	String[] line = s.split(",");

		    	System.out.println(line[0]);

					for (int j = 0; j < n; j++){

						arr[j] = Integer.valueOf(line[j]);

					}

				output[i] = arr;

		    }	

		    in.close();

		    return output;

		}

		catch(Exception e){ System.out.println(e); }

		return null;   

	 }
	    @SuppressWarnings("deprecation")

	 public static Integer[] deepCopy(Integer[] arr) {

	    	Integer[] cpy = new Integer[arr.length];

	    	for (int i = 0; i < arr.length; i++) {

	    		cpy[i] = arr[i];

	    	}

	    	return cpy;

	    }


     public static void codeToTimeBubble(Integer[][] arr, int i){
    	 Integer[] myarr;
         myarr = deepCopy(arr[i]);
         sortingAlgos.bubbleSort(myarr);

    	 
     }
     
     public static void codeToTimeInsertion(Integer[][] arr, int i){
    	 Integer[] myarr;
         myarr = deepCopy(arr[i]);
         sortingAlgos.insertionSort(myarr);
    	 
     }
     
     public static void codeToTimeSelection(Integer[][] arr, int i){

    	Integer[] myarr;
       	myarr = deepCopy(arr[i]);
      	sortingAlgos.SelectionSort(myarr);
     }
     
     public static void codeToTimeMerge(Integer[][] arr, int i){
    	 
    	 Integer[] myarr;
       	 myarr = deepCopy(arr[i]);
       	 sortingAlgos.mergeSortHelper(myarr);
     }
     
     public static void codeToTimeQuick(Integer[][] arr, int i){
    	
    	 Integer[] myarr;
       	 myarr = deepCopy(arr[i]);
       	 sortingAlgos.quickSortMain(myarr);
    	
     }
     
     public static void codeToTimeShell(Integer[][] arr, int i){
    	 
    	 Integer[] myarr;
       	 myarr = deepCopy(arr[i]);
       	 sortingAlgos.shellSort(myarr);
    	 
     }
     
     public static void codeToTimeHeap(Integer[][] arr, int i){

    	 Integer[] myarr;
       	 myarr = deepCopy(arr[i]);
       	 sortingAlgos.heapSort(myarr);
    	 
     }
     
     public static void codeToTimeCounting(Integer[][] arr, int i){
    	 
   		 Integer[] myarr;
       	 myarr = deepCopy(arr[i]);
       	 sortingAlgos.countingsort(myarr);
    	 
     }
     
     public static long[] measureTime(Integer[][] arr, long[] Times) {
    	 for (int i = 0; i < 100; i++){
    		 long start = System.nanoTime();
        	 codeToTimeBubble(arr, i);
        	 long end = System.nanoTime();
        	 Times[0] += end - start;
        	    	 
        	 long start1 = System.nanoTime();
        	 codeToTimeInsertion(arr, i);
        	 long end1 = System.nanoTime();
        	 Times[1] += end1 - start1;
        	 
        	 long start2 = System.nanoTime();
        	 codeToTimeSelection(arr, i);
        	 long end2 = System.nanoTime();
        	 Times[2] += end2 - start2;
        	 
        	 long start3 = System.nanoTime();
        	 codeToTimeMerge(arr, i);
        	 long end3 = System.nanoTime();
        	 Times[3] += end3 - start3;
        	 
        	 long start4 = System.nanoTime();
        	 codeToTimeQuick(arr, i);
        	 long end4 = System.nanoTime();
        	 Times[4] += end4 - start4;
        	 
        	 long start5 = System.nanoTime();
        	 codeToTimeShell(arr, i);
        	 long end5 = System.nanoTime();
        	 Times[5] += end5 - start5;
        	 
        	 long start6 = System.nanoTime();
        	 codeToTimeHeap(arr, i);
        	 long end6 = System.nanoTime();
        	 Times[6] += end6 - start6;
        	 
        	 long start7 = System.nanoTime();
        	 codeToTimeCounting(arr, i);
        	 long end7 = System.nanoTime();
        	 Times[7] += end7 - start7;
    	 }
    	 Times[0] = Times[0]/100;
    	 Times[1] = Times[1]/100;
    	 Times[2] = Times[2]/100;
    	 Times[3] = Times[3]/100;
    	 Times[4] = Times[4]/100;
    	 Times[5] = Times[5]/100;
    	 Times[6] = Times[6]/100;
    	 Times[7] = Times[7]/100;
    	 return Times;
    	 
     }


     public static void output(long[] times, String fileName){
    	 
	 // use this to output the average runtime for each size
	 // of a given algorithm
    	 try{
    		 
    		 File f = new File(fileName);
    		 if (f.createNewFile()) System.out.println("created file");
    		 else { System.out.println("File already exists");}
    		 FileWriter write = new FileWriter(fileName);
    		 for (int i = 0; i < times.length; i++){ 			 
    			write.write(Long.toString(times[i]));
        		write.write("\n");
    			
    		 }
    		 write.close();
    	 }
    	 catch(Exception e) {System.out.println(e);}
     }

     public static void main(String[] args){
    	 
     	 //main showing how everything works
    	 Scanner in = new Scanner(System.in);
    	 long[] times = new long[8];
    	 Integer[][] arr10 = getArrays("arrays10.txt",10);
    	 Integer[][] arr50 = getArrays("arrays50.txt",50);
    	 Integer[][] arr100 = getArrays("arrays100.txt",100);
    	 Integer[][] arr500 = getArrays("arrays500.txt",500);
    	 Integer[][] arr1000 = getArrays("arrays1000.txt",1000);
    	 Integer[][] arr5000 = getArrays("arrays5000.txt",5000);
    	 measureTime(arr10,times);
    	 output(times, "outputARR10FINAL2.csv");
    	 measureTime(arr50,times);
    	 output(times, "outputARR50FINAL2.csv");
    	 measureTime(arr100,times);
    	 output(times, "outputARR100FINAL2.csv");
    	 measureTime(arr500,times);
    	 output(times, "outputARR500FINAL2.csv");
    	 measureTime(arr1000,times);
    	 output(times, "outputARR1000FINAL2.csv");
    	 measureTime(arr5000,times);
    	 output(times, "outputARR5000FINAL2.csv");

     }

 }