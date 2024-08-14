import java.util.Scanner;

public class calcProj extends funcs{
    public static void main(String[] args){
        System.out.println("*****calculator*****");
        Scanner abc = new Scanner(System.in);
        System.out.println("\n1 - Add\n2 - Subtract\n3 - Divide\n4 - Multiply\n5 - logarithm\n6 - trig functions\n7 - quadratic solver\n8 - quit");
        int xyz = 0;

        while(xyz!=8){
            System.out.print("\nenter the number against the function you want to access : ");
            xyz = abc.nextInt();
            switch(xyz){
                case 1:
                    System.out.print("Adding two numbers:\nenter number 1 : ");
                    double num1 = abc.nextDouble();
                    System.out.print("enter number 2 : ");
                    double num2 = abc.nextDouble();
                    System.out.println("Sum : "+(num1+num2)); 
                    break;

                case 2:
                    System.out.print("Subtracting number 2 from number 1:\nenter number 1 : ");
                    double num3 = abc.nextDouble();
                    System.out.print("enter number 2 : ");
                    double num4 = abc.nextDouble();
                    System.out.println("Sum : "+(num3-num4)); 
                    break;

                case 3:
                    System.out.print("Dividing number 1 by number 2:\nenter number 1 : ");
                    double num5 = abc.nextDouble();     //exception handling baaki hai
                    System.out.print("enter number 2 : ");
                    double num6 = abc.nextDouble();
                    if(num6!=0){System.out.println("Sum : "+(num5/num6)); }
                    else{System.out.println("Can't divide by zero!");}
                    break;

                case 4:
                    System.out.print("Multipying two numbers:\nenter number 1 : ");
                    double num7 = abc.nextDouble();
                    System.out.print("enter number 2 : ");
                    double num8 = abc.nextDouble();
                    System.out.println("Sum : "+num7*num8); 
                    break;

                case 5:
                    System.out.print("Enter the base : ");     //exception handling
                    double base = abc.nextDouble();
                    System.out.print("Enter the number : ");
                    double num = abc.nextDouble();
                    if(base>0 && num>0 && base!=1){System.out.print(log(num)/log(base));}
                    else{System.out.println("Can't evaluate logarithm.")}
                    break;

                case 6:
                    System.out.print("Enter value(radian) : ");
                    double val = abc.nextDouble();
                    System.out.print("Choose from the following(Enter integer):\n1.sine\n2.cosine\n3.tangent\n4.cosecant\n5.secant\n6.cotangent");
                    int ch = abc.nextInt();
                    switch(ch){
                        case 1:
                            System.out.println(sine(val));
                            break;
                        case 2:
                            System.out.print(cosine(val));
                            break;
                        case 3:
                            System.out.print(tangent(val));
                            break;
                        case 4:
                            System.out.print(1/sine(val));
                            break;
                        case 5:
                            System.out.print(1/cosine(val));
                            break;
                        case 6:
                            System.out.print(1/tangent(val));
                            break;
                        default: System.out.print("Invalid input.");           //re initiate loop
                    }
                    
                case 7:
                    System.out.print("Enter coefficients A, B, C corresponding to A(x^2)+B(x)+C");
                    System.out.print("A : ");
                    double A = abc.nextDouble();
                    System.out.print("B : ");
                    double B = abc.nextDouble();
                    System.out.print("C : ");
                    double C = abc.nextDouble();
                    quad(A,B,C);

            }
        }
    }
}

class funcs{

    double pi = 3.14159;

    private static int fact(int a){
        if(a == 0){
            return 1;
        }
        int fact=1;
        for(int i=a;i>0;i--) {
            fact*=i;
        }
        return fact;
    }

    private static double pow(double a, int b){
        double pow = 1;
        for (int i=0;i<b;i++) {
            pow*=a;
        }
        return pow;
    }

    private static double powFloat(double a, double b){
        return exp(log(a)*b);
    }

    public static double sine(double a){
        double sin=0;
        for(int i=0;i<10;i++){
            sin += pow(-1,i) * pow(a,2*i+1) / fact(2*i+1);
        }
        return sin;    //no of precision places
    }

    public static double cosine(double a){
        double cos=0;
        for(int i=0;i<10;i++){
            cos += pow(-1,i) * pow(a,2*i) / fact(2*i);
        }
        return cos;    //no of precision places
    }

    public static double tangent(double a) {
        double tan = sine(a)/cosine(a);
        return tan;
    }

    public static double exp(double a){
        double result = 0;
        for (int i=0;i<10;i++) {
            result += pow(a,i) / fact(i);
        }
        return result;
    }

    public static double log(double x) {
    if (x <= 0) throw new IllegalArgumentException("Logarithm undefined for non-positive values");     //exception handling

    double low = 0;
    double high = x;
    double mid;
    double tolerance = 1e-15;
    
    while (high - low > tolerance) {
        mid = (low + high) / 2;
        double power = exp(mid);
        if (power < x) {
            low = mid;
        } else {
            high = mid;
        }
    }

    return (low + high) / 2;
    }


    public static void quad(double a,double b,double c){
        double discri = pow(b,2)-4*a*c;
        if (discri<0){
            System.out.print("no real roots!!");
        }
        else {
            double root1 = (-b+powFloat(discri,0.5))/(2*a);
            double root2 = (-b-powFloat(discri,0.5))/(2*a);
            System.out.print("the roots of the given equation are : "+root1+" and "+root2);
        }
    }
}


