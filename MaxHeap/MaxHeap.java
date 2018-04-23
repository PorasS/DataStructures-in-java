import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.in;

public class MaxHeap {
    int arr[];
    int i=0;
    public static void main(String args[]){
       MaxHeap mx=new MaxHeap();
       Scanner s=new Scanner(in);
       int flag=0;
       int choice=0;
        mx.arrInitialise();
       while(flag!=3){
           System.out.println("1:Insert 2:Display 3:Exit");
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
                   flag=3;
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
    public void display(){

       for(int j=1;j<=i;j++){
           System.out.print(" "+arr[j]);
       }
        System.out.println();
    }
}
