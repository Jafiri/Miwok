package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.miwok.R;
import java.util.ArrayList;
import Classes.WordClass;

public class WordAdapter extends ArrayAdapter<WordClass> {


    public WordAdapter(@NonNull Context context, ArrayList<WordClass> wordClasses) {
        super(context, 0, wordClasses);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.custom_word_layout, parent, false);
        }

        WordClass wordClass = getItem(position);

        TextView txt_englishTraslation = (TextView) listItemView.findViewById(R.id.txt_englishTraslation);

        txt_englishTraslation.setText(wordClass.getmDefaultLanguage());

        TextView txt_miwokTraslation = (TextView) listItemView.findViewById(R.id.txt_miwokTraslation);

        txt_miwokTraslation.setText(wordClass.getmMiwokLanguage());
        ImageView img_words = (ImageView) listItemView.findViewById(R.id.img_words);

        if (wordClass.hasImage()) {

            img_words.setImageResource(wordClass.getmImageResource());
            img_words.setVisibility(View.VISIBLE);
        } else {
            img_words.setVisibility(View.GONE);
        }


        return listItemView;


    }
}