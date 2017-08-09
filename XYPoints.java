
/**
 * Write a description of class XYPoints here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class XYPoints
{
    double xyVals[][];
    double convertToArr[];

    /**
     * Constructor for objects of class XYPoints
     */
    public XYPoints(Equation eq, double range)
    {
        getXYPoints(eq.getCoefArr(), eq.getExpArr(), eq.getAddNums(), range);
    }

    public double[][] getXYPoints(double[] coefArr, int[] expArr, double[] addArr, double range){
        int countIndex = 0;
        xyVals = new double[(int)(range * 2 / 0.01) + 1][2];
        double yVal;
        for(double x = 0; x < range; x = x + 0.01){
            yVal = 0;
            for(int i = 0; i < coefArr.length;i ++){
                
                yVal += (Math.pow(x, expArr[i])) * coefArr[i] + addArr[i];
            }
                xyVals[countIndex][0] = x;
            xyVals[countIndex][1] = yVal;
            countIndex++;
        }
        countIndex = xyVals.length / 2;
        
        
        for(double x = 0; x > -1 * range; x -= 0.01){
            yVal = 0;
            for(int i = 0; i < coefArr.length;i ++){
                
                yVal += (Math.pow(x, expArr[i])) * coefArr[i] + addArr[i];
            }
            if(countIndex >= xyVals.length){
                break;
            }
            xyVals[countIndex][0] = x;
            xyVals[countIndex][1] = yVal;
            countIndex++;
            
        }
        return xyVals;
    }
    
    public double[][] getGraphPoints(){
        return null;
    }
    public double[][] getPoints(){
        return xyVals;
    }
}
