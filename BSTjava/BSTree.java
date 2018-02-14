import java.util.Scanner;
public class BSTree {
    BSNode root=new BSNode();
    BSNode ro1=new BSNode();
    BSNode temp1;
    int count=0;
    int l=0;
    int r=0;
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		BSTree bst=new BSTree();
		int flag=0;
		int choice=0;
		while(flag!=14){
			System.out.println("1:insert  2:preorder  3:inorder  4:postorder  5:find element  6:Find max  7:Find min  8:Count leaf  9:BstHeight  10:levelOrder  11:Delete  12:InorderSuccessor  13:InorderPredesessor  14:Exit");
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
			    System.out.println("Enter the element:");
			    int data=s.nextInt();
			    bst.printdata(data);
			    break;
			case 6:
				bst.max();
				break;
			case 7:
				bst.min();
				break;
			case 8:
				bst.leaf();
				break;
                case 9:
                bst.height();
				break;
				case 10:
					bst.breadthFS();
					break;
				case 11:
                    System.out.println("Enter element you want to delete:");
                    int nn=s.nextInt();
                    bst.del(nn);
                    break;
				case 12:
                 System.out.println("Enter the element whose successor you want:");
                 int x=s.nextInt();
                 bst.successor(x);
                 break;
				case 13:
					System.out.println("Enter the element whose predesessor you want:");
					int n2=s.nextInt();
					bst.predesessor(n2);
					break;
				case 14:
				flag=14;
				break;
			}
		}
	}
	public void predesessor(int n){
          BSNode temp=inPredesessor(root.left,n);
          if(temp!=null) {
			  System.out.println(temp.data);
		  }
	}
	public BSNode inPredesessor(BSNode rot,int value){
		System.out.println("Currently working:");
		return null;
	}
	public void successor(int n){
		BSNode temp=inSuccessor(root.left,n);
		if(temp!=null) {
			System.out.println(temp.data);
		}else{
			System.out.println(n+" has no successor:");
		}
	}
	public BSNode inSuccessor(BSNode rot,int value){
		/*if(rot!=null){
			if(rot.data<value){
				inSuccessor(rot.right,value);
			}else{
				if(rot.data>value){
					inSuccessor(rot.left,value);
				}else{
					if(rot.data==value){
						if(rot.right!=null){
							BSNode temp=rot.right;
							while(temp!=null){
								temp1=temp;
								temp=temp.left;

							}
						}else{
							System.out.println(value+" has no successor in tree:");
							temp1=null;
						}
					}
				}
			}
		}
		return temp1;
		*/
		BSNode current;
		BSNode successor=null;
		BSNode ancestor=null;
		if(rot!=null){
			 current=search(rot,value);
			 ancestor=rot;
			while(ancestor!=current){
				if(ancestor.data>value){
					successor=ancestor;
					ancestor=ancestor.left;
				}else{
					ancestor=ancestor.right;
				}

			}
		}
			if (ancestor.right != null) {
				successor = ancestor.right;

		}
		return successor;
	}
	public void breadthFS(){
		levOrder(root.left);
		System.out.println(" ");
	}
	public void levOrder(BSNode rot){
		BSNode n[]=new BSNode[20];
		int l=0;
		int i=0;
		n[0]=rot;
		while(n[l]!=null){
			System.out.print(n[l].data);
			System.out.print(" ");
			if(n[l].left!=null){
				i++;
				n[i]=n[l].left;
			}
			if(n[l].right!=null){
				i++;
				n[i]=n[l].right;
			}
			l++;
		}
	}
	public void del(int n){
		   temp1=delete(root.left,n);
		   if(temp1==null){
		       System.out.println("Tree is empty:");
           }
	}
	public BSNode delete(BSNode rot,int value){
		if(rot!=null){
			if(rot.data>value){
				rot.left=delete(rot.left,value);
				//return rot;
			}if(rot.data<value){
				rot.right=delete(rot.right,value);
				//return rot;
			}
			if(rot.data==value){
				if(rot.left==null&&rot.right==null){
					rot= rot.left;
				}else{
					if(rot.left==null){
						rot= rot.right;
					}else{
						if(rot.right==null){
							rot=rot.left;
						}else{
							if(rot.right!=null&&rot.left!=null){
								 temp1=findMin(rot.right);
								//System.out.println(temp1);
								rot.data=temp1.data;
								System.out.println(temp1.data);
								rot.right=delete(rot.right,temp1.data);
								//return rot;
							}
						}
					}
				}
			}
		}return rot;
	}
	public void height(){
		int height=BstHeight(root.left);
		System.out.println("Height of bst :"+height);
	}
	public int BstHeight(BSNode rot){
	    if(rot==null){
	        return -1;
        }else{
	        return(1+Math.max(BstHeight(rot.left),BstHeight(rot.right)));
        }
	}
	public void leaf() {
		countLeaf(root.left);
		System.out.println("no of leaf nodes "+count);
	}
	public void countLeaf(BSNode ro) {
		if(ro!=null) {
		if(ro.left==null&&ro.right==null) {
			count++;
			}else {
			countLeaf(ro.left);
			countLeaf(ro.right);
		}
		}
	}
	public void min() {
		findMin(root.left);
	}
	public BSNode findMin(BSNode rot) {
		if(rot.left!=null) {
			rot=findMin(rot.left);
			return rot;
		} else {
		System.out.println("min element is :"+rot.data);
			return rot;
		}
	}
	public void max() {
		findMax(root.left);
	}
	public void findMax(BSNode rot) {
		ro1.right=rot;
		if(ro1.right.right!=null) {
			findMax(ro1.right.right);
		} else {
		System.out.println("max element is :"+ro1.right.data);
		}
	}
	public void printdata(int data) {
		BSNode tmp=search(root.left,data);
		if(tmp!=null) {
			System.out.println(tmp.data+" is present in tree" );
		}else{
			System.out.println(data+" is not present in tree" );
		}
	}
	public BSNode search(BSNode rot,int dt) {
		if(rot!=null) {
			if (rot.data > dt) {
				if(rot.left!=null) {
					rot = search(rot.left, dt);
				}else{
					rot=null;
				}
			} else {
				if (rot.data < dt) {
					if(rot.right!=null){
						rot= search(rot.right, dt);
					}else{
						rot=null;
					}

				} else {
					if (rot.data == dt) {
						return rot;
					}
				}
			}
		}
	/*	try {
		if(rot.data>dt) {
			search(rot.left,dt);
		}else{
			if(rot.data==dt) {
				System.out.println(dt+" is present in the tree:");
			}else {
				search(rot.right,dt);
			}
		}
		}catch(Exception e) {
			System.out.println(dt+" is not present in the tree:");
		}*/
	return rot;
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
