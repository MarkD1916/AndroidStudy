package com.example.intentcodingchallenge;


import android.view.View;
import android.widget.Toast;

import java.util.Random;

public class GameResultPresenter {
    private Model uModel;

    private int[][] mGameRuleMatrix;
    private Rule rule;
    private int result;
    //public void





    public static int playerTwoChoice(int[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }


    //
    public int selectWinner(int playerOneChoice){
        uModel = new Model();
        rule = uModel.createRuleMatrix(3,3);


        mGameRuleMatrix = rule.getRuleMatrix();
        int[] ar = new int[]{0,1,2};
        result = mGameRuleMatrix[playerOneChoice][playerTwoChoice(ar)];
        //ruleMatrix = new int[firsPlayerDim.getFirsPlayerDim()][secondPlayerDim.getSecondPlayerDim()];
        return result;

    }



    }

