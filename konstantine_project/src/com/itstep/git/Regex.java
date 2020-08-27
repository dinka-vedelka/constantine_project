package com.itstep.git;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

    public static void main(String[] args) {
        //  Дана строка с целыми числами. Преобразуйте строку так, чтобы вместо этих чисел стояли их квадраты

        String numbers = "2 5 10 20";
        Pattern pattern = Pattern.compile("([\\d]+)");
        Matcher matcher = pattern.matcher(numbers);

        matcher.find();

        System.out.println("Source numbers:\t" + numbers);

        numbers = matcher.replaceAll(matchResult -> {
            int num = Integer.parseInt(matchResult.group());
            return num * num + " ";
        });

        System.out.println("Sqrt numbers:\t" + numbers);

        /*
        Определите, что переданная строка является корректным временем вида '12:59', '23:41', '00:12', '00:00', '09:15'.
        Время '24.00', '25.00', '12.60', '12.93', '41.93' является некорректным
        */

        System.out.println("\nValidate 24 hours format time");

        pattern = Pattern.compile("^(2[0-3]|[01]?[0-9]):([0-5]?[0-9])$");

        String input;
        System.out.println("------ Positive test:");
        System.out.println("Is " + (input = "12:59") + " valid: " + pattern.matcher(input).matches());
        System.out.println("Is " + (input = "23:41") + " valid: " + pattern.matcher(input).matches());
        System.out.println("Is " + (input = "00:12") + " valid: " + pattern.matcher(input).matches());
        System.out.println("Is " + (input = "00:00") + " valid: " + pattern.matcher(input).matches());
        System.out.println("Is " + (input = "09:15") + " valid: " + pattern.matcher(input).matches());

        System.out.println("\n------ Negative test:");
        System.out.println("Is " + (input = "24.00") + " valid: " + pattern.matcher(input).matches());
        System.out.println("Is " + (input = "25.00") + " valid: " + pattern.matcher(input).matches());
        System.out.println("Is " + (input = "12.60") + " valid: " + pattern.matcher(input).matches());
        System.out.println("Is " + (input = "12.93") + " valid: " + pattern.matcher(input).matches());
        System.out.println("Is " + (input = "41.93") + " valid: " + pattern.matcher(input).matches());
    }
}
