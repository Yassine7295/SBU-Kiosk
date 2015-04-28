/**
*Yassine Khaliqui
*109050245
*Homework Assignment Number 5
*CSE 214 Recitation Section 06
*Recitation TA: Kevin Flyangolts 
*Grading TA: Zheyuan (Jeffrey) Gao;
*@author Yassine
*/
public class TreeNode {
	private String name;
	private String selection;
	private String message;
	private TreeNode left;
	private TreeNode middle;
	private TreeNode right;
	/**
	 * Creates an object of type TreeNode with no parameters.
	 */
	TreeNode() {
		left = null;
		middle = null;
		right = null;
	}
	/**
	 * Creates an object of type TreeNode with parameters.
	 * @param name: the desired name String
	 * @param selection: the desired selection String
	 * @param message: the desired message String
	 */
	TreeNode(String name, String selection, String message) {
		this.name = name;
		this.selection = selection;
		this.message = message;
		left = null;
		middle = null;
		right = null;
	}
	/**
	 * Returns the name String of the object.
	 * @return: the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * Returns the selection String of the object.
	 * @return: the selection
	 */
	public String getSelection() {
		return selection;
	}
	/**
	 * Returns the message String of the object.
	 * @return: the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * The TreeNode object linked to the left of the parent node.
	 * @return: the left TreeNode
	 */
	public TreeNode getLeft() {
		return left;
	}
	/**
	 * The TreeNode object linked to the middle of the parent node.
	 * @return: the middle TreeNode
	 */
	public TreeNode getMiddle() {
		return middle;
	}
	/**
	 * The TreeNode object linked to the right of the parent node.
	 * @return: the right TreeNode
	 */
	public TreeNode getRight() {
		return right;
	}
	/**
	 * Sets a String to the name of a TreeNode.
	 * @param name: the desired name String
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Sets a String to the selection of a TreeNode.
	 * @param selection: the desired selection String
	 */
	public void setSelection(String selection) {
		this.selection = selection;
	}
	/**
	 * Sets a String to the message of a TreeNode.
	 * @param message: the desired message String
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * Sets a TreeNode to be the left child.
	 * @param left: the desired left child
	 */
	public void setLeft(TreeNode left) {
		this.left = left;
	}
	/**
	 * Sets a TreeNode to be the middle child.
	 * @param middle: the desired middle child
	 */
	public void setMiddle(TreeNode middle) {
		this.middle = middle;
	}
	/**
	 * Sets a TreeNode to be the right child.
	 * @param right: the desired right child
	 */
	public void setRight(TreeNode right) {
		this.right = right;
	}
	/**
	 * Returns whether or not the TreeNode is a leaf.
	 * @return: a boolean value of whether or not the TreeNode is a leaf
	 */
	public boolean isLeaf() {
		if(left == null && middle == null && right == null)
			return true;
		return false;
	}
	/**
	 * Returns a String representation of a TreeNode.
	 * @return: a String representation
	 */
	public String toString() {
		return getSelection() + " " + getName() + " " + getMessage();
	}
	
}
