package studiocephei.sprouttech;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 */
public class FragmentOverview extends Fragment {


    private Button mWizard;
    private HomeActivity actHome;
    private View mView;


    public FragmentOverview() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        actHome = (HomeActivity) getActivity();
        mView = inflater.inflate(R.layout.fragment_overview, container, false);
        mWizard = (Button) mView.findViewById(R.id.btn_wizard);
        mWizard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startWizard();
            }
        });
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

    private void startWizard(){
        actHome.switchToWizard();

    }



}
