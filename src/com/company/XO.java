package com.company;

import java.util.Scanner;

public class XO {
    static int r = 3;
    static int c = 3;
    static char[][] board = new char[3][3];


    public boolean select(int player) {
        Scanner sc = new Scanner(System.in);
        int i=0,j=0;
        while (true)
        {
            System.out.println("ENTER row VALUE : ");
            i = sc.nextInt();
            System.out.println("ENTER column VALUE : ");
            j = sc.nextInt();
            if(i<0 || i>=r || j<0 || j>=r)
            {
                System.out.println("ENTER VALID INDEX NUMBER!!!");
                continue;
            }
            if(board[i][j]!='X' && board[i][j]!='O') {
                if (player == 1) {
                    board[i][j] = 'X';
                } else {
                    board[i][j] = 'O';
                }
                break;
            }else {
                System.out.println("--------------------");
                System.out.println("INDEX ALREADY MARKED");
                System.out.println("____________________");
                printBoard();
            }
        }

        if(isWin(i,j,player))
        {
            printBoard();
            System.out.println("HURRAY PLAYER "+player+" WON!!!");
            System.out.println();
            return true;
        }else{
            if(isDraw())
            {
                printBoard();
                System.out.println("----------");
                System.out.println("MATCH DRAW");
                System.out.println("----------");
                return true;
            }
            return false;
        }
    }

    public boolean isDraw()
    {
        for(int i=0;i<r;i++)
        {
            for (int j=0;j<c;j++)
            {
                if(board[i][j]!='X' && board[i][j]!='O')
                {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isWin(int x,int y,int player)
    {
        char check = 'X';
        if (player==2)
        {
            check='O';
        }

        int count=0;
        for (int j=0;j<c;j++)
        {
            if(board[x][j]==check)
            {
                count++;
            }
        }
        if(count==3)
        {
            return true;
        }

        count=0;
        for (int i=0;i<r;i++)
        {
            if(board[i][y]==check)
            {
                count++;
            }
        }
        if(count==3)
        {
            return true;
        }

        count=0;
        if(x==y)
        {
            int i=0,j=0;
            while(i<r && j<c)
            {
                if(board[i][j]==check)
                {
                    count++;
                }
                i++;
                j++;
            }
        }
        if(count==3)
        {
            return true;
        }

        count=0;
        if((x==0 && y==2) || (x==2 && y==0) || (x==1 && y==1))
        {
            int i=0,j=2;
            while (i<r && j>=0)
            {
                if(board[i][j]==check)
                {
                    count++;
                }
                i++;
                j--;
            }
        }
        if(count==3)
        {
            return true;
        }

        return false;
    }

    public void printBoard()
    {
        System.out.println("  0 1 2");
        System.out.println(" -------");

        for(int i=0;i<3;i++)
        {
            System.out.print(i+"|");
            for(int j=0;j<3;j++) {
                if (board[i][j] != 'X' && board[i][j] != 'O') {
                    System.out.print(" |");
                }else {
                    System.out.print(board[i][j]+"|");
                }
            }
            System.out.println();
            System.out.println(" -------");
        }
    }
}
