package TurtleGraph;

/*거북이에게 방향을 가르쳐주고 리턴*/
public class TurtleDirection {

	Turtle turtle;

	public TurtleDirection() {
		turtle=new Turtle();		 
	}

	public Turtle turtleLeft(Turtle turtle){
		this.turtle=turtle;
		String head=turtle.getHead();
		switch(head){
		case "E":
			turtle.setHead("N");
			break;
		case "W":
			turtle.setHead("S");
			break;
		case "S":
			turtle.setHead("E");
			break;
		case "N":
			turtle.setHead("W");
			break;
		}
		//System.out.println("●");
		return turtle;		
	}
	public Turtle turtleRight(Turtle turtle){
		this.turtle=turtle;
		String head=turtle.getHead();
		switch(head){
		case "E":
			turtle.setHead("S");
			break;
		case "W":
			turtle.setHead("N");
			break;
		case "S":
			turtle.setHead("W");
			break;
		case "N":
			turtle.setHead("E");
			break;
		}
		//System.out.println("●");
		return turtle;		
	}
	public Turtle turtleGo(Turtle turtle){
		
		this.turtle=turtle;
		
		String head=turtle.getHead();
		int x=turtle.getX();
		int y=turtle.getY();

		switch(head){
		case "E":
			x+=10;
			turtle.setX(x);
			break;
		case "W":
			x-=10;
			turtle.setX(x);
			break;
		case "S":
			y-=10;
			turtle.setY(y);
			break;
		case "N":
			y+=10;
			turtle.setY(y);
			break;
		}
		return turtle;		
	}

}
