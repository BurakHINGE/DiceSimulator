import java.util.Scanner;

public class eng_DiceSimulator {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the Dice Simulator Program!");
        System.out.println("We have fair dice with 6 sides.");
        System.out.println("We will roll all dice according to the number of dice and rolls you enter, and print a list of the sums.");

        System.out.println("How many dice would you like to roll: ");
        int diceCount = input.nextInt();

        System.out.println("How many times should we roll each die: ");
        int rollTimes = input.nextInt();

        int maxNum = diceCount * 6 + 1;
        int numCount = diceCount * 5 + 1;

        int[] resultArray = new int[numCount];

        for (int i = diceCount; i < maxNum; i++) 
        {
            resultArray[i-diceCount] = i;
        }

        int[] sums = diceSim(rollTimes, diceCount);

        int[] countArray = new int[numCount];

        for (int val : sums) {
            countArray[val - diceCount]++;
        }

        for (int i = 0; i < resultArray.length; i++)
        {
            System.out.print(resultArray[i] + ": ");

            for (int j = 0; j < countArray[i]; j++)
            {
                System.out.print("*");
            }

            System.out.println();
        }
    }

    public static int[] diceSim(int rollTimes, int diceCount) {
        
        int[] diceArray = new int[rollTimes];

        for (int j = 0; j < rollTimes; j++) {
            int sum = 0;
            for (int i = 0; i < diceCount; i++) {
                int diceNumber = (int) (Math.random() * 6) + 1;
                sum += diceNumber;
            }

            diceArray[j] = sum;           
        }
        
        return diceArray;
    }  
}