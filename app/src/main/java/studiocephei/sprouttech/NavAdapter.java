package studiocephei.sprouttech;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by matt on 20/05/2015.
 */
public class NavAdapter extends BaseAdapter {

    private Context mContext;
    private Resources res;
    private ArrayList<NavMenuItem> mNavList;

    public NavAdapter(Context context, ArrayList<NavMenuItem> navList) {
        mNavList = navList;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mNavList.size();
    }

    @Override
    public Object getItem(int position) {
        return mNavList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.drawer_item, null);
        }

        TextView navItemTitle = (TextView)convertView.findViewById(R.id.drawer_title);
        ImageView navItemImg = (ImageView)convertView.findViewById(R.id.drawer_image);
        NavMenuItem item = (NavMenuItem) getItem(position);

        navItemTitle.setText(item.getmTitle());
        navItemImg.setImageResource(item.getmDrawRes());

        return convertView;

    }

}
