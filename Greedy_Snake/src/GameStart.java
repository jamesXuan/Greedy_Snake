import javax.swing.JFrame;
import javax.swing.WindowConstants;
/*如意 2022-4-14
 * 贪吃蛇
 * 实现功能：
 * 1.吃食物
 * 2.变速
 * 3.失败判定
 * 4.键盘控制
 * 后期可优化：
 * 1.食物种类
 * 2.蛇外观多样性
 * 3.多线程
 */
public class GameStart {
   public static void main(String args[]) {
	   JFrame game=new JFrame();
	   game.setBounds(10, 10, 1015, 730);
	   game.setResizable(false);
	   game.add(new GameWin());
	   game.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	   game.setVisible(true);//为什么要放在最后？
   }
}
