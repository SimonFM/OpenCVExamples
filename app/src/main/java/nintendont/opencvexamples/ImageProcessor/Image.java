package nintendont.opencvexamples.ImageProcessor;
import android.graphics.Bitmap;

import org.opencv.android.Utils;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import java.io.File;

/**
 * Created by simon on 24/09/2016.
 */
public class Image {
    public String url;
    public String greyUrl;
    public Mat image;
    public Mat greyImage;
    public Mat rgbImage;

    public Image(String url) {
        this.image = new Mat();
        this.url = url;
        this.loadImage();
    }

    public void loadImage() {
        image = Imgcodecs.imread(url);
        rgb();
    }

    public Mat rgb() {
        rgbImage = new Mat();
        Imgproc.cvtColor(image, rgbImage, Imgproc.COLOR_BGR2RGB);
        return rgbImage;
    }

    public Mat greyscale() {
        greyImage = new Mat();
        Imgproc.cvtColor(rgb(), greyImage, Imgproc.COLOR_RGB2GRAY);
        greyUrl = url.replace(".jpg","-grey.jpg");
        makeFile(greyUrl, greyImage);
        return greyImage;
    }

    private boolean makeFile(String url, Mat data){
        return Imgcodecs.imwrite(url,data);
    }
}
