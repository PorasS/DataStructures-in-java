import java.util.Scanner;
public class StackLink {
    Node head=new Node();
	public static void main(String[] args) {
    Scanner s=new Scanner(System.in);
    StackLink sl=new StackLink();
    int flag=0;
    while(flag!=5) {
    	System.out.println("1:push  2:pop  3:IsEmpty  4:Top element  5:Exit");
    	System.out.println("Enter your choice:");
    	int choice=s.nextInt();
    	switch(choice) {
    	case 1:
    		System.out.println("Enter the Element:");
    		int no=s.nextInt();
           sl.push(no);
    		break;
    	case 2:
    		sl.pop();
    		break;
    	case 3:
    		sl.isEmpty();
    		break;
    	case 4:
    		sl.topEl();
    		break;
    	case 5:
    		flag=5;
    		break;
        }
    	
     }
    }
	public void pop() {
		head.setNadr(head.getNode().getNode());
	}
	public void isEmpty() {
		if(head.getNode()==null) {
			System.out.println("Stack is Empty , Enter some elements :");
		}else {
			System.out.println("Stack is not Empty :");
		}
	}
	public void topEl() {
		System.out.println(head.getNode().getData());
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
      }
}
