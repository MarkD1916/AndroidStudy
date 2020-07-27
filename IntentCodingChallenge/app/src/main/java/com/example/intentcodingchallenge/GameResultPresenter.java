package com.example.intentcodingchallenge;

import java.util.ArrayList;
import java.util.Arrays;

class Rule{
    private int firsPlayerDim;
    private int secondPlayerDim;
    private int[][] ruleMatrix;

    public void setFirsPlayerDim(int firsPlayerDim) {
        this.firsPlayerDim = firsPlayerDim;
    }

    public void setSecondPlayerDim(int secondPlayerDim) {
        this.secondPlayerDim = secondPlayerDim;
    }

    public int getFirsPlayerDim() {
        return firsPlayerDim;
    }

    public int getSecondPlayerDim() {
        return secondPlayerDim;
    }

    public int[][] getRuleMatrix() {
        return ruleMatrix;
    }

    public void setRuleMatrix(int[][] ruleMatrix) {
        this.ruleMatrix = ruleMatrix;
    }

    public void fillRuleMatrix(){

    }
}

public class GameResultPresenter {




    public void randomChoice(){

    }

    public void selectWinner(int playerOneChoice, int playerTwoChoice){
        Rule firsPlayerDim = new Rule();
        Rule secondPlayerDim = new Rule();
        Rule ruleMatrix = new Rule();

        firsPlayerDim.setFirsPlayerDim(3);
        secondPlayerDim.setSecondPlayerDim(3);


        ruleMatrix.setRuleMatrix(new int[firsPlayerDim.getFirsPlayerDim()][secondPlayerDim.getSecondPlayerDim()]);
        int[][] matrix = ruleMatrix.getRuleMatrix();
        for (int[] row : matrix)
            Arrays.fill(row, 10);

        //ruleMatrix = new int[firsPlayerDim.getFirsPlayerDim()][secondPlayerDim.getSecondPlayerDim()];



    }


}
