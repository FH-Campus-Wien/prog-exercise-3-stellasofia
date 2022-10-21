package at.ac.fhcampuswien;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class App {

    // Implement all methods as public static


    public static void oneMonthCalendar(int numDays,int startDay){
        //if bedingung mit modulo
        //rechtsbündig, soutprintf ( %, ... ) oder andere Bedingung

        int row;
        int count = 1;
        int column = startDay;


        if ((numDays+startDay)%7!=0){
            row = (numDays/7)+1;
        } else {
            row = numDays/7;
        }
        for (int i = 1; i < startDay; i++){
            System.out.print("   ");
        }

        for (int j = 0; j < row; j++){
            while (column <= 7) {
                System.out.printf("%2d ",count);
                if (count == numDays){
                    System.out.println();
                    return;
                }
                column++;
                count++;
            }
            column = 1;
            System.out.println();
        }
    }


    public static long[] lcg(long seed){
        long m = ((long) Math.pow(2,31));
        long a  = 1103515245;
        long c = 12345;

        long[] randomNumbers = new long[10];
        randomNumbers[0] =  (a * seed + c) % m;

        for (int i = 1; i < randomNumbers.length; i++){
            randomNumbers[i] = (a*randomNumbers[i-1] + c) % m;
        }
        for (long number : randomNumbers){
            System.out.println(number + " ");
        }

        return randomNumbers;

    }

    public static void guessingGame(int numberToGuess){
        int guess;
        Scanner scan = new Scanner(System.in);
        for(int i = 0; i < 10; i++){
            System.out.print("Guess number " + (i+1) + ": ");
            guess = scan.nextInt();
            if(i == 10-1){
                System.out.println("You lost! Have you ever heard of divide & conquer?");
                break;
            }

            if(guess > numberToGuess){
                System.out.println("The number AI picked is lower than your guess.");
            }else if(guess < numberToGuess){
                System.out.println("The number AI picked is higher than your guess.");
            }
            else{
                System.out.println("You won wisenheimer!");
                break;
            }
        }
    }

    public static int randomNumberBetweenOneAndHundred(){
        Random random = new Random();
        return random.nextInt(100)+1;
    }

    public static boolean swapArrays(int[] arrayOne, int[] arrayTwo){
        int temp;
        if (arrayOne.length != arrayTwo.length){
            return false;
        }
            for (int i = 0; i < arrayOne.length; i++){
                temp = arrayOne[i];
                arrayOne[i] = arrayTwo[i];
                arrayTwo[i] = temp;
            }
        return true;
    }

    public static String camelCase(String text){
        char[] textChar = text.toCharArray();
        if (textChar[0] >= 97 && textChar[0] <= 122) {
            textChar[0] = (char)(textChar[0] - 32);
        }

        for (int i = 0; i <textChar.length; i++){
            if (i >= 1 && textChar[i-1] != ' ' && textChar[i] >= 65 && textChar[i] <= 90){
                textChar[i] += 32;
            }if (i >= 1 && textChar[i-1] == ' ' && textChar[i] >= 97 && textChar[i] <= 122){
                textChar[i] -= 32;
            }
        }
        for (int i = 0; i < textChar.length; i++) {
            if ((textChar[i] > 0 && textChar[i] <= 64) || (textChar[i] >= 91 && textChar[i] <= 96) || (textChar[i] >= 123 && textChar[i] <= 127)){
                textChar[i] = 32;
            }
        }
        return String.valueOf(textChar).replaceAll(" ","");
    }

    public static int checkDigit(int[] arrayOne) {
        int gewichtung = 2;
        int sum = 0;
        int modulo;
        for (int i = 0; i < arrayOne.length; i++) {
            sum += arrayOne[i] * (gewichtung + i);
        }
        modulo = sum % 11;
        if (11-modulo==10)
            return 0;
        if (11-modulo==11)
            return 5;

        return 11-modulo;
    }



    public static void main(String[] args) { //Kommandozeilen Parameter - Zeichenketten die Übergeben werden, könne vom Programm intepretiert werden. , Typischerweise keine runtime arguments
        oneMonthCalendar(30,3);
        //Prozeduales Programmieren: übersichtlichkeit, strukturierung, kleines Programm für sich
        lcg(12345);
        //wird hier abgespeichert, sonst lebt das nur innerhalb der methode wenn es ausgeführt wird
        //das Zuweisen nicht nötig bei zb. void Methode, chaining des return Werts
        guessingGame(randomNumberBetweenOneAndHundred());
        int[] arrayOne = new int[]{1,2,3,4,5,6};
        int[] arrayTwo = new int[]{100,202,30,14,15,16};
        swapArrays(arrayOne, arrayTwo);
        //Aufgabe 5: rechen mit Char - vom kleinbuchstaben den großbuchstaben abziehen = differenz
        //System.out.println((int)('a' - 'A')); // to upper = -32 :)
        //Aufgabe 6:
        checkDigit(arrayOne);
    }
}