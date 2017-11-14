package TurtleGraph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
/*파일 한줄씩읽기*/
public class InputTokenizing {
	

	public InputTokenizing() {
		// TODO Auto-generated constructor stub
		
	}

	public ArrayList<String> readFile(){//파일 읽고 토크나이징 메소드		
		ArrayList<String> fileToken=new ArrayList<String>();
		try {
			StringTokenizer st1;
			String fileName = "turtleSample.txt";
			String line = "";
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			
			while ((line = br.readLine()) != null) {
			
				st1 = new StringTokenizer(line, "\t");
				fileToken.add(st1.nextToken());//한줄 씩 읽어서 리스트에 추가
			
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileToken;

	}

}
