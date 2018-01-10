//without using predefined stack class
import java.util.Scanner;
public class RevStrStack {

	public static void main(String[] args) {
	Scanner s=new Scanner(System.in);	
	System.out.println(" Enter a String ");
	String st=s.nextLine();
	char arr1[]=new char[st.length()];
	char arr[]=new char[st.length()];
	int top=-1;
	for(int i=0;i<st.length();i++) {
		top++;
		arr[i]=st.charAt(i);
	}
	for(int i=0;i<st.length();i++) {
		arr1[i]=arr[top];
		top--;
	}
	st=String.valueOf(arr1);
	System.out.println(st);
	

	}

}
