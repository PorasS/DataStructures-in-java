import java.util.Scanner;
public class InfixToPostfix {
    Node head=new Node();
    String st;
	public static void main(String[] args) {
	Scanner s=new Scanner(System.in);	
	InfixToPostfix ip=new InfixToPostfix();
	System.out.println("Enter the Expression:");
	String str=s.nextLine();
	ip.implement(str);
	}
	public void print() {
		System.out.println("===PostFix===");
		System.out.println(st);
	}
	public void push(char ch) {
		Node temp=new Node();
		temp.setChar(ch);
		if(head.getNode()==null) {
			head.setNadr(temp);
		}else {
			temp.setNadr(head.getNode());
			head.setNadr(temp);
		}
	}
	public void pop() {
		while(head.getNode().getNode()!=null) {
			if(head.getNode().getChar()!='(') {
				st=st+head.getNode().getChar();
				head.setNadr(head.getNode().getNode());
			}else {
				head.setNadr(head.getNode().getNode());
			}
		}
		if(head.getNode().getChar()!='(') {
			st=st+head.getNode().getChar();
			head.setNadr(head.getNode().getNode());
		}
	}
   public void implement(String str) {
	   for(int i=0;i<str.length();i++) {
		   if(str.charAt(i)!=')') {
			   if(str.charAt(i)=='*'||str.charAt(i)=='+'||str.charAt(i)=='-'||str.charAt(i)=='^'||str.charAt(i)=='/'||str.charAt(i)=='(') {
					System.out.println("pushing "+str.charAt(i));
					push(str.charAt(i));
				}else {
					   if(st==null) {
						   st=Character.toString(str.charAt(i));
					   }else {
						   st=st+Character.toString(str.charAt(i));
					   }
				}
			
		   }else {
			   pop();
		   }
		}
	   if(head.getNode()!=null) {
		   pop();
	   }
	  
	   print();
   }
}
