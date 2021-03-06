import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
public class Practice3{
	public static void main(String args[]) throws IOException {
		String tmp, inst;
		BufferedInputStream in = null;
		BufferedOutputStream out = null;
		int c;
		long start=0,end=0;
		Scanner s = new Scanner(System.in);
		tmp = s.nextLine();

		inst = tmp.split(" ")[0].toUpperCase();
		if (inst.equals("COPY")) {
			try {
				in = new BufferedInputStream(new FileInputStream(tmp.split(" ")[1]), 10000);
				out = new BufferedOutputStream(new FileOutputStream(tmp.split(" ")[2]), 10000);
				start = System.currentTimeMillis();
				while ((c = in.read()) != -1) {
					out.write(c);
				}
				end = System.currentTimeMillis();
			} 
			catch (IOException e) {
				e.printStackTrace();
			} 
			finally {
				if (in != null)
				in.close();
				if (out != null)
					out.close();
				}
		}
		s.close();
		System.out.println("���۽ð�: "+(end-start)/1000+"."+(end-start)%1000+"(s)");
	}
}