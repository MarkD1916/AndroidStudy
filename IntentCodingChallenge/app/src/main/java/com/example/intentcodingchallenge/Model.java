package com.example.intentcodingchallenge;

import android.graphics.drawable.Drawable;
import android.net.Uri;

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

}

public class Model {
    public Rule createRuleMatrix(int dim1, int dim2){
        Rule firsPlayerDim = new Rule();
        Rule secondPlayerDim = new Rule();
        Rule ruleMatrix = new Rule();

        firsPlayerDim.setFirsPlayerDim(dim1);
        secondPlayerDim.setSecondPlayerDim(dim2);



        int[][] matrix = new int[dim1][dim2];// ruleMatrix.getRuleMatrix();

        matrix[0][0]=0;
        matrix[0][1]=-1;
        matrix[0][2]=1;
        matrix[1][0]=1;
        matrix[1][1]=0;
        matrix[1][2]=-1;
        matrix[2][0]=-1;
        matrix[2][1]=1;
        matrix[2][2]=0;
        ruleMatrix.setRuleMatrix(matrix);
        return ruleMatrix;
    }
    public int selectItemPic(int selectedItem){

        int[] myImageList = new int[]{R.drawable.sharepic, R.drawable.stonepic,R.drawable.paperpic};

        return myImageList[selectedItem];

    }

}
