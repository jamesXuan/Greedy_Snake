import javax.swing.JFrame;
import javax.swing.WindowConstants;
/*���� 2022-4-14
 * ̰����
 * ʵ�ֹ��ܣ�
 * 1.��ʳ��
 * 2.����
 * 3.ʧ���ж�
 * 4.���̿���
 * ���ڿ��Ż���
 * 1.ʳ������
 * 2.����۶�����
 * 3.���߳�
 */
public class GameStart {
   public static void main(String args[]) {
	   JFrame game=new JFrame();
	   game.setBounds(10, 10, 1015, 730);
	   game.setResizable(false);
	   game.add(new GameWin());
	   game.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	   game.setVisible(true);//ΪʲôҪ�������
   }
}
