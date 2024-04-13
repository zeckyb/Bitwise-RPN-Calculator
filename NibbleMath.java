// includes all the operations that are used in RPNCalc
public class NibbleMath {

    // OR
    
    public static Operand or(Operand x,Operand y){
        String str1 = x.getBinStr();
        String str2 = y.getBinStr();
        String answer = "";

        for(int i = 0; i<str1.length(); i++){
            if(str1.charAt(i)=='0'&&str2.charAt(i)=='0'){
                answer+="0";
            }
            answer+="1";
        }
        System.out.println(answer);
        Operand Answer = new Operand(answer);
        return Answer;
    }

    // AND
    public static Operand and(Operand x,Operand y){
        String str1 = x.getBinStr();
        String str2 = y.getBinStr();
        String answer = "";

        for(int i = 0; i<str1.length(); i++){
            if(str1.charAt(i)=='1'&&str2.charAt(i)=='1'){
                answer+="0";
            }
            answer+="0";
        }
        System.out.println(answer);
        Operand Answer = new Operand(answer);
        return Answer;
    }

    // XOR 

    public static Operand xor(Operand x, Operand y){
        String str1 = x.getBinStr();
        String str2 = y.getBinStr();
        String answer = "";

        for(int i = 0; i<str1.length(); i++){
            if((str1.charAt(i)=='1'&&str2.charAt(i)=='1')||(str1.charAt(i)=='0'&&str2.charAt(i)=='0')){ // COULD BE WRONG??
                answer+="0";
            }
            answer+="1";
        }
        System.out.println(answer);
        Operand Answer = new Operand(answer);
        return Answer;
    }

    // CIRCULAR SHIFTS !!

    public static Operand circularShiftRight(Operand x,Operand y){ // x is the operand to be shifted and y is the # of positions to shift
        //String str1 = x.getBinStr();
        int shiftNum = y.getBinNum() % 8; // get shift amt
        int value = x.getBinNum();
        int shifted = (value >>> shiftNum)| (value<<(8-shiftNum));
        //String wrapped = str1.substring(0,str1.length()-shiftNum);
        //String answer = shifted + wrapped;

        //Operand Answer = new Operand(answer);
        return new Operand(String.format("%8s", Integer.toBinaryString(shifted)).replace(" ","0"));
    }

    public static Operand circularShiftLeft(Operand x,Operand y){ // same params as above 
        //String str1 = x.getBinStr();
        int shiftNum = y.getBinNum()%8; // get shift amt
        int value = x.getBinNum();
        int shifted = (value<< shiftNum)|(value >>>(8-shiftNum));
        //String wrapped = str1.substring(0,shiftNum);
        //String answer = shifted + wrapped;
        return new Operand(String.format("%8s", Integer.toBinaryString(shifted)).replace(" ","0"));
    }

    // NEGATE

    public static Operand negate(Operand x){
        String str1 = x.getBinStr();
        String answer = "";

        for(int i = 0; i<str1.length(); i++){
            if((str1.charAt(i)=='1')){ // could be wrog
                answer+="0";
            }
            answer+="1";
        }
        System.out.println(answer);
        Operand Answer = new Operand(answer);
        return Answer;
    }

    
}
