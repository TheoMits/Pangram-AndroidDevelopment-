package com.j2.pangram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String sentence;

    Button button;
    EditText sentenceInput;
    TextView torF;

    char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sentenceInput = (EditText) findViewById(R.id.sentenceText);
        torF = (TextView) findViewById(R.id.answer);

        button = (Button) findViewById(R.id.mybutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sentence = sentenceInput.getText().toString();
                if (sentenceInput.getText().toString().isEmpty()) {
                    //if user didn't give nothing
                    torF.setText("null");
                    return;
                }
                char[] sentenceToTest = toCharacterArray(sentence);
                int missingLetters = start(sentenceToTest , alphabet);

                if (missingLetters == 0) {  //if no letter missing, then we have all the letters of the alphabet!
                    torF.setText("true");
                } else {
                    torF.setText("false"); //else not
                }
            }
        });

    }


    public int start(char[] sentence, char[] alpha) {

        int numOfMissingLetters = 0;

        for (int i = 0; i < alpha.length; i++) {
            char letterToFind = alpha[i];  //define the next letter of the alphabet
            if (hasLetter(letterToFind, sentence) == false) {
                //Check if the letter exists and add it in the variable
                numOfMissingLetters++;

            }
        }
        return numOfMissingLetters; //return the sum of letters you find
    }

    //check if exists each letter in the sentence
    public boolean hasLetter(char aLetter, char[] aSentence) {
        boolean found = false;
        int position = 0;
        while (!found) {
            if (aLetter == aSentence[position]) {
                //then we found it
                found = true;
            } else if (position == aSentence.length - 1) {
                //we are at the end of array
                break;
            } else {
                //increment the position in the array
                position++;
            }
        }
        return found;
    }

    //convert the string sentence to char array sentence
    public char[] toCharacterArray(String s){
        if (s == null){
            return null;
        }
        char[] array =new char[s.length()];
        for (int i=0; i < s.length(); i++){
            array[i] = s.charAt(i);
        }
        return array;
    }
}

