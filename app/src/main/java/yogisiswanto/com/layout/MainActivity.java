package yogisiswanto.com.layout;

import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //layout
        RelativeLayout layout = new RelativeLayout(this);
        layout.setBackgroundColor(Color.parseColor("#2196f3"));

        //tombol
        Button tombol = new Button(this);
        tombol.setText("Click On Me");
        tombol.setBackgroundColor(Color.parseColor("#ff9800"));

        //edit text
        final EditText user = new EditText(this);

        //set id
        tombol.setId(1);
        user.setId(2);

        //posisi dari tombol
        RelativeLayout.LayoutParams posisi = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        //posisi dari edit text
        RelativeLayout.LayoutParams posisiuser = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        //menampilkan posisi tombol
        posisi.addRule(RelativeLayout.CENTER_HORIZONTAL);
        posisi.addRule(RelativeLayout.CENTER_VERTICAL);

        //menampilkan posisi edittext
        posisiuser.addRule(RelativeLayout.ABOVE, tombol.getId());
        posisiuser.addRule(RelativeLayout.CENTER_HORIZONTAL);
        posisiuser.setMargins(0,0,0,50);

        //set lebar user
        Resources r = getResources();
        int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 300,
                r.getDisplayMetrics()
                );

        user.setWidth(px);

        //menampilkan tombol, posisi tombol, edittext, posisiuser
        layout.addView(tombol, posisi);
        layout.addView(user, posisiuser);

        setContentView(layout);

        //ketika tombol di klik
        tombol.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if(user.getText().toString().equals("yogisiswanto@gmail.com")){

                    Toast toast = Toast.makeText(getApplicationContext(), "Login Berhasil", Toast.LENGTH_LONG);
                    toast.show();

                    user.setText("");
                }else{


                    Toast toast2 = Toast.makeText(getApplicationContext(), "Login Gagal", Toast.LENGTH_LONG);
                    toast2.show();

                    user.setText("");
                }
            }
        });
    }
}
