import java.util.Scanner;
public class QueueLink {
    Node head=new Node();
    Node rear=new Node();
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		QueueLink ql=new QueueLink();
		int flag=0;
		int choice=0;
		while(flag!=6) {
		  System.out.println("1:Enqueue  2:Dequeue  3:Front  4:IsEmpty  5:Queue Content  6:Exit");	
		  choice=s.nextInt();
		  switch(choice) {
		  case 1:
			  System.out.println("enter the element:");
			  int data=s.nextInt();
			  ql.enqueue(data);
			  break;
		  case 2:
			  ql.dequeue();
			  break;
		  case 3:
			  ql.front();
			  break;
		  case 4:
			  ql.isEmpty();
			  break;
		  case 5:
			  ql.print();
			  break;
		  case 6:
			  flag=6;
			  break;
			  
		  }
		}

	}
	public void print() {
		if(head.getNode()!=null) {
			Node temp=new Node();
			temp.setNadr(head.getNode());
			while(temp.getNode().getNode()!=null) {
				System.out.print(temp.getNode().getData());
				temp.setNadr(temp.getNode().getNode());
				System.out.print(" ");
			}
			System.out.println(temp.getNode().getData());
		
		}else {
			System.out.println("Queue is Empty:");
		}
			
	}
    public void enqueue(int data) {
    	Node temp=new Node();
    	temp.setdata(data);
    	if(head.getNode()==null) {
    		head.setNadr(temp);
    		rear.setNadr(temp);
    	}else {
    		rear.getNode().setNadr(temp);
    		rear.setNadr(temp);
    	}
    }
    public void dequeue() {
    	if(head.getNode()==null) {
    		System.out.println("Queue is empty:");
    	}else {
    		head.setNadr(head.getNode().getNode());
    	}
    }
    public void front() {
    	if(head.getNode()!=null) {
    		System.out.println(head.getNode().getData());
    	}else {
    		System.out.println("Queue is Empty:");
    	}
    	
    }
    public void isEmpty() {
    	if(head.getNode()==null) {
    		System.out.println("Queue is empty:");
    	}else {
    		System.out.println("Queue is not empty:");
    	}
    }
}
