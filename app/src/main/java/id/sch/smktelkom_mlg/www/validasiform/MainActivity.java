package id.sch.smktelkom_mlg.www.validasiform;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btnOk;
    TextView txtHasil;
    EditText editNama, editTahun, editAlamat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOk = (Button)findViewById(R.id.btnOk);
        editNama = (EditText)findViewById(R.id.editNama);
        editTahun = (EditText)findViewById(R.id.editTahun);
        editAlamat = (EditText)findViewById(R.id.editAlamat);
        txtHasil = (TextView)findViewById(R.id.txtHasil);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doProcess();
            }
            private void doProcess(){
                if (isValid()){
                    String nama = editNama.getText().toString();
                    int tahun = Integer.parseInt(editTahun.getText().toString());
                    String alamat = editAlamat.getText().toString();
                    txtHasil.setText("Nama Anda "+nama+"\n"+"Lahir pada "+tahun+"\n"+"Alamat Anda "+alamat);
                }
            }
            private boolean isValid() {
                boolean valid = true;
                String nama = editNama.getText().toString();
                String tahun = editTahun.getText().toString();
                String alamat = editAlamat.getText().toString();

                if(nama.isEmpty()) {
                    editNama.setError("Nama belum diisi");
                    valid = false;
                }
                else if (nama.length()<3) {
                    editNama.setError("Karakter nama kurang dari 3 karakter");
                    valid = false;
                }
                else {
                    editNama.setError(null);
                }
                if (tahun.isEmpty()) {
                    editTahun.setError("Tahun belum diisi");
                    valid = false;
                }
                else if (tahun.length()<4) {
                    editTahun.setError("Format tahun YYYY");
                    valid = false;
                }
                else {
                    editTahun.setError(null);
                }
                if (alamat.isEmpty()) {
                    editAlamat.setError("Alamat belum diisi");
                    valid = false;
                }
                else if (alamat.length()<4) {
                    editAlamat.setError("Karakter kurang dari 4");
                    valid = false;
                }
                else {
                    editAlamat.setError(null);
                }
                return valid;
            }
        });
    }
}
