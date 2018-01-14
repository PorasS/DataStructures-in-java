import java.util.Scanner;
public class Prefixj {
   Node head=new Node();
   String str;
	public static void main(String[] args) {
	 Prefixj pj=new Prefixj();
	 Scanner s=new Scanner(System.in);
	 System.out.println("Enter the Expression :");
	 String st=s.nextLine();
	 pj.copy(st);
	 System.out.println("=====output=====");
	 pj.print();
	}
	public void print() {
		Node temp=new Node();
		temp.setNadr(head.getNode());
		System.out.println(temp.getNode().getData());
		
	}
	public void push(int no) {
		Node temp=new Node();
		temp.setdata(no);
		if(head.getNode()==null) {
			head.setNadr(temp);
		}else {
			temp.setNadr(head.getNode());
			head.setNadr(temp);
		}
		print();
	}
	public int pop(char ch) {
		int x=0;
		int op1=0;
		int op2=0;
		if(ch=='*') {
			op1=head.getNode().getData();
			op2=head.getNode().getNode().getData();
			x=op1*op2;
			head.setNadr(head.getNode().getNode().getNode());
			
		}else {
			if(ch=='^') {
				op1=head.getNode().getData();
				op2=head.getNode().getNode().getData();
				x=op1^op2;
				head.setNadr(head.getNode().getNode().getNode());
				
			}else {
				if(ch=='+') {
					op1=head.getNode().getData();
					op2=head.getNode().getNode().getData();
					x=op1+op2;
					head.setNadr(head.getNode().getNode().getNode());
					
				}else {
					if(ch=='-') {
						op1=head.getNode().getData();
						op2=head.getNode().getNode().getData();
						x=op1-op2;
						head.setNadr(head.getNode().getNode().getNode());
						
					}else {
						if(ch=='/') {
							op1=head.getNode().getData();
							op2=head.getNode().getNode().getData();
							x=op1/op2;
							head.setNadr(head.getNode().getNode().getNode());
							
						}
						
					}
					
				}
				
			}
			
		}
		return x;
		
	}
	public void copy(String st) {
		str=st;
		for(int i=str.length()-1;i>=0;i--) {
			if(str.charAt(i)=='^'||str.charAt(i)=='*'||str.charAt(i)=='/'||str.charAt(i)=='+'||str.charAt(i)=='-') {
				int dt=pop(str.charAt(i));
				push(dt);
			}else {
				push(Character.getNumericValue(str.charAt(i)));
					
				}
			}
		}
	}


