package nahilaqudsi.example.com.sportfinder;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import nahilaqudsi.example.com.sportfinder.Adapter.IndorAdapter;
import nahilaqudsi.example.com.sportfinder.Model.LapIndor;

public class DataIndor extends AppCompatActivity {

    private ImageView btnIndor, btnOutdoor, btnFav, btnSwim;


    // Creating DatabaseReference.
    DatabaseReference databaseReference;

    // Creating RecyclerView.
    RecyclerView recyclerView;

    // Creating RecyclerView.Adapter.
    RecyclerView.Adapter adapter ;
//    IndorAdapter adapter;

    // Creating Progress dialog
    ProgressDialog progressDialog;

    // Creating List of ImageUploadInfo class.
    List<LapIndor> list = new ArrayList<>();

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_indor);

        // deskripsi button
        btnIndor = findViewById(R.id.imageView4);
        btnOutdoor = findViewById(R.id.imageView5);
        btnSwim = findViewById(R.id.imageView6);
        btnFav = findViewById(R.id.imageView7);

        //button outdoor
        btnOutdoor.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), DataOotdor.class);
                startActivity(i);
            }
        });

        // button swim
        btnSwim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), DataKolam.class);
                startActivity(i);
            }
        });
//
//        //button fav
//        btnFav.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });

        //menampilkan toolbar
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        setTitle(getString(R.string.app_name));
        mToolbar.setTitleTextColor(getResources().getColor(android.R.color.white));

        // Assign id to RecyclerView.
        recyclerView = (RecyclerView) findViewById(R.id.recyclerIndor);

        // Setting RecyclerView size true.
        recyclerView.setHasFixedSize(true);

        // Setting RecyclerView layout as LinearLayout.
        recyclerView.setLayoutManager(new LinearLayoutManager(DataIndor.this));

        // Assign activity this to progress dialog.
        progressDialog = new ProgressDialog(DataIndor.this);

        // Setting up message in Progress dialog.
        progressDialog.setMessage("Loading Data");

        // Showing progress dialog.
        progressDialog.show();

        // Setting up Firebase image upload folder path in databaseReference.
        // The path is already defined in MainActivity.
        String namaT = "LapanganIndor";
//        myRef = FirebaseDatabase.getInstance().getReference(namaT);
        databaseReference = FirebaseDatabase.getInstance().getReference(namaT);

        // Adding Add Value Event Listener to databaseReference.
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {

                for (DataSnapshot postSnapshot : snapshot.getChildren()) {

                    LapIndor lapIndor = postSnapshot.getValue(LapIndor.class);

                    list.add(lapIndor);
                }

                adapter = new IndorAdapter(getApplicationContext(), list);

                recyclerView.setAdapter(adapter);

                // Hiding the progress dialog.
                progressDialog.dismiss();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                // Hiding the progress dialog.
                progressDialog.dismiss();

            }
        });

    }

}
