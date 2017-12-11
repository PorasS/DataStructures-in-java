import java.util.Scanner;
public class LinkList1 {
    Node head=new Node();
    Node temp;
    Node temp1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkList1 ll=new LinkList1();
		int choice=0;
		Scanner s=new Scanner(System.in);	
		while(choice!=5) {
		System.out.println("Enter your choice : ");
		System.out.println("1:add element  2:add in Begining  3:add element at Nth poition  4:remove nth element 5:exit");
		choice=s.nextInt();
		switch(choice){
			case 1:
				System.out.println("How many elements you want to add in a list :");
			int y=s.nextInt();
			for(int i=0;i<y;i++) {
				System.out.println("Enter element :");
				int x=s.nextInt();
				ll.add(x);
			 }
			break;
			case 2:
				System.out.println("How many elements you want to add in a list :");
				int y1=s.nextInt();
				for(int i=0;i<y1;i++) {
					System.out.println("Enter element :");
					int x=s.nextInt();
					ll.addB(x);
				 }
				break;
			case 3:
				System.out.println("Enter the element :");
				int a=s.nextInt();
				System.out.println("Enter the position where you want to add element :");
				int n=s.nextInt();
				if(n!=1) {
					ll.addNth(a, n);
				}
				else {
					ll.addB(a);
				}
				
				break;
			case 4:
				System.out.println("Enter the position of the element you want to remove :");
				int pos=s.nextInt();
				ll.removeNth(pos);
				break;
			case 5:
				choice=5;
				break;
		  }
		}
		ll.print();

	}
	public void print() {
		temp=new Node();
		temp.setNadr(head);
		System.out.println("List Content  : ");
		while(temp.getNode().getNode()!=null) {
			temp.setNadr(temp.getNode().getNode());
			System.out.print(temp.getNode().getData());
			System.out.print(" ");
			
		}
	}
	public void removeNth(int n) {
		
		if(head.getNode()==null) {
			System.out.println("No elements to delete :");
		}
		else {
			if(n==1) {
				head.setNadr(head.getNode().getNode());
			}
			else {
				temp=new Node();
				temp1=new Node();
				temp.setNadr(head.getNode());
				temp1.setNadr(head.getNode());
				for(int i=1;i<=n-1;i++) {
					temp1.setNadr(temp1.getNode().getNode());
				}
				for(int i=1;i<=n-2;i++) {
					temp.setNadr(temp.getNode().getNode());
				}
				temp.getNode().setNadr(temp1.getNode().getNode());
			}
		}
		print();
		System.out.println();	
	}
	public void addNth(int a,int n) {
		temp=new Node();
		temp.setdata(a);
		if(head.getNode()==null) {
			head.setNadr(temp);
			System.out.println(n+" position is not available at the moment , add some more elements : ");
		}
		else {
			temp1=new Node();
			temp1.setNadr(head.getNode());
			for(int i=1;i<=n-2;i++){
				temp1.setNadr(temp1.getNode().getNode());
			}
			temp.setNadr(temp1.getNode().getNode());
			temp1.getNode().setNadr(temp);
		}
		print();
		System.out.println();	
		
	}
	public void add(int d) {
		temp1=new Node();
		temp=new Node();
		temp.setdata(d);
		temp.setNadr(null);
		if(head.getNode()==null) {
			head.setNadr(temp);
		}else {
	    temp1.setNadr(head.getNode());
	    while(temp1.getNode().getNode()!=null) {
	    	temp1.setNadr(temp1.getNode().getNode());
	    	
	    }
	    temp1.getNode().setNadr(temp);
	    }
		print();
		System.out.println();
	}
	public void addB(int a) {
	 temp=new Node();
	 temp.setdata(a);
	 if(head.getNode()==null) {
		 temp.setNadr(null);
		 head.setNadr(temp);
	 }
	 else {
		 temp.setNadr(head.getNode());
		 head.setNadr(temp);
	 }
	 print();
	 System.out.println("");
	}

}
