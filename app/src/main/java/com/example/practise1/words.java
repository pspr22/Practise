package com.example.practise1;

import java.text.DecimalFormat;

class words{
    private static final String[] tensNames ={
            "",
            " ten",
            " twenty",
            " thirty",
            " fourty",
            " fifty",
            " sixty",
            " sevnety",
            " eighty",
            " ninety",
    };

    private static final String[] numNames = {
            "",
            " one",
            " two",
            " three",
            " four",
            " five",
            " six",
            " seven",
            " eight",
            " nine",
            " ten",
            " eleven",
            " twelve",
            " thirteen",
            " fourteen",
            " fifteen",
            " sixteen",
            " seventeen",
            " eighteen",
            " nineteen"
    };

    private words(){
    }
    public static String convertLessThanThousand(int number){
        String soFar;
        if(number%100 < 20){
            soFar =numNames[number%100];
            number /= 100;
        }
        else{
            soFar = numNames[number%10];
            number /= 10;
            soFar = tensNames[number%10]+soFar;
            number /= 10;
        }
        if(number == 0){
            return soFar;
        }
        return  numNames[number]+ " hundred"+soFar;
    }

    public static String convert(long number){
        if(number == 0){
            return " zero";
        }
        String snumber = Long.toString(number);

        String mask ="000000000000";
        DecimalFormat df = new DecimalFormat(mask);
        snumber = df.format(number);

        int billions = Integer.parseInt(snumber.substring(0,3));
        int millions = Integer.parseInt(snumber.substring(3,6));
        int hundredThousands = Integer.parseInt(snumber.substring(6,9));
        int thousands = Integer.parseInt(snumber.substring(9,12));

        String tradBillions;
        switch (billions){
            case 0:
                tradBillions = "";
                break;
            case 1:
                tradBillions = convertLessThanThousand(billions)+" billion ";
                break;
            default:
                tradBillions = convertLessThanThousand(billions)+" billion ";
        }
        String result = tradBillions;

        String tradmillions;
        switch(millions){
            case 0:
                tradmillions = "";
                break;
            case 1:
                tradmillions = convertLessThanThousand(millions)+" million ";
                break;
            default:
                tradmillions = convertLessThanThousand(millions)+" million ";
        }
        result += tradmillions;

        String tradHundredThousands;
        switch(hundredThousands){
            case 0:
                tradHundredThousands = "";
                break;
            case 1:
                tradHundredThousands = " one thousand ";
                break;
            default:
                tradHundredThousands = convertLessThanThousand(hundredThousands)
                        +" thousand ";
        }
        result += tradHundredThousands;

        String tradThousand;
        tradThousand = convertLessThanThousand(thousands);
        result += tradThousand;

        return result.replaceAll("^\\s+","")
                .replaceAll("\\b\\s{2,}\\b"," ");

    }


}
