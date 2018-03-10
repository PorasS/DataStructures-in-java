import java.util.Scanner;

public class AvlTree {
    private AvlNode root;
    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        AvlTree av=new AvlTree();
        int flag=0;
        while(flag!=4){
            System.out.println("insert:1 delete:2 print:3 exit:4");
            int choice=s.nextInt();
            switch(choice){
                case 1:
                    System.out.println("Enter element:");
                    int dt=s.nextInt();
                    av.insert(dt);
                    break;
                case 2:
                    System.out.println("Enter Element:");
                    int el=s.nextInt();
                    av.delete(el);
                    break;
                case 3:
                    av.print();
                    break;
                case 4:
                    flag=4;
                    break;
            }
        }
    }
    public int predesessor(AvlNode rot){
        AvlNode temp=rot.left;
        while(temp.right!=null){
            temp=temp.right;
        }
        return temp.data;
    }
    public void delete(int dt){
        root=deleteNode(root,dt);
        if(root==null){
            System.out.println(dt+" not present ,tree is empty:");
        }
    }
    public AvlNode deleteNode(AvlNode rot,int dt) {
        if(rot==null){
            rot=null;
        }else{
            if(rot.data>dt){
              rot.left=deleteNode(rot.left,dt);
            }else{
                if(rot.data<dt){
                     rot.right=deleteNode(rot.right,dt);
                }else{
                    if (rot.data==dt){
                        if(rot.left==null&&rot.right==null){
                            rot=null;
                        }else
                        if(rot.right==null){
                            rot=rot.left;
                        }else
                        {
                            if(rot.left.right==null){
                                rot.data=rot.left.data;
                                rot.left=deleteNode(rot.left,rot.data);
                            }else{
                                if(rot.left==null){
                                    rot=rot.right;
                                }else {

                                        rot.data = predesessor(rot);
                                        rot.left = deleteNode(rot.left, rot.data);

                                }
                            }
                        }
                    }
                }
            }
        }
        return rot;
    }
    public void print(){
        if(root==null){
           System.out.println("Nothing to print:");
        }else{
            printData(root);
        }
        System.out.println(" ");
    }
    private void printData(AvlNode rot){
        if(rot.left!=null){
            printData(rot.left);
        }
        System.out.print(" "+rot.data);
        if(rot.right!=null){
            printData(rot.right);
        }

    }
    public void insert(int dt){
        insertElement(root,dt);
        System.out.println("root "+root.data);
    }
    public int balanceFactor(AvlNode rot){

        return height(rot.left)-height(rot.right);
    }
    public int height(AvlNode rot){
        if(rot==null){
            return 0;
        }else{
            return (Math.max(height(rot.left),height(rot.right))+1);
        }
    }
    public AvlNode lr(AvlNode rot){
        AvlNode temp=rot.left.right;
        temp.right=rot;
        temp.left=rot.left;
        rot.left=null;
        temp.left.right=null;
        return temp;
    }
    public AvlNode rr(AvlNode rot){
        AvlNode temp=rot.right;
        temp.left=rot;
        rot.right=null;
        return temp;
    }
    public AvlNode ll(AvlNode rot){
        AvlNode temp=rot.left;
        if(temp.right!=null){
            rot.left=temp.right;
        }else{
            rot.left=null;
        }
        temp.right=rot;
        return temp;
    }
    public AvlNode rl(AvlNode rot){
        AvlNode temp=rot.right.left;
        temp.right=rot.right;
        temp.right.left=null;
        temp.left=rot;
        rot.right=null;
        return temp;
    }
    private void insertElement(AvlNode rot,int dt){
        if(rot==null){
            AvlNode temp=new AvlNode(dt);
            root=temp;
        }else{
            if(rot.data>dt){
                int bt=balanceFactor(rot);
                System.out.println(bt);
                if(bt==2&&rot.left.left==null){
                    root=lr(rot);
                   insertElement(root,dt);
                }else{
                    if(bt==2&&rot.left.left!=null){
                        if(root!=rot){
                            root.left=ll(rot);
                            insertElement(root,dt);
                        }else{
                            root=ll(rot);
                            insertElement(root,dt);
                        }

                    }else{
                        if(bt==-2&&rot.right.right==null) {
                            root = rl(rot);
                            insertElement(root, dt);
                        }else{
                            if(bt==-2&&rot.right.right!=null){
                                root=rr(rot);
                                insertElement(root,dt);
                            }else{
                                if(rot.left==null){
                                    AvlNode temp=new AvlNode(dt);
                                    rot.left=temp;
                                }else{
                                    insertElement(rot.left,dt);
                                }
                            }
                        }
                    }
                }
            }else{
                if(rot.data<dt){
                    int bt=balanceFactor(rot);
                    System.out.println(bt);
                    if(rot.right==null){
                        AvlNode temp=new AvlNode(dt);
                        rot.right=temp;
                    }else{
                        if(bt==-2&&rot.right.right==null){
                            if(root!=rot){
                                root.right=rl(rot);
                                insertElement(root,dt);
                            }else {
                                root=rl(rot);
                                insertElement(root, dt);
                            }
                        }else{
                            if(bt==-2&&rot.right.right!=null){
                                if(root!=rot){
                                    root.left=rr(rot);
                                    insertElement(root,dt);
                                }else {
                                    root = rr(rot);
                                    insertElement(root, dt);
                                }
                            }
                            else{
                                insertElement(rot.right,dt);
                            }
                        }
                    }
                }
            }
        }
    }

}
