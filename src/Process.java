import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;

/**
 * Created by Miles Aikens on 2/16/2017.
 */
public class Process {
    public static void main(String[] args){
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        VideoCapture capture = new VideoCapture("http://10.33.22.32:8080/?action=stream");
        capture.open("http://10.33.22.32:8080/?action=stream");
        Mat img = new Mat();
        EagleVision eagle = new EagleVision();
        while(true){
            capture.read(img);
            eagle.process(img);
        }
    }
}
