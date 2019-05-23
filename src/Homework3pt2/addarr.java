package Homework3pt2;

public class addarr {
    int[] arr;
    addarr (int[] arr){
        this.arr = arr;
    }
    public void manipulatearr(int location, int number){
        arr[location]=number;
    }
    public int getvalue(int location){
        return arr[location];
    }
}
