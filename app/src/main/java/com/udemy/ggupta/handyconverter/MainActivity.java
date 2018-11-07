package com.udemy.ggupta.handyconverter;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    /*
        Units Included should be common yet unknown
        DISTANCE
        -meter
        -feet
        -yard
        -mile
        MASS
        -gram
        -ton
        -pound
        -ounce
        VOLUME
        -liter
        -gallon
        -pint
        -cup
        -fluid ounce
        -teaspoon
        -tablespoon

        Once the user selects a specific category such as distance, only comparative measures
        should be shown
     */
    private EditText enterValue;
    private TextView resultText;
    private Spinner fromUnits;
    private Spinner toUnits;
    private Button convertButton;
    private Spinner category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enterValue = (EditText) findViewById(R.id.valueId);
        resultText = (TextView) findViewById(R.id.answerId);
        fromUnits = (Spinner) findViewById(R.id.fromId);
        toUnits = (Spinner) findViewById(R.id.toId);
        convertButton = (Button) findViewById(R.id.convertId);
        category = (Spinner) findViewById(R.id.categoryId);

        String[] categoryList = new String[]{"Distance", "Mass", "Volume", "Temperature"};

        ArrayAdapter<String> categoryAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, categoryList);

        category.setOnItemSelectedListener(this);
        category.setAdapter(categoryAdapter);


        //conversion on click
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fromUnits.getSelectedItem().equals("Meter")) {
                    if (toUnits.getSelectedItem().equals("Feet")) {
                        distanceConvert(3.28084);
                    } else if (toUnits.getSelectedItem().equals("Meter")) {
                        distanceConvert(1.00);
                    } else if (toUnits.getSelectedItem().equals("Yard")) {
                        distanceConvert(1.09361);
                    } else {
                        distanceConvert(0.000621371);
                    }
                } else if (fromUnits.getSelectedItem().equals("Feet")) {
                    if (toUnits.getSelectedItem().equals("Feet")) {
                        distanceConvert(1.0);
                    } else if (toUnits.getSelectedItem().equals("Meter")) {
                        distanceConvert(0.3048);
                    } else if (toUnits.getSelectedItem().equals("Yard")) {
                        distanceConvert(0.333333);
                    } else {
                        distanceConvert(0.000189394);
                    }
                } else if (fromUnits.getSelectedItem().equals("Yard")) {
                    if (toUnits.getSelectedItem().equals("Feet")) {
                        distanceConvert(3.0);
                    } else if (toUnits.getSelectedItem().equals("Meter")) {
                        distanceConvert(0.3048);
                    } else if (toUnits.getSelectedItem().equals("Yard")) {
                        distanceConvert(1);
                    } else {
                        distanceConvert(0.000568182);
                    }
                } else if (fromUnits.getSelectedItem().equals("Mile")) {
                    if (toUnits.getSelectedItem().equals("Feet")) {
                        distanceConvert(5280.0);
                    } else if (toUnits.getSelectedItem().equals("Meter")) {
                        distanceConvert(1609.34);
                    } else if (toUnits.getSelectedItem().equals("Yard")) {
                        distanceConvert(1760.0);
                    } else {
                        distanceConvert(1);
                    }
                } else if (fromUnits.getSelectedItem().equals("Gram")) {
                    if (toUnits.getSelectedItem().equals("Ton")) {
                        distanceConvert(0.00000110231);
                    } else if (toUnits.getSelectedItem().equals("Gram")) {
                        distanceConvert(1.00);
                    } else if (toUnits.getSelectedItem().equals("Pound")) {
                        distanceConvert(0.00220462);
                    } else {
                        distanceConvert(0.035274);
                    }
                } else if (fromUnits.getSelectedItem().equals("Ton")) {
                    if (toUnits.getSelectedItem().equals("Ton")) {
                        distanceConvert(1.0);
                    } else if (toUnits.getSelectedItem().equals("Gram")) {
                        distanceConvert(907185.0);
                    } else if (toUnits.getSelectedItem().equals("Pound")) {
                        distanceConvert(2000);
                    } else {
                        distanceConvert(32000);
                    }
                } else if (fromUnits.getSelectedItem().equals("Pound")) {
                    if (toUnits.getSelectedItem().equals("Gram")) {
                        distanceConvert(453.592);
                    } else if (toUnits.getSelectedItem().equals("Ton")) {
                        distanceConvert(0.0005);
                    } else if (toUnits.getSelectedItem().equals("Pound")) {
                        distanceConvert(1.0);
                    } else {
                        distanceConvert(16.0);
                    }
                } else if (fromUnits.getSelectedItem().equals("Ounce")) {
                    if (toUnits.getSelectedItem().equals("Gram")) {
                        distanceConvert(28.3495);
                    } else if (toUnits.getSelectedItem().equals("Ton")) {
                        distanceConvert(0.00003125);
                    } else if (toUnits.getSelectedItem().equals("Pound")) {
                        distanceConvert(0.0625);
                    } else {
                        distanceConvert(1);
                    }
                } else if (fromUnits.getSelectedItem().equals("Celsius")) {
                    if (toUnits.getSelectedItem().equals("Celsius")) {
                        distanceConvert((1));
                    } else {
                        double result;
                        result = Double.parseDouble(enterValue.getText().toString());
                        result = result * 1.8 + 32;
                        resultText.setTextColor(Color.DKGRAY);
                        resultText.setText(Double.toString(result));
                    }
                } else if (fromUnits.getSelectedItem().equals("Fahrenheit")) {
                    if (toUnits.getSelectedItem().equals("Celsius")) {
                        double result;
                        result = Double.parseDouble(enterValue.getText().toString());
                        result = (result - 32) / 1.8;
                        resultText.setTextColor(Color.DKGRAY);
                        resultText.setText(Double.toString(result));
                    } else {
                        distanceConvert(1);
                    }
                } else if (fromUnits.getSelectedItem().equals("Liter")) {
                    if (toUnits.getSelectedItem().equals("Gallon")) {
                        distanceConvert(0.264172);
                    } else if (toUnits.getSelectedItem().equals("Cup")) {
                        distanceConvert(4.22675);
                    } else if (toUnits.getSelectedItem().equals("Fluid Ounce")) {
                        distanceConvert(33.814);
                    } else {
                        distanceConvert(1);
                    }
                } else if (fromUnits.getSelectedItem().equals("Gallon")) {
                    if (toUnits.getSelectedItem().equals("Gallon")) {
                        distanceConvert(1);
                    } else if (toUnits.getSelectedItem().equals("Liter")) {
                        distanceConvert(3.78541);
                    } else if (toUnits.getSelectedItem().equals("Fluid Ounce")) {
                        distanceConvert(128);
                    } else {
                        distanceConvert(16);
                    }
                } else if (fromUnits.getSelectedItem().equals("Fluid Ounce")) {
                    if (toUnits.getSelectedItem().equals("Gallon")) {
                        distanceConvert(0.0078125);
                    } else if (toUnits.getSelectedItem().equals("Cup")) {
                        distanceConvert(0.125);
                    } else if (toUnits.getSelectedItem().equals("Liter")) {
                        distanceConvert(0.0295735);
                    } else {
                        distanceConvert(1);
                    }
                } else if (fromUnits.getSelectedItem().equals("Cup")) {
                    if (toUnits.getSelectedItem().equals("Gallon")) {
                        distanceConvert(0.0625);
                    } else if (toUnits.getSelectedItem().equals("Liter")) {
                        distanceConvert(0.236588);
                    } else if (toUnits.getSelectedItem().equals("Fluid Ounce")) {
                        distanceConvert(8);
                    } else {
                        distanceConvert(1);
                    }
                }
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position,
                               long id) {
        if (category.getSelectedItem().equals("Distance")) {
            String[] unitsDistance = new String[]{"Meter", "Feet", "Yard", "Mile"};
            ArrayAdapter<String> distanceAdapter = new ArrayAdapter<>(this,
                    android.R.layout.simple_spinner_dropdown_item, unitsDistance);
            fromUnits.setAdapter(distanceAdapter);
            toUnits.setAdapter(distanceAdapter);

        } else if (category.getSelectedItem().equals("Mass")) {
            String[] unitsMass = new String[]{"Gram", "Ton", "Pound", "Ounce"};
            ArrayAdapter<String> massAdapter = new ArrayAdapter<>(this,
                    android.R.layout.simple_spinner_dropdown_item, unitsMass);
            fromUnits.setAdapter(massAdapter);
            toUnits.setAdapter(massAdapter);

        } else if (category.getSelectedItem().equals("Volume")) {
            String[] unitsVolume = new String[]{"Liter", "Gallon", "Cup", "Fluid Ounce"};
            ArrayAdapter<String> volumeAdapter = new ArrayAdapter<>(this,
                    android.R.layout.simple_spinner_dropdown_item, unitsVolume);
            fromUnits.setAdapter(volumeAdapter);
            toUnits.setAdapter(volumeAdapter);
        } else {
            String[] unitsTemp = new String[]{"Celsius", "Fahrenheit"};
            ArrayAdapter<String> tempAdapter = new ArrayAdapter<>(this,
                    android.R.layout.simple_spinner_dropdown_item, unitsTemp);
            fromUnits.setAdapter(tempAdapter);
            toUnits.setAdapter(tempAdapter);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // TODO Auto-generated method stub
    }

    public void distanceConvert(double m) {
        double result;
        result = Double.parseDouble(enterValue.getText().toString());
        result = result * m;
        resultText.setTextColor(Color.DKGRAY);
        resultText.setText(Double.toString(result));

    }
} //end class


