public class ImaginaryNum {
    public double real;
    public double imaginary;
    public ImaginaryNum(double r, double i){
        this.real = r;
        this.imaginary = i;
    }
    public static ImaginaryNum add (ImaginaryNum a, ImaginaryNum b){
        double r = a.real + b.real;
        double  i = a.imaginary + b.imaginary;
        return new ImaginaryNum(r,i);
    }
    public static ImaginaryNum mult(ImaginaryNum a, ImaginaryNum b){
        double r = a.real * b.real + a.imaginary*b.imaginary*(-1);
        double i = a.imaginary*b.real + a.real*b.imaginary;
        return new ImaginaryNum(r, i);
    }
    public String toString (){
        return this.real + " + " + this.imaginary + "i";
    }
    public double radius(){
        return Math.sqrt(this.real*this.real + this.imaginary*this.imaginary );
    }
    
}
