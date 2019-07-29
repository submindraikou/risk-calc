import java.util.Scanner;

public class riskcalc {

    //n = data | s = size
    static String text(int n,int s){

        String t = " " + Integer.toString(n);

        while (t.length() < s){
            t = t + " ";
        }

        return t;

    }

    public static void main(String[] args) {

        System.out.print("This program helps view your risk when rolling your points at earn.gg's roll." + 
                        "\nIt assumes that you start by betting 10 points and double that betting amount every time you lose, or reset to 10 if you win." + 
                        "\nRoll #       -> The number of rolls that have been used." +
                        "\nPoints spent -> The amount of points needed to do x rolls." + 
                        "\nProfit       -> How many points you will gain if you win the current roll." + 
                        "\nRisk %       -> The chance that you will lose x rolls in a row.");
        System.out.print("Input the desired amount of rolls. > ");
        Scanner scan = new Scanner(System.in);
        int cap = scan.nextInt();

        System.out.print("Input the payback multiplier (2 - 9). > ");
        Scanner scan2 = new Scanner(System.in);
        int profit = scan2.nextInt();

        int lastspent = 5;
        int totalspent = 0;

        double[] risk = {0, 0, 0.51, 0.6767, 0.86, 0.81, 0.85, 0.87, 0.89, 0.90};

        System.out.println("Roll # | Points Spent |    Profit    | Risk %");

        for(int i = 1; i <= cap; i++){

            lastspent = lastspent*2;
            totalspent = totalspent + lastspent;
            System.out.println(text(i, 7) + "|" + 
                               text(totalspent, 14) + "|" + 
                               text(((lastspent*profit) - totalspent), 14) + "| " + 
                               Math.pow(risk[profit], (double)i));

        }
    }
}