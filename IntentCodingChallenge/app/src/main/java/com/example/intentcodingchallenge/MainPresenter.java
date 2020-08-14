package com.example.intentcodingchallenge;



public class MainPresenter {
    private int countFirstPlayer=0;
    private int countSecondPlayer=0;

    public MainPresenter(){

    }


    public int getCountFirstPlayer() {
        return countFirstPlayer;
    }

    public void setCountFirstPlayer(int countFirstPlayer) {
        this.countFirstPlayer = countFirstPlayer;
    }

    public int getCountSecondPlayer() {
        return countSecondPlayer;
    }

    public void setCountSecondPlayer(int countSecondPlayer) {
        this.countSecondPlayer = countSecondPlayer;
    }

    public void countScore(int count){
        if (count<0){
            setCountSecondPlayer(countSecondPlayer-count);
        }
        else{
            setCountFirstPlayer(countFirstPlayer+count);
        }


    }
}
