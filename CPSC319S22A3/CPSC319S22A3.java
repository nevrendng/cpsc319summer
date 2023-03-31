/**
  @author Nolan Parmar <a
  href= "mailto: Nolan.parmar@ucalgary.ca">Nolan.parmar@ucalgary.ca</a>
  @version 1.1
  @since   1.0
  UCID: 30132281
 */


import java.util.ArrayList;
import java.util.*;
import java.io.*;

class Node 
{
	String word; 	//carried by the node
	Node next; 		// next node in the chain
	
	public Node(String wordValue)
	// Constructor
	{
		word = wordValue;
		next = null;
	}
    public Node(String wordValue, Node nextValue)//constructor to specify a node to point to 
    {
        next = nextValue;
        word = wordValue;
    }
    public String getData() //getter
    {
        return this.word;
    }
    public void setData(String wordValue) //setter
    {
        word = wordValue;
    }
    public Node getNext()  //getter
    {
		return this.next;
	}

	public void setNext(Node nextValue)  //setter
    {
		next = nextValue;
	}
   
}


class LinkedList 
{
	Node head; 		
	Node tail;
	
	public LinkedList()
	// Constructor
	{
		this.head = null;
		this.tail = null;
	}
    public void setHead(Node newHead) //setter
    {
        this.head = newHead;
    }
    public Node getHead() //getter
    {
        return this.head;
    }
    public LinkedList(String word)//constructor to create a list with a data point
    {
        insertTail(word);
    }
	
	public void insertTail(String word) // Insert a new node at the tail of the linked list
	{
		Node n = new Node(word);
		n .setNext(null);
        if(this.head == null)
        {
            this.head = n;
        }
        else
        {
            Node last = this.head;
            while(last.getNext() != null)
            {
                last = last.getNext();
            }
            last.setNext(n);    
        }
	}
    public Node insertionSort() //sorts the words in the linked list
    {
        Node temp = new Node(null);
        Node currNode = this.head;

        while (currNode != null) 
        {
            // At each iteration an element is inserted into the resulting list.
            Node prev = temp;

            // find the position to insert the current node
            while (prev.getNext() != null && prev.getNext().getData().compareTo(currNode.getData()) < 0) 
            {
                prev = prev.getNext();
            }

            Node next = currNode.getNext();
            // insert the current node to the new list
            currNode.setNext(prev.getNext());
            prev.setNext(currNode);

            // moving on to the next iteration
            currNode = next;
        }

        return temp.getNext();

    }
	
	public void display() // Print all of the words in the linked list
	{
		Node currNode = this.head;
        while(currNode != null)
        {
            System.out.print(currNode.getData() + " ");
            currNode = currNode.getNext();
        }
	}
    
    public String toString() // Method to print the LinkedList.
    {
        Node currNode = this.head;
        StringBuilder returnString = new StringBuilder(3000);
        String appendString = "";

        while (currNode != null) 
        {
            appendString = currNode.getData() + " ";
            returnString.append(appendString);

            // Go to next node
            currNode = currNode.getNext();
        }
        returnString.setLength(returnString.length() - 1);
        return returnString.toString();
    }
}

public class CPSC319S22A3 
{
    private String[] inputWordList;       // Word list to initially put file into
    private LinkedList[] linkedListB;   //used to create List B
    private String inputFile = "";    // Input file name

    private void readFile()//reads the input file and puts it into a 1-D array
    //referenced from notes, textbook, and https://www.geeksforgeeks.org/read-file-into-an-array-in-java/
   {
       

    
       // list that holds strings of a file
       List<String> listOfStrings = new ArrayList<String>();
       // load data from file
       BufferedReader bf;

       try 
       {
           bf = new BufferedReader(new FileReader(inputFile));
       } 
       catch (FileNotFoundException e) 
       {
           throw new RuntimeException(inputFile + " not found, " + e.getMessage());
       }

       try 
       {
           // read entire line as string
           String line = bf.readLine();

           // checking for end of file
           while (line != null) 
           {
               listOfStrings.add(line);
               line = bf.readLine();
           }
       } catch (Exception e)
       {
           throw new RuntimeException("Error reading file, exception caught " + e.getMessage());
       }

       // closing bufferreader object
       try 
       {
           bf.close();
       } 
       catch (IOException e) 
       {
           throw new RuntimeException("Error closing file, exception caught " + e.getMessage());
       }

       
       inputWordList = listOfStrings.toArray(new String[0]); // stores the data in arraylist to array

     
   }

    

