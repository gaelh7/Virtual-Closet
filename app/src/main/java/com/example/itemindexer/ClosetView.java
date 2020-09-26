package com.example.itemindexer;
import android.os.Bundle;

//import com.example.itemindexer.dummy.DummyContent;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;

public class ClosetView extends AppCompatActivity implements ItemFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_closet_view);
    }

    @Override
    public void onListFragmentInteraction(Item item) {
    }

    public void allFilterTapped(View view) {
    }

    public void dressesFilterTapped(View view) {
    }

    public void jackets_coatsFilterTapped(View view) {
    }
}


