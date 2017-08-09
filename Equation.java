
/**
 * Write a description of class Equation here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Equation
{
    // instance variables - replace the example below with your own
    private String equation;
    private int[] signIndex;
    private String[] eqSplit;
    private int[] expArr;
    private double[] coefArr;
    private double[] addNums;
    /**
     * Constructor for objects of class Equation
     */
    public Equation(String eq)
    {
        equation = eq;
        makeExec();
    }

    public void makeExec(){
        int expIndex, xIndex;

        int counter = 0;
        int count = 0;
        int count1 = 0;
        equation = equation.replaceAll("\\s", "");
        for(int i = 0; i < equation.length(); i++){
            if(equation.charAt(i) == '+' || equation.charAt(i) == '-'){
                counter++;
            }
        }
        signIndex = new int[counter];
        counter = 0;
        for(int i = 0; i < equation.length(); i++){
            if(equation.charAt(i) == '+' || equation.charAt(i) == '-'){
                signIndex[counter] = i;
                counter++;
            }
        }
        
        //------------------------------------------------------------------------------------------        
        eqSplit = new String[counter + 1];
        expArr = new int[counter + 1];
        coefArr = new double[counter + 1];
        addNums = new double[counter + 1];
        eqSplit[0] = equation.substring(0, signIndex[0]);
        if(counter > 1){
        for(int i = 1; i < counter; i++){
            eqSplit[i] = equation.substring(signIndex[i - 1] + 1, signIndex[i]);
        }
    }
        eqSplit[counter] = equation.substring(signIndex[counter - 1] + 1, equation.length());
        //------------------------------------------------------------------------------------------
        
        for(int i = 0; i < eqSplit.length; i++){
            expIndex = -1;
            xIndex = -1;
            for(int j = 0; j < eqSplit[i].length(); j++){
                
                
                if(eqSplit[i].charAt(j) == '^'){
                    expIndex = j;
                }
                
                if(eqSplit[i].charAt(j) == 'x' || eqSplit[i].charAt(j) == 'X'){
                    xIndex = j;
                }
                
            }
            

            if(expIndex != -1){
                expArr[i] = Integer.parseInt(eqSplit[i].substring(expIndex + 1, eqSplit[i].length()));                   
            } else {
                expArr[i] = 1;
                
            }
            
          
            if(xIndex != -1){
                if(i > 0){
                    if(signIndex.length != 1){
                        count++;
                    }  else {
                        
                    }
                    
                    if(equation.charAt(signIndex[count]) == '+'){
                        if(xIndex != 0){
                            coefArr[i] = Double.parseDouble(eqSplit[i].substring(0, xIndex));
                    
                        } else {
                            coefArr[i] = 1;
                        }
                    } else if(equation.charAt(signIndex[count]) == '-'){
                        if(xIndex != 0){
                            coefArr[i] = Double.parseDouble(eqSplit[i].substring(0, xIndex)) * -1;
                        
                        } else {
                            coefArr[i] = -1;
                        }
                    }
                } else {
                    if(xIndex != 0){
                            coefArr[i] = Double.parseDouble(eqSplit[i].substring(0, xIndex));
                    
                        } else {
                            coefArr[i] = 1;
                        }
                }
                    addNums[i] = 0;
            } else {
                
                coefArr[i] = 0;
                if(i > 0){
                    if(signIndex.length != 1){
                    count1++;
                }
                if(equation.charAt(signIndex[count1]) == '+'){
                    
                    addNums[i] = Double.parseDouble(eqSplit[i]);
                } else {
                    addNums[i] = Double.parseDouble(eqSplit[i]) * -1;
                }
            }
            }
            
        }   

    }
    
    public double[] getCoefArr(){
        return coefArr;
    }
    
    public int[] getExpArr(){
        return expArr;
    }
    
    public double[] getAddNums(){
        return addNums;
    }
}
