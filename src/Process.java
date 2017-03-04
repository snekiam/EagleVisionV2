import edu.wpi.first.wpilibj.networktables.NetworkTable;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;

/**
 * Created by Miles Aikens on 2/16/2017.
 */
public class Process {
    public static VideoCapture videoCapture;
    public static void main(String[] args){
        try {
            System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
//				opens up the camera stream and tries to load it
            videoCapture = new VideoCapture();
            videoCapture.open("http://10.33.22.32:8080/?action=stream");
            while(!videoCapture.isOpened()){
                System.out.println("Didn't open Camera, restart jar");
            }
            Mat img = new Mat();
            NetworkTable.setClientMode();
            NetworkTable.setIPAddress("10.33.22.2");
            NetworkTable sd = NetworkTable.getTable("SmartDashboard");
            EagleVision eagle = new EagleVision(sd);
            while(true){
                videoCapture.read(img);
                eagle.process(img);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
