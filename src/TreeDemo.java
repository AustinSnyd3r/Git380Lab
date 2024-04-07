class Node{
   int value;
   Node left, right;
   
   public Node(int value){
      this.value = value;
      left = null;
      right = null;
   }

}

class BinarySearchTree{

   Node root;


   /**
    * A method to insert a node into a bst.
    * @param root The root of the tree that the new value will be inserted into. Type: Node
    * @param value Integer that represents the node value that will be inserted. Type: int
    * @return  Returns the root of the binary search tree. Type: Node
    */
   public Node insert(Node root, int value){
      //base case
      if(root == null){
         root = new Node(value);
         return root;
      }
      
      //recursive step
      if(value < root.value){
         root.left = insert(root.left, value); 
      }else{
         root.right = insert(root.right, value);
      }
      
      return root;
   }


   /**
    * Function to print the pre order traversal of a binary search tree
    * @param root
    */
   public void preOrderTraversal(Node root){
      //if the root isnt null we go recursively L R then Node
      if(root != null){
         //Print the node
         System.out.println(root.value + ", ");
         //recurse left
         postOrderTraversal(root.left);
         //recurse right
         postOrderTraversal(root.right);
      }
      //Returns here back down callstack to go down different paths of tree
   }


   /**
    * Function that prints out the inOrder of the bst
    * @param root Node that is the root of bst
    */
   public void inOrderTraversal(Node root){
      //if the root isnt null we go recursively L R then Node
      if(root != null){
         //recurse left
         postOrderTraversal(root.left);

         //print the node
         System.out.println(root.value + ", ");

         //recurse right
         postOrderTraversal(root.right);
      }

      //Returns here back down callstack to go down different paths of tree
   }


   /**
    * Function that goes through a bst in post-order: LRN
    * @param root The Node root of the bst.
    */
   public void postOrderTraversal(Node root){

      //if the root isnt null we go recursively L R then Node
      if(root != null){
         //recurse left
         postOrderTraversal(root.left);
         //recurse right
         postOrderTraversal(root.right);
         System.out.println(root.value + ", ");
      }

      //Returns here back down callstack to go down different paths of tree
   }


   /**
    * A function that checks if a key is included in a binary search tree.
    * @param root This is the root of the tree that the search starts from. Type: Node
    * @param key  This is an integer value that is searched for in the tree.
    * @return Returns true if key is found in the tree, false if not found.
    */
   public boolean find(Node root, int key){
      //base case: reached a null pointer
      if(root == null){
         return false;
      }

      //base case: found the key
	  if(root.value == key){
         return true;
      }

      //if the key is bigger we can decide to go to the right side.
      if(key > root.value){
         return find(root.right, key);
      }

      //recursive call to the left
      return find(root.left, key);
   }


   /**
    * Function to find the smallest value within a binary search tree.
    * @param root The root of the tree that will be searched. Type: Node
    * @return  The smallest int value in the tree.
    */
   public int getMin(Node root){
      //base case
      if(root == null){
         return Integer.MAX_VALUE;
      }

      //initialize a curr node
      Node curr = root;

      //push the current node "pointer" all the way to left
      //this will have the smallest value
      while(curr.left != null){
         //shift curr left
         curr = curr.left;
      }

      return curr.value;
   }


   /**
    * A method for finding the greatest value in the bst
    * @param root This is the root node of the tree that will be searched.
    * @return Returns the max node value of the tree as an int.
    */
   public int getMax(Node root){
      //base case
      if(root == null){
         return Integer.MIN_VALUE;
      }

      //initialize a curr node
      Node curr = root;

      //push the current node "pointer" all the way to right side of tree
      //this will have the greatest value
      while(curr.right != null){
         //shift curr
         curr = curr.right;
      }

      return curr.value;
   }
   
   
   
   /*
   this method will not compile until getMax
   is implemented
   */
   public Node delete(Node root, int key){
      
      if(root == null){
         return root;
      }else if(key < root.value){
         root.left = delete(root.left, key);
      }else if(key > root.value){
         root.right = delete(root.right, key);
      }else{
         //node has been found
         if(root.left==null && root.right==null){
            //case #1: leaf node
            root = null;
         }else if(root.right == null){
            //case #2 : only left child
            root = root.left;
         }else if(root.left == null){
            //case #2 : only right child
            root = root.right;
         }else{
            //case #3 : 2 children
            root.value = getMax(root.left);
            root.left = delete(root.left, root.value);
         }
      }
      return root;  
   }
   
   
   
}



public class TreeDemo{
   public static void main(String[] args){
      BinarySearchTree t1  = new BinarySearchTree();
      Node root = t1.root;
      t1.insert(root,24);
      t1.insert(root,80);
      t1.insert(root,18);
      t1.insert(root,9);
      t1.insert(root,90);
      t1.insert(root,22);
            
      System.out.print("in-order :   ");
      t1.inOrderTraversal(t1.root);
      System.out.println();
           
      
   }  
}