package nahilaqudsi.example.com.sportfinder;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import nahilaqudsi.example.com.sportfinder.Adapter.KolamAdapter;
import nahilaqudsi.example.com.sportfinder.Adapter.OutdorAdapter;
import nahilaqudsi.example.com.sportfinder.Model.LapOutdor;

public class DataKolam extends AppCompatActivity {

    private ImageView btnIndor, btnOutdoor, btnFav, btnSwim;

    // Creating DatabaseReference.
    DatabaseReference databaseReference;

    // Creating RecyclerView.
    RecyclerView rv;

    // Creating RecyclerView.Adapter.
    RecyclerView.Adapter adapter ;
//    IndorAdapter adapter;

    // Creating Progress dialog
    ProgressDialog progressDialog;

    // Creating List of ImageUploadInfo class.
    List<LapOutdor> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_kolam);

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

        // button indoor
        btnIndor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), DataIndor.class);
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


        // Assign id to RecyclerView.
        rv = findViewById(R.id.recyclerKolam);

        // Setting RecyclerView size true.
        rv.setHasFixedSize(true);

        // Setting RecyclerView layout as LinearLayout.
        rv.setLayoutManager(new LinearLayoutManager(DataKolam.this));

        // Assign activity this to progress dialog.
        progressDialog = new ProgressDialog(DataKolam.this);

        // Setting up message in Progress dialog.
        progressDialog.setMessage("Loading Images From Firebase.");

        // Showing progress dialog.
        progressDialog.show();

        // Setting up Firebase image upload folder path in databaseReference.
        // The path is already defined in MainActivity.
        String namaT = "KolamRenang";
//        myRef = FirebaseDatabase.getInstance().getReference(namaT);
        databaseReference = FirebaseDatabase.getInstance().getReference(namaT);

        // Adding Add Value Event Listener to databaseReference.
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {

                for (DataSnapshot postSnapshot : snapshot.getChildren()) {

                    LapOutdor lapOutdor = postSnapshot.getValue(LapOutdor.class);

                    list.add(lapOutdor);
                }

                adapter = new KolamAdapter(getApplicationContext(), list);

                rv.setAdapter(adapter);

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
