package nahilaqudsi.example.com.sportfinder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Nahila Khunafa on 1/22/2018.
 */

public class OneFragment extends Fragment {
    public OneFragment() {
    }

    Button btnSepakBola, btnBadminton, btnKolam, btnLainnya;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
//        return inflater.inflate(R.layout.activity_main, container, false);
        View view = inflater.inflate(R.layout.activity_category, container, false);

        Button button1 = (Button) view.findViewById(R.id.buttonIndor);
        button1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(getActivity(), DataIndor.class);
                startActivity(i);
            }
        });
        Button button2 = view.findViewById(R.id.buttonOutdoor);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), DataOotdor.class);
                startActivity(i);
            }
        });
        Button button3 = view.findViewById(R.id.buttonKolam);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), DataKolam.class);
                startActivity(i);
            }
        });
        return view;
    }
}