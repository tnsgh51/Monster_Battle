package Test;

import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.Color;
import java.io.File;
import javax.imageio.ImageIO;

public class imgTest {

	public static void main(String[] args) {

		BufferedImage img = new BufferedImage(514, 344, BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics = img.createGraphics(); // Graphics2D를 얻어와 그림을 그린다

		graphics.setColor(Color.WHITE); // 색상을 지정한다(파란색)
		graphics.fillRect(0, 0, 200, 200); // 사각형을 하나 그린다
		
		graphics.setColor(Color.black); // 색상을 지정한다(파란색)
		graphics.fillRect(100, 100, 200, 200); // 사각형을 하나 그린다
		
		
		try {
			File file = new File("C:\\Users\\admin\\Desktop\\새 폴더\\imgtest.jpg"); // 파일의 이름을 설정한다
			ImageIO.write(img, "jpg", file); // write메소드를 이용해 파일을 만든다
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}
