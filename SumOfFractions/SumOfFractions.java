import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SumOfFractions {

static String[] fractionSum(String[] str) {
        
        String res[] = new String[str.length];
        
        int i,n, minFrac_1, minFrac_2, minNumerator, minDenominator;
        String frac_addition = "", frac_reduction = "";
        for(i = 0; i < str.length; i++){
            int s[] = new int[3];
            String twoFractions[] = str[i].split("\\+");
            
            String fraction_1[] = twoFractions[0].split("/");
            int numerator_1 = Integer.parseInt(fraction_1[0]);
            int denominator_1 = Integer.parseInt(fraction_1[1]);
            
            String fraction_2[] = twoFractions[1].split("/");
            int numerator_2 = Integer.parseInt(fraction_2[0]);
            int denominator_2 = Integer.parseInt(fraction_2[1]);
            
            //calculate minNumerator and minDenominator
            minNumerator = calcMin(numerator_1, numerator_2);
            minDenominator = calcMin(denominator_1, denominator_2);
            
            //Calculate minimum value (N or D) from each of the fractions
            minFrac_1 = calcMin(numerator_1, denominator_1);
            minFrac_2 = calcMin(numerator_2, denominator_2);
            
            //reduce functions
            s = reduceFractions(numerator_1, denominator_1, minFrac_1);
            numerator_1 = s[0];
            denominator_1 = s[1];
            
            s = reduceFractions(numerator_2, denominator_2, minFrac_2);
            numerator_2 = s[0];
            denominator_2 = s[1];
            
            //check if denominators are same (After reduction process)
            if(denominator_1 == denominator_2){
                int D_addition = 0;
                int N_addition = numerator_1 + numerator_2;
                int min_new_frac = calcMin(N_addition, denominator_2);
                s = reduceFractions(N_addition, denominator_2, min_new_frac);
                N_addition = s[0];
                D_addition = s[1];
                frac_addition = N_addition + "/" + D_addition;
                
                res[i] = frac_addition;
                //System.out.println(frac_addition);
            }
            else{
                //calculate reduced functions of denominators (to prevent values exceeding integer limit)    
                s = reduceFractions(denominator_1, denominator_2, minDenominator);
                denominator_1 = s[0];
                denominator_2 = s[1];
                int numDivided = s[2];
                
                //cross product
                int newNum = numerator_1*denominator_2 + numerator_2*denominator_1;
                int newDen = denominator_1*denominator_2*numDivided;
                int min_newNum_newDen = calcMin(newNum, newDen);
                
                s = reduceFractions(newNum, newDen, min_newNum_newDen);
                newNum = s[0];
                newDen = s[1];
                frac_addition = newNum + "/" + newDen;
                
                res[i] = frac_addition;
                //System.out.println(frac_addition);
            }
            
        }
        return res;
    }


    public static int[] reduceFractions(int numerator, int denominator, int minFrac){
        int s[] = new int[3];
        int numDivided = 1;
        for(int n = 2; n <= minFrac; n++){
            while(numerator%n == 0 && denominator%n == 0){
                numerator = numerator/n;
                denominator = denominator/n;
                numDivided = numDivided * n;
            }
        }
        s[0] = numerator;
        s[1] = denominator;
        s[2] = numDivided;
        return s;
    }

    public static int calcMin(int a, int b){
        return ((a < b) ? a : b);
    }
    
    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        String[] res;
        
        int _str_size = 0;
        _str_size = Integer.parseInt(in.nextLine().trim());
        String[] _str = new String[_str_size];
        String _str_item;
        for(int _str_i = 0; _str_i < _str_size; _str_i++) {
            try {
                _str_item = in.nextLine();
            } catch (Exception e) {
                _str_item = null;
            }
            _str[_str_i] = _str_item;
        }
        
        res = fractionSum(_str);
        for(int res_i=0; res_i < res.length; res_i++) {
            System.out.println(res[res_i]);
        }
    }

}
