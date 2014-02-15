public class DeltaIt implements SeqIt
{
	protected int num;
	protected int [] values;
	protected int count;

	public DeltaIt(Delta d) {
		this.num = d.num;
		if(this.num > 0) {
			this.values = new int[this.num];
			this.values[0] = d.initial;
			for(int i = 1; i < this.num; i++) 
				values[i] = values[i-1] + d.delta;
			count = 0;
		}
		
	}

	public boolean hasNext()
	{
		if(num == 0)
			return false;
		if(count < num)
			return true;
		return false;
	}
	
	public int next() throws UsingIteratorPastEndException
	{
		if(this.hasNext())  {
			count++;
			return values[count-1];
		}
		else
			throw new UsingIteratorPastEndException();
	}	
}
