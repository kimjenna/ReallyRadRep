import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class StampGrid {

	static char[][] grid = new char[1][1];
	static char[][] stamp1 = new char[1][1];
	static char[][] stamp2 = new char[1][1];
	static char[][] stamp3 = new char[1][1];
	static char[][] stamp4 = new char[1][1];

	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		for(int i = 0; i < t; i++)
		{
			in.readLine();
			int n = Integer.parseInt(in.readLine());
			grid = new char[n][n];
			for(int j = 0; j < n; j++)
			{
				grid[j] = in.readLine().toCharArray();
			}
			int k = Integer.parseInt(in.readLine());
			stamp1 = new char[k][k];
			stamp2 = new char[k][k];
			stamp3 = new char[k][k];
			stamp4 = new char[k][k];

			for(int j = 0; j < k; j++)
			{
				String[] str = in.readLine().split("");
				for(int m = 0; m < k; m++)
				{
					char ch = str[m].charAt(0);
					stamp1[j][m] = ch;
					stamp2[m][k - 1 - j] = ch;
					stamp3[k - 1 - j][k - 1 - m] = ch;
					stamp4[k - 1 - m][j] = ch;
				}
			}
			char g = '/';
			for(int j = 0; j <= n - k; j++)
			{
				for(int m = 0; m <= n - k; m++)
				{
					boolean b = true;
					ArrayList<Integer> a = new ArrayList<Integer>();
					for(int p = j; p < j + k; p++)
					{
						for(int q = m; q < m + k; q++)
						{
							int x = p - j;
							int y = q - m;
							if(grid[p][q] == '.')
							{
								if(stamp1[x][y] != '.')
								{
									b = false;
									break;
								}
							}
							else
							{
								if(stamp1[x][y] == '*' && grid[p][q] == '*')
								{
									grid[p][q] = g;
									a.add(p);
									a.add(q);
								}
							}
						}
						if(!b)
						{
							for(int r = 0; r + 1 < a.size(); r += 2)
							{
								if(grid[a.get(r)][a.get(r + 1)] == g)
								{
									grid[a.get(r)][a.get(r + 1)] = '*';
								}
							}
						}
					}
					g = (char) (g + 1);
					b = true;
					a = new ArrayList<Integer>();
					for(int p = j; p < j + k; p++)
					{
						for(int q = m; q < m + k; q++)
						{
							int x = p - j;
							int y = q - m;
							if(grid[p][q] == '.')
							{
								if(stamp2[x][y] != '.')
								{
									b = false;
									break;
								}
							}
							else
							{
								if(stamp2[x][y] == '*' && grid[p][q] == '*')
								{
									grid[p][q] = g;
									a.add(p);
									a.add(q);
								}
							}
						}
						if(!b)
						{
							for(int r = 0; r + 1 < a.size(); r += 2)
							{
								if(grid[a.get(r)][a.get(r + 1)] == g)
								{
									grid[a.get(r)][a.get(r + 1)] = '*';
								}
							}
							break;
						}
					}
					g = (char) (g + 1);
					b = true;
					a = new ArrayList<Integer>();
					for(int p = j; p < j + k; p++)
					{
						for(int q = m; q < m + k; q++)
						{
							int x = p - j;
							int y = q - m;
							if(grid[p][q] == '.')
							{
								if(stamp3[x][y] != '.')
								{
									b = false;
									break;
								}
							}
							else
							{
								if(stamp3[x][y] == '*' && grid[p][q] == '*')
								{
									grid[p][q] = g;
									a.add(p);
									a.add(q);
								}
							}
						}

						if(!b)
						{
							for(int r = 0; r + 1 < a.size(); r += 2)
							{
								if(grid[a.get(r)][a.get(r + 1)] == g)
								{
									grid[a.get(r)][a.get(r + 1)] = '*';
								}
							}
							break;
						}
					}
					g = (char) (g + 1);
					b = true;
					a = new ArrayList<Integer>();
					for(int p = j; p < j + k; p++)
					{
						for(int q = m; q < m + k; q++)
						{
							int x = p - j;
							int y = q - m;
							if(grid[p][q] == '.')
							{
								if(stamp4[x][y] != '.')
								{
									b = false;
									break;
								}
							}
							else
							{
								if(stamp4[x][y] == '*' && grid[p][q] == '*')
								{
									grid[p][q] = g;
									a.add(p);
									a.add(q);
								}
							}
						}

						if(!b)
						{
							for(int r = 0; r + 1 < a.size(); r += 2)
							{
								if(grid[a.get(r)][a.get(r + 1)] == g)
								{
									grid[a.get(r)][a.get(r + 1)] = '*';
								}
							}
							break;
						}
					}

					g = (char) (g + 1);
				}
			}
			boolean b = true;
			int j = 0;
			int ans = 0;
			while(j < n && b)
			{
				b = new String(grid[j]).indexOf('*') == -1;
				j++;
				if(b)
				{
					ans++;
				}
			}
			if(ans == n)
			{
				System.out.println("YES");
			}
			else
			{
				System.out.println("NO");
			}
			
		}
	}
	

}