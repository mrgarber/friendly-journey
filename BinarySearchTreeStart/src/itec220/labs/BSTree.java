package itec220.labs;

import java.util.ArrayList;
import java.util.Comparator;

import javafx.scene.Parent;

@SuppressWarnings("unused")
public class BSTree <Key extends Comparable<Key>, Value> implements BinarySearchTree<Key, Value>  {
	
	
	public Node<Key, Value> root;
	
	private Comparator<Key> comparator;
	
	private int size = 0;
	
	private ArrayList<Value> list = new ArrayList<Value>();
 
	
	public BSTree() {
		this.comparator = (k1 , k2) -> {return k1.compareTo(k2);};
	}
	
	public BSTree(Comparator<Key> comparator) {
		
		super();
		this.comparator = comparator;
	}
	
	public static class Node<Key extends Comparable<Key>, Value> 
	{
				
		public Node(Key key, Value data) {
			// this is a leaf node
			super();			
			this.data = data;
			this.key = key;
			this.rightChild = null;
			this.leftChild = null;
		}

		 public Key key;		 
		 public Value data;		
		 public Node<Key, Value> rightChild;		
		 public Node<Key, Value> leftChild;
	}
	
	   
   
 
	@Override
	public void printTree(Traversal order) {
		ArrayList<Value> temp = values(order);
			for(Value item : temp) {
				System.out.println(item);
			}
	}
	
	public void traversePostOrder(Node<Key, Value> node) {
	    if (node != null) {
	        traversePostOrder(node.leftChild);
	        traversePostOrder(node.rightChild);
	        list.add(node.data);
	    }
	}
	
	public void traversePreOrder(Node<Key, Value> node) {
	    if (node != null) {
	    	list.add(node.data);
	        traversePreOrder(node.leftChild);
	        traversePreOrder(node.rightChild);
	    }
	}
	
	public void traverseInOrder(Node<Key, Value> node) {
	    if (node != null) {
	        traverseInOrder(node.leftChild);
	        list.add(node.data);
	        traverseInOrder(node.rightChild);
	    }
	}
	
	public void traverseLevelOrder(Node<Key, Value> node) {
	    QueueList<Node<Key, Value>> queue = new QueueList<Node<Key, Value>>();
	    queue.enqueue(node);

	    while (!queue.isEmpty()) {
	    	
	    	Node<Key, Value> removedNode = queue.dequeue();
	    	
	    	list.add(removedNode.data);
	    	
	    	if(removedNode.leftChild != null) {
	    		queue.enqueue(removedNode.leftChild);
	    	}
	    	
	    	if(removedNode.rightChild != null) {
	    		queue.enqueue(removedNode.rightChild);
	    	}
	    	

	    	
	    }
	}
	
	@Override
	public void clear() {
		root = new Node<Key, Value>(null, null);
		size = 0;
	}

	@Override
	public boolean insert(Key key, Value value) {
		Node<Key, Value> temp = root;
			while(temp != null) {
				int compared = (comparator.compare(key, temp.key));
				if(compared > 0) {
					if(temp.rightChild == null) {
						temp.rightChild = new Node<Key, Value>(key, value);
						size++;
						return true;
					} else {
						temp = temp.rightChild;
					}
				} else if(compared < 0) {
					if(temp.leftChild == null) {
						temp.leftChild = new Node<Key, Value>(key, value);
						size++;
						return true;
					} else {
						temp = temp.leftChild;
					}
				} else {
					return false;
				}

			}
			size++;
			root = new Node<Key, Value>(key, value);
			return true;
	}

	public boolean isEmpty()
	{
		if(size == 0) {
			return true;
		}
		return false;
	}
	@Override
	public int size() {
		
		return size;
	}

	@Override
	public boolean contains(Key key) {
		Node<Key, Value> temp = root;
		while(temp != null) {
			int compared = comparator.compare(key, temp.key);
			if(compared > 0){
				temp = temp.rightChild;
			} else if(compared < 0){
					temp = temp.leftChild;
			} else {
				return true;
			}
		}
			return false;
	}
	
