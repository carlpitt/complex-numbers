package Java.Complex;

public class Main {
    public static void main(String[] args) {
        System.out.println(Complex.ZERO);
        System.out.println(Complex.ONE);
        System.out.println(Complex.I);

        Complex a = new Complex(3, 4);
        Complex b = new Complex(3, -4);
        System.out.println(a.multiply(b));
        // 25.0 + 0.0i

        System.out.println(a.re());
        // 3
        System.out.println(a.im());
        // 4

        Complex c = new Complex(1, 1);
        System.out.println(c.Arg());
        // 0.7853981633974484

        Complex d = new Complex(-1,1);
        System.out.println(d.Arg());
        // 2.356194490192345
        System.out.println(d.Arg() / Math.PI);
        // 0.75

        Complex z = new Complex(1, 1);
        System.out.println(z.pow(5));
        // -4.0 - 4.0i

        System.out.println(z.pow(4));
        // -4.0 + 0.0i

        System.out.println(z.pow(8));
        // 16.0 + 0.0i
    }
}
