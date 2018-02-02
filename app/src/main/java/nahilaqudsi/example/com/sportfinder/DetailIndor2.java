//package nahilaqudsi.example.com.sportfinder;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;
//import android.view.View;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import com.bumptech.glide.Glide;
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.ValueEventListener;
//
//import nahilaqudsi.example.com.sportfinder.Model.LapIndor;
//
//public class DetailIndor2 extends AppCompatActivity
//{
//
//    TextView txtnama1,txtAlamat1,txtTelp1,txtdeskripsi1;
//    private String nama,alamat,telp,deskripsi;
//    DatabaseReference databaseReference;
//    String url;
//    ImageView gambar;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_detail_indor2);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        txtnama1 = (TextView) findViewById(R.id.txtNama1);
//        txtAlamat1 = (TextView) findViewById(R.id.txtAlamat);
//        txtTelp1 = (TextView) findViewById(R.id.txtTlpn);
//        txtdeskripsi1 = (TextView) findViewById(R.id.txtDeskripsi);
//        gambar = (ImageView) findViewById(R.id.foto);
//
//        Intent i = this.getIntent();
//
//        nama = i.getExtras().getString("nama");
//        alamat  = i.getExtras().getString("alamat");
//        telp = i.getExtras().getString("telp");
//        deskripsi = i.getExtras().getString("keterangan");
//        txtnama1.setText(nama);
//        txtAlamat1.setText(alamat);
//        txtTelp1.setText(telp);
//
////        ImageView map = (ImageView) findViewById(R.id.btnMap);
////        map.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
////                        .setAction("Action", null).show();
////                Intent a = new Intent(DetailIndor2.this,MapsActivity.class);
////                a.putExtra("alamat", alamat); //ketambahan
////                startActivity(a);
////            }
////        });
//
//        String namaT = "LapanganIndor";
//        databaseReference = FirebaseDatabase.getInstance().getReference(namaT);
//
//        databaseReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot snapshot) {
//
//                for (DataSnapshot postSnapshot : snapshot.getChildren()){
//                    final LapIndor i = postSnapshot.getValue(LapIndor.class);
//
//
//                    if (i.getNama().equals(nama))
//                    {
//                        url = i.getImageURL();
//                        Glide.with(getApplicationContext()).load(url).into(gambar);
////
//                    }
//                }
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//                // Hiding the progress dialog.
//
//            }
//        });
//
//
//    }
//}
