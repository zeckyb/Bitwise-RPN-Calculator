// uses switch case to perform calculator operations; includes functions like clear, push, pop, top value, length, + isEmpty

public class RPNCalc implements Stack{
    private static final int STACKSIZE = 100;
    private Operand[] stack;
    private int TOS = -1; // why is this -1
    private int stkdepth; // what is this again?

    public RPNCalc(){
        stack = new Operand[STACKSIZE];
        stkdepth = 0;
    }

    public Operand eval(String expression){
        /* 
        String[] explst = expression.split(" ",0);
        StringBuilder expressionBuilder = new StringBuilder();
        //System.out.println(explst);
        for(int i = 0;i<explst.length;i++){
            System.out.println(explst[i]);
        }

        for(int i=0;i<explst.length;i++){
            switch(explst[i]){
*/
        StringBuilder expressionBuilder = new StringBuilder();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '0' || c == '1') {
                // If the character is a binary digit, push it onto the stack and append it to the expression
                Operand v = new Operand(String.valueOf(c));
                this.push(v);
                expressionBuilder.append(c);
            } else if (c == '+' || c == '-' || c == '*' || c == '^' || c == '>' || c == '<' || c == '!') {
                // If the character is an operator, pop the operands, perform the operation, and push the result onto the stack
                Operand result = performOperation(c);
                this.push(result);
                expressionBuilder.append(c);
            } else if (c == '.') {
                // If the character is a dot, it represents the end of the expression, so break the loop
                break;
            }
        }
        
        String finalExpression = expressionBuilder.toString();
        System.out.println("The expression produces: ");
        System.out.println(finalExpression);

        Operand result = (Operand) this.pop();
        System.out.println("Answer: "+result.getBinStr());
        return result;
    
        //System.out.println("end");
        //return null;
    }
    /* 
    private Operand performOperation(char operator){
        Operand a = (Operand) this.pop();
        Operand b = (Operand) this.pop();

        switch(operator){
            case '+':
                System.out.println("+: pop 2 values and \"or\" them together");
                Operand a1 = (Operand) this.pop();
                Operand b1 = (Operand) this.pop();
                Operand ans1 = NibbleMath.or(a1,b1);
                this.push(ans1);
                break;
            case '*':
                System.out.println("-: pop 2 values and \"and\" them");
                Operand a2 = (Operand) this.pop();
                Operand b2 = (Operand) this.pop();
                Operand ans2 = NibbleMath.and(a2,b2);
                this.push(ans2);

                break;
            case '^': // XOR
                System.out.println("^: pop 2 values and XOR them");
                Operand a3 = (Operand) this.pop();
                Operand b3 = (Operand) this.pop();
                Operand ans3 = NibbleMath.xor(a3,b3);
                this.push(ans3);
                break;
            case '>':
                System.out.println(">: pop 1 value and circular shift right x many bits");
                Operand a4 = (Operand) this.pop();
                Operand b4 = (Operand) this.pop();
                Operand ans4 = NibbleMath.circularShiftRight(a4,b4);
                this.push(ans4);
                break;
            case '<':
                System.out.println("<: pop 2 value and circular shift right x many bits");
                Operand a5 = (Operand) this.pop();
                Operand b5 = (Operand) this.pop();
                Operand ans5 = NibbleMath.circularShiftRight(a5,b5);
                this.push(ans5);
                break;
            case '!': 
                System.out.println("!: pop 1 value and negate");
                Operand a6 = (Operand) this.pop();
                Operand ans6 = NibbleMath.negate(a6);
                this.push(ans6);
                break;
            
            case '.':
                System.out.println(".: reveal top of stack");
                if(TOS>0){
                    System.out.println(this.topValue());
                    break;
                }
                System.out.println("NULL");
                break;
            case '-':
                System.out.println("-: pop current element at TOS");
                if(TOS>0){
                    this.pop();
                    break;
                }
                System.out.println("ERROR");
                break;
                
            case '$':
                System.out.println("$: displays all elements in stack\n");
                System.out.println(this.toString());
                break;

            default:
                throw new IllegalArgumentException("Invalid Operator: "+ operator);
                /* 
                Operand v = new Operand(explst[i]);
                this.push(v);
                //System.out.println("PUSH THIS: "+explst[i]);
                expressionBuilder.append(explst[i]);
                break;
                
            
        }
        
    }
    */
    private Operand performOperation(char operator) {
        Operand a = (Operand) this.pop();
        Operand b = (Operand) this.pop();
        
    
        switch (operator) {
            case '+':
                return NibbleMath.or(a, b);
            case '-':
                return NibbleMath.and(a, b);
            case '*':
                return NibbleMath.xor(a, b);
            case '^':
                return NibbleMath.circularShiftRight(a, b); // Call the method on the instance
            case '>':
                return NibbleMath.circularShiftRight(a, b); // Call the method on the instance
            case '<':
                return NibbleMath.circularShiftLeft(a, b); // Call the method on the instance
            case '!':
                return NibbleMath.negate(a);
            default:
                // Handle invalid operator
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    /* 
        String finalExpression = expressionBuilder.toString();
        System.out.println("The expression produces: ");
        System.out.println(finalExpression);

        Operand result = (Operand) this.pop();
        System.out.println("Answer: "+result.getBinStr());
        return result;
    
        //System.out.println("end");
        //return null;
    }
    */
    
   // System.out.println("end");
    //return null;

    @Override
    public void clear() {
        while (stkdepth!=0){
            this.pop();
        }
    }

    @Override
    public boolean push(Object it) {
        System.out.println("push");
        TOS++;
        stack[TOS] = (Operand) it;
        stkdepth++;
        return true;
    }

    @Override
    public Object pop() {
        stkdepth--;
        TOS--;
        return stack[TOS+1];
    }

    @Override
    public Object topValue() {
        if(TOS>0){
            System.out.println("TOS");
            return stack[TOS];
        }
        return null;
    }

    @Override
    public int length() {
       return stkdepth;
    }

    @Override
    public boolean isEmpty() {
        if(TOS==0){
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();

        if(isEmpty()){
            str.append(" << TOS >> \n[EMPTY]\n");
        }
        str.append(" << TOS >> \n");
        for(int i= TOS; i>=0;i--){
            //str.append(String.format("[$4d]\n", stack[i]));
            str.append(stack[i].toString()).append("\n");
        }
    
    return str.toString();
    }
    
}
