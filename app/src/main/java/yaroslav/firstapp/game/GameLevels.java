package yaroslav.firstapp.game;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameLevels extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamelevel);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Button buttonBack = (Button) findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent= new Intent(GameLevels.this,Levels.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
            }
        });

        TextView textView1 = (TextView)findViewById(R.id.textView1);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent= new Intent(GameLevels.this,Level1.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
            }
        });

        TextView textView2 = (TextView)findViewById(R.id.textView2);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent= new Intent(GameLevels.this,Level2.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
            }
        });

        TextView textView3 = (TextView)findViewById(R.id.textView3);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent= new Intent(GameLevels.this,Level3.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
            }
        });

        TextView textView4 = (TextView)findViewById(R.id.textView4);
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent= new Intent(GameLevels.this,Level4.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
            }
        });
//
//        TextView textView5 = (TextView)findViewById(R.id.textView5);
//        textView5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                try {
//                    Intent intent= new Intent(GameLevels.this,Level5.class);
//                    startActivity(intent);finish();
//                }catch (Exception e){
//
//                }
//            }
//        });
    }
}