import java.util.Scanner;
public class DoublyLinkList {
    Dnode head=new Dnode();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoublyLinkList dl=new DoublyLinkList();
		int flag=0;
		Scanner s=new Scanner(System.in);
		
       while(flag!=7) {
    	   System.out.println("Enter your choice :");
   		   System.out.println("1:Add element  2:print in forDir  3:Add in Beginning  4:Add at Nth position  5:remove nth element  6:print in rev  7:Exit");
   		   int choice=s.nextInt();
    	    switch(choice) {
    	    case 1:
    	    	System.out.println("No of elements to add:");
    	    	int n =s.nextInt();
    	    	for(int i=0;i<n;i++) {
    	    	System.out.println("Enter element:");
    	    	int d=s.nextInt();
    	    	dl.add(d);
    	    	dl.printFor();
    	    	}
    	    	break;
    	    case 2:
    	    	dl.printFor();
    	    	break;
    	    case 3:
    	    	System.out.println("No of elements to add:");
    	    	int n1 =s.nextInt();
    	    	for(int i=0;i<n1;i++) {
    	    	System.out.println("Enter element:");
    	    	int d=s.nextInt();
    	    	dl.addBg(d);
    	    	dl.printFor();
    	    	}
    	    	break;
    	    case 4:
    	    	System.out.println("Enter element :");
    	    	int d=s.nextInt();
    	    	System.out.println("Enter the position :");
    	    	int n3=s.nextInt();
    	    	dl.addNth(d,n3);
    	    	dl.printFor();
    	    	break;
    	    case 5:
    	    	System.out.println("Enter the position :");
    	    	int pos=s.nextInt();	
    	    	dl.deleteNth(pos);
    	    	dl.printFor();
    	    	break;
    	    case 6:
    	    	dl.printRev();
    	    	break;
    	    case 7:
    	    	flag=7;
    	    	break;
    	    }
       }
	}
	public void printRev() {
		Dnode temp=new Dnode();
		temp.setNext(head.getNext());
		while(temp.getNext().getNext()!=null) {
			temp.setNext(temp.getNext().getNext());
		}
		while(temp.getNext()!=head.getNext()) {
			System.out.print(temp.getNext().getData());
			System.out.print(" ");
			temp.setNext(temp.getNext().getPrev());
		}
		System.out.print(temp.getNext().getData());
		System.out.println(" ");
	}
	public void deleteNth(int n) {
		Dnode temp=new Dnode();
		temp.setNext(head.getNext());
		for(int i=0;i<n-2;i++) {
			temp.setNext(temp.getNext().getNext());
			
		}
		Dnode temp1=new Dnode();
		temp1.setNext(temp.getNext().getNext());
		if(temp1.getNext().getNext()!=null) {
			temp1.setNext(temp1.getNext().getNext());
			temp.getNext().setNext(temp1.getNext());
			temp1.getNext().setPrev(temp.getNext());
		}
		else {
			temp.getNext().setNext(null);
			temp1.getNext().setPrev(null);
		}
	}
	public void addNth(int d,int n) {
		Dnode temp=new Dnode();
		temp.setData(d);
		try {
		if(n==1) {
			addBg(d);
		}else{
			Dnode temp1=new Dnode();
			temp1.setNext(head.getNext());
			for(int i=1;i<n-1;i++){
				temp1.setNext(temp1.getNext().getNext());
			}
			temp.setPrev(temp1.getNext());
			temp.setNext(temp.getPrev().getNext());
			temp.getPrev().setNext(temp);
			temp.getNext().setPrev(temp);
		}
		}catch(Exception e) {
			System.out.println("Add elements 1st. "+n+" position is not available :");
		}
	}
	 public void addBg(int d) {
		 Dnode temp=new Dnode();
		 temp.setData(d);
		 if(head.getNext()==null) {
			 head.setNext(temp);
		 }else {
			 temp.setNext(head.getNext());
			 temp.getNext().setPrev(temp);
			 head.setNext(temp);
		 }
		
	 }
	 public void add(int d) {
	 Dnode temp=new Dnode();
	 temp.setData(d);
	 if(head.getNext()==null) {
		 head.setNext(temp);
	 }else {
		 Dnode temp1=new Dnode();
		 temp1.setNext(head.getNext());
		 while(temp1.getNext().getNext()!=null) {
			 temp1.setNext(temp1.getNext().getNext());
		 }
		 temp1.getNext().setNext(temp);
		 temp.setPrev(temp1.getNext());
	 }
	 
	}
	 public void printFor() {
		 Dnode temp=new Dnode();
		 System.out.println("list content:");
		 if(head.getNext()!=null) {
			 temp.setNext(head.getNext());
			 while(temp.getNext().getNext()!=null) {
				 System.out.print(" ");
				 System.out.print(temp.getNext().getData());
				 temp.setNext(temp.getNext().getNext());
			 }
			 System.out.print(" ");
			 System.out.print(temp.getNext().getData());
			 System.out.println();
		 }else {
			 System.out.println("No element to print :");
		 }
		 
		 
	 }

}
