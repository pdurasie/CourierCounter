package com.example.android.quidditchcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.android.quidditchcounter.R;

public class MainActivity extends AppCompatActivity {

    //declare Counters
    int teamAScore = 0;
    int teamBScore = 0;
    int teamAYellowCards = 0;
    int teamBYellowCards = 0;
    int teamARedCards = 0;
    int teamBRedCards = 0;
    //initialize Buttons
    Button teamAYellow, teamARed, teamBYellow, teamBRed, teamAIncrease, teamADecrease, teamBIncrease, teamBDecrease, teamASnitchCatch, teamBSnitchCatch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //declare buttons
        teamAYellow = (Button) findViewById(R.id.team_a_yellow_card);
        teamARed = (Button) findViewById(R.id.team_a_red_card);
        teamBYellow = (Button) findViewById(R.id.team_b_yellow_card);
        teamBRed = (Button) findViewById(R.id.team_b_red_card);
        teamAIncrease = (Button) findViewById(R.id.increase_score_team_a);
        teamADecrease = (Button) findViewById(R.id.decrease_score_team_a);
        teamBIncrease = (Button) findViewById(R.id.increase_score_team_b);
        teamBDecrease = (Button) findViewById(R.id.decrease_score_team_b);
        teamASnitchCatch = (Button) findViewById(R.id.team_a_snitch_catch);
        teamBSnitchCatch = (Button) findViewById(R.id.team_b_snitch_catch);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    // **************** Add and remove goals for teams **********************
    public void scoreGoalTeamA(View view) {
        teamAScore += 10;
        displayForTeamA(teamAScore);
    }

    ;

    public void rescindGoalTeamA(View view) {
        if (teamAScore != 0) {
            teamAScore -= 10;
        }
        displayForTeamA(teamAScore);
    }

    ;

    public void scoreGoalTeamB(View view) {
        teamBScore += 10;
        displayForTeamB(teamBScore);
    }

    ;

    public void rescindGoalTeamB(View view) {
        if (teamBScore != 0) {
            teamBScore -= 10;
        }
        displayForTeamB(teamBScore);
    }

    ;

    // *********** INCREASING CARD COUNTERS AND DISPLAYING THEM ***************************
    public void giveYellowTeamA(View view) {
        teamAYellowCards++;
        teamAYellow.setText("Yellow card (" + String.valueOf(teamAYellowCards) + ")");
    }

    public void giveRedTeamA(View view) {
        teamARedCards++;
        teamARed.setText("Red card (" + String.valueOf(teamARedCards) + ")");
    }

    public void giveYellowTeamB(View view) {
        teamBYellowCards++;
        teamBYellow.setText("Yellow card (" + String.valueOf(teamBYellowCards) + ")");
    }

    public void giveRedTeamB(View view) {
        teamBRedCards++;
        teamBRed.setText("Red card (" + String.valueOf(teamBRedCards) + ")");
    }
    /* ***************** Snitch Catches here *********************
       A snitch catch gives 30 Points for the catching team.
       The game ends, so all buttons except "reset" are disabled.
       It is convention that the catching team is designated with an asterix (*) behind their name. */

    public void snitchCatchTeamA(View view) {
        teamAScore += 30;
        displayForTeamA(teamAScore);
        TextView teamAName = (TextView) findViewById(R.id.team_a_team_name);
        teamAName.setText(teamAName.getText() + "*");
        disableButtons();
    }

    public void snitchCatchTeamB(View view) {
        teamBScore += 30;
        displayForTeamB(teamBScore);
        TextView teamBName = (TextView) findViewById(R.id.team_b_team_name);
        teamBName.setText(teamBName.getText() + "*");
        disableButtons();
    }

    // *************** Reset Button ****************
    public void resetScores(View view) {
        //reset globals
        teamAScore = 0;
        teamBScore = 0;
        teamAYellowCards = 0;
        teamARedCards = 0;
        teamBYellowCards = 0;
        teamBRedCards = 0;
        //reset score display
        displayForTeamA(teamAScore);
        displayForTeamB(teamBScore);
        //reset cards
        teamAYellow.setText("Yellow card (" + String.valueOf(teamAYellowCards) + ")");
        teamARed.setText("Red card (" + String.valueOf(teamARedCards) + ")");
        teamBYellow.setText("Yellow card (" + String.valueOf(teamBYellowCards) + ")");
        teamBRed.setText("Red card (" + String.valueOf(teamBRedCards) + ")");
        resetNames();
        enableButtons();
    }

    public void disableButtons() {
        teamAIncrease.setEnabled(false);
        teamADecrease.setEnabled(false);
        teamBIncrease.setEnabled(false);
        teamBDecrease.setEnabled(false);
        teamAYellow.setEnabled(false);
        teamARed.setEnabled(false);
        teamBYellow.setEnabled(false);
        teamBRed.setEnabled(false);
        teamASnitchCatch.setEnabled(false);
        teamBSnitchCatch.setEnabled(false);
    }

    public void enableButtons() {
        teamAIncrease.setEnabled(true);
        teamADecrease.setEnabled(true);
        teamBIncrease.setEnabled(true);
        teamBDecrease.setEnabled(true);
        teamAYellow.setEnabled(true);
        teamARed.setEnabled(true);
        teamBYellow.setEnabled(true);
        teamBRed.setEnabled(true);
        teamASnitchCatch.setEnabled(true);
        teamBSnitchCatch.setEnabled(true);
    }

    // I'm hard coding the names, because I'd otherwise have to check which team caught the snitch or which string contains an asterix
    public void resetNames() {
        TextView teamAName = (TextView) findViewById(R.id.team_a_team_name);
        teamAName.setText("Team A");
        TextView teamBName = (TextView) findViewById(R.id.team_b_team_name);
        teamBName.setText("Team B");
    }

}
