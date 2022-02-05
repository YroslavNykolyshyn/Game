package yaroslav.firstapp.game;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Level4 extends AppCompatActivity {

    Dialog dialog;

    Dialog dialogEnd;

    public int numLeft;

    public int numRight;

    Array array = new Array();

    Random random = new Random();

    public int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);

        //створюєм Level1

        TextView text_levels = findViewById(R.id.text_levels);
        text_levels.setText(R.string.level4);

        final ImageView img_left = (ImageView)findViewById(R.id.img_left);
        img_left.setClipToOutline(true);

        final ImageView img_right = (ImageView)findViewById(R.id.img_right);
        img_right.setClipToOutline(true);

        final TextView text_left = findViewById(R.id.textView_left);
        final TextView text_right = findViewById(R.id.textView_right);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        //виклик діалогового вікна
        dialog = new Dialog(this); //створення нового діалоговоо вікна
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.preview_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(false);

        TextView textdescription = (TextView)dialog.findViewById(R.id.textdescription);
        textdescription.setText(R.string.text_desription4);

        ImageView previewimg = (ImageView)dialog.findViewById(R.id.previewimg);
        previewimg.setImageResource(R.drawable.match);

        //кнопка яка закриває діалогове вікно
        TextView btnclose = (TextView)dialog.findViewById(R.id.button_close);
        btnclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent= new Intent(Level4.this,GameLevels.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
                dialog.dismiss();
            }
        });
        // кнопка продовжити в ділоговому вікіні
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
        dialog.show(); // показати вікно діалогу

        //----------------------------------------------------------------------------------------
        //виклик діалогового вікна
        dialogEnd = new Dialog(this); //створення нового діалоговоо вікна
        dialogEnd.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogEnd.setContentView(R.layout.dialog_end);
        dialogEnd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogEnd.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT);
        dialogEnd.setCancelable(false);

        TextView textdescriptionEnd = (TextView)dialogEnd.findViewById(R.id.textdescriptionEnd);
        textdescriptionEnd.setText(R.string.text_descriptionEnd4);

        TextView btnclose2 = (TextView)dialogEnd.findViewById(R.id.button_close);
        btnclose2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent= new Intent(Level4.this,GameLevels.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
                dialogEnd.dismiss();
            }
        });
        Button button_continue2 = (Button)dialogEnd.findViewById(R.id.button_continue);
        button_continue2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Level4.this,Level5.class);
                    startActivity(intent);finish();

                }catch (Exception e){

                }
                dialogEnd.dismiss();
            }
        });
        //----------------------------------------------------------------------------------------

        Button button_back =  (Button)findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent= new Intent(Level4.this,GameLevels.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
            }
        });

        final int[] progress={
            R.id.point1,
                R.id.point2,
                R.id.point3,
                R.id.point4,
                R.id.point5,
                R.id.point6,
                R.id.point7,
                R.id.point8,
                R.id.point9,
                R.id.point10, R.id.point11,R.id.point12,R.id.point13,R.id.point14,R.id.point15,
                R.id.point16,R.id.point17,R.id.point18,R.id.point19,R.id.point20

        };

        final Animation  animation = AnimationUtils.loadAnimation(Level4.this, R.anim.alpha);

        numLeft = random.nextInt(20);
        img_left.setImageResource(array.images4[numLeft]);

        text_left.setText(array.text_levels4[numLeft]);

        numRight = random.nextInt(20);

        while (numLeft == numRight){
            numRight = random.nextInt(20);
        }
        img_right.setImageResource(array.images4[numRight]);
        text_right.setText(array.text_levels4[numRight]);

        img_left.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){
                    img_right.setEnabled(false);
                    if (numLeft>numRight){
                        img_left.setImageResource(R.drawable.green);
                    }else {
                        img_left.setImageResource(R.drawable.red);
                    }
                } else if (motionEvent.getAction()==MotionEvent.ACTION_UP){
                    if(numLeft>numRight){
                        if(count<20){
                            count=count+1;
                        }
                        for (int i = 0; i<20;i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }

                        for (int i = 0; i<count;i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                    }else {
                        if(count>0){
                            if (count==1){
                                count=0;
                            }else {
                                count=count-2;
                            }
                        }
                        for (int i = 0; i<19;i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }

                        for (int i = 0; i<count;i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                    }
                    if (count==20){

                        dialogEnd.show();
                    }else {
                        numLeft = random.nextInt(20);
                        img_left.setImageResource(array.images4[numLeft]);
                        img_left.startAnimation(animation);

                        text_left.setText(array.text_levels4[numLeft]);

                        numRight = random.nextInt(20);

                        while (numLeft == numRight){
                            numRight = random.nextInt(20);
                        }
                        img_right.setImageResource(array.images4[numRight]);
                        img_right.startAnimation(animation);
                        text_right.setText(array.text_levels4[numRight]);

                        img_right.setEnabled(true);
                    }
                }
                return true;
            }
        });
        img_right.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){
                    img_left.setEnabled(false);
                    if (numLeft<numRight){
                        img_right.setImageResource(R.drawable.green);
                    }else {
                        img_right.setImageResource(R.drawable.red);
                    }
                } else if (motionEvent.getAction()==MotionEvent.ACTION_UP){
                    if(numLeft<numRight){
                        if(count<20){
                            count=count+1;
                        }
                        for (int i = 0; i<20;i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }

                        for (int i = 0; i<count;i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                    }else {
                        if(count>0){
                            if (count==1){
                                count=0;
                            }else {
                                count=count-2;
                            }
                        }
                        for (int i = 0; i<19;i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }

                        for (int i = 0; i<count;i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                    }
                    if (count==20){

                        dialogEnd.show();
                    }else {
                        numLeft = random.nextInt(20);
                        img_left.setImageResource(array.images4[numLeft]);
                        img_left.startAnimation(animation);

                        text_left.setText(array.text_levels4[numLeft]);

                        numRight = random.nextInt(20);

                        while (numLeft == numRight){
                            numRight = random.nextInt(20);
                        }
                        img_right.setImageResource(array.images4[numRight]);
                        img_right.startAnimation(animation);
                        text_right.setText(array.text_levels4[numRight]);

                        img_left.setEnabled(true);
                    }
                }
                return true;
            }
        });
    }
}