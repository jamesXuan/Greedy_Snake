
import java.net.URL;
import javax.swing.ImageIcon;


//������Ϸ������Դ(ÿ��ͼƬ��С 25x25 px)
public class Data {
public static URL headUrl= Data.class.getResource("/data/head.png");
public static URL tailUrl= Data.class.getResource("/data/tail.png");
public static URL foodUrl= Data.class.getResource("/data/food.png");
public static ImageIcon head=new ImageIcon(headUrl);
public static ImageIcon tail=new ImageIcon(tailUrl);
public static ImageIcon food=new ImageIcon(foodUrl);
}
