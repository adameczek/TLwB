package com.company;

public class MyPrivateKey extends MyKey {
    private long d;
    public MyPrivateKey(long n, long d) {
        this.n = n;
        this.d = d;
    }
    public long getD() {
        return d;
    }

}
