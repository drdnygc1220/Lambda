package day01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


    public class Lambda02 {
        public static void main(String[] args) {
            List<String> meyve = new ArrayList<>(Arrays.asList("elma","portakal","uzum","cilek","greyfurt","nar",
                    "mandalina","armut","elma","keciboynuzu","elma"));

            basınaVeSonunaYıldız(meyve);//*elma* *portakal* *uzum* *cilek* *greyfurt* *nar* *mandalina* *armut* *elma* *keciboynuzu* *elma*
            System.out.println();
            eHarfı(meyve);//elma cilek greyfurt elma keciboynuzu elma
            System.out.println();
            lHaarfiniSil(meyve);//ema portaka uzum ciek greyfurt nar mandaina armut ema keciboynuzu ema
            System.out.println();
            karakterSayısınaGoreSırala(meyve);//nar elma uzum elma elma cilek armut portakal greyfurt mandalina keciboynuzu
            System.out.println();
            karakterSayısınaGoreSıralaMethodReferance(meyve);//keciboynuzu mandalina portakal greyfurt cilek armut elma uzum elma elma nar
            System.out.println();


        }
        // SORU1 : List elemanlarının ilk harfi 'e' veya 'c' olanlari,
        // Method References ile aralarında bosluk bırakarak yazdıralım
        public static void ılkHarfiEVeyaC(List<String>meyve){
            meyve.stream().
                    filter(t->t.startsWith("e") || t.startsWith("c")).
                    forEach(Utils::yazdır);




        }
        // SORU2 : List elemanlarının hepsinin basina ve sonuna yildiz ekleyerek yazdiralim
        public static void basınaVeSonunaYıldız(List<String>meyve){
            meyve.stream().
                    map(t->"*"+t+"*").
                    forEach(Utils::yazdır);

        }
        // SORU3 : List elemanlarının icinde 'e' harfi olanları yazdırın
        public static void eHarfı(List<String>meyve){
            meyve.stream().
                    filter(t->(t.contains("e"))).
                    forEach(Utils::yazdır);

        }
        // SORU4 : List elemanlarındaki 'l' harflerini silip yazdırınız
        public static void lHaarfiniSil(List<String>meyve){
            meyve.stream().map(t->t.replace("l","")).forEach(Utils::yazdır);


        }
        // SORU5 : List elemanlarini, Lambda Expression kullanarak
// karakter sayisina göre kucukten buyuge dogru sıralayarak yazdırınız
        public static void karakterSayısınaGoreSırala(List<String>meyve){
            meyve.stream().
                    sorted(Comparator.comparing(t->t.length())).//kuralı  biz belirledik..
                    forEach(Utils::yazdır);
        }
        // SORU6 : List elemanlarini, Method References kullanarak
// karakter sayisina göre buyukten kucuge dogru sıralayarak yazdırınız
        public static void  karakterSayısınaGoreSıralaMethodReferance(List<String>meyve){
            meyve.stream().
                    sorted(Comparator.comparing(String::length).reversed()).//kuralı  biz belirledik..
                    // string methodundaki lengh methodunu kullanıyorum...
                    //method referance dediğinde hazır methodları kullanıyoruz..

                            forEach(Utils::yazdır);
        }

    }


