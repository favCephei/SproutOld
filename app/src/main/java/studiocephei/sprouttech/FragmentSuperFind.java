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
public class FragmentSuperFind extends Fragment {


    private Button mNext;
    private Typeface mTypeface;
    private HomeActivity actHome;
    private View mView;
    private EditText mFirstandMiddleEt;
    private EditText mSurnameEt;
    private EditText mDOBEt;
    private EditText mTFNEt;
    private EditText mAddressEt;
    private EditText mPhoneEt;
    private TextView mDisclosure;


    public FragmentSuperFind() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_superfind, container, false);
        mTypeface = Typeface.createFromAsset(getActivity().getAssets(), "gothic.TTF");
        actHome = (HomeActivity)getActivity();
        assignEditTexts();
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

    private void assignEditTexts(){

        mNext = (Button) mView.findViewById(R.id.btn_next);
        mNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actHome.switchToSuper();
            }
        });
        mFirstandMiddleEt = (EditText) mView.findViewById(R.id.et_firstandmiddle);
        mSurnameEt = (EditText) mView.findViewById(R.id.et_surname);
        mDOBEt = (EditText) mView.findViewById(R.id.et_dob);
        mTFNEt = (EditText) mView.findViewById(R.id.et_tfn);
        mAddressEt = (EditText) mView.findViewById(R.id.et_address);
        mPhoneEt = (EditText) mView.findViewById(R.id.et_phone);
        mDisclosure = (TextView) mView.findViewById(R.id.tv_product_disclosure_statement);
        mDisclosure.setText(Html.fromHtml(
                "Please read the " +
                        "<a href=\"http://www.google.com\">Product Disclosure Statement,</a> " +
                        "By clicking next I have read and understood the Product Disclosure Statement relevant to my product, and agree to provide my TFN for approved purposes."));
        mDisclosure.setMovementMethod(LinkMovementMethod.getInstance());
        mFirstandMiddleEt.setHint("First and Middle names");
        mSurnameEt.setHint("Surname");
        mDOBEt.setHint("DD/MM/YYYY");
        mTFNEt.setHint("Tax File Number");
        mAddressEt.setHint("Current Address");
        mPhoneEt.setHint("Best phone number");


        mNext.setTypeface(mTypeface);
        mFirstandMiddleEt.setTypeface(mTypeface);
        mSurnameEt.setTypeface(mTypeface);
        mDOBEt.setTypeface(mTypeface);
        mTFNEt.setTypeface(mTypeface);
        mAddressEt.setTypeface(mTypeface);
        mPhoneEt.setTypeface(mTypeface);
        mDisclosure.setTypeface(mTypeface);



    }


}
