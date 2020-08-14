import defaultInterface.Formula;
import defaultInterface.FormulaImpl;
import functionalInterface.Converter;
import interfaceFactory.Person;
import interfaceFactory.PersonFactory;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Predicate;

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

//example 5 предикаты
//Предикаты — это функции, принимающие один аргумент, и возвращающие значение типа boolean.
        Predicate<String> predicate = (s) -> s.length() > 0;
        System.out.println(predicate.test("qwerty"));

        Predicate<String> isEmpty = String::isEmpty;
        System.out.println(isEmpty.test("1"));


//example 6 функции
        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = toInteger.andThen(integer -> "Васе " + (integer + 1) + " лет");

        System.out.println(backToString.apply("20"));     // "123"

//example 7 компараторы
        Comparator<Person> comp = (person1, person2) -> person1.firstName.compareTo(person2.firstName);

        Person person1 = new Person("A" ,"B");
        Person person2 = new Person("C" ,"D");
        System.out.println(comp.compare(person1, person2));
        System.out.println(comp.reversed().compare(person1, person2));

    }
}
