package com.company;

public class Main {

    public static void main(String[] args) {
        XO game = new XO();
        System.out.println("X/O GAME");
        System.out.println("--------");
        System.out.println();
        System.out.println("PLAYER 1 is X");
        System.out.println("PLAYER 2 is O");

        boolean player1 = true;

        while (true)
        {
            game.printBoard();
            int move = 1;
            if(!player1) {
                move = 2;
            }

            System.out.println("PLAYER "+move+"'s move ");
            System.out.println("-----------------------");
            if(game.select(move))
            {
                break;
            }else {
                player1 = !player1;
            }
        }
    }
}
