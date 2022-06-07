package ryndra.ppf.akb_10119105_ryndrappf_if3;
/**NIM : 10119105
 * Nama : Ryndra Putra Pratama Firdaus
 * Kelas: IF-3
 */
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class TambahCatatan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_catatan);

        FloatingActionButton btn_tambah = findViewById(R.id.btn_tambah);

        btn_tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TambahCatatan.this, MainActivity.class));
                finish();
            }
        });
    }
}