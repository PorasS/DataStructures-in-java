import java.util.Scanner;
public class PostfixJ {
    Node head=new Node();
    String str;
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		PostfixJ pj=new PostfixJ();
		System.out.println("Enter a postFix Expression :");
		String str1=s.nextLine();
		pj.postfix(str1);
		System.out.println("========");
		pj.print();
	}
	public void postfix(String st) {
		str=st;
		for(int i=0;i<str.length();i++) {
		
			if(str.charAt(i)=='/'||str.charAt(i)=='^'||str.charAt(i)=='+'||str.charAt(i)=='-'||str.charAt(i)=='*') {
				System.out.println(str.charAt(i));
				int dt=opPer(str.charAt(i));
				Node temp=new Node();
				temp.setdata(dt);
				if(head.getNode()==null) {
					head.setNadr(temp);
				}else {
					temp.setNadr(head.getNode());
					head.setNadr(temp);
				}
				System.out.println(head.getNode().getData());
				
			}else {
				System.out.println(str.charAt(i));
				Node temp=new Node();
				temp.setdata(Character.getNumericValue(str.charAt(i)));
				if(head.getNode()==null) {
				head.setNadr(temp);
				}else {
					temp.setNadr(head.getNode());
					head.setNadr(temp);
				}
			}
		}
		
    }
	public void print() {
		Node temp=new Node();
		temp.setNadr(head.getNode());
		while(temp.getNode()!=null) {
			System.out.print(temp.getNode().getData());
			System.out.print(" ");
			temp.setNadr(temp.getNode().getNode());
		}
	}
	public int opPer(char ch) {
		int x=0;
		if(ch=='*') {
			int op2=head.getNode().getData();
			int op1=head.getNode().getNode().getData();
		    x=op1*op2;
		    head.setNadr(head.getNode().getNode().getNode());
		}else {
			if(ch=='^') {
				int op2=head.getNode().getData();
				int op1=head.getNode().getNode().getData();
			    x=op1^op2;
			    head.setNadr(head.getNode().getNode().getNode());
			}else {
				if(ch=='/') {
					int op2=head.getNode().getData();
					int op1=head.getNode().getNode().getData();
				    x=op1/op2;
				    head.setNadr(head.getNode().getNode().getNode());
				}else {
					if(ch=='+') {
						int op2=head.getNode().getData();
						int op1=head.getNode().getNode().getData();
					    x=op1+op2;
					    head.setNadr(head.getNode().getNode().getNode());
					}else {
						if(ch=='-') {
							int op2=head.getNode().getData();
							int op1=head.getNode().getNode().getData();
						    x=op1-op2;
						    head.setNadr(head.getNode().getNode().getNode());
						}
					}
				}
			}
		}
		
		return x;	
	}

}
