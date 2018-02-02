package nahilaqudsi.example.com.sportfinder;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import nahilaqudsi.example.com.sportfinder.Model.LapIndor;

public class DetailKolam extends AppCompatActivity {
    private static final int REQUEST_PHONE_CALL =1 ;

    private TextView txtnama1,txtAlamat1,txtTelp1,txtdeskripsi1;
    private String nama, alamat, telp, deskripsi;
    private Button btnDetailMaps, btnDetailTelp, btnDetailFav, btnDetailShare;
    DatabaseReference databaseReference;
    ImageView gambar;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_indor);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txtnama1 = (TextView) findViewById(R.id.txtNama);
        txtAlamat1 = (TextView) findViewById(R.id.txtAlamat);
        txtTelp1 = (TextView) findViewById(R.id.txtTelp);
        txtdeskripsi1 = (TextView) findViewById(R.id.txtDeskripsi);
        gambar = (ImageView) findViewById(R.id.foto);

        btnDetailMaps = (Button) findViewById(R.id.btnDetailMaps);
        btnDetailFav = findViewById(R.id.btnDetailFav);
        btnDetailTelp = findViewById(R.id.btnDetailTelp);
        btnDetailShare = findViewById(R.id.btnDetailShare);

        // set data from data sebelumnya
        Intent i = this.getIntent();

        nama = i.getExtras().getString("nama");
        alamat  = i.getExtras().getString("alamat");
        telp = i.getExtras().getString("telp");
        deskripsi = i.getExtras().getString("keterangan");
        txtnama1.setText(nama);
        txtAlamat1.setText(alamat);
        txtTelp1.setText(telp);

        txtdeskripsi1.setText(deskripsi);
        final ImageView gambar = (ImageView) findViewById(R.id.foto);

        // set telepon otomatis
        txtTelp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callTelepon();
            }
        });
        btnDetailTelp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                callTelepon();
            }
        });

        // set maps otomatis

        // set button maps
        btnDetailMaps.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent a = new Intent(DetailKolam.this,MapsActivity.class);
                a.putExtra("alamat", alamat); //ketambahan
                startActivity(a);
            }
        });

//        //set button favorite
//        btnDetailFav.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });

        // set button share
        btnDetailShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareText();
            }
        });

        // Adding Add Value Event Listener to databaseReference.
        String namaT = "KolamRenang";
        databaseReference = FirebaseDatabase.getInstance().getReference(namaT);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {

                for (DataSnapshot postSnapshot : snapshot.getChildren()){
                    final LapIndor i = postSnapshot.getValue(LapIndor.class);


                    if (i.getNama().equals(nama))
                    {
                        url = i.getImageURL();
                        Glide.with(getApplicationContext()).load(url).into(gambar);
//
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                // Hiding the progress dialog.

            }
        });


    }


    public void callTelepon()
    {
        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:"+telp+""));

        if (ContextCompat.checkSelfPermission(DetailKolam.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(DetailKolam.this, new String[]{android.Manifest.permission.CALL_PHONE},REQUEST_PHONE_CALL);
        }
        else
        {
            startActivity(callIntent);
        }
    }

    public void shareText()
    {
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "AndroidSolved");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Nama : " + txtnama1.getText() + "\n\nAlamat : " + txtAlamat1.getText() + " \n\nTelepon : " + txtTelp1.getText());
        startActivity(Intent.createChooser(sharingIntent, "Share via"));
    }
}
