package Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import com.example.tipscalc.R;
import com.example.tipscalc.SeekPresenter;

import java.util.List;

import Models.PercentageButtons;

public class ButtonAdapter extends BaseAdapter {
    private Context ctx;
    private List<PercentageButtons> btns;
    SeekPresenter seekPresenter;
    private int value;
    public ButtonAdapter() {
    }

    public ButtonAdapter(Context ctx, List<PercentageButtons> btns) {
        this.ctx = ctx;
        this.btns = btns;
    }

    @Override
    public int getCount() {
        return btns.size();
    }

    @Override
    public Object getItem(int position) {
        return btns.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Button btn;

        seekPresenter = btns.get(position).getSeekPresenter();
        if (convertView == null) {
            btn = new Button(ctx);
            btn.setText(btns.get(position).getName());
            btn.setBackground(ctx.getResources().getDrawable(R.drawable.round_button));
            btn.setTextColor(ctx.getResources().getColor(R.color.White));
        } else {
            btn = (Button) convertView;
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value = btns.get(position).getValue();
                seekPresenter.setProgress(value);
            }
        });

        btn.setId(position);

        return btn;
    }
}
