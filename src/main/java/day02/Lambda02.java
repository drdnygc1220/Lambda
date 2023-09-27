

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lambda02 {
    public static void main(String[] args) {
        //stringle lambda yapacagız şimdi..
        List<String> myList = new ArrayList<>();
        myList.add("Ali");
        myList.add("Elif");
        myList.add("Yusuf");
        myList.add("Elif");
        myList.add("Zeynep");
        myList.add("Mustafa");

        printElementsExceptsStartsWithE(myList);
        System.out.println();
        printDistinctElementLenghtLessThanFive(myList);
        System.out.println();
        List<String> newList = getElementLengthMoreThanFiveWithUpperCase(myList);
        System.out.println(myList);
        printDistinchLengthLessThanFiveUniqueUpperCase(myList);
        System.out.println();
        printElementUniqueLowerCaseSortWithLenght(myList);
        System.out.println();

    }

    //Example 1: Bir List'teki E ile baslayanlar haric tum elemanlari console'a yazdiran method'u olusturunuz.
    public static void printElementsExceptsStartsWithE(List<String> myList) {
        myList.
                stream().
                filter(t -> !t.startsWith("E")).
                forEach(t -> System.out.print(t + " "));
    }

    //Example 2: Bir List'te character sayisi 5 den az olan tum elemanlari
    // tekrarsiz olarak console'a yazdiran method'u olusturunuz.
    public static void printDistinctElementLenghtLessThanFive(List<String> myList) {
        myList.
                stream().
                distinct().
                filter(t -> t.length() < 5).
                forEach(t -> System.out.print(t + " "));

    }

    //Example 3: Bir List'teki character sayisi 5 den cok olan tum elemanlari buyuk
    // harflerle bir listin icinde veren method'u olusturunuz.......//listin içinde istediği için void demiyoruz
    public static List<String> getElementLengthMoreThanFiveWithUpperCase(List<String> myList) {//void yerine List<String> yazılıyor
        return myList.
                stream().
                filter(t -> t.length() > 5).
                map(t -> t.toUpperCase()).
                collect(Collectors.toList());

    }
    //Example 4: Bir List'teki character sayisi 5 den az olan tum elemanlari tekrarsiz olarak kucuk harflerle
    // natural order da console'a yazdiran method'u olusturunuz.

    public static void printElementsLengthLessThanFiveUniqueLowerCase(List<String> myList) {

        myList.
                stream().
                distinct().
                filter(t -> t.length() < 5).
                map(t -> t.toLowerCase()).
                sorted().
                forEach(t -> System.out.print(t + " "));
    }
    //Example 5: Bir List'teki elemanlari tekrarsiz olarak buyuk harflerle alfabetik sirada
// console'a yazdiran method'u olusturunuz.
    public static void  printDistinchLengthLessThanFiveUniqueUpperCase(List<String>myList){
        myList.
                stream().
                distinct().//tekrarsız
                map(t->t.toUpperCase()).//dönüştürmek için
                sorted().forEach(t-> System.out.print(t+" "));//ALİ ELİF MUSTAFA YUSUF ZEYNEP...harf sıralamasına göre yazıdık
    }
    //Example 6: Bir List'teki elemanlari tekrarsiz olarak kucuk harflerle uzunluklarina gore kucukten buyuge
    // siralayarak console'a yazdiran method'u olusturunuz.
    public static void printElementUniqueLowerCaseSortWithLenght(List<String>myList){
        myList.
                stream().
                distinct().
                map(t->t.toLowerCase()).
                sorted(Comparator.comparing(t->t.length())).//benim verdiğim kurala göre yap.biz belirliyorsak bu methodu kullanıyoruz..
                forEach(t-> System.out.print(t+" "));

    }
}

