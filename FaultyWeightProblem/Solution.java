import java.io.*;
import java.util.*;

class Solution {
  
  public static void main(String[] args) {
    
    double w1 = 1.0, w2 = 1.1;
    System.out.println("Initialize all bottles as 1gm per pill per bottle");
    double a[] = new double[20];
    for(int i = 0; i < 20; i++){
      a[i] = w1;
    }
  
    int j = 1;
    double sum = 0;
    for (int i = 0; i < 20; i++) {
      sum = sum + (a[i] * j);
      j++;
    }
    
    System.out.println("Calculated sum = " + sum);
    
    System.out.println("Assume bottle number 6 is faulty");
    a[5] = w2;
    
    double sum2 = 0;
    j = 1;
    for (int i = 0; i < 20; i++) {
      sum2 = sum2 + (a[i] * j);
      j++;
    }
    
    System.out.println("New sum = " + sum2);  
    
    double sumDiff = (double)Math.round((sum2 - sum) * 100) / 100;
    System.out.println("sumDiff = " + sumDiff);  
    
    double faultyBottle = Math.round(sumDiff / (w2 - w1));
    System.out.println("faultyBottle = " + (int)faultyBottle);  
    
  }
}
