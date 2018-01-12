import java.util.Arrays;
import java.util.Scanner;
public class BalancedParan {
     Node head=new Node();
	public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
	BalancedParan bp=new BalancedParan();
	System.out.println("Enter expression:");
	String str =s.nextLine();
	char arr[]=new char[str.length()];
	//string to array
	for(int i=0;i<str.length();i++) {
		arr[i]=str.charAt(i);
	}
	System.out.println(Arrays.toString(arr));
	//
	for(int i=0;i<arr.length;i++) {
		if(arr[i]=='('||arr[i]=='['||arr[i]=='{') {
		   System.out.println(arr[i]); 
		   bp.push(arr[i]);	
		}
		if(arr[i]==')'||arr[i]==']'||arr[i]=='}') {
				System.out.println(arr[i]); 
				bp.pop(arr[i]);	
				 
				}
		}
	bp.print();
	bp.check();
	}
	public void print() {
		Node temp=new Node();
		temp.setNadr(head.getNode());
		while(temp.getNode()!=null) {
			System.out.println(temp.getNode().getChar());
			temp.setNadr(temp.getNode().getNode());
			
		}
	}
	public void check() {
		if(head.getNode()==null) {
			System.out.println("Balanced:");
		}else {
			System.out.println("not Balanced:");
		}
	}
	  public void push(char no) {
    	  Node temp=new Node();
    	  temp.setChar(no);
    	  if(head.getNode()==null) {
    		  head.setNadr(temp);
    	  }else {
    		temp.setNadr(head.getNode());
    		head.setNadr(temp);
    	  }
      }
 public void pop(char ch) {
	  if(head.getNode().getChar()=='{'&&ch=='}') {
		  if(head.getNode()!=null) {
				head.setNadr(head.getNode().getNode());
			}else {
				System.out.println("Stack is empty :");
			}
		  
	  }else {
		  if(head.getNode().getChar()=='('&&ch==')') {
			  if(head.getNode()!=null) {
					head.setNadr(head.getNode().getNode());
				}else {
					System.out.println("Stack is empty :");
				}
			  
		  }else {
			  if(head.getNode().getChar()=='['&&ch==']') {
				  if(head.getNode()!=null) {
						head.setNadr(head.getNode().getNode());
					}else {
						System.out.println("Stack is empty :");
					}
				  
			  }
		  }
	  }
		
		
	}
	 
 
 
}
