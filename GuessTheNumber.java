//program to make guess number game in oop edition.
package com.company;

import java.util.Scanner;

class Game{
    int result_number;
     int guess[] = new int[5];
     int userWant =0;
     int number_correct_or_not =0;
     int count=0;
     //create the method for display rule of game
    public void rule_of_game(){
        System.out.println("You have five chances to guess the number.");
        System.out.println("You will get three hints in game.");
        System.out.println("Number must match to win game.");
        System.out.println("hint: result number is between 0 to 30.");
        System.out.println("Enter 1 to play");
    }
    //create a method to check user want to play or not
    public void isUserWantPlay(){
        Scanner scan = new Scanner(System.in);
        int  input = scan.nextInt();
        if (input ==1){
            System.out.println("Start playing........");
            userWant ++;
        }
        else {
            System.out.println("See you next time.");
        }
    }
     //create the method for generating random number
    public void setResult_number() {
        int r =(int) (Math.random()*30);
        result_number = r;
    }
    //create the method for taking user input
    public int takeUserInput(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Guess number:");
        int number = scan.nextInt();
        return number;
    }
    //create the method for checking guess number with computer generate number.
    public void isCorrectNumber(int number, int range){
        if (number == result_number){
            System.out.println("Your guess is correct.");
            number_correct_or_not ++;
        }
        else if(number<result_number){
            if (range ==4){
                System.out.println("You loose the game.");
            }
            else {
                System.out.println("Hint:Answer is large number.");
            }
        }
        else {
            if (range == 4) {
                System.out.println("You loose the game.");
            } else {
                System.out.println("Hint:Answer is small number.");
            }
        }
    }
    //store the user guess number
    public void noOfGuess(int guess_number, int index){
        guess[index] = guess_number;
    }
    //create a method for display user guess
    public void display_guess_number(int[] guess_number, int total_guess){
        System.out.println("Number you guessed.");
        for (int i =0;i<total_guess;i++){
            System.out.printf("%d\t",guess_number[i]);
        }
    }
    //create a method to display score
    public int score_count(int total_guess, int userInput){
        if (total_guess == 5 || userInput == result_number)
        {
            return 1;
        }
        else if (total_guess == 5){
            return 0;
        }
        else {
            return 6 - total_guess;
        }
    }
    //lets combine all the method to make complete game
    public void playGame(){
        rule_of_game();//show the rule of game
        isUserWantPlay();//check user desire about game
        //generate result number
        setResult_number();
//        System.out.println(result_number);
        //if user want play
        if (userWant == 1){
            //use loop to give the five chances to guess number
            for (int i =0;i<5;i++){
                count++;
                //take user input
                int user_input = takeUserInput();
                //store the user input
                noOfGuess(user_input,i);
                //check the guess number is correct or not
                isCorrectNumber(user_input,i);
                if (number_correct_or_not == 1){
                    break;
                }
            }
            //display user input number
            display_guess_number(guess,count);
            //display score
            System.out.println("\nScore:\t" +score_count(count,guess[4]));
            //display answer
            System.out.printf("Answer:\t%d",result_number);
        }
    }
}
public class GuessTheNumber {
    public static void main(String[] args) {
        //create a object of class Game to access method of that class
        Game obj_game = new Game();
        obj_game.playGame();

    }
}