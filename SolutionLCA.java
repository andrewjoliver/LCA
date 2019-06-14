import java.util.Stack;

class SolutionLCA{
	
	public static Node LCA(Node root, Node target1, Node target2){
		if (target1.data < root.data && target2.data < root.data){
			return LCA(root.left, target1, target2);
		}
		if (target1.data > root.data && target2.data > root.data){
			return LCA(root.right, target1, target2);
		}
		return root;
	}

	public static Node LCAStack(Node root, Node target1, Node target2){
		Stack<Node> myStack = new Stack<>();
		myStack.push(root);
		
		while (! myStack.isEmpty()){
			Node myNode = myStack.pop();

			if (target1.data < myNode.data && target2.data < myNode.data){
				myStack.push(myNode.left);
			}

			else if (target1.data > myNode.data && target2.data > myNode.data){
				myStack.push(myNode.right);
			}

			else{
				return myNode;
			}
		}
		return null;
	}

	static class Node { 
	    int data; 
	    Node right;
	    Node left;
	    Node(int val, Node rightChild, Node leftChild){
	    	data = val;
	    	right = rightChild;
	    	left = leftChild; 
	    }
	}

    public static void main(String args[]){
    	//				8
    	//			/ 	   \	
    	//		3			15	
    	//	  /   \
    	//	1		5
    	//		   / \
    	//		  4   7 

    	Node right3 = new Node(7, null, null);
    	Node left3 = new Node(4, null, null);
    	Node right2 = new Node(5, right3, left3);
    	
    	Node left2 = new Node(1, null, null);
    	Node left1 = new Node(3, right2, left2);
    	
    	Node right1 = new Node(15, null, null);
    	Node root = new Node(8, right1, left1);
    	
    	System.out.println(LCA(root, left3, right3).data);
    	System.out.println(LCAStack(root, left3, right3).data);
    }
}

