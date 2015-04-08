package sk.spixy.bbc;

public class Utils
{
	private static final int[] ms_values = new int[] {
		250,
		500,
		750,
		1000,
		1500,
		2000,
		2500,
		3000,
		4000,
		5000,
		6000,
		7000,
		8000,
		9000,
		10000,
		11000,
		12000,
		13000,
		14000,
		15000,
		16000,
		17000,
		18000,
		19000,
		20000,
		0
	};

	public static int GetMS(int progress)
	{
		return ms_values[progress];
	}

	public static int GetProgress(int ms)
	{
		for (int i = 0; i < ms_values.length; i++)
		{
			if (ms_values[i] == ms)
				return i;
		}
	
		return 0;
	}
}
