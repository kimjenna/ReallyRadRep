import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class WatchingMooloo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		long n = Long.parseLong(st.nextToken());
		long k = Long.parseLong(st.nextToken());
		st = new StringTokenizer(in.readLine());
		long n2 = Long.parseLong(st.nextToken());
		long ans = 0;
		long consec = 0;
		for(int i = 1; i < n; i++)
		{
			long t = Long.parseLong(st.nextToken());
			if(t - n2 < k + 1)
			{
				//if distance between consecutives is less than k + 1, keep going
				consec += t - n2;
			}
			else
			{
				//make break in consecutives
				if(consec > 0)
				{
					ans += consec + 1 + k;
				}
				else
				{
					ans += k + 1;
				}
				consec = 0;
			}
			n2 = t;
		}
		if(consec > 0)
		{
			ans += consec + 1 + k;
		}
		else
		{
			ans += k + 1;
		}
		System.out.println(ans);
	}

}
