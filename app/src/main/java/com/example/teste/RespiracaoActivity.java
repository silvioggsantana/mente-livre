package com.example.teste;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RespiracaoActivity extends AppCompatActivity {

    private View circleView;
    private TextView textBreathing;
    private boolean isInhale = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.respiracao);

        circleView = findViewById(R.id.circleView);
        textBreathing = findViewById(R.id.textBreathing);

        startBreathingAnimation();
    }

    private void startBreathingAnimation() {
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(circleView, "scaleX", 1f, 2f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(circleView, "scaleY", 1f, 2f);

        scaleX.setDuration(4000);
        scaleY.setDuration(4000);
        scaleX.setRepeatMode(ObjectAnimator.REVERSE);
        scaleY.setRepeatMode(ObjectAnimator.REVERSE);
        scaleX.setRepeatCount(ObjectAnimator.INFINITE);
        scaleY.setRepeatCount(ObjectAnimator.INFINITE);

        scaleX.start();
        scaleY.start();

        new Thread(() -> {
            try {
                while (true) {
                    runOnUiThread(() -> textBreathing.setText(isInhale ? "Expire..." : "Inspire..."));
                    isInhale = !isInhale;
                    Thread.sleep(4000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
