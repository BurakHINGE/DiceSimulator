import java.util.Scanner;

public class diceSimulator {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Zar Simulator Programına Hoş Geldiniz!");
        System.out.println("Programda 10 tane eşit yüzlü hilesiz zarımız var.");
        System.out.println("Girmiş olduğunuz miktar kadar tüm zarları atacağız ve gelen sayıların toplamının listesini bastıracağız.");

        System.out.println("Her zarı kaç defa atalım: ");
        int N = input.nextInt();

        int[] resultArray = new int[51];

        for (int i = 10; i < 61; i++) 
        {
            resultArray[i-10] = i;
        }

        int[] sums = diceSim(N);

        int[] countArray = new int[51];

        for (int val : sums) {
            countArray[val - 10]++;
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

    public static int[] diceSim(int number) {
        
        int[] diceArray = new int[number];

        for (int j = 0; j < number; j++) {
            int sum = 0;
            for (int i = 0; i < 10; i++) {
                int diceNumber = (int) (Math.random() * 6) + 1;
                sum += diceNumber;
            }

            diceArray[j] = sum;
            
        }
        
        return diceArray;
    }
    
}
