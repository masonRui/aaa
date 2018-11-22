package cn.itheima.polymorphismTest;

public class TestDemo {
    public static void main(String[] args) {
        Father father = new Child("nn");
        //如果子类没有show方法，一样可以运行成功，调用的父类的show，但这个就不叫多态了。
        //多态有两个要求，一个是有继承或者实现关系，二是有方法的重写。
        //为什么不会失败，因为子类继承了父类的方法啊，子类不会继承父类的构造方法和final方法
        father.show();
    }
}
