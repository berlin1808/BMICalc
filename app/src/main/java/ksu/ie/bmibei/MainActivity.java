package ksu.ie.bmibei;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView txtHasil;
    private EditText edBerat;
    private EditText edTinggi;
    double hasilBMI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnUkur = findViewById(R.id.btnHitung);
        txtHasil = findViewById(R.id.txtHasil);
        edBerat = findViewById(R.id.txtberat);
        edTinggi = findViewById(R.id.txttinggi);

        btnUkur.setOnClickListener(btnUkurListener);

    }

    private final Button.OnClickListener btnUkurListener = new Button.OnClickListener() {
        @Override
        public void onClick(View view) {
            double tinggi = Double.parseDouble(edTinggi.getText().toString())/100;
            double berat = Double.parseDouble(edBerat.getText().toString());

            hasilBMI = berat / (tinggi*tinggi);
            String hasilBMIString = String.format("%.2f", hasilBMI);
            if(hasilBMI < 18.5){
                txtHasil.setText("您的BMI是 "+hasilBMIString+"\n你需要增加體重, 多吃一點");
            }else if(hasilBMI >= 18.5 && hasilBMI < 25){
                txtHasil.setText("您的BMI是 "+hasilBMIString+"\n你在你的理想體重, 保持");
            }else{
                txtHasil.setText("您的BMI是 "+hasilBMIString+"\n你需要減肥, 開始你的飲食");
            }

        }
    };
}