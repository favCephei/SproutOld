package studiocephei.sprouttech;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 */
public class FragmentStock extends Fragment {


    private Button mNext;
    private Typeface mTypeface;
    private HomeActivity actHome;
    private View mView;
    private TextView mTitle;




    public FragmentStock() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_stock, container, false);
        mTypeface = Typeface.createFromAsset(getActivity().getAssets(), "gothic.TTF");
        actHome = (HomeActivity)getActivity();
        assignTextViews();
        return mView;

    }



    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    private void assignTextViews(){

        mTitle = (TextView) mView.findViewById(R.id.tv_title);
        mNext = (Button) mView.findViewById(R.id.btn_next);
        mNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actHome.switchToOverview();
            }
        });
        //mMoneyAmt.setText("$121,318.42");
        mNext.setTypeface(mTypeface);
        mTitle.setTypeface(mTypeface);

    }


}
