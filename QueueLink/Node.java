
public class Node {
	 char ch;
     int data;
     Node nadr;
     public void setChar(char c) {
    	 ch=c;
     }
     public void setdata(int a) {
    	 data=a;
     }
	 public void setNadr(Node n) {
		 nadr=n;
	 }
	 public Node getNode() {
		 return nadr;
	 }
	 public int getData() {
		 return data;
	 }
	 public char getChar() {
		 return ch;
	 }
	 
	
}
