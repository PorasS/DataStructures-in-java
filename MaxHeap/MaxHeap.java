import java.util.Scanner;
public class MaxHeap {
    int arr[];
    int i=0;
    public static void main(String args[]){
       MaxHeap mx=new MaxHeap();
       Scanner s=new Scanner(System.in);
       int flag=0;
       int choice=0;
        mx.arrInitialise();
       while(flag!=4){
           System.out.println("1:Insert 2:Display 3:Delete 4:Exit");
           choice=s.nextInt();
           switch(choice){
               case 1:
                   System.out.println("Enter a no:");
                   int x=s.nextInt();
                   mx.insert(x);
                   break;
               case 2:
                   mx.display();
                   break;
               case 3:
                   System.out.println("Delete a no:");
                   int y=s.nextInt();
                   mx.delete(y);
                   break;
               case 4:
                   flag=4;
           }
       }
    }
    public void arrInitialise(){
        arr=new int[100];
    }
    public void insert(int dt){
        i++;
        arr[i]=dt;
        if(i!=1){
            check(i);
        }

    }
    private void check(int j){
        while(j!=1){
            if((arr[j]>=arr[Math.floorDiv(j,2)])){
                int temp=arr[Math.floorDiv(j,2)];
                arr[Math.floorDiv(j,2)]=arr[j];
                arr[j]=temp;
                j=Math.floorDiv(j,2);
            }else{
                j=1;
            }

        }
    }
    public void check1(int j){
        if(arr[j]<=arr[2*j]){
            int temp=arr[j];
            arr[j]=arr[2*j];
            arr[2*j]=temp;
            check1(2*j);
        }else{
            if(arr[j]<=arr[2*j+1]){
                int temp=arr[j];
                arr[j]=arr[2*j+1];
                arr[2*j+1]=temp;
                check1(2*j+1);
            }
        }
    }
    public void delete(int dt){
        int j=1;
        while(arr[j]!=dt){
            j++;
        }
        arr[j]=arr[i];
        i--;
        check1(j);
    }
    public void display(){

       for(int j=1;j<=i;j++){
           System.out.print(" "+arr[j]);
       }
        System.out.println();
    }
}
