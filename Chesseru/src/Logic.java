import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;



public class Logic {

	field[] fields=new field[64];
	
	public BufferedImage getCorrectFieldImage(int i, boolean startBlack){
		System.out.println("return getCorrectFieldImage");
		String PathToBlack="src/images/black.jpg";
		String PathToWhite="src/images/white.jpg";

		BufferedImage imageF;
		if(startBlack){
			if(i % 2 == 0){	
				imageF = getBufImage(PathToBlack);
				fields[i]=new field("black", 0);
			}
			else{			
				imageF = getBufImage(PathToWhite);
				fields[i]=new field("white", 0);
			}
		} 
		else{
			if(i % 2 == 0){	
				imageF = getBufImage(PathToWhite);
				fields[i]=new field("white", 0);
			}
			else{			
				imageF = getBufImage(PathToBlack);
				fields[i]=new field("black", 0);
			}
		}
		return imageF;
	}
	
	public BufferedImage getBufImage(String Path){
		BufferedImage imageF=null;
		try {
			imageF = ImageIO.read(new File(Path));
			return imageF;
		} catch (IOException e) {
			System.out.println("getBufImage");
			e.printStackTrace();
		}
		System.out.println("Error in getBufImage, no Image found!");
		return imageF;
	}
}
