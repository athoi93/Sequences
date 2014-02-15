public class Jumble extends Seq{
	protected int [] values;

  	Jumble(int [] v) {
		this.values = new int [v.length];
    		System.arraycopy(v, 0, this.values, 0, v.length);
  	}

	public String toString() {
		String str = new String();
		if(values.length == 0)
			return "{ 0 : }";
		else {
			for(int i = 0; i < values.length; i++) {
				str += values[i];	
				str += " ";
			}
			return "{ "+values.length+" : "+str+"}";
		}
	}
}
