package com.example.vicke.tictactoe;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /*
        grid: the main grid that player clicked
     */

    private String m_p1 = "X";
    private String m_p2 = "O";
    private int xCounter, yCounter;
    private static int m_turnCounter = 0;
    private int[] grid = new int[9];
    //index: 0 -> player 1, 1 -> player 2
    private boolean[] winToggle;
    private TextView p1View, p2View;
    private boolean[] clicked;
    private Button b1, b2, b3, b4, b5, b6, b7, b8, b9, reset, quit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        winToggle = new boolean[2];
        winToggle[0] = winToggle[1] = false;
        xCounter = yCounter = 0;
        clicked = new boolean[9];

        //initialize array to false;
        for(int i = 0; i<clicked.length; i++)
            clicked[i] = false;

        b1 = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);
        b4 = (Button) findViewById(R.id.button4);
        b5 = (Button) findViewById(R.id.button5);
        b6 = (Button) findViewById(R.id.button6);
        b7 = (Button) findViewById(R.id.button7);
        b8 = (Button) findViewById(R.id.button8);
        b9 = (Button) findViewById(R.id.button9);
        reset = (Button) findViewById(R.id.reset);
        quit = (Button) findViewById(R.id.quit);

        p1View = (TextView) findViewById(R.id.playerView1);
        p2View = (TextView) findViewById(R.id.playerView2);

        if(isWon())
            Toast.makeText(this, "testing...", Toast.LENGTH_SHORT).show();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //check if it is enable to set text
                if(!enable()) {
                    if (grid[0] == 0) {
                        setText(b1);
                        //set keep track according to number of turns
                        if(m_turnCounter % 2 == 0)
                        grid[0] = 1;
                        else
                            grid[0] = 2;
                        m_turnCounter++;
                    }
                }

                //check if already clicked before
                if(!clicked[0]) {
                    if (isWon()) {

                        if (grid[0] != 0)
                            setScores();

                        Toast.makeText(MainActivity.this, "You Won this game!", Toast.LENGTH_SHORT).show();
                    }
                }
                //set button as clicked
                clicked[0] = true;
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!enable()) {
                    if (grid[1] == 0) {
                        setText(b2);

                        //set keeptract according to number of turns
                        if(m_turnCounter % 2 == 0)
                            grid[1] = 1;
                        else
                            grid[1] = 2;

                        m_turnCounter++;
                    }
                }
                //check if already clicked before
                if(!clicked[1]) {
                    if (isWon()) {

                        if (grid[1] != 0)
                            setScores();

                        Toast.makeText(MainActivity.this, "You Won this game!", Toast.LENGTH_SHORT).show();
                    }
                }
                //set button as clicked
                clicked[1] = true;



            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!enable()) {
                    if (grid[2] == 0) {
                        setText(b3);

                        //set keeptract according to number of turns
                        if(m_turnCounter % 2 == 0)
                            grid[2] = 1;
                        else
                            grid[2] = 2;

                        m_turnCounter++;
                    }
                }

                //check if already clicked before
                if(!clicked[2]) {
                    if (isWon()) {

                        if (grid[2] != 0)
                            setScores();

                        Toast.makeText(MainActivity.this, "You Won this game!", Toast.LENGTH_SHORT).show();
                    }
                }
                //set button as clicked
                clicked[2] = true;

            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!enable()) {
                    if (grid[3] == 0) {
                        setText(b4);

                        //set keeptract according to number of turns
                        if(m_turnCounter % 2 == 0)
                            grid[3] = 1;
                        else
                            grid[3] = 2;

                        m_turnCounter++;
                    }

                }

                //check if already clicked before
                if(!clicked[3]) {
                    if (isWon()) {
                        if (grid[3] != 0)
                            setScores();
                    }
                }
                //set button as clicked
                clicked[3] = true;

            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!enable()) {
                    if (grid[4] == 0 ) {
                        setText(b5);

                        //set keeptract according to number of turns
                        if(m_turnCounter % 2 == 0)
                            grid[4] = 1;
                        else
                            grid[4] = 2;

                        m_turnCounter++;
                    }

                }

                //check if already clicked before
                if(!clicked[4]) {
                    if (isWon()) {
                        if (grid[4] != 0)
                            setScores();
                    }
                }
                //set button as clicked
                clicked[4] = true;

            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!enable()) {
                    if (grid[5] == 0) {
                        setText(b6);

                        //set keeptract according to number of turns
                        if(m_turnCounter % 2 == 0)
                            grid[5] = 1;
                        else
                            grid[5] = 2;

                        m_turnCounter++;
                    }
                }

                //check if already clicked before
                if(!clicked[5]) {
                    if (isWon()) {
                        if (grid[5] != 0)
                            setScores();
                    }
                }
                //set button as clicked
                clicked[5] = true;


            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!enable()) {
                    if (grid[6] == 0) {
                        setText(b7);

                        //set keeptract according to number of turns
                        if(m_turnCounter % 2 == 0)
                            grid[6] = 1;
                        else
                            grid[6] = 2;

                        m_turnCounter++;
                    }

                }

                //check if already clicked before
                if(!clicked[6]) {
                    if (isWon()) {
                        if (grid[6] != 0)
                            setScores();
                    }
                }
                //set button as clicked
                clicked[6] = true;

            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!enable()) {
                    if (grid[7] == 0) {
                        setText(b8);

                        //set keeptract according to number of turns
                        if(m_turnCounter % 2 == 0)
                            grid[7] = 1;
                        else
                            grid[7] = 2;

                        m_turnCounter++;
                    }
                }

                //check if already clicked before
                if(!clicked[7]) {
                    if (isWon()) {
                        if (grid[7] != 0)
                            setScores();
                    }
                }
                //set button as clicked
                clicked[7] = true;

            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!enable()) {
                    if (grid[8] == 0) {
                        setText(b9);

                        //set keeptract according to number of turns
                        if(m_turnCounter % 2 == 0)
                            grid[8] = 1;
                        else
                            grid[8] = 2;

                        m_turnCounter++;
                    }
                }

                //check if already clicked before
                if(!clicked[8]) {
                    if (isWon()) {
                        if (grid[8] != 0)
                            setScores();
                    }
                }
                //set button as clicked
                clicked[8] = true;

            }
        });

        //reset all variable
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //reset text to empty
                b1.setText("");
                b2.setText("");
                b3.setText("");
                b4.setText("");
                b5.setText("");
                b6.setText("");
                b7.setText("");
                b8.setText("");
                b9.setText("");

                //reset the turn counter to 0
                m_turnCounter = 0;

                //reset the grid
                for(int i = 0; i< grid.length; i++)
                    grid[i] = 0;

                //reset the clicked array
                for(int i = 0; i<clicked.length; i++)
                    clicked[i] = false;

            }
        });

        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });
    }

    //function to set text
    public void setText(Button b){

            if (m_turnCounter % 2 == 0) {
                b.setText(m_p1);
                b.setTextColor(Color.RED);
            } else if (m_turnCounter % 2 == 1) {
                b.setText(m_p2);
                b.setTextColor(Color.BLUE);
            }
    }

    public void setScores(){
        //increment counter for x or y
        if (winToggle[0] == true) {
            xCounter++;
            p1View.setText((String.valueOf(xCounter)));
        } else if (winToggle[1] == true) {
            yCounter++;
            p2View.setText(String.valueOf(yCounter));
        }
    }

    public boolean enable(){

        if(isWon())
            return true;
        else
            return false;
    }


    public boolean isWon(){
        /*
        ======Check wins for player X=======
         */
//        //check for horizontale
        if(grid[0] == 1 && grid[3] == 1 && grid[6] == 1){
            winToggle[0] = true;
            return true;
        }

        else if(grid[1] == 1 && grid[4] == 1 && grid[7] == 1) {
            winToggle[0] = true;
            return true;
        }
        else if(grid[2] == 1 && grid[5] == 1 && grid[8] == 1) {
            winToggle[0] = true;
            return true;
        }
//        //check for vertical
        if(grid[0] == 1 && grid[1] == 1 && grid[2] == 1) {
            winToggle[0] = true;
            return true;
        }
        else if(grid[3] == 1 && grid[4] == 1 && grid[5] == 1) {
            winToggle[0] = true;
            return true;
        }
        else if(grid[6] == 1 && grid[7] == 1 && grid[8] == 1) {
            winToggle[0] = true;
            return true;
        }
//        //check for diagonal
        if(grid[0] == 1 && grid[4] == 1 && grid[8] == 1) {
            winToggle[0] = true;
            return true;
        }
        else if(grid[2] == 1 && grid[4] == 1 && grid[6] == 1) {
            winToggle[0] = true;
            return true;
        }
        //============check wins for player Y =========

        if( grid[0] == 2 && grid[3] == 2 && grid[6] == 2)
        return true;

        return false;

    }
}