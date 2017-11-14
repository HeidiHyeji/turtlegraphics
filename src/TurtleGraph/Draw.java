package TurtleGraph;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/*메인*/
/*거북이 흔적 받아서 좌표에 그리기*/
public class Draw extends JFrame {
	ArrayList<Turtle> turtleTrace;

	Draw() {

	}

	Draw(ArrayList<Turtle> turtleTrace) {
		this.turtleTrace = turtleTrace;
	}

	public void init() {
		setTitle("turtle 그리기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new MyPanel());
		setSize(1000, 1000);
		setVisible(true);
		
	}

	class MyPanel extends JPanel {

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.RED); // 빨간색을 선택한다.

			for (int i = 0; i < (turtleTrace.size() - 1); i++) {

				int x1 = turtleTrace.get(i).getX();
				int y1 = turtleTrace.get(i).getY();
				int x2 = turtleTrace.get(i + 1).getX();
				int y2 = turtleTrace.get(i + 1).getY();
				System.out.println(turtleTrace.get(i).getHead()+","+x1 + "," + y1 + "," + x2 + "," + y2);

				g.drawLine(x1, y1, x2, y2);

			}

		}
	}

	public static void main(String[] args) {
		Graphic graphic = new Graphic();
		graphic.init();
		ArrayList<Turtle> turtleList = new ArrayList<>();
		turtleList = graphic.start();
		Draw d = new Draw(turtleList);
		d.init();

	}

}
