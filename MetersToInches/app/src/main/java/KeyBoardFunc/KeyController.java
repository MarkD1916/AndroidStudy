package KeyBoardFunc;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class KeyController {

    private Context ctx;

    public KeyController() {
    }

    public KeyController(Context ctx) {
        this.ctx = ctx;
    }

    public String writeNumber(TextView textView, Button button){
        String getText = textView.getText().toString();
        String newText = getText+button.getText();
        return newText;
    }

    public String deleteNumber(TextView textView){
        String getText = textView.getText().toString();
        if (getText != null && getText.length() > 0) {
            getText = getText.substring(0, getText.length() - 1);
        }
        return getText;
    }

}
