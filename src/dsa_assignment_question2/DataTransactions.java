package dsa_assignment_question2;

public class DataTransactions {
	public static Node node;
	static Node prevNode = null;
	static Node headNode = null;

	static void ConvertBinaryTreeToSkewedTree(Node root, int order) {

		if (root == null) {
			return;
		}
		if (order > 0) {
			ConvertBinaryTreeToSkewedTree(root.right, order);
		} else {
			ConvertBinaryTreeToSkewedTree(root.left, order);
		}
		Node rightNode = root.right;
		Node leftNode = root.left;

		// Condition to check if the root Node of skewed tree is not defined
		
		if (headNode == null) {
			headNode = root;
			root.left = null;
			prevNode = root;
		} else {
			prevNode.right = root;
			root.left = null;
			prevNode = root;
		}

		if (order > 0) {
			ConvertBinaryTreeToSkewedTree(leftNode, order);
		} else {
			ConvertBinaryTreeToSkewedTree(rightNode, order);
		}
	}

	// Traverse the right one skewed using recursion
	static void traverseRightSkewed(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(root.val + " ");
		traverseRightSkewed(root.right);
	}

	public static void main(String[] args) {
	
		DataTransactions tree = new DataTransactions();
		DataTransactions.node = new Node(50);
		DataTransactions.node.left = new Node(30);
		DataTransactions.node.right = new Node(60);
		DataTransactions.node.left.left = new Node(10);
		DataTransactions.node.right.left = new Node(55);

		int order = 0;
		ConvertBinaryTreeToSkewedTree(node, order);
		traverseRightSkewed(headNode);

	}

}
