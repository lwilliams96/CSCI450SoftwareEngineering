package hxgstudio.compliplenty;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.qrcode.encoder.QRCode;

public class Question extends AppCompatActivity {

    private TextView question;
    private int compNum, qNum, qRow;
    private Button yes, no;
    private String[] str_quest, str_comp;
    private String test;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        question = (TextView)findViewById(R.id.text_question);
        yes = (Button) findViewById(R.id.button_yes);
        no = (Button) findViewById(R.id.button_no);
        qNum = 1;
        qRow = 0;
        updateQuestion(qNum);

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (qRow == 3) {
                    Resources res = getResources();
                    Intent i = new Intent(Question.this, StartApp.class);
                    compNum = (qNum * 2) - 15;
                    String str_comp[] = res.getStringArray(R.array.compliment_question);
                    Toast.makeText(Question.this, str_comp[compNum], Toast.LENGTH_SHORT).show();
                    Bundle bundle = new Bundle();
                    bundle.putString("compliment", str_comp[compNum]);
                    i.putExtras(bundle);
                    Question.this.finish();
                    startActivity(i);
                } else {
                    qNum = qNum * 2;
                    qRow++;
                    updateQuestion(qNum);
                }
            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (qRow == 3) {
                    Resources res = getResources();
                    Intent i = new Intent(Question.this, StartApp.class);
                    compNum = (qNum * 2) - 14;
                    String str_comp[] = res.getStringArray(R.array.compliment_question);
                    Toast.makeText(Question.this, str_comp[compNum], Toast.LENGTH_SHORT).show();
                    Bundle bundle = new Bundle();
                    bundle.putString("compliment", str_comp[compNum]);
                    i.putExtras(bundle);
                    Question.this.finish();
                    startActivity(i);
                } else {
                    qNum = (qNum *2) + 1;
                    qRow++;
                    updateQuestion(qNum);
                }
            }
        });

    }

    private void updateQuestion(int qNum) {
        Resources res = getResources();
        String str_quest[] = res.getStringArray(R.array.questions);
        question.setText(str_quest[qNum]);
    }
}