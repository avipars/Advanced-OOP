package Inheritance;

public class A{
    public static int f(int x){
        return (x+5);
    }
    public int g(int x){
        return (3);
    }
    
    public static void main(String [] args){
        D d = new D();
        A a = d;
        System.out.print(a.f(2)*a.g(3)); // question is what does it print?
    }
}

class D extends A{
    public static int f(int x){
        return (x+4);
    }
    
    public int g(int x){
        return (x+8);
    }
}

