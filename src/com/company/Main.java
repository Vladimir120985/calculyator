package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // считываем из консоли выражение
        Scanner console = new Scanner(System.in);
        String str = console.nextLine();

        //делим выражение на составные части и запихиваем в массив
        //критерий для деления - пробел
        String[] words = str.split(" ");

        if(words.length > 3){
            System.out.println("Чувак. ты ввел слишком много цифр для расчетов!!!");
            System. exit(0);
        }


        //создадим логические флажки, для определения в дальнейшем введеных значений
        boolean flagArabic1 = false, flagArabic2 = false, flagRoman1 = false, flagRoman2 = false, flagZnak = false;
        //создадим массив римских цифр
        String[] roman  = new String[] {"Нуля в римском исчислени нет", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                                                              "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                                                    "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
                                            "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                                            "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
                                            "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                                            "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                                          "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                                   "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                                                      "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C",
        };

        //сделаем проверку второго символа, является ли он плюсом, минусом, делением или умножением
        if (words[1].equals("-") | words[1].equals("+") | words[1].equals("*") | words[1].equals("/")){
            flagZnak = true; //если является, включаем флажок
        }else{
            //прекращение работы программы в случае некорректного ввода
            System.out.println("Некорректный символ математической операции");
            System. exit(0);
        }

        //проверяем первое выражение является ли оно числом
        //и не просто числом, а целым числом
        if (new Scanner(words[0]).hasNextInt() ) {
            //число не должно превышать 10
            if(Integer.parseInt(words[0]) < 11){
                flagArabic1 = true; //если является числом и меньше 10, включаем флажок
            } else {
                System.out.println("Первое число больше 10");
                System. exit(0); //прекращение работы программы
            }
        }

        //проверяем первое выражение является ли оно числом
        //и не просто числом, а целым числом
        if (new Scanner(words[2]).hasNextInt() ) {
            //число не должно превышать 10
            if(Integer.parseInt(words[2]) < 11) {
                flagArabic2 = true; //если является числом и меньше 10, включаем флажок
            }else {
                System.out.println("Второе число больше 10");
                System. exit(0); //прекращение работы программы
            }
        }

        if(flagArabic1 == true & flagArabic2 == false | flagArabic1 == false & flagArabic2 == true){
            System.out.println("Операции с арабскими и римскими цифрами одновременно недопустимы");
            System. exit(0); //прекращение работы программы
        }


        //проверяем на наличие римских цифр
        if(words[0].equals("I") | words[0].equals("II") | words[0].equals("III") | words[0].equals("IV") |
                words[0].equals("V") | words[0].equals("VI") | words[0].equals("VII") | words[0].equals("VIII") |
                words[0].equals("IX") | words[0].equals("X")){
                flagRoman1 = true;
        }
        //проверяем на наличие римских цифр
        if(words[2].equals("I") | words[2].equals("II") | words[2].equals("III") | words[2].equals("IV") |
                words[2].equals("V") | words[2].equals("VI") | words[2].equals("VII") | words[2].equals("VIII") |
                words[2].equals("IX") | words[2].equals("X")){
                flagRoman2 = true;
        }

        if (flagArabic1 == false & flagArabic2 == false & flagRoman1 == false & flagRoman2 == false){
            System.out.println("Некорректный ввод условия");
            System. exit(0); //прекращение работы программы
        }

        //расчеты с арабскими цифрами
        if(flagZnak == true & flagArabic1 == true & flagArabic2 == true){
            if (words[1].equals("-")){
                int result = Integer.parseInt(words[0])  - Integer.parseInt(words[2]);
                System.out.println(result);
            }else if (words[1].equals("+")){
                int result = Integer.parseInt(words[0])  + Integer.parseInt(words[2]);
                System.out.println(result);
            }else if (words[1].equals("*")){
                int result = Integer.parseInt(words[0])  * Integer.parseInt(words[2]);
                System.out.println(result);
            }else if (words[1].equals("/")){
                int result = Integer.parseInt(words[0])  / Integer.parseInt(words[2]);
                System.out.println(result);
            }
        }

        //расчеты с римскими цифрами
        if(flagZnak == true & flagRoman1 == true & flagRoman2 == true){
            int value1 = 0;
            int value2 = 0;
            //распознаем первое римское число
            if(words[0].equals("I")){
                 value1 = 1;
            } else if(words[0].equals("II")){
                 value1 = 2;
            } else if(words[0].equals("III")){
                 value1 = 3;
            } else if(words[0].equals("IV")){
                 value1 = 4;
            } else if(words[0].equals("V")){
                 value1 = 5;
            } else if(words[0].equals("VI")){
                 value1 = 6;
            } else if(words[0].equals("VII")){
                 value1 = 7;
            } else if(words[0].equals("VIII")){
                 value1 = 8;
            } else if(words[0].equals("IX")){
                 value1 = 9;
            } else if(words[0].equals("X")){
                 value1 = 10;
            }

            //распознаем второе римское число
            if(words[2].equals("I")){
                 value2 = 1;
            } else if(words[2].equals("II")){
                 value2 = 2;
            } else if(words[2].equals("III")){
                 value2 = 3;
            } else if(words[2].equals("IV")){
                 value2 = 4;
            } else if(words[2].equals("V")){
                 value2 = 5;
            } else if(words[2].equals("VI")){
                 value2 = 6;
            } else if(words[2].equals("VII")){
                 value2 = 7;
            } else if(words[2].equals("VIII")){
                 value2 = 8;
            } else if(words[2].equals("IX")){
                 value2 = 9;
            } else if(words[2].equals("X")){
                 value2 = 10;
            }

            //после распознавания начинаем расчет
            if (words[1].equals("-")){
                int result = value1 - value2;
                    if (result < 0){
                        System.out.println("Отрицательных чисел в римском исчислени нет");
                    }else {
                        System.out.println(roman[result]);
                    }
            }else if (words[1].equals("+")){
                int result = value1 + value2;
                System.out.println(roman[result]);
            }else if (words[1].equals("*")){
                int result = value1 * value2;
                System.out.println(roman[result]);
            }else if (words[1].equals("/")){
                int result = value1 / value2;
                System.out.println(roman[result]);
            }
        }





    }
}
