package defaultInterface;

public interface Formula {
    double calculate(int a);

    default double sqrt(int a){
        double result = Math.sqrt(a);
        return result;
    }
}