    private char[] sortCharArray(char[] arr)//method used to sort words by characters when the first letter is the same
     //referenced from notes, textbook and  https://www.geeksforgeeks.org/sort-a-string-in-java-2-different-ways/
    {
       
        char temp;                                                      
        int i = 0;                                                      
        while (i < arr.length)                                                      
        {
            int j = i + 1;                                              
            while (j < arr.length)                                      
            {
                if (arr[j] < arr[i])                                    
                {

                    // Comparing the characters one by one
                    temp = arr[i];                                     
                    arr[i] = arr[j];                                    
                    arr[j] = temp;                                      
                }
                j += 1;                                                 
            }
            i += 1;                                                     
        }

        return arr;                                                     
        

    }

    private boolean findAnagrams(String first, String second)//checks if two strings are anagrams of eachother
    //referenced from source and textbook
    //https://stackoverflow.com/questions/2131997/checking-if-two-strings-are-permutations-of-each-other

    {
        if(first.length() != second.length())                       
        {
            return false;                                           
        }
        char[] x = first.toCharArray();                             
        char[] y = second.toCharArray();                            

        return Arrays.equals(sortCharArray(x), sortCharArray(y));   
        
    }
    
  
    private void quickSortLinkedListArrayAlg(LinkedList[] arr, int l, int h) 
    //l for the lowesr array index, h for the highest array index, and arr for the linkedlist array that gets quicksorted
    {
      

        // Quick sort algorithm
        int[] stack = new int[h - l + 1];
        int top = -1;
        stack[++top] = l;
        stack[++top] = h;

        while (top >= 0) 
        {
            h = stack[top--];
            l = stack[top--];
            int p = partitionLinkedListArray(arr, l, h);

            if (p - 1 > l) 
            {
                stack[++top] = l;
                stack[++top] = p - 1;
            }

            if (p + 1 < h) 
            {
                stack[++top] = p + 1;
                stack[++top] = h;
            }
        }
    }

  
    private int partitionLinkedListArray(LinkedList[] arr, int low, int high) //arr to select partition, low for the lowesr array index, high for the highest array index
    {

        LinkedList pivot = arr[high];

        int i = (low - 1);
        for (int j = low; j <= high - 1; j++) {
            if (arr[j].getHead().getData().compareTo(pivot.getHead().getData()) < 0) {
                i++;

                Node temp = arr[i].getHead();
                arr[i].setHead(arr[j].getHead());
                arr[j].setHead(temp);
            }
        }

        Node temp = arr[i + 1].getHead();
        arr[i + 1].setHead(arr[high].getHead());
        arr[high].setHead(temp);

        return i + 1;
    }
    private void quickSortLinkedListArray() //quicksorts the array of anagrams
    {
       quickSortLinkedListArrayAlg(linkedListB, 0, linkedListB.length - 1);

       
    }

    private void createLinkedListArray() //populates the linkedlist in the linkedlist array
    {
       
        linkedListB  = new LinkedList[inputWordList.length]; //listB has the size of the length of the inputfile

        linkedListB[0] = new LinkedList(inputWordList[0]);


        for(int j = 1; j < inputWordList.length; j++)
        {
            for(int i = 0; i < linkedListB.length; i++) 
            {
                if (linkedListB[i] != null) 
                {
                    if (findAnagrams(inputWordList[j], linkedListB[i].getHead().getData())) 
                    {
                        linkedListB[i].insertTail(inputWordList[j]);
                        break;
                    } 
                    
                } 
                else 
                {
                    linkedListB[i] = new LinkedList(inputWordList[j]);
                    break;
                }
            }
        }

       

        for (LinkedList linkedList : linkedListB) 
        {
            if (linkedList != null) 
            {
                linkedList.setHead(linkedList.insertionSort());
            }
        }

    }

    private void shrinkLinkedListArray() //removes the null values from the array 
    //referenced from source and textbook
    //https://stackoverflow.com/questions/4150233/remove-null-value-from-string-array-in-java
    {  


        ArrayList<LinkedList> list = new ArrayList<LinkedList>();
        for (LinkedList s : linkedListB)
        {
            if (s != null)
            {
                list.add(s);
            }    
        }
        linkedListB = list.toArray(new LinkedList[list.size()]);

      
    }

    private void output()//outputs the list to the command panel
    {
        for (LinkedList list : linkedListB) 
        {
          
            System.out.println(list.toString());
        }
    }
	
    
		
        	
	public CPSC319S22A3(String[] args)//executes the program
    {
        inputFile = args[0] + ".txt"; //first argument when inputting in the command line

        readFile();

        createLinkedListArray();

        shrinkLinkedListArray();

        quickSortLinkedListArray();

        output();

        
    }
	
	public static void main(String[] args) 
    {

		new CPSC319S22A3(args);
	}
}
