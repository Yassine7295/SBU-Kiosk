/**
*Yassine Khaliqui
*109050245
*Homework Assignment Number 5
*CSE 214 Recitation Section 06
*Recitation TA: Kevin Flyangolts 
*Grading TA: Zheyuan (Jeffrey) Gao;
*@author Yassine
*/
import java.util.Scanner;

public class Tree {
	TreeNode root, cursor, parent;
	Scanner s;
	String input, pointer, order;
	String sentence = "";
	String[] array;
	/**
	 * Creates a Tree object with the root set to null.
	 */
	Tree() {
		root = null;
		cursor = root;
	}
	/**
	 * Sets a TreeNode as the root of the Tree.
	 * @param node: the desired root
	 */
	public void setRoot(TreeNode node) {
		node.setLeft(null);
		node.setMiddle(null);
		node.setRight(null);
		this.root = node;
		this.cursor = node;
	}
	/**
	 * Returns the root of the Tree.
	 * @return: the root as a TreeNode object
	 * @throws EmptyTreeException: Cannot get the information from an empty tree.
	 */
	public TreeNode getRoot() throws EmptyTreeException{
		if(root == null)
			throw new EmptyTreeException();
		return root;
	}
	/**
	 * Retrieves a TreeNode from a Tree, if the TreeNode exists, else null.
	 * @param name: name of the desired TreeNode
	 * <dt><b>Precondition:</b><dd> This Tree object has been initialized.
	 * @return: the found TreeNode or null
	 * @throws EmptyTreeException: Cannot get the information from an empty tree.
	 */
	public TreeNode findNode(String name) throws EmptyTreeException {
		if(root == null)
			throw new EmptyTreeException();
		return finder(root, name);
	}
	/**
	 * Helper recursive method for the findNode method.
	 * @param node: a reference node that traverses the Tree
	 * @param name: name of the desired TreeNode
	 * <dt><b>Precondition:</b><dd> This Tree object has been initialized.
	 * @return: the found TreeNode or null
	 */
	public TreeNode finder(TreeNode node, String name){
		TreeNode result = null;
			if(node.getName().equalsIgnoreCase(name))
				return node;
			if(node.getLeft() != null && result == null)
				result = finder(node.getLeft(), name);
			if(node.getMiddle() != null && result == null)
				result = finder(node.getMiddle(), name);
			if(node.getRight() != null && result == null)
				result = finder(node.getRight(), name);
		return result;
	}
	/**
	 * Adds a TreeNode as the child of the desired parent node in a Tree.
	 * @param name: name of the node to be added
	 * @param selection: selection of the node to be added
	 * @param message: message of the node to be added
	 * @param parentName: the name of the parent node
	 * <dt><b>Precondition:</b><dd> This Tree object has been initialized.
	 * <dt><b>Postcondition:</b><dd> A TreeNode has been added to the Tree
	 * @return: a boolean value based on whether or not the node was added
	 * @throws EmptyTreeException: Cannot get the information from an empty tree.
	 */
	public boolean addNode(String name, String selection, String message, String parentName) throws EmptyTreeException {
		TreeNode newNode = new TreeNode(name, selection, message);
		TreeNode parent = findNode(parentName);
		if(parent != null){
			if(parent.getLeft() == null) {
				parent.setLeft(newNode);
				return true;
			}
			else if(parent.getMiddle() == null) {
				parent.setMiddle(newNode);
				return true;
			}
			else if(parent.getRight() == null) {
				parent.setRight(newNode);
				return true;
			}
			else{
				System.out.println("Subtree is full.");
				return false;
			}
		}
		else{
			System.out.println("Parent node not found.");
			return false;
		}
	}
	/**
	 * Prints the menu.
	 * @param parentInfo: the name of the root node of the Tree to be printed
	 * <dt><b>Precondition:</b><dd> This Tree object has been initialized.
	 * @throws EmptyTreeException: Cannot get the information from an empty tree.
	 */
	public void printMenu(String parentInfo) throws EmptyTreeException{
		 if(root == null)
			 throw new EmptyTreeException();
		 System.out.println("\nMenu:\n"
		 		+ "Dining\t\tSelection\t\t\t\t\tPrice\n"
		 		+ "-----------------------------------------------------------------------");
		 printing(root, "");
		 System.out.println();
	}
	 /**
	  * Helper method for the printMenu method.
	  * @param node: reference TreeNode that traverses the Tree
	  * @param s: String that accumulates data that is later printed
	  * <dt><b>Precondition:</b><dd> This Tree object has been initialized.
	  * @return: a String representation of the data
	  * @throws EmptyTreeException: Cannot get the information from an empty tree.
	  */
	public String printing(TreeNode node, String s) throws EmptyTreeException{
		 if(node == null)
			 throw new EmptyTreeException();
		 if(node == root){
				 printing(node.getLeft(), s);
				 printing(node.getMiddle(), s);
				 printing(node.getRight(), s);
		 }
		 if (node != root){
			 if(node.isLeaf()){
				 s += node.getSelection() + ", " + node.getMessage();
				 array = s.split(",");
				 sentence = "";
				 for(int i = 0; i < array.length; i++){
					 if(i == 0)
						 System.out.printf("%-15s", array[i]);
					 else if(i < array.length - 2)
						 sentence += array[i] + " ";
					 else if(i == array.length - 2){
						 sentence += array[i];
						 System.out.printf("%-48s", sentence);
					 }
					 else
						 System.out.print(array[i]);
				 }
				 System.out.println();
			 }
			 else 
				 s += node.getSelection() + ", ";
			 if(node.getLeft() != null){
				 printing(node.getLeft(), s);
			 }
			 if(node.getMiddle() != null){
				 printing(node.getMiddle(), s);
			 }
			 if(node.getRight() != null){
				 printing(node.getRight(), s);
			 }
			 return s;
		 }
		 return s;
	 }
	 /**
	  * Initiates the session for customers to use to order.
	  * <dt><b>Precondition:</b><dd> This Tree object has been initialized.
	  * @throws EmptyTreeException: Cannot get the information from an empty tree.
	  */
	 public void beginSession() throws EmptyTreeException {
		 if(root == null)
			 throw new EmptyTreeException();
		 s = new Scanner(System.in);
		 input = "";
		 System.out.println("\n" + root.getMessage());
		 printChildren(root);
		 input = s.nextLine();
		 cursor = root;
		 order  = "The order is: ";
		 while(!input.equalsIgnoreCase("0")){
			 if(cursor.isLeaf()){
			 System.out.print(order);
			 System.out.println(cursor.getMessage());
			 input = "0";
			 }
			 else if(input.equalsIgnoreCase("1") && cursor.getLeft() != null){
				 cursor = cursor.getLeft();
				 if(cursor.isLeaf()){
					 order += cursor.getSelection() + " has been sent to the kitchen. Your total is ";
					 System.out.print(order);
					 System.out.println(cursor.getMessage() + "\n");
					 input = "0";
				 }
				 else{
					 order += cursor.getSelection() + ", ";
					 System.out.println("\n" + cursor.getSelection());
					 printChildren(cursor);
					 input = s.nextLine();
				 }
			 }
			 else if(input.equalsIgnoreCase("2") && cursor.getMiddle() != null){
				 cursor = cursor.getMiddle();
				 if(cursor.isLeaf()){
					 order += cursor.getSelection() + " has been sent to the kitchen. Your total is ";
					 System.out.print(order);
					 System.out.println(cursor.getMessage() + "\n");
					 input = "0";
				 }
				 else{
					 order += cursor.getSelection() + ", ";
					 System.out.println("\n" + cursor.getSelection());
					 printChildren(cursor);
					 input = s.nextLine();
				 }
			 }
			 else if(input.equalsIgnoreCase("3") && cursor.getRight() != null){
			 	 cursor = cursor.getRight();
			 	 if(cursor.isLeaf()){
					 order += cursor.getSelection() + " has been sent to the kitchen. Your total is ";
					 System.out.print(order);
					 System.out.println(cursor.getMessage() + "\n");
					 input = "0";
				 }
			 	 else{
			 		 order += cursor.getSelection() + ", ";
				 	 System.out.println("\n" + cursor.getSelection());
					 printChildren(cursor);
					 input = s.nextLine();
			 	 }
			 }
			 else{
				 System.out.println("\nInvalid command.");
				 input = s.nextLine();
			 }
		 } 
	 }
	 /**
	  * Helper recursive method for the beginSession method. This method prints the children of a node.
	  * @param node: the parent node
	  * <dt><b>Precondition:</b><dd> This Tree object has been initialized.
	  * @throws EmptyTreeException: Cannot get the information from an empty tree.
	  */
	 public void printChildren(TreeNode node) throws EmptyTreeException{
		 if(node == null){
			 throw new EmptyTreeException();
		 }
		 else{
			 if(node.getLeft() != null)
				 System.out.println("1 " + node.getLeft().getSelection());
			 if(node.getMiddle() != null)
				 System.out.println("2 " + node.getMiddle().getSelection());
			 if(node.getRight() != null)
				 System.out.println("3 " + node.getRight().getSelection());
			 System.out.println("0 Exit Session");
		 }
	 }
}