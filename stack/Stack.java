import java.util.Scanner;
public class Stack {
	   int arr[]=new int [5];;
	   int top=-1;
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		Stack st=new Stack();
	   
	   int flag=0;
	   while(flag!=6) {
		   System.out.println("1:push  2:pop  3:top  4:IsEmpty  5:print Stack  6:Exit");
		   int choice=s.nextInt();
	   switch(choice) {
	   case 1:
		   System.out.println("Enter element:");
		   int no=s.nextInt();
            st.push(no);
            break;
	   case 2:
		   st.pop();
		   break;
	   case 3:
		   System.out.println(st.top());
		   break;
	   case 4:
		   st.isEmpty();
		   break;
	   case 5:
		   st.print();
		   break;
	   case 6:
		   flag=6;
		   break;
	   
	   }
	   }
	}
	public void print() {
		for(int i=0;i<=top;i++) {
			System.out.println(arr[top-i]);
			
		}
	}
      public void push(int no) {
    	  if(top!=arr.length-1) {
		  top++;
		  arr[top]=no;
	  }
	  else {
		  int arr1[]=new int[(arr.length)*2];
		  for(int i=0;i<arr.length;i++) {
			  arr1[i]=arr[i];
			  System.out.print(arr1[i]);
			  System.out.print(" ");
		  }
		  top++;
		  arr1[top]=no;
		  arr=arr1; 
		  }
		
	  }
      public void isEmpty() {
    	  if(top==-1) {
    		  System.out.println("Stack is empty add elements:");
    	  }else {
    		  System.out.println("Stack is not empty:");
    	  }
      }
      public void pop() {
    	  if(top!=-1) {
    		  top--;  
    	  }
    	  else {
    		  System.out.println("Stack is Empty:");
    	  }
      }
      public int top() {
    	  return(arr[top]);
      }
}
