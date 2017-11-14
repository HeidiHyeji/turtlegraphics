package TurtleGraph;
/*거북이*/
public class Turtle {
	private String head;
	private int x;
	private int y;
	public Turtle() {
		// TODO Auto-generated constructor stub
	}
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void setTurtle(Turtle t){
		this.head=t.getHead();
		this.x=t.getX();
		this.y=t.getY();
	}

}
