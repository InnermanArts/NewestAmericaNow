package com.example.dennisthicklin.naturalizationgame3.UI;

import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.dennisthicklin.naturalizationgame3.R;


public class practice_activity extends Activity {
    //Essentially, the code for this class is for a multiple choice.



    TextView question;
    Button next;
    Button home;
    RadioGroup answerChoices;
    RadioButton answer1, answer2, answer3, answer4;
    TextView time;
    String questionTest;

    // Create variables for the objects on the activity.
    String[] questions = {"What is the supreme law of the land?",
            "What are the first three words of the Preamble?",
            "How many justices are on the Supreme Court?",
            "Who is in charge of the Executive Branch?",
            "What did Susan B. Anthony do?",
            "What is one power state governments possess?",
            "What is the name of the national anthem?",
            "What are two rights given to United States citizens?",
            "Who vetoes bills?",
            "Who was President during the Great Depression and World War II?",
            "What are the two major political parties in the United States?",
            "What happened at the Constitutional Convention?",
            "What do we call the first ten amendments to the Constitution?",
            "Name one state that borders Mexico","What is one power of the federal government?"

    };

    // Create a string array for the questions.
    String[] answers = {"Constitution",
            "We the People",
            "Nine",
            "The President",
            "Fought for women's rights",
            "Provide schooling and education",
            "Star-Spangled Banner",
            "Freedom of speech and freedom of worship",
            "The President",
            "Franklin Roosevelt",
            "Democrats and Republicans",
            "The Constitution was written",
            "The Bill of Rights",
            "California",
            "To make treaties"}; // Create a string array for the answers.

    String[] userOptions = {"Constitution",
            "Articles of Confederation",
            "Magna Carta",
            "Declaration of Independence"
            ,"In the course",
            "We the People",
            "The People of",
            "Of Human Events"
            ,"Ten",
            "Eight",
            "Nine",
            "Twelve",
            "Chief Secretary",
            "Head Senator",
            "The President",
            "The Head Minister",
            "First woman to be elected by the House of Representatives",
            "Fought for women's rights",
            "Founded the Red Cross",
            "Made the first flag of the United States",
            "Coin and print money",
            "Make treaties",
            "Assemble an army",
            "Provide schooling and education",
            "Star-Spangled Banner",
            "God Bless the USA",
            "America the Beautiful",
            "My Country Tis of Thee",
            "Freedom of speech and freedom to make treaties",
            "Freedom of speech and freedom to run for president",
            "Freedom of speech and freedom of worship",
            "Freedom to petition the government and freedom to disobey traffic laws",
            "The President",
            "The Speaker of House",
            "The President Pro Tempore",
            "The Vice President",
            "Calvin Coolidge",
            "Franklin Roosevelt",
            "Herbert Hoover",
            "Harry Truman",
            "Democrats and Republicans",
            "Democratic-Republican and Whigs",
            "American and Bull-Moose",
            "Reform and Green",
            "The Emancipation Proclamation was written.",
            "The Virginia Declaration of Rights was written.",
            "The Declaration of Independence was written.",
            "The Constitution was written.",
            "The Declaration of Independence",
            "The inalienable rights",
            "The Bill of Rights",
            "The Articles of Confederation",
            "Alabama",
            "Florida",
            "Arkansas",
            "California",
            "To provide police departments",
            "To make treaties",
            "To issue driver's licenses",
            "To provide schooling"};
    // Create a string for the user's options.

