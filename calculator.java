class areacalculator {
    void area(int a) {
        int result = a * a;
        System.out.println("Area of square: " + result);
    }
    void area(int l,int b){
        int result=l*b;
        System.out.println("Area of Rectangle: "+result);
    }
    void area(double r){
        double result=Math.PI*r*r;
        System.out.println("Area of circle: "+result);
    }
}
class calculator{
    public static void main(String[]args){
        areacalculator ar=new areacalculator();
        ar.area(10);
        ar.area(5,7);
        ar.area(3.5);
    }
}