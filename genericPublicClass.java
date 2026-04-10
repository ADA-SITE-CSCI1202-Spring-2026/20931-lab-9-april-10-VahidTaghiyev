public class genericPublicClass <T extends Number> {
    
    private T num;
    public genericPublicClass(T num){
        this.num = num;
    }
    
    public double reciprocal(){
        return 1.0/num.doubleValue();
    }
    
    public double fractionalPart(){
        return num.doubleValue() - Math.floor(num.doubleValue());
    }
    
    public static <T extends Number,V extends Number> boolean absEqual(T a, V b){
        return Math.abs(a.doubleValue()) == Math.abs(b.doubleValue());
    }




 

    public static void main(String[] args) {

        //Reciprocal
        genericPublicClass<Double> a = new genericPublicClass<>(62.11);
        System.out.println("Reciprocal of 5.0:       " + a.reciprocal());   

        genericPublicClass<Integer> b = new genericPublicClass<>(42);
        System.out.println("Reciprocal of 4:          " + b.reciprocal());  
        //Fractional
        genericPublicClass<Double> c = new genericPublicClass<>(23.233);
        System.out.printf("Fractional part of 9.76: %.2f%n", c.fractionalPart()); 

        genericPublicClass<Float> d = new genericPublicClass<>(3.14f);
        System.out.printf("Fractional part of 3.14: %.2f%n", d.fractionalPart()); 
        //Equals
        Double x = -3.5;
        Float  y =  3.5f;
        System.out.println("absEqual(-3.5, 3.5f):    " + absEqual(x, y));  // true

        Double p = 2.0;
        Float  q = 3.0f;
        System.out.println("absEqual(2.0, 3.0f):     " + absEqual(p, q));  // false
    }

}
