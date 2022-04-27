package com.txy.datastructure.linear;

public class Fibonacci {

    public static void main(String[] args) {
        for(int i = 1; i < 6; i++){
            System.out.print(fibonacci(i) + " ");
        }
    }

    public static int fibonacci(int i){
        if(i == 1 || i == 2){
            return 1;
        }else {
            return fibonacci(i - 1) + fibonacci(i - 2);
        }
    }
}
