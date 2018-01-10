import java.util.Scanner;
public class RevLinkListStack {
     Node head=new Node();
     Node temp1=new Node();
	 public static void main(String[] args) {
	 Scanner s=new Scanner(System.in);
	 RevLinkListStack rv=new RevLinkListStack();
	 System.out.println("Enter a String:");	
	 String str=s.nextLine();
	 rv.createLinkedList(str);
	 System.out.println("LinkedList created:");
     rv.reverse(str.length());
     System.out.println("LinkedList reversed:");
     System.out.println("=======================");
     System.out.println("Printed in reversed order:");
     rv.print();
     
	}
	 public void print() {
		 temp1.setNadr(head.getNode());
		 while(temp1.getNode().getNode()!=null) {
			 System.out.print(temp1.getNode().getChar());
			 temp1.setNadr(temp1.getNode().getNode());
		 }
		 System.out.print(temp1.getNode().getChar());
	 }
  public void createLinkedList(String st) {
	  for(int i=0;i<st.length();i++) {
		  if(head.getNode()==null) {
			 Node temp=new Node();
			 temp.setChar(st.charAt(i));
			 head.setNadr(temp);
			 temp1.setNadr(temp);
		  }else {
			  Node temp=new Node();
			  temp.setChar(st.charAt(i));
			  temp1.getNode().setNadr(temp);
			  temp1.setNadr(temp);
		  }
	  }
	  temp1.getNode().setNadr(null);
	 // System.out.println(head.getNode().getChar());
	  }
  public void reverse(int len) {
	  Node array[]=new Node[len];
	  int top=-1;
	  temp1.setNadr(head.getNode());
	  for(int i=0;i<len;i++) {
		  top++;
		  array[top]=temp1.getNode();
		  temp1.setNadr(temp1.getNode().getNode());
	  }
	  head.setNadr(array[top]);
	  temp1.setNadr(array[top]);
	  while(top!=0) {
		  top--;
		  temp1.getNode().setNadr(array[top]);
		  temp1.setNadr(array[top]);
	  }
	  temp1.getNode().setNadr(null);
	  
  }
}
