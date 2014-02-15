public class JumbleIt implements SeqIt
{
	protected int [] values;
	protected int count;

        public JumbleIt(Jumble j) {
		if(j.values.length > 0) {
			count = j.values.length;
	        	this.values = new int [count];
			System.arraycopy(j.values, 0, this.values, 0, count);
			count = 0;
		}
		else
			count = -1;
		
        }

        public boolean hasNext()
        {
		if(count == -1)
			return false;
		else if(count < values.length)
			return true;
		return false;
        }

        public int next()
        {
		if(this.hasNext()) {
			count++;
			return values[count-1];
		}
		else {
			System.err.println("JumbleIt called past end");
			System.exit(1);
		}
		return -1;
        }	
}
