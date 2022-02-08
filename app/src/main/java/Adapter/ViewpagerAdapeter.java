package Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.miwok.ColorFragment;
import com.example.miwok.FamlyFragment;
import com.example.miwok.NumbersFragment;
import com.example.miwok.PhrasesFragment;

public class ViewpagerAdapeter extends FragmentStateAdapter {

    public ViewpagerAdapeter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0) {
            return new NumbersFragment();
        } else if (position == 1){
            return new PhrasesFragment();
        } else if (position == 2){
            return new ColorFragment();
        }else {
            return new FamlyFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
