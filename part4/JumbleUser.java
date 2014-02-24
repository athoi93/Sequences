public class JumbleUser {

	public static int lengthLongestNDCSS1(Jumble j) {
		JumbleIt ji = new JumbleIt(j);
		
		//2 int variables;
		//max to store max count
		//count to iterate through the sequence
		
		int max=0, count=0;

		int n1, n2=0; //n1 to store the numbers from Jumble []

		//initialize n1 to initial value of Jumble array first
		//if hasNext() still, check n1 < ji.next();
		//increment count if true
		//set max = count if false, then count = 0, startover

		if(ji.hasNext()) {
			try {
				n1 = ji.next();
				count++;
			
				if(ji.hasNext()) {
					n2 = ji.next();
					if(n1 <= n2) 
						count++;
					else if(max <= count) {
				//n1 > n2 -> decreasing -> reset count
						max = count;
						count = 1;
					}
					else
						count = 1;
				}
				else 
					return count;
			}
			catch(UsingIteratorPastEndException e){}

		}


		while(ji.hasNext()) {
			n1 = n2;
			if(ji.hasNext()) {
				try{
					n2 = ji.next();
					if(n1 <= n2) {
						count++;
						if(max <= count)
							max = count;
					}
					else if(max <= count) {
						max = count;
						count = 1;
					}
					else
						count = 1;							}
				catch(UsingIteratorPastEndException e) {}
			}
			
		}

		return max;
	}


	public static int lengthLongestNDCSS2(Jumble j) {
		int max=0, count=0;
		int n1=0, n2=0;
		JumbleIt ji = new JumbleIt(j);

		try {
			n1 = ji.next();
			count++;
			n2 = ji.next();
			if(n1 <= n2)
				count++;
			else if(max <= count) {
				max = count;
				count = 1;
			}
			else
				count = 1;
		}
		catch(UsingIteratorPastEndException e){
			return count;
		}

		try {
			while(true) {
				n1 = n2;
				n2 = ji.next();
				if(n1 <= n2) {
					count++;
					if(max <= count)
						max = count;
				}
				else if(max <= count) {
					max = count;
					count = 1;
				}
				else
					count = 1;
			}
		}
		catch(UsingIteratorPastEndException e){}

		return max;		
	}

}
