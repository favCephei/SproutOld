package studiocephei.sprouttech;

import android.content.Context;
import android.graphics.Typeface;

import java.lang.reflect.Field;

/**
 * Created by matt on 29/07/15.
 */
public class FontReplace {

    public static void replaceDefaultFont(Context context, String fontReplaced, String fontFile){

        Typeface customTypeface = Typeface.createFromAsset(context.getAssets(), fontFile);
        replaceFont(fontReplaced, customTypeface);

    }

    private static void replaceFont(String fontReplaced, Typeface customTypeface) {
        try {
            Field myField = Typeface.class.getDeclaredField(fontReplaced);
            myField.setAccessible(true);
            myField.set(null, customTypeface);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
