package nahilaqudsi.example.com.sportfinder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import nahilaqudsi.example.com.sportfinder.Model.LapIndor;

public class Coba extends AppCompatActivity {

    TextView txtnama1,txtAlamat1,txtTelp1,txtdeskripsi1;
    private String nama,alamat,telp,deskripsi;
    DatabaseReference databaseReference;
    String url;
    ImageView gambar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coba);

        txtnama1 = (TextView) findViewById(R.id.txtNama1);
        txtAlamat1 = (TextView) findViewById(R.id.txtAlamat);
        txtTelp1 = (TextView) findViewById(R.id.txtTelp);
        txtdeskripsi1 = (TextView) findViewById(R.id.txtDeskripsi);
        gambar = (ImageView) findViewById(R.id.foto);

        Intent i = this.getIntent();

        nama = i.getExtras().getString("nama");
        alamat  = i.getExtras().getString("alamat");
        telp = i.getExtras().getString("telp");
        deskripsi = i.getExtras().getString("deskripsi");
        txtnama1.setText(nama);
        txtAlamat1.setText(alamat);
        txtTelp1.setText(telp);

        String namaT = "LapanganIndor";
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
}
