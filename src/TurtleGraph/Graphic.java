package TurtleGraph;

import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JFrame;

/*파일을 읽어서 토크나이징 한 후 ArrayList에 명령어 저장*/
/*저장한 명령어에 따라 명령 실행*/
/*명령 실행 후 거북이 흔적 받아서 반환*/
public class Graphic{
	int repeatNum1;
	int repeatNum2;
	StringTokenizer st1;
	int endLine = 0;//읽은 라인 수
	Turtle turtle;//거북이
	TurtleDirection turtleDirection;//거북이 길가르쳐주기
	ArrayList<Turtle> turtleTrace;//거북이 흔적 저장
	public Graphic() {
		// TODO Auto-generated constructor stub
		turtle=new Turtle();
		turtleTrace=new ArrayList<Turtle>();
		turtleDirection=new TurtleDirection();
	}
	public void init(){
		turtle.setHead("N");//초기화
		turtle.setX(400);
		turtle.setY(400);
	}

	/*program,repeat,end 처리*/
	public ArrayList<Turtle> start() {
		String token = null;
		InputTokenizing it = new InputTokenizing();
		ArrayList<String> fileToken=new ArrayList<>();
		fileToken = it.readFile();// fileToken에 파일토큰을 저장한다.
		

		token = fileToken.get(0);// 프로그램 시작
		if (token.equals("program")) {
			token = fileToken.get(1);
			turtleTrace.add(turtle);
			
			if (token.contains("repeat")) {// 1번줄이 repeat일때, 반복문에 들어감
				st1 = new StringTokenizer(token, " ");
				st1.nextToken();// repeat
				repeatNum1 = Integer.parseInt(st1.nextToken());// 반복 횟수 저장
				
				for (int i = 0; i < repeatNum1; i++) {
					token = fileToken.get(2);
					if (token.contains("repeat")) {
						st1 = new StringTokenizer(token, " ");
						st1.nextToken();// repeat
						repeatNum2 = Integer.parseInt(st1.nextToken());// 반복 횟수 저장
						for (int j = 0; j < repeatNum2; j++) {
							turtleAlgo(3,fileToken);//3번째 줄 부터go,right,left,
						}
						turtleAlgo(++endLine,fileToken);
					}else{
						turtleAlgo(2,fileToken);//2번째 줄부터 go,right,left,
					}
				}
				turtleAlgo(++endLine,fileToken);
				
			} else {// 1번줄이 repeat아닐때
				turtleAlgo(1,fileToken);//1번째줄 부터 go,right,left,
			}

		}
		
		return turtleTrace;
	}

	/*go,left,right 처리*/
	public void turtleAlgo(int listStartIndex,ArrayList<String> fileToken) {//fileToken.get(start)부터뽑아서 저장

		Turtle t=new Turtle();
		t.setTurtle(turtle);
		if(fileToken.get(listStartIndex).equals("end")){endLine= listStartIndex;return;}
		
		//스위치  fileToken.get(start)가 left인지, right인지 go인지
		if(fileToken.get(listStartIndex).equals("right")){
			t.setTurtle(turtleDirection.turtleRight(turtle));//현재 거북이 주고 다음 위치 받기
		}
		else if(fileToken.get(listStartIndex).equals("left")){
			t.setTurtle(turtleDirection.turtleLeft(turtle));//현재 거북이 주고 다음 위치 받기
		}
		else if(fileToken.get(listStartIndex).equals("go")){
			t.setTurtle(turtleDirection.turtleGo(turtle));//현재 거북이 주고 다음 위치 받기
			turtleTrace.add(t);//go일 때만 거북이 흔적 저장
			turtle.setTurtle(t);
		}
		System.out.println(fileToken.get(listStartIndex));
		turtleAlgo(++listStartIndex,fileToken);
		
	}
	public ArrayList<Turtle> getTurtleTrace() {
		return turtleTrace;
	}
	
}
