import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HungryCow {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		long n = Long.parseLong(st.nextToken());
		long t = Long.parseLong(st.nextToken());
		long ans = 0;
		st = new StringTokenizer(in.readLine());
		long d0 = Long.parseLong(st.nextToken());
		long c = Long.parseLong(st.nextToken());
		for(int i = 1; i < n; i++)
		{
			st = new StringTokenizer(in.readLine());
			long d1 = Long.parseLong(st.nextToken());
			if(c <= d1 - d0)
			{
				ans += c;
				c = 0;
			}
			else
			{
				c -= (d1 - d0);
				ans += d1 - d0;
			}
			c += Long.parseLong(st.nextToken());
			d0 = d1;
		}

		long d1 = t;
		if(c <= d1 - d0 + 1)
		{
			ans += c;
		}
		else
		{
			c -= (d1 - d0 + 1);
			ans += d1 - d0 + 1;
		}

		System.out.println(ans);
	}

}
