package com.example.itemindexer;
import android.os.Build;
import android.os.Bundle;

//import com.example.itemindexer.dummy.DummyContent;
import android.widget.Button;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.chip.Chip;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;

public class ClosetView extends AppCompatActivity implements ItemFragment.OnListFragmentInteractionListener {
    private boolean tags[];
    private Button search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_closet_view);
        tags = new boolean[Tag.NUMTAGS.ordinal()];

        search = findViewById(R.id.button3);
        search.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                ItemFragment.refresh(ControlPanel.search(tags));
                finish();
                startActivity(getIntent());
            }
        });
    }

    @Override
    public void onListFragmentInteraction(Item item) {

    }


    public void filterTapped(View view) {
        Chip chip = (Chip)view;
        switch (chip.getId()) {
            case R.id.chipActivewear:
                tags[Tag.ACTIVEWEAR.ordinal()] = chip.isChecked();
                break;
            case R.id.chipDresses:
                tags[Tag.DRESSES.ordinal()] = chip.isChecked();
                break;
            case R.id.chipJackets:
                tags[Tag.JACKETS_COATS.ordinal()] = chip.isChecked();
                break;
            case R.id.chipJeans:
                tags[Tag.JEANS.ordinal()] = chip.isChecked();
                break;
            case R.id.chipJumpsuits:
                tags[Tag.JUMPSUITS.ordinal()] = chip.isChecked();
                break;
            case R.id.chipLingerie:
                tags[Tag.LINGERIE.ordinal()] = chip.isChecked();
                break;
            case R.id.chipPants:
                tags[Tag.PANTS.ordinal()] = chip.isChecked();
                break;
            case R.id.chipShorts:
                tags[Tag.SHORTS.ordinal()] = chip.isChecked();
                break;
            case R.id.chipSkirts:
                tags[Tag.SKIRTS.ordinal()] = chip.isChecked();
                break;
            case R.id.chipSweaters:
                tags[Tag.SWEATERS.ordinal()] = chip.isChecked();
                break;
            case R.id.chipSwimwear:
                tags[Tag.SWIMWEAR.ordinal()] = chip.isChecked();
                break;
            case R.id.chipTops:
                tags[Tag.TOPS.ordinal()] = chip.isChecked();
                break;
        }
    }
}


