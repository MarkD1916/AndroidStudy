package com.example.intentcodingchallenge;
import java.util.Random;


public class GameResultPresenter {
    private Model uModel;

    private int[][] mGameRuleMatrix;
    private Rule rule;
    private int result;
    private int firstItem;
    private int secondItem;


    private int playerTwoChoice;


    public static int selectTwoChoice(int[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }


    //
    public int selectWinner(int playerOneChoice){
        uModel = new Model();
        rule = uModel.createRuleMatrix(3,3);

        mGameRuleMatrix = rule.getRuleMatrix();
        int[] ar = new int[]{0,1,2};
        playerTwoChoice = selectTwoChoice(ar);
        result = mGameRuleMatrix[playerOneChoice][playerTwoChoice];
        selectItem(playerOneChoice,playerTwoChoice);
        return result;
    }


    public void selectItem(int playerOneChoice,int playerTwoChoice){
        firstItem = uModel.selectItemPic(playerOneChoice);
        secondItem = uModel.selectItemPic(playerTwoChoice);
        setFirstItem(firstItem);
        setSecondItem(secondItem);

    }



    public int getFirstItem() {
        return firstItem;
    }

    public void setFirstItem(int firstItem) {
        this.firstItem = firstItem;
    }

    public int getSecondItem() {
        return secondItem;
    }

    public void setSecondItem(int secondItem) {
        this.secondItem = secondItem;
    }


}

