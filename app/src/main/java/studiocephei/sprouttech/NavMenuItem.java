package studiocephei.sprouttech;

/**
 * Created by matt on 20/05/2015.
 */
public class NavMenuItem {

    private String mTitle;
    private int mDrawRes;

    NavMenuItem(String title, int drawRes){
        this.mTitle = title;
        this.mDrawRes = drawRes;
    }

    public void setmTitle(String title){
        this.mTitle = title;
    }

    public void setmDrawRes(int drawRes){
        this.mDrawRes = drawRes;
    }

    public String getmTitle(){
        return mTitle;
    }

    public int getmDrawRes(){
        return mDrawRes;
    }
}
