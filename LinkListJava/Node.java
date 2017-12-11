
public class Node {
     int data;
     Node nadr;
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
	
}
