package com.ccsi.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by gxliu on 2017/2/3.
 */
public class LC36validSudoku {
    public static void main(String[] args) {
        char[][] board={{'5','3','.','.','7','.','.','.','.'},
                        {'6','.','.','1','9','5','.','.','.'},
                        {'.','9','8','.','.','.','.','6','.'},
                        {'8','.','.','.','6','.','.','.','3'},
                        {'4','.','.','8','.','3','.','.','1'},
                        {'7','.','.','.','2','.','.','.','6'},
                        {'.','6','.','.','.','.','2','8','.'},
                        {'.','.','.','4','1','9','.','.','5'},
                        {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(isValidSudoku1(board));
    }

    //O(n^3)
    public static boolean isValidSudoku(char[][] board){
        if(board==null||board.length!=9||board[0].length!=9)return false;

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char curr=board[row][col];
                //判断行或列中是否有重复的值
                if(curr!='.'){
                    if(curr<'0'||curr>'9')return false;
                    for (int i = 0; i < 9; i++) {
                        if(board[row][i]==curr&&i!=col)return false;
                        if(board[i][col]==curr&&i!=row)return false;
                    }

                    int srow=row/3;
                    int scol=col/3;
                    for (int i = srow*3; i < (srow+1)*3; i++) {
                        for (int j = scol*3; j <(scol+1)*3 ; j++) {
                            if(board[i][j]==curr&&i!=row&&j!=col)return false;
                        }
                    }
                }

            }
        }
        return true;
    }

    //O(n^2) set
    public static boolean isValidSudoku1(char[][] board){
        if(board==null||board.length!=9||board[0].length!=9)return false;

        for (int row = 0; row < 9; row++) {
            Set<Character> rowSet=new HashSet<>();
            for (int col = 0; col < 9; col++) {
                char curr=board[row][col];
                if(curr!='.'){
                    if(curr<'0'||curr>'9')return false;
                    if(!rowSet.add(curr))return false;
                }
            }
        }

        for (int col = 0; col < 9; col++) {
            Set<Character> colSet=new HashSet<>();
            for (int row = 0; row < 9; row++) {
                char curr=board[row][col];
                if(curr!='.'){
                    if(curr<'0'||curr>'9')return false;
                    if(!colSet.add(curr))return false;
                }
            }
        }

        for (int row = 0; row < 9; row+=3) {
            for (int col = 0; col < 9; col+=3) {
                Set<Character> blockSet=new HashSet<>();
                for (int smallRow = row; smallRow < row+3; smallRow++) {
                    for (int smallCol = col; smallCol < col + 3; smallCol++) {
                        char curr=board[smallRow][smallCol];
                        if(curr!='.'){
                            if(curr<'0'||curr>'9')return false;
                            if(!blockSet.add(curr))return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}
