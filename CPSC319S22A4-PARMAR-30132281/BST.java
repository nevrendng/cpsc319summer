/**
  @author Nolan Parmar <a
  href= "mailto: Nolan.parmar@ucalgary.ca">Nolan.parmar@ucalgary.ca</a>
  @version 1.1
  @since   1.0
  UCID: 30132281
 */


import java.util.*;


public class BST 
{
    Node root; //the top node of the tree 
    int size; // amount of words in the input file
    private class Node
    {
        String data;
        Node left; //left side of the tree
        Node right; //right side of the tree
        int frequency; //times the same word shows up

        public Node(String Data) //constructor to set the frequency when give the data from the input file 
        {
            data = Data;
            frequency = 1;
        }    

    }

    public BST() //constructor that sets the size to 0 before it goes throught the input file 
    {
        size = 0;
    }

    public void add(String Data) //
    {
		Node n = new Node(Data);
		if (root == null)
        {
            root = n;
        }
			
		else
        {
            add(root, n);
        }
			
	}
	
	private void add(Node t, Node current) //adds words to the tree 
    {
		if (current.data.compareTo(t.data) > 0) 
		{
			if (t.right == null)
			{
				t.right = current;
				return;
			}
			else
            {
                add(t.right, current);
            }
				
		}
		else if (current.data.compareTo(t.data) < 0) 
		{
			if (t.left == null)
			{
				t.left = current;
				return;
			}
			else
            {
                add(t.left, current);
            }
		}
		else if(current.data.compareTo(t.data) == 0)
        {
            t.frequency++;
			return;
        }
			
	}
	
	private int countPreorder(Node curr) 
    {
		if (curr == null)
        {
            return 0;
        }
		return 1 + countPreorder(curr.left) + countPreorder(curr.right);
	}

	public int countPreorder() 
    {
		return countPreorder(root);
	}
	
	
	
	private int uniquePreorder(Node curr)
	{
		if(curr == null)
		{
			return 0;
		}
		
		if(curr.frequency == 1)
		{
			return 1 + uniquePreorder(curr.left) + uniquePreorder(curr.right);
		}
		else
        {
            return 0 + uniquePreorder(curr.left) + uniquePreorder(curr.right);
        }
	}
	
	public int uniquePreorder()
	{
		return uniquePreorder(root);
	}
	
	
	private void preOrderPrint(Node curr)//prints the entire tree using preorder traversal
	{
		if(curr == null)
		{
			return;
		}
		System.out.print(curr.data + " ");
		preOrderPrint(curr.left);
		preOrderPrint(curr.right);
	}
	
	public void preOrderPrint()//constructor 
	{
		preOrderPrint(root);
	}
	
	private void postOrderPrint(Node curr)//prints the entire tree using postorder traversal
	{
		if(curr == null)
		{
			return;
		}
		postOrderPrint(curr.left);
		postOrderPrint(curr.right);
		System.out.print(curr.data + " ");
	}
	
	public void postOrderPrint()//constructor
	{
		postOrderPrint(root);
	}

	private void inOrderPrint(Node curr)//prints the entire tree using inorder traversal
	{
		if(curr == null)
		{
			return;
		}
		inOrderPrint(curr.left);
		System.out.print(curr.data + " ");
		inOrderPrint(curr.right);
	}
	
	public void inOrderPrint()//constructor
	{
		inOrderPrint(root);
	}
	
	private int largestPreorder(Node curr) //finds the path of the input file using preorder traversal
	{
		if(curr == null)
		{
			return 0;
		}
		
		int large = curr.frequency;
		int largeL = largestPreorder(curr.left);
		int largeR = largestPreorder(curr.right);
		if(large < largeR)
		{
			large = largeR;
		}
		if(large < largeL)
		{
			large = largeL;
		}
		return large;
	}
	
	public int largestPreorder()
	{
		return largestPreorder(root);
	}
	
	
	
	private void findLargest(Node curr, int largest)//finds the word that occurs the most often
	{
		if(curr == null)
		{
			return;
		}
		
		if(curr.frequency == largest)
		{
			System.out.println(curr.data + " = " + largest + " times");
		}
		findLargest(curr.left,largest);
		findLargest(curr.right,largest);
	}
	
	public void findLargest(int largest)//constructor 
	{
		findLargest(root, largest);
	}
	
	
	private int findWord(Node curr, String word)//finds specific words that are requested by the user.
	{
		if(curr != null)
		{
			if(curr.data.equals(word))
			{
				return curr.frequency;
			}
			else	
			{
				int found = findWord(curr.right, word);
				if(found == -1)
				{
					found = findWord(curr.left, word);
				}
				return found;
			}
		}
		else
		{
			return -1;
		}	
	}
	
	public int findWord(String word)//constructor when finding a specific word
	{
		return findWord(root, word);
	}
	
	private int maximumDepth(Node curr)//gives the result of the maximum depth of the tree
	{
		if(curr == null)
		{
			return 0;
		}
		int lDepth = maximumDepth(curr.left);
		int rDepth = maximumDepth(curr.right);
		
		if(lDepth > rDepth)
        {
            return (lDepth + 1);
        }
			
		else
        {
            return(rDepth + 1);
        }
			
	}
	
	public int maximumDepth()//constructor that returns the depth from the root
	{
		return maximumDepth(root);
	}

}
