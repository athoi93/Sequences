public class ConstantIt implements SeqIt
{
	protected int num, value;
	protected int count;

	public ConstantIt(Constant s)
	{
		this.num = s.num;
		if(this.num > 0) {
			this.value = s.value;
			count = 0;
		}
		else
			count = -1;
	}	
	
	public boolean hasNext()
	{
		if(count == -1)
			return false;
		if(count < num)
			return true;
		return false;
	}

	public int next()
	{
		if(this.hasNext()) {
			count++;
			return value;
		}
		else {
			System.err.println("ConstantIt called past end");
			System.exit(1);
		}
		return -1;
	}
}
