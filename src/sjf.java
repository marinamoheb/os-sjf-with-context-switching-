import java.util.Scanner;
import java.util.*;

public class sjf {
    static void findtime(String names[],int av[], int bt[], int rt[], int numberofprocesses, int cs) {
        int ta[] = new int[numberofprocesses];// ta means turn around time
        int wt[] = new int[numberofprocesses];  // wt means waiting time
        int f[] = new int[numberofprocesses];  // f means it is flag it checks process is completed or not
        int ct[]= new int[numberofprocesses];
        int  start=0, complete=0,m=0;
        float avgwt=0, avgta=0;
        while (true) {
            int min = 99, count = numberofprocesses;

            if (complete == numberofprocesses){
                break;
            }
            for (int i = 0; i < numberofprocesses; i++) {
                if ((av[i] <= start) && (f[i] == 0) && (bt[i] < min)) {
                    min = bt[i];
                    count = i;
                }
            }
            if(m==count)
            {
                start++;
                m=count;
            }
            else{
                start+=cs;
                start++;
                m=count;
            }

            if (count == numberofprocesses){
                    start++;
            }

            else {

                bt[count]--;
                System.out.println("excution of " + names[count]);
                if (bt[count] == 0) {
                    ct[count] =start;
                    f[count] = 1;
                    complete++;
                    System.out.println("complete of "+names[count]);
                }
            }
        }


            for(int i = 0;i<numberofprocesses;i++)

    {
        ta[i] = ct[i] - av[i];
        wt[i] = ta[i] - rt[i];
        avgwt += wt[i];
        avgta += ta[i];
    }

        System.out.println("names arrival  burst  complete turn waiting");
        for(int i=0;i<numberofprocesses;i++)
        {
            System.out.println(names[i] +" \t"+ av[i]+" \t"+ rt[i] +" \t"+ ct[i] +" \t"+ ta[i] +" \t"+ wt[i]);
        }

            System.out.println("Average Turnaround  Time    is "+(float)(avgta/numberofprocesses));
            System.out.println("Average Waiting Time   is "+(float)(avgwt/numberofprocesses));
}
    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

        System.out.print("1.Shortest Job First Scheduling ");
        System.out.println("You entered " );
    int choice = input.nextInt();
        if (choice==1) {

            System.out.println("Please Enter Number of Processes");
            int numberofprocesses = input.nextInt();
            int []av=new int[numberofprocesses];
            int []bt=new int[numberofprocesses];
            int []rt=new int[numberofprocesses];
            String[]names=new String[numberofprocesses];
            for ( int i = 0; i < numberofprocesses; i++) {
                System.out.println("Please Enter Name of Processes");
                names[i] = input.next();
                System.out.println("Please Enter Arrival Time of :" + names[i]);
                 av[i] = input.nextInt();
                System.out.println("Please Enter Burst Time of :" + names[i]);
                bt[i]= input.nextInt();
                rt[i]= bt[i];
            }
            System.out.println("Please Enter context switch");
            int cs = input.nextInt();
            findtime(names, av, bt,rt, numberofprocesses, cs);

            input.close();
        }
    }}