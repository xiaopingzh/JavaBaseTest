package com.ping.loadBalancing;

/**
 * Created by zhangxiaoping on 17/5/3.
 */
public class Server {
    private String ip;
    private int weight;

    public Server(String ip) {
        super();
        this.ip = ip;
    }

    public Server(String ip, int weight) {
        this.ip     = ip;
        this.weight = weight;
    }

    public String getIp() {
        return ip;
    }
    public void setIp(String ip) {
        this.ip = ip;
    }
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Server [ip=" + ip + ", weight=" + weight + "]";
    }


    int gcd(int m,int n){
        while (m % n != 0) {
            int temp = m % n;
            m = n;
            n = temp;
        }
        return n;
    }

    public static void main(String[] args){
        System.out.print(new Server("",1).gcd(5,8));
    }
}

