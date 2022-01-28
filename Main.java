// Java program to construct an expression tree
import java.util.Stack;
import java.util.*;
// Java program for expression tree
class Node {

  char value;
  Node left, right;

  Node(char item) {
    value = item;
    left = right = null;
  }
}

public class Main {

  // A utility function to check if 'c'
  // is an operator

  boolean isOperator(char c) {
    if (c == '+' || c == '-'
        || c == '*' || c == '/'
        || c == '^') {
      return true;
    }
    return false;
  }

  // Utility function to do inorder traversal
  void inorder(Node t) {
    if (t != null) {
      inorder(t.left);
      System.out.print(t.value + " ");
      inorder(t.right);
    }
  }
   void preorder(Node t) {
    if (t != null) {
        System.out.print(t.value + " ");
      inorder(t.left);
      inorder(t.right);
    }
  }
    void postorder(Node t) {
    if (t != null) {
      inorder(t.left);
      inorder(t.right);
      System.out.print(t.value + " ");
    }
  }

  // Returns root of constructed tree for given
  // postfix expression
  Node constructTree(char postfix[]) {
    Stack<Node> st = new Stack<Node>();
    Node t, t1, t2;

    // Traverse through every character of
    // input expression
    for (int i = 0; i < postfix.length; i++) {

      // If operand, simply push into stack
      if (!isOperator(postfix[i])) {
        t = new Node(postfix[i]);
        st.push(t);
      } else // operator
      {
        t = new Node(postfix[i]);

        // Pop two top nodes
        // Store top
        t1 = st.pop();   // Remove top
        t2 = st.pop();

        // make them children
        t.right = t1;
        t.left = t2;

        // System.out.println(t1 + "" + t2);
        // Add this subexpression to stack
        st.push(t);
      }
    }

    // only element will be root of expression
    // tree
    t = st.peek();
    st.pop();

    return t;
  }

  public static void main(String args[]) { 
 System.out.println("\n\t\t*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");   
  System.out.println("\n\t\t\t\tIMPLEMENTING THE EXPRESSION TREES USING BST\t\t\t\t\n");  
System.out.println("\n\t\t*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");  
System.out.println("Press  '1' to start");   
   Scanner sc = new Scanner(System.in);
  sc.nextInt();
 
   Main et = new Main();
   int ch=1;
  while(ch<=3 && ch>0)
   {
System.out.println("\n\t\t--*--MENU--*--");
System.out.println("\n\t\t1. Infix  \n\t\t2. Postfix\n\t\t3. Prefix\n\t\t4. Exit");
     System.out.println("\n\t\tEnter your choice: ");
     ch = sc.nextInt();
     switch(ch)
  {

   case 1: 
         
          String postfix = "ab*c-d+ef/*";
          char[] charArray = postfix.toCharArray(); 
          Node root = et.constructTree(charArray);
          System.out.println("\n\t\tINFIX EXPRESSION ");
          et.inorder(root);
          System.out.println(" ");   
          break;
case 2:
           System.out.println("\n\t\tPOSTFIX EXPRESSION ");
          String postfix1 = "ab+ed*f*-";
         char[] charArray1 = postfix1.toCharArray(); 
         Node root1 = et.constructTree(charArray1);
         et.postorder(root1);
         System.out.println(" ");
         break;
case 3:
       System.out.println("\n\t\tPREFIX EXPRESSION ");
       String postfix2 = "ab+cd-*";
       char[] charArray2 = postfix2.toCharArray(); 
       Node root2 = et.constructTree(charArray2);
       et.preorder(root2);
       System.out.println(" ");
       break;
         }
     }
  }
}