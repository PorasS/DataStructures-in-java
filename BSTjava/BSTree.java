import java.util.Scanner;
public class BSTree {
    BSNode root=new BSNode();
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		BSTree bst=new BSTree();
		int flag=0;
		int choice=0;
		while(flag!=5){
			System.out.println("1:insert  2:preorder  3:inorder  4:postorder  5:Exit");
	        choice=s.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Enter element:");
				int dt=s.nextInt();
				bst.create( dt);
				break;
			case 2:
				bst.printPre();
				System.out.println(" ");
				break;
			case 3:
				bst.printIn();
				System.out.println(" ");
				break;
			case 4:
				bst.printPost();
				System.out.println(" ");
				break;
			case 5:
				flag=5;
				break;
			}
		}
		
	}
	public void printIn() {
		inorder(root.left);
	}
	public void inorder(BSNode rot) {
		if(rot!=null) {
			inorder(rot.left);
			System.out.print(rot.data);
			System.out.print(" ");
			inorder(rot.right);
		}
		
	}
	public void printPost() {
		postorder(root.left);
	}
	public void postorder(BSNode rot) {
		if(rot!=null) {
		postorder(rot.left);
		postorder(rot.right);
		System.out.print(rot.data);
		System.out.print(" ");
		}
	}
	public void printPre() {
		preorder(root.left);
	}
	public void preorder(BSNode rot) {
		if(rot!=null) {
			System.out.print(rot.data);
			System.out.print(" ");
			preorder(rot.left);
			preorder(rot.right);
		}
	}
	public void create(int dt) {
		insert(root.left,dt);
	//	System.out.println(root.left.data);
	}
	public void insert(BSNode rot,int dt) {
		BSNode ro=new BSNode();
		ro.left=rot;
		if(ro.left==null) {
			BSNode temp=new BSNode(dt);
			if(root.left==null) {
				root.left=temp;
			}else {
				if(ro.left.data>dt) {
					ro.left.left=temp;
				}else {
					ro.left.right=temp;
				}
			}
		}else {
			if(ro.left.data>dt) {
				if(ro.left.left==null) {
					BSNode temp=new BSNode(dt);
					ro.left.left=temp;
				}else {
					insert(ro.left.left,dt);
					}
			}else {
				if(ro.left.right==null) {
					BSNode temp=new BSNode(dt);
					ro.left.right=temp;
				}else {
					insert(ro.left.right,dt);
				}
			}
		}
	}

}
