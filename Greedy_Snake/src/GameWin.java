import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.*;

public class GameWin extends JPanel implements KeyListener,ActionListener{
	 /*length:С�߳���
	  *score: ��Ϸ����
	  *level: ��Ϸ�ȼ�
	  *snakeX��snakeY: С������
	  *foodX,foodY: ʳ������
	  *position:С���ƶ�����
	  *isStart: ��Ϸ��ʼ��־
	  *isFail:��Ϸʧ�ܱ�־
	  */
      int length;     
      int score;      
      int level;
      int[] snakeX=new int [1000];
      int[] snakeY=new int [1000];
      int foodX;
      int foodY;
      String position;
      boolean isStart=false;
      boolean isFail=false;
      Timer timer=new Timer(100,this);
      Random ram=new Random();
      
      //������
      GameWin() {
    	  init();
    	  this.setFocusable(true);
    	  this.addKeyListener(this);
    	  timer.start();
      }
      
      //��ʼ������
      void init(){
      length=3;
      snakeX[0]=100;snakeY[0]=100;
      snakeX[1]=75;snakeY[1]=100;
      snakeX[2]=50;snakeY[2]=100;
      position="R";
      foodX=ram.nextInt(37)*25+25;
      foodY=ram.nextInt(19)*25+75;
      score=0;
      level=1;
      }
      
      protected void paintComponent(Graphics g) {
    	  super.paintComponent(g);
    	  
    	  //�滭���
    	  g.setColor(Color.white);
    	  g.setFont(new Font("΢���ź�",Font.BOLD,40));
    	  g.drawString("Greedy  Snake",350,50);
    	  g.setColor(Color.black);
    	  g.fillRect(25, 75, 950, 600);
    	  g.setColor(Color.red);
    	  g.setFont(new Font("΢���ź�",Font.BOLD,20));
    	  g.drawString("Score: "+score,850,30);
    	  g.setFont(new Font("΢���ź�",Font.BOLD,20));
    	  g.drawString("Level: "+level,850,60);
    	  
    	  //��ʳ��
    	  Data.food.paintIcon(this, g, foodX, foodY);
    	  //��С��
    	  for(int i=1;i<length;i++)
    		  Data.tail.paintIcon(this, g, snakeX[i], snakeY[i]);
    	  Data.head.paintIcon(this, g, snakeX[0], snakeY[0]);
    	  
    	  //��Ϸ��ͣ����
    	  if(!isStart&&!isFail) {
    		  g.setColor(Color.WHITE);
    		  g.setFont(new Font("΢���ź�",Font.BOLD,40));
    		  g.drawString("Press space start/stop", 300, 350);
    	  }
    	  //��Ϸʧ�ܱ���
    	  if(isFail) {
    		  g.setColor(Color.red);
    		  g.setFont(new Font("΢���ź�",Font.BOLD,40));
    		  g.drawString("Game Over", 300, 350);
    	  }
      }
    //���̼����¼�
	@Override
	public void keyPressed(KeyEvent a) {
		// TODO Auto-generated method stub
		int keyCode=a.getKeyCode();
		
		//�ո�ʼor��ͣ
		if(keyCode==KeyEvent.VK_SPACE) {
			isStart=!isStart;
			if(isFail) {
				init();
				isFail=false;
			}
			repaint();
		}
		//���������ƶ�
		if(keyCode==KeyEvent.VK_UP&&!position.equals("D")) {
			position="U";
		}
        if(keyCode==KeyEvent.VK_DOWN&&!position.equals("U")) {
        	position="D";
		}
        if(keyCode==KeyEvent.VK_RIGHT&&!position.equals("L")) {
        	position="R";
        }
        if(keyCode==KeyEvent.VK_LEFT&&!position.equals("R")) {
        	position="L";
        }
	}
	@Override
	public void keyReleased(KeyEvent e) {}
	@Override
	public void keyTyped(KeyEvent e) {}
	//���������¼�
	@Override
  	public void actionPerformed(ActionEvent e) {
  		// TODO Auto-generated method stub
		//С���ƶ�
  		if(isStart&&!isFail) {
  			for(int i=length-1;i>0;i--) {
  				snakeX[i]=snakeX[i-1];
  				snakeY[i]=snakeY[i-1];
  			}
  			if(position.equals("R")) {
  				snakeX[0]=snakeX[0]+25;
  			    if(snakeX[0]>950)snakeX[0]=25;}
  			else if(position.equals("L")){
  				snakeX[0]=snakeX[0]-25;
  			    if(snakeX[0]<25)snakeX[0]=950;}
  			else if(position.equals("U")){
  				snakeY[0]=snakeY[0]-25;
  			    if(snakeY[0]<75)snakeY[0]=650;}
  	  		else if(position.equals("D")){
  				snakeY[0]=snakeY[0]+25;
  			    if(snakeY[0]>650)snakeY[0]=75;}
  			//��ʳ��
  			if(foodX==snakeX[0]&&foodY==snakeY[0]) {
  				length++;
  				score+=10;
  				foodX=ram.nextInt(37)*25+25;
	            foodY=ram.nextInt(19)*25+75;
	            //�ж�ʳ�������Ƿ���С�������غ�
  				while(true) {
  				int i;
  				for(i=0;i<length;i++)
  					if(foodX==snakeX[i]&&foodY==snakeY[i]) {
  				       foodX=ram.nextInt(37)*25+25;
  		               foodY=ram.nextInt(19)*25+75;
  		               i=0;
  					}
  				if(i==length)
  				break;
  				}
  			}
  			//�ж�С���Ƿ������Լ�
  			for(int i=1;i<length-1;i++)
  				if(snakeX[i]==snakeX[0]&&snakeY[i]==snakeY[0]) {
  					isFail=true;
  					isStart=false;
  					break;
  				}
  			//�Ʒ�
  			level=score/100+1;
  			timer.setDelay(100-(level-1)*10);
  			repaint();
  		}
  		timer.start();
  	}
}
