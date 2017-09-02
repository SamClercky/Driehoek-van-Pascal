package com.samclercky.bignumber;

import java.util.ArrayList;

/**
 * This is a class where you can store very big numbers
 * @author Clercky
 */
public class BigNumber {
    private ArrayList<Boolean> bigNumber;
    
    public BigNumber(long dec) {
        bigNumber = toBin(dec);
    }
    public BigNumber(BigNumber number) {
        bigNumber = number.getArrayList();
    }
    public BigNumber(ArrayList<Boolean> number) {
        bigNumber = number;
    }
    
    /**
     * Calcs the sum of the 2 numbers
     * @param number
     * @return 
     */
    public static BigNumber sum(BigNumber... numbers) {
        ArrayList<Boolean> result = new ArrayList<>();
        Boolean firstTime = true;
        
        for(BigNumber num : numbers) {
            if (firstTime) {
                result = num.getArrayList();
                firstTime = false;
                continue;
            }
            result = sum(result, num.getArrayList());
        }
        
        return new BigNumber(result);
    }
    
    private static ArrayList<Boolean> sum(ArrayList<Boolean> num1, ArrayList<Boolean> num2) {
        ArrayList<Boolean> result = new ArrayList<>();
        Boolean onthouden = false;
        int index = 0;
        
        Boolean number1;
        Boolean number2;
        
        while(num1.size() > index || num2.size() > index) {
            int numTrue = 0;
            number1 = (num1.size() > index) ? num1.get(index) : false;
            number2 = (num2.size() > index) ? num2.get(index) : false;
            
            numTrue += (onthouden) ? 1:0;
            numTrue += (number1) ? 1:0;
            numTrue += (number2) ? 1:0;
            
            switch(numTrue) {
                case 0:
                    result.add(index, false);
                    onthouden = false;
                    break;
                case 1:
                    result.add(index, true);
                    onthouden = false;
                    break;
                case 2:
                    result.add(index, false);
                    onthouden = true;
                    break;
                case 3:
                    result.add(index, true);
                    onthouden = true;
                    break;
            }
        }
        
        return result;
    }
    
    /**
     * Compiles dec to bin
     * @param dec
     * @return 
     */
    private ArrayList<Boolean> toBin(long dec) {
        ArrayList<Boolean> result;
        
        // init
        int biggestMacht = calcBiggestMachtOf2(dec);
        result = fillEmpty(biggestMacht+1);
        result.set(biggestMacht, Boolean.TRUE);
        
        while (dec > 0) {
            dec -= calcMacht(2, biggestMacht);
            biggestMacht = calcBiggestMachtOf2(dec);
            result.set(biggestMacht, Boolean.TRUE);
        }
        
        return result;
    }
    private String getDec() {
        // TODO convert bin to dec
        return "0";
    }
    private long calcMacht(int num, int macht) {
        for (int i = 0; i < macht; i++) {
            num *= num;
        }
        
        return num;
    }
    private int calcBiggestMachtOf2(long dec) {
        int curr = 0;
        int prev = 0;
        
        while(dec > calcMacht(2, curr)) {
            prev = curr;
            curr++;
        }
        
        return prev;
    }
    /**
     * Creates a empty arrayList
     * @param count initialcount
     * @return new arrayList
     */
    private ArrayList<Boolean> fillEmpty(int count) {
        ArrayList<Boolean> result = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            result.add(false);
        }
        
        return result;
    }
    
    // accessors
    public ArrayList<Boolean> getArrayList() {
        return bigNumber;
    }
    
    @Override public String toString() {
        return getDec();
    }
}
