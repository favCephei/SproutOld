package studiocephei.sprouttech;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 */
public class FragmentSupers extends Fragment {


    private Button mConsolidate;
    private Typeface mTypeface;
    private HomeActivity actHome;
    private View mView;

    private TextView mFundName1;
    private TextView mFundName2;
    private TextView mFundName3;

    private TextView mFundDetails1;
    private TextView mFundDetails2;
    private TextView mFundDetails3;



    public FragmentSupers() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_supers, container, false);
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

        mConsolidate = (Button) mView.findViewById(R.id.btn_consolidate);
        mConsolidate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actHome.switchToPlant();
            }
        });

        mFundName1 = (TextView) mView.findViewById(R.id.tv_fundname1);
        mFundName2 = (TextView) mView.findViewById(R.id.tv_fundname2);
        mFundName3 = (TextView) mView.findViewById(R.id.tv_fundname3);

        mFundDetails1 = (TextView) mView.findViewById(R.id.tv_funddetails1);
        mFundDetails2 = (TextView) mView.findViewById(R.id.tv_funddetails2);
        mFundDetails3 = (TextView) mView.findViewById(R.id.tv_funddetails3);

        mFundName1.setText("Hostplus #2893632819");
        mFundName2.setText("Colonial First State #807153097");
        mFundName3.setText("AMP Flexible Lifetime Super #987092834");

        mFundDetails1.setText("$7,585.01");
        mFundDetails2.setText("$23,894.43");
        mFundDetails3.setText("$89,838.98");




        mConsolidate.setTypeface(mTypeface);
    }


}
