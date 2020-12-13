package Models;

import android.widget.Button;

import com.example.tipscalc.SeekPresenter;

public class PercentageButtons {
        private String name;
        private int value;
        private SeekPresenter seekPresenter;

    public PercentageButtons(String name, int value, SeekPresenter seekPresenter) {
        this.name = name;
        this.value = value;
        this.seekPresenter = seekPresenter;
    }

    public SeekPresenter getSeekPresenter() {
        return seekPresenter;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public PercentageButtons() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
