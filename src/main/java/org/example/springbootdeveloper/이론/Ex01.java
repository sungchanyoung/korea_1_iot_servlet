package org.example.springbootdeveloper.이론;

public class Ex01 {
    public static void main(String[] args) {
        int a =0;
        for(int i =0; i<100; i*=2){
            if((++i) %3==0){
                System.out.print(i);
            }
        }

    }
}
