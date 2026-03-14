import java.util.Scanner;
public class tr_DiceSimulator {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Zar Simulator Programına Hoş Geldiniz!");
        System.out.println("Programda 6 yüzü bulunan hilesiz zarlarımız var.");
        System.out.println("Girmiş olduğunuz zar sayısı ve zar atma miktarı kadar tüm zarları atacağız ve gelen sayıların toplamının listesini bastıracağız.");

        System.out.println("Kaç tane zar atmak istersiniz: ");
        int diceCount = input.nextInt();

        System.out.println("Her zarı kaç defa atalım: ");
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