	public Value remove(Key key) {
		if(!contains(key)) {
			clear();
			return null;
		}
		boolean isLeftChild = false;
		Node<Key, Value> child = null; 
		Node<Key, Value> temp = null;

		if(size == 1) {
			temp = root;
			root = null;
			size--;
			return temp.data;
		}
		
		if(comparator.compare(key, root.key) == 0) {
			Node<Key, Value> predesesor = predesesor(root);
			Value tempData = root.data;
			if(predesesor == null) {
				root = root.rightChild;
				size--;
				return tempData;
			}		
			
			Node<Key, Value> predParent = getParent(predesesor.key); 
			root.key = predesesor.key;  
			root.data = predesesor.data;
			
			if(comparator.compare(predParent.rightChild.key, predesesor.key) == 0) { 
				predParent.rightChild = predesesor.rightChild;
			} else {
				predParent.leftChild = predesesor.leftChild;
			}
			size--;
			return tempData;
		}
		
		Node<Key, Value> parent = getParent(key);
		
		if(parent.leftChild != null && comparator.compare(parent.leftChild.key, key) == 0){
			isLeftChild = true;
			child = parent.leftChild;
		} else {
			child = parent.rightChild;
		} 

		if(child.leftChild == null && child.rightChild == null) {
			Value tempData = child.data;
			if(isLeftChild) {
				parent.leftChild = null;
			} else {
				parent.rightChild = null;
			}
			size--;
			return tempData;
				
		} else if(child.leftChild == null && child.rightChild != null) {
			if(isLeftChild) {
				parent.leftChild = child.rightChild;
			} else {
				parent.rightChild = child.rightChild;
			}
			Value tempData = child.data;
			child = null;
			size--;
			return tempData;
				
		} else if(child.leftChild != null && child.rightChild == null) {
			if(isLeftChild) {
				parent.leftChild = child.leftChild;
			} else {
				parent.rightChild = child.leftChild;
			}
			Value tempData = child.data;
			child = null;
			size--;
			return tempData;
		} else {
			Node<Key, Value> predesesor = predesesor(child);
			Node<Key, Value> predParent = getParent(predesesor.key); 
			Value tempData = child.data;
			
			child.key = predesesor.key; 
			child.data = predesesor.data;			

			//comparator
			if(comparator.compare(predParent.rightChild.key,predesesor.key) == 0) { 
				predParent.rightChild = predesesor.rightChild;
			} else {
				predParent.leftChild = predesesor.leftChild;
			}
			
			size--;
			return tempData;
		}
	}
	
	private Node<Key, Value> getParent(Key key) {
		Node<Key, Value> parent = root; 
		while(parent != null) {

			if(parent.leftChild != null && (comparator.compare(parent.leftChild.key, key) == 0)) {
				return parent;
			} else if(parent.rightChild != null && (comparator.compare(parent.rightChild.key, key) == 0)) {
				return parent;
			} else if(comparator.compare(parent.key, key) > 0) {
				parent = parent.leftChild;
			} else if(comparator.compare(parent.key, key) < 0) {
				parent = parent.rightChild;
			} 
		}	
		return null;
	}

	private Node<Key, Value> predesesor(Node<Key, Value> node){
		Node<Key, Value> temp = node;
		if(temp.leftChild == null) {
			return null;
		}
			temp = temp.leftChild;
			while(temp.rightChild != null) {
				temp = temp.rightChild;
			}
			return temp;
	}
	
	public Value getRoot(){
		return root.data;
	}
	
	
	@Override
	public ArrayList<Value> values(Traversal order) {
		if(list.size() > 0) {
			list = new ArrayList<Value>();
		}
		Node<Key, Value> temp = root;
		// If only I had a method that got a list of the different traversals...
			if(BinarySearchTree.Traversal.POST_ORDER.equals(order)) {
				traversePostOrder(temp);
				return list;
			} else if(BinarySearchTree.Traversal.PRE_ORDER.equals(order)) {
				traversePreOrder(temp);
				return list;
			} else if(BinarySearchTree.Traversal.IN_ORDER.equals(order)) {
				traverseInOrder(temp);
				return list;
			} else if(BinarySearchTree.Traversal.LEVEL_ORDER.equals(order)) {
				list = new ArrayList<Value>();
				traverseLevelOrder(temp);
				return list;
			}
		return null;
	}
	
	@Override
	public Value findIteratively(Key key) {
			Node<Key, Value> current = root;
			while(!isEmpty() && current != null) {
				int compared = comparator.compare(key, current.key);
				if(compared > 0) {
					current = current.rightChild;
				} else if(compared < 0) {
					current = current.leftChild;
				} else {
					return current.data;
				}
			}
			
				return null;
	}

	private boolean insert(Node<Key,Value> current, Key key, Value value)
	{
		Node<Key, Value> node = find(current, key);
		int compared = comparator.compare(node.key, key);
		if(node == null) {
			return false;
		}
		if(compared > 0 && node.rightChild == null) {
			node.rightChild = new Node<Key, Value>(key, value); 
			return true;
		} else if(compared < 0 && node.leftChild == null){
			node.leftChild = new Node<Key, Value>(key, value);
			return true;
		} 
		return false;
		
	}
	
	private Node<Key,Value> find(Node<Key,Value> current, Key find)
	{
		if(current == null) {
			Node<Key, Value> node = new Node<Key, Value>(null, null);
			return node;
		}
			int compared = comparator.compare(current.key, find);
			if(compared == 0) {
				return current;
			}
			if(compared < 0){
				return find(current.rightChild, find);
			} else {
				return find(current.leftChild, find);
			}
	}

	@Override
	public Value findRecursively(Key key) {
		Node<Key, Value> node = find(root, key);
		return node.data;
	}
	
	

}
