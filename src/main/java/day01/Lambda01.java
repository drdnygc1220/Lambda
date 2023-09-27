package day01;

import java.util.*;
import java.util.stream.Collectors;



import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

    public class Lambda01 {


        public static void main(String[] args) {


            List<Integer> sayi = new ArrayList<>(Arrays.asList(-5, -8, -12, 0, 1, 12, 5, 5, 6, 9, 15, 8));

            ciftVePozitifLambdaExpression(sayi);//12 6 8 12 6 8
            System.out.println();
            ciftVePozitifMethodReferences(sayi);//12 6 8
            System.out.println();
            kare(sayi);//25 64 144 0 1 144 25 25 36 81 225 64
            System.out.println();
            kareTekrarsız(sayi);//25 64 144 0 1 36 81 225
            System.out.println();
            buyukdenKucuge(sayi);//15 12 9 8 6 5 5 1 0 -5 -8 -12
            System.out.println();
            PozitifKüpBirlerBasamagıBes(sayi);//125 125 3375
            System.out.println();
            toplamıMethodRefence(sayi);//Optional[36]
            System.out.println();
            toplamıMethodRefence2(sayi);//36
            System.out.println();
            toplamıLambdaExpression(sayi);//toplamı=36
            System.out.println();
            //...return ettiğimiz için sout içinde yazdık..
            System.out.println(pozitifCarpimLambdaExpression(sayi));//1944000
            System.out.println();
            System.out.println(cıftKareKucuktenBuyuge(sayi));//[0, 36, 64, 64, 144, 144]


        }

        //SORU1: List elemanlarının çift ve pozitif olanlarını,
        // Lambda Expression kullanarak aralarında bosluk olacak sekilde yazdırın

        public static void ciftVePozitifLambdaExpression(List<Integer> sayi) {

            // 1.Yol
            sayi.stream().filter(t -> t % 2 == 0 && t > 0).forEach(t -> System.out.print(t + " "));

            // 2.Yol
            sayi.stream().filter(t -> t % 2 == 0).filter(t -> t > 0).forEach(t -> System.out.print(t + " "));

        }


        //SORU2: List elemanlarının çift ve pozitif olanlarını,
        // Method Referances kullanarak aralarında bosluk olacak sekilde yazdırın

        public static void ciftVePozitifMethodReferences(List<Integer> sayi) {

            sayi.stream().
                    filter(Utils::cıftPozitifBul).//foreach yerine method kullanarak cektik..
                    forEach(Utils::yazdır);

        }

        //SORU3)List elemanlarının karelerini aralarında boşluk olacak şekilde yazdır..
        public static void kare(List<Integer> sayı) {
            sayı.stream().map(t -> t * t).forEach(Utils::yazdır);
        }

        //SORU4 : List elemanlarının karelerini, tekrarsiz yazdırın
        public static void kareTekrarsız(List<Integer> sayı) {
            sayı.
                    stream().
                    map(t -> t * t).//akıştan gelen elemanları kareleriyle degişikliğe ugrattı..
                    distinct().
                    forEach(Utils::yazdır);


        }

        //SORU5)List elemeanlarını büyükten küçüge sıralayanız....
        public static void buyukdenKucuge(List<Integer> sayi) {
            sayi.
                    stream().
                    sorted(Comparator.reverseOrder()).//sıralama yapmak için default küçükten büyüğe dogru sıralar.AMA SORU TERSİNİ SORUDGU İÇİN
                    forEach(Utils::yazdır);

        }
        // SORU6 : List elemanlarının pozitif olanlarının, kuplerini bulup, birler basamagı 5 olanları yazdırınız

        public static void PozitifKüpBirlerBasamagıBes(List<Integer> sayi) {
            sayi.stream().
                    filter(t -> t > 0).
                    map(t -> t * t * t).
                    filter(t -> t % 10 == 5).//birler basamagı 5 dir..
                    forEach(Utils::yazdır);

        }

        // SORU7: List elemanlarının Method References ile toplamını bulun ve yazdırın
        public static void toplamıMethodRefence(List<Integer> sayi) {//java tedirgin oldu optional almak zorndayız..ınt null kabul etmeyeck çünkü...
            Optional<Integer> referance = sayi.stream().
                    reduce(Integer::sum);//lambdanın hazır methodlarını kullandık..Integer::sum..topladıı
            //akıştan gelen elemanları tek bir eleman olarak cıkaracagım..=REDUCE

            //forEach gelmiyor..terminal methoddur.reduce sonra kullanmayız..Integer değere isayn ettik..
            System.out.println(referance);
        }


        // 2.yol...
        public static void toplamıMethodRefence2(List<Integer> sayi) {
            int referance2 = sayi.
                    stream().
                    reduce(Integer::sum).
                    get();
            System.out.println(referance2);


        }

        // SORU8: List elemanlarının Lambda Expression ile toplamını bulun ve yazdırın
        public static void toplamıLambdaExpression(List<Integer> sayi) {//burada java tedirgin olmuyor.çünkü lambda expression kullandık ilk degeri biz kendimiz verdik..
            int sonuc = sayi.
                    stream().
                    reduce(0, (a, b) -> a + b);//toplamı ınteger oldugu için kavanoza koyduk
            System.out.println(sonuc);
        }

        //SORU10 : Listin cift elemanlarının, karelerini, kucukten buyuge sıralayıp list halinde return ederek yazdırınız
        public static List<Integer> cıftKareKucuktenBuyuge(List<Integer> sayi) {
            List<Integer> list= sayi.stream().
                    filter(t -> t % 2 == 0).
                    map(t -> t * t).
                    sorted().//default olarak küçükten büyüge sıralar..
                            collect(Collectors.toList());//liste cevirdik..
            return list;


        }
        //SORU9 : Listin pozitif elemanlarının, carpımını Lambda Expression ile return ederek yazdırın
        public static int pozitifCarpimLambdaExpression(List<Integer> sayi){
            int sonuc = sayi.stream().
                    filter(t->t>0).
                    reduce(1,(a,b)->a*b);

            return sonuc;
        }


    }







