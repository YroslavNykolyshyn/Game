package yaroslav.firstapp.game;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Levels extends AppCompatActivity {

    Dialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.levelsection);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Button buttonBack2 = (Button) findViewById(R.id.buttonBack2);
        buttonBack2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent= new Intent(Levels.this,MainActivity.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
            }
        });

        //виклик діалогового вікна
        dialog = new Dialog(this); //створення нового діалоговоо вікна
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.preview_levels);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(false);

        TextView btnclose = (TextView)dialog.findViewById(R.id.button_close);
        btnclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent= new Intent(Levels.this,MainActivity.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
               dialog.dismiss();
            }
        });
        Button button_continue = (Button)dialog.findViewById(R.id.button_continue);
        button_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    dialog.dismiss();
                }catch (Exception e){

                }
            }
        });
       dialog.show(); // показати вікно діалогу(End)

        TextView textLevelSection = (TextView)findViewById(R.id.textLevelSection);
        textLevelSection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent= new Intent(Levels.this,GameLevels.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
            }
        });


        TextView textLevelSection2 = (TextView)findViewById(R.id.textLevelSection2);
        textLevelSection2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent= new Intent(Levels.this,Levels.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
            }
        });

        TextView textLevelSection3 = (TextView)findViewById(R.id.textLevelSection3);
        textLevelSection3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent= new Intent(Levels.this,Levels.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
            }
        });

        TextView textLevelSection4 = (TextView)findViewById(R.id.textLevelSection4);
        textLevelSection4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent= new Intent(Levels.this,Levels.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
            }
        });
        TextView textLevelSection5 = (TextView)findViewById(R.id.textLevelSection5);
        textLevelSection5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent= new Intent(Levels.this,Levels.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
            }
        });
        TextView textLevelSection6 = (TextView)findViewById(R.id.textLevelSection6);
        textLevelSection6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent= new Intent(Levels.this,Levels.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
            }
        });
    }
}