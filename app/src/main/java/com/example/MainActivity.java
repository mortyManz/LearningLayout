package com.example;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Boolean variable to keep track of background opacity. Default is false (fully visible).
    private boolean isTransparent = false;

    // Integer variable for accumulating value
    private int counter = 0;

    // TextView reference to update the displayed counter value
    private TextView centerTextView;
    private ImageView backgroundImageView;  // ImageView for the background image

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // Finding the Toast button by its resource ID.
        Button toastButton = findViewById(R.id.button1);

        // Finding the Toggle button and background image view by their resource IDs.
        Button toggleButton = findViewById(R.id.button2);
        backgroundImageView = findViewById(R.id.backgroundImageView);  // Use ImageView for toggling opacity
        centerTextView = findViewById(R.id.centerTextView);  // Use TextView for displaying the counter

        // Finding the Double, Count, and Reset buttons by their resource IDs.
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);

        // Initial value display
        centerTextView.setText(String.valueOf(counter));

        // Toast OnClickListener
        toastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast Button execution
                Toast.makeText(MainActivity.this, "You clicked the Toast button!", Toast.LENGTH_SHORT).show();
            }
        });

        // Toggle OnClickListener for toggling image opacity
        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isTransparent) {
                    backgroundImageView.setAlpha(1.0f);
                } else {
                    backgroundImageView.setAlpha(0.0f);
                }
                // After decision is made, change the state of the opacity.
                isTransparent = !isTransparent;
            }
        });

        // Button 3 (Double) OnClickListener
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Double the value of counter
                counter *= 2;
                updateCenterTextView();
            }
        });

        // Button 4 (Count) OnClickListener
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                updateCenterTextView();
            }
        });

        // Button 5 (Reset) OnClickListener
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter = 0;
                updateCenterTextView();
            }
        });
    }

    // Method which handles the update of the center text.
    private void updateCenterTextView() {
        centerTextView.setText(String.valueOf(counter));
    }
}
