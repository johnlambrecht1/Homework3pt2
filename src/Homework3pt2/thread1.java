package Homework3pt2;

import java.util.Random;

public class thread1 extends Thread{
    public addarr add;
    int thread;
    thread1 (addarr add, int thread){
        this.add = add;
        this.thread=thread;
    }
    public void run(){
        //addarr add;
        Random rand = new Random();
        int count=0;
        while(count!=25){
            synchronized(add){
                int locate = 0;
                while (add.getvalue(locate)!=0&&locate<99){
                    locate++;
                }
                try{
                    int num = rand.nextInt(1000);
                    add.manipulatearr(locate, num);
                    //array[i]=num;
                    //thread4.join();
                    Thread.sleep(1000);
                    System.out.println("Thread "+thread+" adds "+add.getvalue(locate)+" at spot "+locate);
                }catch (InterruptedException e){
                    return;
                }
            }
            count++;
        }
    }

    public static void main(String[] args){
        final int[] arr= new int[100];
        addarr add = new addarr(arr);
        Thread t1 = new Thread(new thread1(add, 1));
        Thread t2 = new Thread(new thread1(add, 2));
        Thread t3 = new Thread(new thread1(add, 3));
        Thread t4 = new Thread(new thread1(add, 4));
        t1.start();
        /*try{
            t1.join();
        }catch(InterruptedException e){
            System.out.println("Interrupted");
        }*/
        t2.start();
//        try{
//            t2.join();
//        }catch(InterruptedException e){
//            System.out.println("Interrupted");
//        }
        t3.start();
//        try{
//            t3.join();
//        }catch(InterruptedException e){
//            System.out.println("Interrupted");
//        }
        t4.start();
//        try{
//            t4.join();
//        }catch(InterruptedException e){
//            System.out.println("Interrupted");
//        }
//        for(int i=0;i<100;i++){
//            try{
//                t1.join();
//                t2.join();
//                t3.join();
//                t4.join();
//            }catch(InterruptedException e){
//                System.out.println("interrupted");
//            }
//        }
    }
}
