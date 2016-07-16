package app.javiersanz.com.criminalintent;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;

/**
 * Created by Usuario on 16/07/2016.
 */
public class PictureUtils {

    // another getScaledBitmap to sclae a Bitmap for a particular Activity's size

    public static Bitmap getScaledBitmap(String path, Activity activity){
        Point size = new Point();
        activity.getWindowManager().getDefaultDisplay()
                .getSize(size);

        return getScaledBitmap(path, size.x, size.y);
    }

    // getScaledBitmap method

    public static Bitmap getScaledBitmap(String path, int destWith, int destHeight){
        //Read in the dimensions of the image on the disk

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path, options);

        float srcWidth = options.outWidth;
        float srcHeight = options.outHeight;

        // Figure out how much to scale down by

        int inSampleSize = 1;
        if (srcHeight > destHeight || srcWidth > destWith){
            if (srcWidth > srcHeight){
                inSampleSize = Math.round(srcHeight / destHeight);
            } else {
                inSampleSize = Math.round(srcWidth / destHeight);
            }
        }

        options = new BitmapFactory.Options();
        options.inSampleSize = inSampleSize;

        // Read in and create final bitmap

        return BitmapFactory.decodeFile(path, options);
    }

}
