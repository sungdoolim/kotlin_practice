package mobile_software.week4;

public class Calculation {
    int z;
    public void addition(int x, int y) {
        z = x + y;
        System.out.println("주어진 수의 합: "+z);
    }
    public void Subtraction(int x, int y) {
        z = x - y;
        System.out.println("주어진 수의 차: "+z);
    }
}
 class Myjava extends Calculation {
    public void multiplication(int x, int y) {
        z = x * y;
        System.out.println("주어진 수의 곱: "+z);
    }
    public static void main(String args[]) {
        int a = 20, b = 10;
        Myjava demo = new Myjava();
        demo.addition(a, b);
        demo.Subtraction(a, b);
        demo.multiplication(a, b);
    }
}