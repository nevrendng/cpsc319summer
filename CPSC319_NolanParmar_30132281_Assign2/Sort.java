/** 
	@author Nolan Parmar <a
	href= "mailto: Nolan.parmar@ucalgary.ca">Nolan.parmar@ucalgary.ca</a>
	30132281 
	CPSC 319 
	Assignment 2
*/
public class Sort 
{
        //sorts the array using the Selection Sort algorithm adapted from lecture notes and tutorials. 
        public void selectionSort(int[] array)                  //Complexity Analysis
        {
            int temp, min;                                         //2
            for(int i = 0; i < array.length - 1; i++)              // 2 + n + n
            {
                //find the least element in right subarray
                 min = i;                                        //n
                for(int j = i + 1; j < array.length; j++)        //2(n) + n + n
                {
                    if (array[j] < array[min])                   //2(n+1)
                    {
                        min  = j;                                //   
                    }
                }     
            //swap items
            temp = array[min];                                  //2(n)
            array[min] = array[i];                              //2(n)
            array[i] = temp;                                    //2(n)
            }
            
        }
        //sorts the array using the Insertion Sort algorithm adapted from notes, tutorials, and https://www.geeksforgeeks.org/insertion-sort/
        public void insertionSort(int[] array)                  
      {                                                         //complexity analysis
        
          for(int i = 1, j; i < array.length; i++)              //outer loop: 1 + (n+1) + n
           {
              int temp = array[i];                              //2(n)
              for(j = i; j > 0 && temp < array[j - 1]; j--)   //inner loop:  1 + (n + 1) + 2(n + 1) + n + 2(n + 1) 
                                                               //= 6n +6 (Is O(n))
              {                             
                  array[j] = array[j-1];
              }
              
              array[j] = temp;                                 //2(n)
            }
        
      }
        //adapted from notes, tutorials, and https://www.geeksforgeeks.org/merge-sort/
        void merge(int arr[], int l, int m, int r) //This function is used for merging two halves
        {
            // Find sizes of two subarrays to be merged
            int n1 = m - l + 1;
            int n2 = r - m;
             /* Create temp arrays */
            int L[] = new int[n1];
            int R[] = new int[n2];
      
            /*Copy data to temp arrays*/
            for (int i = 0; i < n1; ++i)
                L[i] = arr[l + i];
            for (int j = 0; j < n2; ++j)
                R[j] = arr[m + 1 + j];
      
            /* Merge the temp arrays */
            // Initial indexes of first and second subarrays
            int i = 0, j = 0;
      
            // Initial index of merged subarray array
            int k = l;
            while (i < n1 && j < n2) 
            {
                if (L[i] <= R[j]) 
                {
                    arr[k] = L[i];
                    i++;
                }
                else {
                    arr[k] = R[j];
                    j++;
                }
                k++;
            }
      
            /* Copy remaining elements of L[] if any */
            while (i < n1) 
            {
                arr[k] = L[i];
                i++;
                k++;
            }
            /* Copy remaining elements of R[] if any */
            while (j < n2) {
                arr[k] = R[j];
                j++;
                k++;
            }
        }
      
        void mergeSort(int arr[], int l, int r) //Main function that sorts the array using the merge Sort algorithm
        {                                       //complexity analysis
            if (l < r)                          //1
            {
                
                int m =l+ (r-l)/2;              //1
      
                mergeSort(arr, l, m);           //log n
                mergeSort(arr, m + 1, r);       //log n
      
                merge(arr, l, m, r);            //n
            }
        }
       
    
        //adapted from notes, tutorials, and https://www.geeksforgeeks.org/bubble-sort/
        public void bubbleSort(int array[]) 
         {                                                  //complexity analysis
             
            for(int i = 0; i < array.length - 1; i++)       //1 + (n+1) + n   
            {
                for(int j = 0; j < array.length - i - 1; j++) //n + n(n+1) + n(n)
                {
                    if(array[j] > array[j + 1]) //3(n)
                    { 
                        // swap arr[j+1] and arr[j] 
                        int temp = array[j]; //2(n) 
                        array[j] = array[j + 1]; //2(n)
                        array[j + 1] = temp; //n
                    } 
                }
            } 
                
                   
         } 
    
}
