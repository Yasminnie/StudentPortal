package yazzyyas.studentportal;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fab;
    public List<Portal> Portals = new ArrayList<>();
    Portal portal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getIntent();
        getIntent().getStringExtra("portal");
        Portals.add(new Portal("VLO", "http://www.google.com"));

        RecyclerView portalRecyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager mLayoutManager = new StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL);

        portalRecyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {
                System.out.println("wooehooee");
            }

            @Override
            public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
                return false;
            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });

        portalRecyclerView.setLayoutManager(mLayoutManager);
        PortalAdapter mAdapter = new PortalAdapter(this, Portals);
        portalRecyclerView.setAdapter(mAdapter);

        fab = findViewById(R.id.AddPortalBtn);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivityForResult(intent, 1234);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == 1234) {
                Bundle bundle = data.getExtras();
                Portal intentPortal = (Portal) bundle.getSerializable("portal");
                Portals.add(intentPortal);
            }
        }
    }
}
