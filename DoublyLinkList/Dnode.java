
public class Dnode {
Dnode prev;
int data;
Dnode next;
  public Dnode getNext() {
	return next;
    }
  public Dnode getPrev() {
	return prev;
    }
   public void setNext(Dnode d) {
	   next=d;
   }
   public void setPrev(Dnode d) {
	   prev=d;
   }
   public void setData(int d) {
	   data=d;
   }
   public int getData() {
	   return data;
   }
}
