package com.company;

public class MyPublicKey extends MyKey {
    private long e;
    public MyPublicKey(long n, long e){
        this.n = n;
        this.e = e;
    }

    public long getE(){
        return this.e;
    }
}
