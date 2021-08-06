package Java.Complex;

// https://faculty.ncssm.edu/~morrison/complexPlacement/complex.pdf

public class Complex implements IComplex 
{
    public static final Complex ZERO = new Complex(), ONE = new Complex(1), I = new Complex(0, 1);
    private double re, im;
    
    /*
    static {
        ZERO = null;
        ONE = null;
        I = null;
    }
    */

    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }
    public Complex(double re) {
        this.re = re;
        this.im = 0;
    }
    public Complex() {
        this.re = 0;
        this.im = 0;
    }



    public Complex add(Complex that) {
        return new Complex(this.re + that.re, this.im + that.im);
    }
    public Complex add(double that) {
        return new Complex(this.re + that, this.im);
    }
    public Complex subtract(Complex that) {
        return new Complex(this.re - that.re, this.im - that.im);
    }
    public Complex subtract(double that) {
        return new Complex(this.re - that, this.im);
    }
    public Complex multiply(Complex that) {
        return new Complex(this.re * that.re - this.im * that.im, this.re * that.im + this.im * that.re);
    }
    public Complex multiply(double that) {
        return new Complex(this.re * that, this.im * that);
    }
    public Complex divide(Complex that) {
        double denom = that.re * that.re + that.im * that.im;
        return new Complex((this.re * that.re - this.im * that.im) / denom, (this.re * that.im + this.im * that.re) / denom);
    }
    public Complex divide(double that) {
        return new Complex(this.re / that, this.im / that);
    }
    public Complex conjugate() {
        return new Complex(this.re, -this.im);
    }
    public double abs() {
        return Math.sqrt(this.re * this.re + this.im * this.im);
    }
    public Complex pow(int n) {
        if (n == 0) return Complex.ONE;
        
        Complex tempThis = new Complex(this.re, this.im);

        if (n < 0) {
            // tempThis = 1 / tempThis;
            double denom = tempThis.re * tempThis.re + tempThis.im * tempThis.im;
            tempThis.re /= denom;
            tempThis.im = -tempThis.im / denom;
            n = -n;
        }

        Complex result = new Complex(1);
        double t;
        while (n > 1) {
            if ((n & 1) == 1) {
                // result *= tempThis;
                t = result.re;
                result.re = result.re * tempThis.re - result.im * tempThis.im;
                result.im = t * tempThis.im + result.im * tempThis.re;
            }
            // tempThis *= tempThis;
            t = tempThis.re;
            tempThis.re = tempThis.re * tempThis.re - tempThis.im * tempThis.im;
            tempThis.im = 2 * t * tempThis.im;
            n >>= 1;
        }
        // return * tempThis;
        t = result.re;
        result.re = result.re * tempThis.re - result.im * tempThis.im;
        result.im = t * tempThis.im + result.im * tempThis.re;
        return result;
    }

    public double re() {
        return this.re;
    }
    public double im() {
        return this.im;
    }
    public double Arg() {
        return Math.atan2(this.im, this.re);
    }
    public boolean equals(Object o) {
        if (! (o instanceof Complex)) {
            return false;
        }

        Complex c = (Complex) o;
        return ((Double) this.re).equals(c.re) && ((Double) this.im).equals(c.im);
    }
    public String toString() {
        //return this.im >= 0 ? String.format("%f + %fi", this.re, this.im) : String.format("%f - %fi", this.re, -this.im);
        return this.im >= 0 ? this.re + " + " + this.im + 'i' : this.re + " - " + -this.im + 'i';
    }
}
