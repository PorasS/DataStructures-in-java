import java.util.Scanner;
public class RBTree {
    RBNode root;

    public static void main(String args[]) {
        Scanner s=new Scanner(System.in);
        RBTree rb = new RBTree();
        int flag=0;
        int choice=0;
        while(flag!=3){
            System.out.println("1:insert 2:display 3:exit");
            choice=s.nextInt();
            switch(choice){
                case 1:
                    System.out.println("Enter ele");
                    int dt=s.nextInt();
                    rb.insert(dt);
                    break;
                case 2:
                    rb.display();
                    break;
                case 3:
                    flag=3;
                    break;
            }
        }
    }
    public void display(){
        displayEle(root);
    }
    private void displayEle(RBNode rot){
       if(rot!=null){
           displayEle(rot.left);
           System.out.println(rot.data+" "+rot.color);
           displayEle(rot.right);
        }
         //System.out.println(rot.data+" "+rot.color);
        //System.out.println(rot.left.data+" "+rot.left.color);
        //System.out.println(rot.right.data+" "+rot.right.color);
    }
    private RBNode rr(RBNode rot){
        RBNode temp=rot.right;
        temp.left=rot;
        rot.right=null;
        temp.parent=null;
        rot.parent=temp;
        return temp;
    }
    public void colorFlipL(RBNode rot){
        if(rot.color==0){
            rot.color=1;
        }else{
            rot.color=0;
        }
        if(rot.right.color==0){
            rot.right.color=1;
        }else{
            rot.right.color=0;
        }
    }
    public void check(){
        if(root.color==0){
            root.color=1;
        }
    }
    public void colorFlip1(RBNode rot){
        if(rot.color==0){
            rot.color=1;
        }else{
            rot.color=0;
        }
        if(rot.left.color==0){
            rot.left.color=1;
        }else{
            rot.left.color=0;
        }
    }
    public void colorFliprl(RBNode rot){
        if(rot.color==0){
            rot.color=1;
        }
        if(rot.left.color==1){
            rot.left.color=0;
        }
    }
    public RBNode rl(RBNode rot){
        RBNode temp=rot.right.left;
        temp.right=rot.right;
        rot.right.parent=temp;
        rot.right.left=null;
        rot.right=null;
        temp.left=rot;
        rot.parent=temp;
        temp.parent=null;
        return temp;
    }
    public RBNode ll(RBNode rot){
        RBNode temp=rot.left;
        temp.right=rot;
        rot.parent=temp;
        temp.parent=null;
        return temp;
    }
    public RBNode lr(RBNode rot){
        RBNode temp=rot.left.right;
        temp.right=rot;
        rot.left.right=null;
        temp.left=rot.left;
        temp.left.parent=temp;
        rot.parent=temp;
        rot.left=null;
        temp.parent=null;
        return temp;
    }
    public void colorflipLr(RBNode rot){
        if(rot.color==0){
            rot.color=1;
        }
        if(rot.right.color==1){
            rot.right.color=0;
        }
    }
    public void colorFlipL2(RBNode rot){
        if(rot.color==0){
            rot.color=1;
        }else{
            rot.color=0;
        }
        if(rot.right.color==0){
            rot.right.color=1;
        }else{
            rot.right.color=0;
        }
        if(rot.left.color==0){
            rot.left.color=1;
        }else{
            rot.left.color=0;
        }
    }
    public Boolean colorCheck(RBNode rot){
        if(rot.parent.color==0){
            return true;
        }else{
            return false;
        }
    }
    public void insert(int dt){
        insertEle(root,dt);
    }
    private void insertEle(RBNode rot,int dt){
        if(rot==null){
            RBNode temp=new RBNode(dt);
            root=temp;
            check();
        }else{
            if(rot.data>dt){
                if(rot.left==null){
                    RBNode temp=new RBNode(dt);
                    rot.left=temp;
                    temp.parent=rot;
                    boolean flag=colorCheck(temp);
                    if(flag==true){
                        if(root==rot.parent){
                            if(rot.parent.right==null){
                                root=ll(rot.parent);
                                colorFlipL(root);
                                check();
                            }else {
                                if(rot.right==null&&rot.parent.left==null){
                                    root=rl(rot.parent);
                                    colorFliprl(root);
                                    check();
                                }else {
                                    colorFlipL2(rot.parent);
                                    check();
                                }
                            }
                        }else{
                            if(rot.parent.right==null){
                                root.left=ll(rot.parent);
                                root.left.parent=root;
                                colorFlipL(root.left);
                                check();

                            }else{
                                if(rot.right==null&&rot.parent.left==null){
                                    root.right=rl(rot.parent);
                                    root.right.parent=root;
                                    colorFliprl(root.right);
                                }else {
                                    if(rot.right!=null&&rot.parent.left==null){
                                        //rr();
                                    }else {
                                        colorFlipL2(rot.parent);
                                        check();
                                    }
                                }
                            }
                        }
                    }
                }else{
                    insertEle(rot.left,dt);
                }
            }else{
                if(rot.data<dt){
                    if(rot.right==null){
                        RBNode temp=new RBNode(dt);
                        rot.right=temp;
                        temp.parent=rot;
                        boolean flag=colorCheck(temp);
                        if(flag==true){
                            if(root==rot.parent){
                                if(root.left==null){
                                    root=rr(rot.parent);
                                    colorFlip1(root);
                                    check();
                                }else{
                                    if(rot.left==null){
                                        if(rot.parent.left.color==0&&root.right!=null){
                                            colorFlipL2(rot.parent);
                                            check();
                                        }else {
                                            root = lr(rot.parent);
                                            colorflipLr(root);
                                            check();

                                        }
                                    }else {
                                        colorFlipL2(rot.parent);
                                        check();
                                    }
                                }
                            }else{
                                if(rot.parent.left==null){
                                    if(rot.right==null){
                                        if(root!=rot.parent){
                                            root.right=rl(rot.parent);
                                            root.right.parent=root;
                                            colorFliprl(root.right);
                                        }
                                    }else {
                                        rot.right = rr(rot.parent);
                                        root.right.parent = root;
                                        colorFlip1(rot.right);
                                        check();
                                    }
                                }else{
                                    if(rot.left==null&&rot.parent.right==null){
                                        root.left=lr(rot.parent);
                                        root.left.parent=root;
                                        colorflipLr(root.left);
                                    }else{
                                        colorFlipL2(rot.parent);
                                        check();
                                    }
                                }
                            }
                        }
                    }else{
                       insertEle(rot.right,dt);
                    }
                }
            }
        }
    }
}
