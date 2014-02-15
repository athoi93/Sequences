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

		if(d == 0)
			return new Constant(n, i);
		else
			return new Delta(n, i, d);
			
	}

	public static Seq plus(Jumble j1, Jumble j2) {
		//create jumble sequences for j1, j2
		//implement more fucking pluses
		
		int max = (j1.values.length < j2.values.length) ? 
				j1.values.length : j2.values.length;
		int d = -1;
		boolean flag = true;
		/*
		 *	Max = 	0 -> constant
		 *		1 -> constant
		 *		2+ -> check delta/constant	
		 */
		if(max == 0) 
			return new Constant(0, 0);
		else if(max == 1)
			return new Constant(1, j1.values[0] + j2.values[0]);
		else
			d = (j1.values[1] + j2.values[1]) - 
				(j1.values[0] + j2.values[0]);

		int [] v = new int [max];

		for(int i = 0; i < max; i++) {
			v[i] = j1.values[i] + j2.values[i];
			if(i > 0) {
				int check = v[i] - v[i-1];
				if(check != d)
					flag = false;
			}
		}
		if(flag && d == 0)
			return new Constant(max, v[0]);
		else if(flag && d != 0)
			return new Delta(max, v[0], d);
		else
			return new Jumble(v);
	}

	public static Seq plus(Constant c, Delta d) {
		int n = (c.num < d.num) ? c.num : d.num;
		int i = d.initial + c.value;

		if(n == 0)
			return new Constant(0,0);
		else if(n == 1)
			return new Constant(1, i);

		return new Delta(n, i, d.delta);
	}

	public static Seq plus(Delta d, Constant c) {
		return plus(c, d);
	}

	public static Seq plus(Constant c, Jumble j) {
		int max = (c.num < j.values.length) ? c.num : j.values.length;
		int [] arr = new int [max];
		int d = -1;
		boolean flag = true;

		if(max == 0)
			return new Constant(0,0);
		else if(max == 1)
			return new Constant(1, c.value + j.values[0]);
		else
			d = j.values[1] - j.values[0];


		for(int i = 0; i < max; i++) {
			arr[i] = c.value + j.values[i];
			if(i > 0 && (arr[i] - arr[i-1]) != d)
				flag = false;
		}

		if(flag && d == 0)
			return new Constant(max, arr[0]);
		else if(flag && d != 0)
			return new Delta(max, arr[0], d);
		else
			return new Jumble(arr);
	}

	public static Seq plus(Jumble j, Constant c) {
		return plus(c, j);
	}

	public static Seq plus(Delta d, Jumble j) {
		int max = (d.num < j.values.length) ? d.num : j.values.length;
		int [] arr = new int [max];
		int c = -1; //c is the new "delta"
		boolean flag = true;

		if(max == 0)
			return new Constant(0,0);
		else if(max == 1)
			return new Constant(1, d.initial + j.values[0]);
		else
			c = (j.values[1] + d.initial + d.delta) -
				(j.values[0] + d.initial);

		for(int i = 0; i < max; i++) {
			arr[i] = d.initial + (i * d.delta) + j.values[i];
			if(i > 0 && (arr[i] - arr[i-1]) != c)
				flag = false;
		}

		if(flag && c == 0)
			return new Constant(max, arr[0]);
		else if(flag && c != 0)
			return new Delta(max, arr[0], c);
		else
			return new Jumble(arr);
	}

	public static Seq plus(Jumble j, Delta d) {
		return plus(d, j);
	}
}