    /*int signal = 0;
    public static int marks, wrong, correct;

    final List<Integer> ints = new ArrayList<>();


    int current_question_index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_activity);
        time = (TextView) findViewById(R.id.time);
        question = (TextView) findViewById(R.id.questionText);
        next = (Button) findViewById(R.id.next);
        home = (Button) findViewById(R.id.home);
        answerChoices = (RadioGroup) findViewById(R.id.options);
        answer1 = (RadioButton) findViewById(R.id.a1);
        answer2 = (RadioButton) findViewById(R.id.a2);
        answer3 = (RadioButton) findViewById(R.id.a3);
        answer4 = (RadioButton) findViewById(R.id.a4);
        Toast.makeText(getApplicationContext(), "BEGIN!",Toast.LENGTH_LONG).show();// This will prompt the user to begin.
        final MediaPlayer roll = MediaPlayer.create(this, R.raw.roll);
        final MediaPlayer right = MediaPlayer.create(this, R.raw.right);
        final MediaPlayer wrong = MediaPlayer.create(this, R.raw.wrong);
        final MediaPlayer beat = MediaPlayer.create(practice_activity.this, R.raw.beat);


        question.setText("Press Next to proceed to a question!");

        for(int i = 0; i < questions.length; i++)
        {
            ints.add(i);
        }
        Collections.shuffle(ints);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int randomFactor = ints.get(current_question_index);
                current_question_index = current_question_index + 1;
                question.setText(questions[randomFactor]);
                switch(randomFactor) {
                    case 0:
                        answer1.setText(userOptions[0]); // Right
                        answer2.setText(userOptions[1]);
                        answer3.setText(userOptions[2]);
                        answer4.setText(userOptions[3]);
                        break;
                    case 1:
                        answer1.setText(userOptions[4]);
                        answer2.setText(userOptions[5]); // Right
                        answer3.setText(userOptions[6]);
                        answer4.setText(userOptions[7]);
                        break;
                    case 2:
                        answer1.setText(userOptions[8]);
                        answer2.setText(userOptions[9]);
                        answer3.setText(userOptions[10]); // Right
                        answer4.setText(userOptions[11]);
                        break;
                    case 3:
                        answer1.setText(userOptions[12]);
                        answer2.setText(userOptions[13]);
                        answer3.setText(userOptions[14]); // Right
                        answer4.setText(userOptions[15]);
                        break;
                    case 4:
                        answer1.setText(userOptions[16]);
                        answer2.setText(userOptions[17]); // Right
                        answer3.setText(userOptions[18]);
                        answer4.setText(userOptions[19]);
                        break;
                    case 5:
                        answer1.setText(userOptions[20]);
                        answer2.setText(userOptions[21]);
                        answer3.setText(userOptions[22]);
                        answer4.setText(userOptions[23]); // Right
                        break;
                    case 6:
                        answer1.setText(userOptions[24]); // Right
                        answer2.setText(userOptions[25]);
                        answer3.setText(userOptions[26]);
                        answer4.setText(userOptions[27]);
                        break;
                    case 7:
                        answer1.setText(userOptions[28]);
                        answer2.setText(userOptions[29]);
                        answer3.setText(userOptions[30]); // Right
                        answer4.setText(userOptions[31]);
                        break;
                    case 8:
                        answer1.setText(userOptions[32]); // Right
                        answer2.setText(userOptions[33]);
                        answer3.setText(userOptions[34]);
                        answer4.setText(userOptions[35]);
                        break;
                    case 9:
                        answer1.setText(userOptions[36]); // Right
                        answer2.setText(userOptions[37]);
                        answer3.setText(userOptions[38]);
                        answer4.setText(userOptions[39]);
                        break;
                    case 10:
                        answer1.setText(userOptions[40]); // Right
                        answer2.setText(userOptions[41]);
                        answer3.setText(userOptions[42]);
                        answer4.setText(userOptions[43]);
                        break;
                    case 11:
                        answer1.setText(userOptions[44]);
                        answer2.setText(userOptions[45]);
                        answer3.setText(userOptions[46]);
                        answer4.setText(userOptions[47]); // Right
                        break;
                    case 12:
                        answer1.setText(userOptions[48]);
                        answer2.setText(userOptions[49]);
                        answer3.setText(userOptions[50]); // Right
                        answer4.setText(userOptions[51]);
                        break;
                    case 13:
                        answer1.setText(userOptions[52]);
                        answer2.setText(userOptions[53]);
                        answer3.setText(userOptions[54]); // Right
                        answer4.setText(userOptions[55]);
                        break;
                    case 14:
                        answer1.setText(userOptions[56]);
                        answer2.setText(userOptions[57]);
                        answer3.setText(userOptions[58]);
                        answer4.setText(userOptions[59]); // Right
                        break;
                    case 15:
                        answer1.setText(userOptions[60]);
                        answer2.setText(userOptions[61]); // Right
                        answer3.setText(userOptions[62]);
                        answer4.setText(userOptions[63]);
                        break;

                }
                beat.start();
            }

        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home = new Intent(practice_activity.this, MainActivity.class);
                startActivity(home);
                overridePendingTransition(R.anim.pushdownin, R.anim.pushdownout);
                beat.stop();
            }
        });


        final MediaPlayer a1 = MediaPlayer.create(this, R.raw.tap);
        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a1.start();
            }
        });
        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a1.start();
            }
        });
        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a1.start();
            }
        });
        answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a1.start();
            }
        });




    }*/


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_practice_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}

