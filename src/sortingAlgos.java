
import java.util.*;
public class sortingAlgos {
	public static Integer[] bubbleSort(Integer[] myarr)
    {
        int n = myarr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (myarr[j] > myarr[j+1])
                {
                    
                    int temp = myarr[j];
                    myarr[j] = myarr[j+1];
                    myarr[j+1] = temp;
                }
        return (myarr);
        
    }
	
	public static Integer[] insertionSort(Integer[] myarr)
    {
        int n = myarr.length;
        for (int i = 1; i < n; ++i) {
            Integer key = myarr[i];
            int j = i - 1;
 
            
            while (j >= 0 && myarr[j] > key) {
                myarr[j + 1] = myarr[j];
                j = j - 1;
            }
            myarr[j + 1] = key;
        }
        return (myarr);
    }
	
	public static Integer[] SelectionSort(Integer[] arr)
    {
        int n = arr.length;
  
        
        for (int i = 0; i < n-1; i++)
        {
        
            int minNum = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[minNum])
                    minNum = j;
  
            int temp = arr[minNum];
            arr[minNum] = arr[i];
            arr[i] = temp;
        }
        return (arr);
    }
	
	

	
    public static void mergeSortMerge(Integer arr[], int l, int m, int r)
    {
      
        int n1 = m - l + 1;
        int n2 = r - m;
  

        int L[] = new int[n1];
        int R[] = new int[n2];
  

        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
       
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
  
       
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    
    public static void mergeSort(Integer arr[], int l, int r){
        if (l < r) {
            
            int m =l+ (r-l)/2;
  
            
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
  
            
            mergeSortMerge(arr, l, m, r);
        }
    }
    
    public static void mergeSortHelper(Integer[] arr) {
    	mergeSort(arr, 0, arr.length-1);
    	
    }
    

	
	static void swap(Integer[] arr, int i, int j){
	    Integer temp = arr[i];
	    arr[i] = arr[j];
	    arr[j] = temp;
	}
	
	static Integer partition(Integer[] arr, int low, int high){
	     
	    
	    Integer pivot = arr[high];
	    arr[1] = 1;
	   
	    int i = (low - 1);
	 
	    for(Integer j = low; j <= high - 1; j++){
	         
	        
	        if (arr[j] < pivot){
	             
	            
	            i++;
	            swap(arr, i, j);
	        }
	    }
	    swap(arr, i + 1, high);
	    return (i + 1);
	}
	
	public static Integer[] quickSort(Integer[] arr, int low, int high){
	    if (low < high){
	         
	       
	        int pi = partition(arr, low, high);
	 
	        
	        quickSort(arr, low, pi - 1);
	        quickSort(arr, pi + 1, high);
	    }
	    return arr;
	}
	
	public static void quickSortMain(Integer[] arr) {
		quickSort(arr, 0, arr.length-1);
	}
	
	public static Integer[] shellSort(Integer[] arr) {
		int n = arr.length;
		 
        
        for (int gap = n/2; gap > 0; gap /= 2)
        {
           
            for (int i = gap; i < n; i += 1)
            {
               
                int temp = arr[i];
 
          
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap)
                    arr[j] = arr[j - gap];
 
         
                arr[j] = temp;
            }
        }
        return arr;
	}
	
	public static Integer[] heapSort(Integer[] arr)
    {
        int n = arr.length;
 
        
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
 
       
        for (int i = n - 1; i > 0; i--) {
            
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
 
            heapify(arr, i, 0);
        }
        return arr;
    }
	
	static void heapify(Integer[] arr, int n, int i)
    {
        int largest = i; 
        int l = 2 * i + 1; 
        int r = 2 * i + 2; 
 
        
        if (l < n && arr[l] > arr[largest])
            largest = l;
 
        
        if (r < n && arr[r] > arr[largest])
            largest = r;
 
        
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
 
            
            heapify(arr, n, largest);
        }
    }
	
	public static void countingsort(Integer[] arr)
	  {
	    int len = arr.length;
	    Integer[] output = new Integer[len + 1];
	    Integer max = arr[0];
	    for (int i = 1; i < len; i++)
	    {
	      if (arr[i] > max)
	        max = arr[i];
	    }
	    int[] count = new int[max + 1];
	    for (int i = 0; i < max; ++i)
	      count[i] = 0;
	    for (int i = 0; i < len; i++)
	 	     count[arr[i]]++;
	    for (int i = 1; i <= max; i++)
	      count[i] += count[i - 1];
	    for (int i = len - 1; i >= 0; i--)
	    {
	 	     output[count[arr[i]] - 1] = arr[i];
	 	     count[arr[i]]--;
	    }
	    for (int i = 0; i < len; i++)
	 	     arr[i] = output[i];  
	  }

	
}
