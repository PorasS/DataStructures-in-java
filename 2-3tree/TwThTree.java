import java.util.Scanner;

public class TwThTree {
    TwThNode root;
    public static void main(String args[]){
        TwThTree tw=new TwThTree();
        int flag=0;
        int choice=0;
        Scanner s=new Scanner(System.in);
        while(flag!=3){
            System.out.println("1:insert 2:display 3:exit");
            choice=s.nextInt();
            switch(choice){
                case 1:
                    System.out.println("enter ele:");
                    int dt=s.nextInt();
                    tw.ins(dt);
                    break;
                case 2:
                    tw.display();
                    break;
                case 3:
                    flag=3;
                    break;
            }
        }
    }

    public void display(){
        System.out.println(root.a+" "+root.b);
        System.out.println(root.left.a+" "+root.left.b);
        System.out.println(root.middle.a+" "+root.middle.b);
        System.out.println(root.right.a+" "+root.right.b);
      // disp(root);
    }
    public void disp(TwThNode rot){
        disp(rot.left);
        System.out.println(rot.a+" "+rot.b);
        disp(rot.middle);
    }
    public void ins(int dt){
        insert(root,dt);
    }
    public TwThNode split(TwThNode rot,int dt) {
        if(dt>rot.a&&dt<rot.b){

        }else{
            if(dt<rot.a){
                TwThNode temp1=new TwThNode(dt);
                TwThNode temp2=new TwThNode(rot.b);
                System.out.println(rot);
                System.out.println(root);
                if(rot==root){
                    TwThNode temp3=new TwThNode(rot.a);
                    temp3.left=temp1;
                    temp3.middle=temp2;
                    temp3.left.parent=temp3;
                    temp3.middle.parent=temp3;
                    rot=temp3;
                }
                else{
                    if(rot.parent.b==0){
                        if(rot.a<rot.parent.a){
                            swap(rot.parent,rot.a);
                            rot.parent.right=rot.parent.middle;
                            rot.parent.middle=temp2;
                            rot.parent.left=temp1;
                            rot=rot.parent;
                            rot.left.parent=rot;
                            rot.middle.parent=rot;
                            rot.right.parent=rot;

                        }else {
                            if(rot.parent!=null&&rot.parent.b==0){
                                rot.parent.b = rot.a;
                            }else{
                                TwThNode temp3=new TwThNode(rot.a);
                                if(rot.right!=null){
                                    temp2.middle=rot.right;
                                }else{
                                    temp3.middle=temp2;
                                }
                                temp2.parent=temp3;
                                if(rot.middle!=null){
                                    temp2.left=rot.middle;
                                }else{
                                    temp3.left=temp1;
                                }
                                temp1.parent=temp3;
                                rot=temp3;
                            }

                        }
                    }else{
                        if(rot==root){
                            if(rot.a!=0&&rot.b!=0){

                            }else{}
                        }else{
                            split(rot.parent,rot.a);
                        }

                    }
                }

            }else{
                if(dt>rot.b){
                    TwThNode temp1=new TwThNode(rot.a);
                    TwThNode temp2=new TwThNode(dt);
                    if(rot!=root){
                        if(rot.parent.b==0){
                            rot.parent.b=rot.b;
                        }
                    }
                    else{
                        TwThNode temp3=new TwThNode(rot.b);
                        temp3.left=temp1;
                        temp3.middle=temp2;
                        temp3.left.parent=temp3;
                        temp3.middle.parent=temp3;
                        rot=temp3;
                    }
                }else{}
            }
        }
        return rot;
    }
    public void swap(TwThNode rot,int dt){
        int temp=rot.a;
        rot.a=dt;
        rot.b=temp;
    }
    public void insert(TwThNode rot, int dt){
        if(root==null){
            TwThNode temp=new TwThNode(dt);
            root=temp;
        }else{
            if(rot.a<dt){
                if(rot.b==0&&rot.left==null){
                    rot.b=dt;
                }else{
                    if(rot.a!=0&&rot.b!=0&&rot.left==null){
                        TwThNode temp=split(rot,dt);
                        if(root==rot){
                            root=temp;
                        }else{}
                    }else{}
                }
            }else{
                if(rot.a>dt){
                    if(rot.b==0&&rot.left==null){
                        if(rot.a>dt){
                            swap(rot,dt);
                        }else {
                            rot.b = dt;
                        }
                    }else{
                        if(rot.a!=0&&rot.b!=0&&rot.left==null){
                            if(rot.parent!=null){
                                if(rot.parent.a!=0&&rot.parent.b!=0){
                                    root=split(rot.parent,rot.a);
                                   root.left=split(rot,dt);
                                   root.left.parent=root;
                                   if(rot.parent.middle!=null){
                                       root.middle.left=rot.parent.middle;
                                       rot.parent.middle.parent=root.middle;
                                   }
                                    if(rot.parent.right!=null){
                                        root.middle.middle=rot.parent.right;
                                        rot.parent.right.parent=root.middle;
                                    }
                                }else{
                                    if(rot.parent.a!=0&&rot.parent.b==0){
                                        if(rot.parent.a>rot.a){
                                            swap(rot.parent,rot.a);
                                            rot.parent.right=rot.parent.middle;
                                            TwThNode temp1=new TwThNode(dt);
                                            rot.parent.left=temp1;
                                            temp1.parent=rot.parent;
                                            TwThNode temp2=new TwThNode(rot.b);
                                            rot.parent.middle=temp2;
                                            temp2.parent=rot.parent;
                                        }else{
                                            rot.parent.b=rot.a;
                                        }
                                    }else{}
                                }
                            }else{
                                TwThNode temp=split(rot,dt);
                                if(temp==root){
                                    root=temp;
                                }
                            }
                        }else{
                            insert(rot.left,dt);
                        }

                    }
                }
            }
        }
    }
}
