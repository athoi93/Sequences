public abstract class Plus extends Seq{
	public Plus() {} //blank fucking constructor

	public static Seq plus(Constant c1, Constant c2) {
		//create consant sequences for c1, c2
		//implement plus algorithm
		int n = (c1.num < c2.num) ? c1.num : c2.num;
		int v = c1.value + c2.value;

		return new Constant(n, v);
	}	

	public static Seq plus(Delta d1, Delta d2) {
		//create delta sequences for d1, d2
		//implement plus
	
		int v1=0, v2=0;
		int n = (d1.num < d2.num) ? d1.num : d2.num;
		int i = d1.initial + d2.initial;
		int d = d1.delta + d2.delta;

		return new Delta(n, i, d);
			
	}

	public static Seq plus(Jumble j1, Jumble j2) {
		//create jumble sequences for j1, j2
		//implement more fucking pluses
		
		int max = (j1.values.length < j2.values.length) ? 
				j1.values.length : j2.values.length;
		int [] v = new int [max];

		for(int i = 0; i < max; i++) 
			v[i] = j1.values[i] + j2.values[i];


		return new Jumble(v);
	}


}
