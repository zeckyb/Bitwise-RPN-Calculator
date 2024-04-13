import java.util.Scanner;

public class RPNTester{
    public static void main(String args[]){
        System.out.println("begin !!");
        System.out.println("~~~~~~~~");

        RPNCalc mycalc = new RPNCalc();
        Scanner kb = new Scanner(System.in); // create a scanner class
        System.out.println("Please enter your expression: \n");
        String expression = kb.nextLine().replaceAll("\\s","");
        kb.close();
        System.out.println(mycalc.eval(expression)); 
    }
}
