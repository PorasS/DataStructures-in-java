import java.util.Scanner; 
public class QueueJ {
  int f=-1;
  int r=-1;
  int arr[];
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		QueueJ q=new QueueJ();
		int flag=0;
		System.out.println("how many elements you want to enter in queue:");
		int no=s.nextInt();
		q.create(no);
		while(flag!=7) {
			System.out.println("1:enqueue  2:Dequeue  3:front  4:IsEMpty  5:Queue content  6:Exit ");
			System.out.println("Enter your choice: ");
		    int choice=s.nextInt();
            switch(choice) {
            case 1:
            	System.out.println("Enter the element:");
            	int x=s.nextInt();
            	q.enqueue(x);
            	break;
            case 2:
            	q.dequeue();
            	break;
            case 3:
            	System.out.println(q.front());
            	break;
            case 4:
            	q.isEmpty();
            	break;
            case 5:
            	q.print();
            	break;
            case 6:
            	flag=6;
            	break;
            	
			}
		}
	}
	public void print() {
		for(int i=0;i<arr.length;i++) {
			System.out.print(" ");
			System.out.print(arr[i]);
		}
		System.out.println(" ");
	}
	public void isEmpty() {
		if(f==-1&&r==-1) {
			System.out.println("Empty:");
		}
	}
	public int front() {
		if(f==-1) {
			System.out.println("Queue is empty:");
			return 0;
		}else {
			 return arr[f];
		}
		 	
		}
	public void dequeue() {
		if(f==-1&&r==-1) {
			System.out.println("queue is empty:");
		}else {
			if(r==f) {
				r=-1;
				f=-1;
			}else {
				f=(f+1)%arr.length;
			}
		}
		
	}
	public void create(int n) {
		arr=new int[n];
	}
	public void enqueue(int dt) {
		if(f==-1&&r==-1) {
			f=0;
			r=0;
		}else {
			if((r+1)%arr.length==f) {
				System.out.println("queue is full:");
			}
			r=(r+1)%arr.length;
		}
		arr[r]=dt;	
	}
}
