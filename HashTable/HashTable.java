import java.util.Scanner;
public class HashTable {
    HashNode table[];
    HashNode temp;
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
        HashTable ht=new HashTable();
        ht.createTable();
        int flag=0;
        while(flag!=3) {
        	System.out.println("1:Create Node 2:Print 3:Exit");
        	int choice=s.nextInt();
        	switch(choice) {
        	case 1:
        	System.out.println("Enter tht key:");
            int key=s.nextInt();
            System.out.println("Enter tht value:");
            String value=s.next();
            ht.createNode(key, value);
            break;
        	case 2:
        	System.out.println("Enter tht key:");
            ht.print(s.nextInt());
            break;
        	case 3:
        		flag=3;
        	}
        }
	}
	private void print(int k) {
		int hash=k%(table.length);
		//System.out.println("hash "+hash);
		//System.out.println("hashValue "+table[hash]);
		temp=table[hash];
		while(temp.addr!=null) {
			System.out.print(" "+temp.value);
			temp=temp.addr;
		}
		System.out.print(" "+temp.value);
		System.out.println();
	}
	private void createTable() {
		table=new HashNode[5]; 
	  }
	 private void createNode(int k,String v) {
	  HashNode node=new HashNode(k,v);
	  int hash=k%(table.length);
	//  System.out.println("value "+node.getValue());
	  if(table[hash]==null) {
		  table[hash]=node;
	  }else {
		  temp=table[hash];
		  while(temp.addr!=null) {
			  temp=temp.addr;
		  }
		 temp.addr=node;
	  }
  }
}
