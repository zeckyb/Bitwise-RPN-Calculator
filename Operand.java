// handles converting the expression into string and int representations

public class Operand {
    private String Soperand; // string 
    private int Noperand; // int (haha funny name)

    public Operand(String op){
        op = op.trim();
        if(!isValidBinary(op)){
            throw new IllegalArgumentException("Invalid binary number: " + op);
        }
        Soperand = op;
        Noperand = Integer.parseInt(op,2);
        /* 
        int mul = 8;

        for(int i=0;i<op.length();i++){
            Noperand+=mul*((int)(op.charAt(i))-(int)('0'));
            mul /= 2;
        }
        */
    }
    private boolean isValidBinary(String str){
        for(char c: str.toCharArray()){
            if(c!='0'&& c!='1'){
                return false;
            }
        }
        return true;
    }
    
    public String getBinStr(){
        return Soperand;
    }

    public int getBinNum(){
        return Noperand;
    }

    public String toString(){
        return Soperand + "-"+ Noperand;
    }
}
