package tech.hyperdev.scorekeeper.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

import tech.hyperdev.scorekeeper.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScoreFragment extends Fragment implements View.OnClickListener {

    private TextView titleTextView, scoreTextView;
    private ImageButton plusButton, minusButton;

    private String teamName;
    private int score;

    public ScoreFragment() {

    }

    public ScoreFragment(String teamName, int score) {
        this.teamName = teamName;
        this.score = score;
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("TeamName", teamName);
        outState.putInt("Score", score);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_score, container, false);

        titleTextView = (TextView) view.findViewById(R.id.tvTeamName);
        scoreTextView = (TextView) view.findViewById(R.id.textView2);
        plusButton = (ImageButton) view.findViewById(R.id.btnPlus);
        minusButton = (ImageButton) view.findViewById(R.id.btnMinus);

        if (savedInstanceState != null) {
            teamName = savedInstanceState.getString("TeamName");
            score = savedInstanceState.getInt("Score");
        }
        titleTextView.setText(teamName);
        scoreTextView.setText(Integer.toString(score));


        plusButton.setOnClickListener(this);


        minusButton.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnPlus) {
            score++;
            scoreTextView.setText(Integer.toString(score));
        } else if (view.getId() == R.id.btnMinus) {
            if (score > 0) {
                score--;
                scoreTextView.setText(Integer.toString(score));
            }
        }
    }
}
