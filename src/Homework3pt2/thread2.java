package Homework3pt2;

import java.util.Random;

public class thread2 extends Thread {
    public addarr add;
    thread2 (addarr add){
        this.add = add;
    }
    public void run(){
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
                    System.out.println("Thread 2 adds "+add.getvalue(locate)+" at spot "+locate);
                }catch (InterruptedException e){
                    return;
                }

                count++;
            }
        }

    }
}
