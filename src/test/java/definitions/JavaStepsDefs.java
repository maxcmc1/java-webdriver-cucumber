package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import pages.*;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class JavaStepsDefs {
    @Given("I say hello world")
    public void iSayHelloWorld() {
        String var1 = "Hello World";
        System.out.println(var1);

        String firstName = "Maks";
        String lastName = "Seli";
        System.out.println("Full name: " + firstName + " " + lastName);

        String firstNameAgain = "Maks";
        System.out.println(firstNameAgain.length());
    }

    @And("I say {string}")
    public void iSay(String message) {
        System.out.println("Simon says " + message);
    }


    //Methods Exercises
    @Given("I perform actions with {string} and {string}")
    public void iPerformActionsWithAnd(String seleniumWebdriver, String seleniumWebdriver2) {

        System.out.println(seleniumWebdriver + " " + seleniumWebdriver2);

        System.out.println((seleniumWebdriver + " " + seleniumWebdriver2).toUpperCase());

        System.out.println(seleniumWebdriver.length() + " " + seleniumWebdriver2.length());

        System.out.println((seleniumWebdriver + " " + seleniumWebdriver2).toUpperCase());

        System.out.println((seleniumWebdriver + " " + seleniumWebdriver2).toUpperCase());

        System.out.println(seleniumWebdriver.equals(seleniumWebdriver2));

        System.out.println(seleniumWebdriver.equalsIgnoreCase(seleniumWebdriver2));

        System.out.println(seleniumWebdriver.contains(seleniumWebdriver2));
        System.out.println();

    }


    @Given("I perform variable evaluation with digits {int} and {int}")
    public void iPerformVariableEvaluationWithDigitsAnd(int num1, int num2) {

        //Numbers exercises

        //dividing an integer by an integer and print results to the console
        int division = num1 / num2;
        System.out.println("Division of digits is " + division);

        // dividing an integer by a float
        int intNum = 20;
        double floatNum = 4;
        System.out.println(intNum / floatNum);


        int myNumber1 = 25;
        int myNumber2 = 5;

        //Sum
        int sum = myNumber1 + myNumber2;
        System.out.println("Sum is " + sum);

        //difference
        int difference = myNumber1 - myNumber2;
        System.out.println("difference is " + difference);

        //quotient
        int quotient = myNumber1 / myNumber2;
        System.out.println("quotient is " + quotient);

        //product
        int product = myNumber1 * myNumber2;
        System.out.println("product is " + product);


    }

    //Conditions Exercise
    @Given("I compare {string} and {string} strings")
    public void iCompareAndStrings(String word1, String word2) {

        if (word1.equals(word2)) {
            System.out.println("Strings are equal");
        } else if (!word1.equals(word2)) {
            System.out.println("Strings are not equal");
        }
    }

    //Conditions Exercise
    @Given("I print url for {string} page")
    public void iPrintUrlForPage(String site) {
        if (site.equals("google")) {
            System.out.println("https://www.google.com");
        } else if (site.equals("sample")) {
            System.out.println("https://skryabin.com/webdriver/html/sample.html");
        }
    }


    @Given("Is this your favorite color {string}")
    public void isThisYourFavoriteColor(String color) {

        if (color.equalsIgnoreCase("green")) {
            System.out.println("My favorite color is " + color);
        } else {
            System.out.println(color + " is not favorite color");
        }
    }


    @And("I print if number {int} is {string}")
    public void iPrintIfNumberIs(int number, String result) {
        if (number >= 0 && result.equalsIgnoreCase("positive")) {
            System.out.println(number + " is positive");
        } else if (number < 0 && result.equalsIgnoreCase("negative")) {
            System.out.println(number + " is negative");
        } else {
            System.out.println("Invalid input");
        }

    }

    @And("I print {int} th day of week")
    public void iPrintThDayOfWeek(int dayNum) {
        switch (dayNum) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("No day of the week exists");
                break;
        }
    }


    //==========================================================================================

    @Given("I work with arrays and loops")
    public void iWorkWithArraysAndLoops() {
        String[] fruits = {"apple", "plums", "kiwi", "orange"};

        System.out.println(fruits[0]);

        for (String fruit : fruits) {  // ForEach loop (enhanced)
            System.out.println(fruit);
        }

        List<String> myFruits = Arrays.asList("apple", "plums", "kiwi", "orange");

        for (String myFruit : myFruits) { // ForEach loop (enhanced)
            System.out.println(myFruit);
        }

        for (int i = 0; i < myFruits.size(); i++) { // regular for loop
            System.out.println(myFruits.get(i));
        }


        int[] nums = {5, 2, 3, 2, 5};
        System.out.println(nums[0]);

        for (int num : nums) { // ForEach loop (enhanced)
            System.out.println("number is " + num);
        }

        List<Integer> myNums = Arrays.asList(2, 4, 6, 8);

        for (int myNum : myNums) {  // ForEach loop (enhanced)
            System.out.println("number is " + myNum);
        }

        for (int i = 0; i < myNums.size(); i++) { // regular for loop
            System.out.println("number is " + myNums.get(i));
        }

    }

    @Given("Function that swaps two array elements")

    // O(1)
    public void functionThatSwapsTwoArrayElements() {
        int[] myNums = {5, 2, 9, 7, 3};

        for (int myNum : myNums) {
            System.out.println(myNum);
        }

        System.out.println();

        int tempNum = myNums[1];
        myNums[1] = myNums[3];
        myNums[3] = tempNum;

        for (int myNum : myNums) {
            System.out.println(myNum);
        }

    }

    @Given("I work with maps")
    public void iWorkWithMaps() {
        Map<String, String> user = Map.of(
                "username", "jdoe",
                "password", "welcome",
                "email", "john@doe.com"
        );

        Map<String, String> admin = Map.of(
                "username", "admin",
                "password", "pass",
                "email", "admin@doe.com"
        );
        System.out.println(user);
        System.out.println(admin);
        System.out.println(user.get("username"));
        System.out.println(user.get("password"));
        System.out.println(user.get("email"));

    }

    @Given("HashMap variable called myInfo")
    public void hashmapVariableCalledMyInfo() {
        Map<String, String> myInfo = Map.of(
                "firstName", "Max",
                "lastName", "Seli",
                "hometown", "Athens",
                "favoriteFood", "Greek"
        );

        System.out.println(myInfo);
        System.out.println();

        System.out.println(myInfo.get("firstName"));
        System.out.println(myInfo.get("lastName"));
        System.out.println(myInfo.get("hometown"));
        System.out.println(myInfo.get("favoriteFood"));

    }

    @Given("Swap values of firstName and middleName in a Map")
    public void swapValuesOfFirstNameAndMiddleNameInAMap() {


        Map<String, String> info = new LinkedHashMap<>(Map.of(
                "firstName", "John",
                "middleName", "George"
        ));

        System.out.println("map before swap: " + info);

        String temp1 = info.get("firstName");

        info.put("firstName", info.get("middleName"));
        info.put("middleName", temp1);

        System.out.println("map after swap: " + info);

    }

    //==================================================================================================
    @Given("Declare variables")
    public void declareVariables() {

        String firstName = "Max";
        String lastName = "Seli";
        String favoriteColor = "green";

        System.out.println(firstName);
        System.out.println(lastName);
        System.out.println(favoriteColor);


    }

    @Given("Using variables firstName, lastName and favoriteColor print to the console")
    public void usingVariablesFirstNameLastNameAndFavoriteColorPrintToTheConsole() {
        String firstName = "Max";
        String lastName = "Seli";
        String favoriteColor = "green";

        System.out.println("Hi, my name is " + firstName + " " + lastName + ", my favorite color is " + favoriteColor);
    }


    @Given("Try calling different methods on String variables you declared and print the results")
    public void tryCallingDifferentMethodsOnStringVariablesYouDeclaredAndPrintTheResults() {
        String firstName = "Max";
        String lastName = "Seli";
        String favoriteColor = "green red ";


        System.out.println(firstName.length());
        System.out.println();

        System.out.println(firstName.getClass());
        System.out.println();

        System.out.println(lastName.toLowerCase());
        System.out.println();

        System.out.println(lastName.toUpperCase());
        System.out.println();

        System.out.println(favoriteColor.trim() + "blue");
        System.out.println();

        String str1 = firstName + lastName;
        System.out.println();

        System.out.println("Length of string = " + str1.length());

        System.out.println("Is this string empty? = " + str1.isEmpty());
        System.out.println();

    }

    @Given("Given I perform actions with {string} and {string}")
    public void givenIPerformActionsWithAnd(String var1, String var2) {
        System.out.println(var1);
        System.out.println(var2);

        System.out.println();

        System.out.println(var1.toUpperCase());
        System.out.println(var2.toUpperCase());

        System.out.println();

        System.out.println(var1.length());
        System.out.println(var2.length());

        System.out.println();

        System.out.println(var1.equals(var2));

        System.out.println();

        System.out.println(var1.equalsIgnoreCase(var2));

        System.out.println();

        System.out.println(var1.contains(var2));

    }

    @And("Swap two variables")

    // O(1)
    public void swapTwoVariables() {

        // using temp variable
        int a = 2;
        int b = 4;

        System.out.println("a = " + a);
        System.out.println("b = " + b);

        int temp = 2;
        a = b;
        System.out.println("a after swapping = " + a);

        b = temp;
        System.out.println("b after swapping = " + b);

        System.out.println();

        //without using temp variable
        int x = 8;
        int y = 3;

        System.out.println("x = " + x);
        System.out.println("y = " + y);

        x = x + y; // = 11

        y = x - y; // = 11 - 3
        System.out.println("y after swapping = " + y); // = 8
        x = x - y; // = 11 - 8
        System.out.println("x after swapping = " + x); // = 11

    }


    @Given("Function that accepts integer {int} and prints")
    public void functionThatAcceptsIntegerAndPrints(int number) {

        // O(1)
        if (number % 2 == 0 && number % 5 == 0) {
            System.out.println(number + " divisible by 2 and 5");
        } else if (number % 2 == 0) {
            System.out.println(number + " divisible by 2");
        } else if (number % 5 == 0) {
            System.out.println(number + " divisible by 5");
        } else {
            System.out.println(number + " not divisible by 2 and 5");
        }
    }

    @Given("Coding tasks Day eleven")
    public void codingTasksDayEleven() {

//        // Write a function that prints all numbers from 0 up to n
//        printNum(7);
//
//        System.out.println();
//
//        //Write a function that supports also negative numbers
//        printNegativeNum(-7);
//
//        System.out.println();
//
//        //Write a function that prints all integer array
//        Integer [] arr = {19, 2, 8, -122, 9};
//        printArr(arr);
//
//        System.out.println();
//
//        // Write a function that prints all even numbers from integer array
//        printArrEven(arr);
//
//        System.out.println();
//
//        // Write a function that checks if array is empty
//        Integer[] newArr = {};
//        System.out.println("array is empty = " + isArrEmpty(newArr));
//        System.out.println("array is empty = " + isArrEmpty(arr));
//
//        System.out.println();
//
//        // Write a function that checks if array is not empty
//        System.out.println("array is not empty = " + isNotEmpty(newArr));
//        System.out.println("array is not empty = " + isNotEmpty(arr));
//
//        System.out.println();
//
//        // Write a function that checks if array contains another element
//        String[] strArr = {"apple", "orange", "pumpkin"};
//        System.out.println("apple = " + isContaining(strArr, "apple"));
//        System.out.println("6 = " + isContaining(arr, 6));
//
//        System.out.println();
//
        // Function that reverse characters in words
//        String str = "Web Driver";
//        reverseWords(str);


        // function, accepts integer argument. It should print all the numbers up to the argument
//        fizzBuzz(20);

        // Function that finds max number in an array
//        int [] arr = {9, 2, 8, -122, 19};
//        System.out.println(maxValueArr(arr));


        // Function reverse words in string
//        System.out.println(reverseWords("Hello World!"));

        // String is palindrome
//        System.out.println(isPalindrome("madam"));


        // functions finds tow max numbers
//        int [] arr = {7, 12, 11};
//        twoMaxNumbers(arr);


        // Function that verifies if number is prime
//        System.out.println(isPrime(7));

//
//        // Function to print every third character in string
//        System.out.println(printReversed("WebDriverA"));
//
//
//        // function that sorts an array
//        int[] myArray = {90, 8, 55, 1};
//        System.out.println(Arrays.toString(sort(myArray)));
//
//
//        // function that find factorial of a number
//        System.out.println(factorial(5));


        // function that finds if sum of any of 2 elements in an array result in number
//        int[] arr2 = {4, 8, 4, 1, 11};
//        int sum = 16;
//        System.out.println(isResultSum(arr2, sum));


        // function that finds Fibonacci number sequence
        System.out.println(fib(1));
        System.out.println(fib(5));
        System.out.println(fib(10));

    }

    // function that finds Fibonacci number sequence in recursive call
    long fib(int num){
        if (num == 0 || num == 1){
            return num;
        }
        return fib(num - 1) + fib(num - 2);
    }

    // function that finds Fibonacci number sequence
    // 1 1 2 3 5 8 13 21 34 55 89 144
    // perFib = 0
    // nextFib = 1
    long fibFor(int seq){
        long prevFib = 0;
        long nextFib = 1;

        for (int i = 1; i < seq; i++){
            long temp = nextFib;
            nextFib = prevFib + nextFib;
            prevFib = temp;
        }
        return nextFib;
    }


    // function that finds if sum of any of 2 elements in an array result in number
    boolean isResultSum(int[] arr, int sum){
        for(int i = 0; i < arr.length - 1; i++){
            for(int j = i + 1; j < arr.length; j++){
                if(arr[i] + arr[j] == sum){
                    return true;
                }
            }
        }
        return false;
    }



    // function that find factorial of a number
    long factorial(long num){
        if(num == 0) {
            return 1;
        }
        return num * factorial(num - 1);
    }

    // O(n^2)
    // function that sorts an array
    int[] sort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++){
            for (int j = i + 1; j < arr.length; j++){
                if(arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }


    // Function to print every third character in string
    String printReversed (String str){
        String reversed = "";
        int j = 1;
        for(int i = str.length() - 1; i >= 0; i--){
            if(j % 3 == 0) {
                reversed += str.charAt(i);
            }
            System.out.println(j);
            j++;
        }
        return reversed;
    }


    // Function that verifies if number is prime
    boolean isPrime(int num){
        if(num < 2){
            return false;
        }
        for(int i = 2; i < num; i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }

    // O(n)
    // functions finds tow max numbers
    void twoMaxNumbers(int[] maxNums){
        int maxOne = Integer.MIN_VALUE;
        int maxTwo = Integer.MIN_VALUE;
        for(int i = 0; i < maxNums.length; i++){
            if(maxOne < maxNums[i]){
                maxTwo = maxOne;
                maxOne = maxNums[i];
            } else if(maxTwo < maxNums[i]){
                maxTwo = maxNums[i];
            }
        }
        System.out.println(maxOne + " & " + maxTwo);
    }


    // String is palindrome
    boolean isPalindrome(String word){
        String reverse = "";
        for (int i = word.length() - 1; i >= 0; i--){
            reverse += word.charAt(i);
        }
        return word.equalsIgnoreCase(reverse);
    }



      // O(n)
    // Function reverse words in string
//  String reverseWords(String phrase){
//        String[] phraseArr = phrase.split(" "); // 'split' function is to split phrase by whatever is provided as 'Regex' inside of double quotes
//        String reversePhrase = "";
//
//        for (int i = phraseArr.length - 1; i >=0; i--){
//            reversePhrase += " " + phraseArr[i];
//        }
//        return reversePhrase;
//  }



            // O(n)
        // Function that finds max number in an array
//    int maxValueArr(int[] numbers){
//        int maxValue = numbers[0];
//        for (int i = 1; i < numbers.length; i++){
//            if(maxValue < numbers[i]){
//                maxValue = numbers[i];
//            }
//        }
//        return maxValue;
//    }

            // O(n)
//         Function, accepts integer argument. It should print all the numbers up to the argument
    void fizzBuzz(int maxNumber) {
        for (int i = 1; i <= maxNumber; i++) {
            if (((i % 5) == 0) && ((i % 3) == 0)) {
                System.out.println("FizzBuzz");
            } else if ((i % 3) == 0) {
                System.out.println("Fizz");
            } else if ((i % 5) == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }

         // O(n)
        // Function that reverse characters in words
//    void printReversed (String str){
//        for(int i = str.length() - 1; i >= 0; i--){
//            System.out.print(str.charAt(i));
//        }
//    }

    // element search binary (assuming array sorted)
    // [4, 6, 9, 11, 234, 535, 580]
    //  0  1  2   3   4    5    6
    // O(log n)
    boolean binarySearch(int[] arr, int num){
        int low = 0; // 0
        int high = arr.length - 1; // 6
        while (low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] == num){
                return true;
            } else if(arr[mid] < num){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

//
//          O(n)
//    // Write a function that checks if array contains another element
    boolean isContaining(Object[] arr, Object other){
        for (int i = 0; i < arr.length; i++){
            if(arr[i].equals(other)){
                return true;
            }
        }
        return false;
    }
//
//    // Write a function that checks if array is not empty
//    boolean isNotEmpty(Integer[] arr){
//        if(arr != null && arr.length != 0){
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//          // O(1) - because speed of execution of this function doesn't change no matter how much data we feed to it
//    // Write a function that checks if array is empty
//    boolean isArrEmpty(Integer[] arr){
//        if(arr == null || arr.length == 0){
//            return true;
//        } else {
//            return false;
//        }
//    }
//
            // O(n)
//    // Write a function that prints all even numbers from integer array
//    void printArrEven(Integer[] arr){
//        for(int i = 0; i < arr.length; i++){
//            if(arr[i] % 2 == 0){
//                System.out.println(arr[i]);
//            }
//        }
//    }
//
//          O(n)
//    // Write a function that prints all integer array
//    void printArr(Integer[] arr){
//        for(int i = 0; i < arr.length; i++){
//            System.out.println(arr[i]);
//        }
//    }
//
//    // Write a function that supports also negative numbers
//    void printNegativeNum (int num) {
//        for(int i = 0; num <= i; i--){
//            System.out.println(i);
//        }
//    }
//
//          O(n)
//    // Write a function that prints all numbers from 0 up to n
//    void printNum(int num){
//        for(int i = 0; i <= num; i++){
//            System.out.println(i);
//        }


//    }


    // function that sorts an array


    @Given("I run classes")
    public void iRunClasses() {
        // here we reviewed:
        // Encapsulation (fields that we hide from public)
        // Inheritance (ability to extend class and we have access to all in it)
        // Abstraction (When we create class like Pet or Animal and work with that)
        // Polymorphism - static and dynamic

        Pet tom = new Cat("Tom"); // creating an object or instance of the class 'Cat'
        System.out.println("Cat's name: " + tom.getName());
        tom.walk();
        tom.eat("fish");

        // will go to Cat's class implementation of speak() - dynamic POLYMORPHISM
        tom.speak();

        System.out.println();

        Pet charlie = new Dog();
        charlie.setName("Charlie");
        System.out.println("Dog's name: " + charlie.getName());
        charlie.walk();
        charlie.eat("bone");

        // will go to Dog's class implementation of speak() - dynamic POLYMORPHISM
        charlie.speak();

        System.out.println();

        Pet baks = new Rabbit();
        baks.setName("Baks");
        System.out.println("Rabbit's name: " + baks.getName());
        baks.walk();
        baks.eat("carrot");

        // will go to Dog's class implementation of speak() - dynamic POLYMORPHISM
        baks.speak();

        System.out.println();

        Animals cow = new FarmAnimals("cow");
        System.out.println("Farm animal is " + cow.getType());
        cow.walk();
        cow.eat("grass");
        cow.speak();

        System.out.println();

        Animals bear = new WildAnimals();
        bear.setType("bear");
        System.out.println("Wild animal is " + bear.getType());
        bear.walk();
        bear.eat("fish");
        bear.speak();

    }

}

