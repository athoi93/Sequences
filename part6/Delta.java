public class Delta extends Seq {
	protected int num, initial, delta;

	Delta(int num, int initial, int delta) {
    		this.num = num;
		if(num == 0) 
		{
			this.initial = 0;
			this.delta = 0;
		}
		else {
	    		this.initial = initial;
			this.delta = delta;
		}
  	}

	public String toString() {
    return "< "+num+" : "+initial+" &"+delta+" >";
 }
	
	public int min()
	{
		if(num == 0)
			return 0;
		else 
			return (delta < 0) ? initial + delta * (num - 1) :
				initial;
	}

	public SeqIt createSeqIt() {
		return new DeltaIt(this);
	}
}
