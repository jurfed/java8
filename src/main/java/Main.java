import defaultInterface.Formula;
import defaultInterface.FormulaImpl;
import functionalInterface.Converter;
import interfaceFactory.Person;
import interfaceFactory.PersonFactory;

public class Main {
    public static void main(String[] args) {

//example 1 default method
        FormulaImpl formula = new FormulaImpl();
        System.out.println(formula.sqrt(9));

//example 2 lambda
        Formula f = (a) -> a*a;

        double res = f.calculate(4);
        System.out.println(res);

//example 3 функциональные интерфейсы
        //1
        Converter<String, Integer> converter = from -> Integer.valueOf(from);
        System.err.println(converter.convert("1000")*2);

        //2
        Converter<String, Integer> converter2 = Integer::valueOf;
        System.err.println(converter2.convert("123")*2);

        //3
        class SomethingDoing{
            Integer doSomething(String s){
                return Integer.valueOf(s);
            }
        }

        Converter<String, Integer> converter3 = new SomethingDoing()::doSomething;
        System.err.println(converter3.convert("333")/3);

//example 4 ссылка на конструктор
        PersonFactory<Person> personFactory = Person::new;
        Person person = personFactory.create("Ivan", "Ivanov");
        System.out.println(person);


    }
}
