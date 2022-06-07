package ryndra.ppf.akb_10119105_ryndrappf_if3;
/**NIM : 10119105
 * Nama : Ryndra Putra Pratama Firdaus
 * Kelas: IF-3
 */
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import ryndra.ppf.akb_10119105_ryndrappf_if3.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new CatatanFragment());

        binding.bottomView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.note:
                    replaceFragment(new CatatanFragment());
                    break;
                case R.id.profile:
                    replaceFragment(new ProfileFragment());
                    break;
            }
            return true;
        });
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentLayout,fragment);
        fragmentTransaction.commit();
    }
}