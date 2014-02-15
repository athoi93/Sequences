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


		while(ji.hasNext()) {
			n1 = n2;
			if(ji.hasNext()) {
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

		return max;
	}

}
