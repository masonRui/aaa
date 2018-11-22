package cn.itheima.dynamicProxyPractice;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Demo {
    public static void main(String[] args) {
        final Car car = new MyCar();

        Car newCar = (Car)Proxy.newProxyInstance(car.getClass().getClassLoader(),
                car.getClass().getInterfaces(),
                (a,b,c)->{
                    if ("jump".equals(b.getName())) {
                        System.out.println("汽车飞");
                        return null;
                    }
                    b.invoke(car, c);
                    return null;
                }
               /* new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if ("jump".equals(method.getName())) {
                            System.out.println("汽车飞");
                            return null;
                        }
                        method.invoke(car, null);
                        return null;
                    }
                }*/
        );
        newCar.run();
        newCar.jump();
    }
}
