package cn.itheima.dynamicProxyPractice;

public class MyCar implements  Car {

    @Override
    public void run() {
        System.out.println("汽车跑");
    }

    @Override
    public void jump() {
        System.out.println("汽车跳");
    }
}
