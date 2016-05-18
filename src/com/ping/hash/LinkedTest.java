package com.ping.hash;

public class LinkedTest {
	
	/**
	 * 遍历实现
	 * @param head
	 * @return
	 */
	public Node reverseOne(Node head){
		if(head == null || head.next == null){
			return head;
		}
		Node p = head;
		Node q = head.next;
		head.next = null;
		
		Node r;
		while(q != null){
			r = q.next;
			q.next = p;
			p = q;
			q = r;
		}
		head = p;
		return head;
	}
	
	/**
	 * 使用递归实现反转
	 * @param current
	 * @return
	 */
	public Node reverse(Node current){
	     if (current == null || current.next == null){
	    	 return current;
	     }
	     Node nextNode = current.next;
	     current.next = null;
	     Node reverseRest = reverse(nextNode);
	     nextNode.next = current;
	     return reverseRest;
	 }
	
	/**
	 * 添加一个Node
	 * @param value
	 * @param head
	 * @return
	 */
	public static Node add(String value,Node head){
		if(head == null){
			return new Node(value,null);
		}
		Node last = new Node(value,null);
		Node p = head;
		while(head.next != null){
			head = head.next;
		}
		head.next = last;
		return p;
	}
	
	
	
	
	
	public static void main(String[] args){
		
	}
	
	
}

/**
 * 定义一个节点类型
 * @author 
 *
 * 2016年3月16日 下午2:18:21
 */
class Node{
	
	public String value;
	
	public Node next;
	
	public Node(String value,Node next){
		this.value = value;
		this.next = next;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
}
