import org.opencv.core.Core;

public class Center {
	static{ System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
}
	
	public static void main(String[] args){
		System.out.println("Welcome to OpenCV "+Core.VERSION);
	}
	
}