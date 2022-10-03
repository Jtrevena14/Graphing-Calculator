public class SciCalculator{
	public static void main(String [] args){
		                                
		Graph();                         //Graph equations using the methods below, the one called "Graph()", input the equation into the parenthesis after the "y=(board.length-1)-(EQUATION HERE)"
		                     	         //All functions: Graph(), ln(x), Log(y,x), LambertW(x), findSqrt(x), findCube(x), all can be used in combination with eachother, I.E. ln(LambertW(findSqrt(x)))
      System.out.println(ln(2));       //<---- Input any math problem into here, I.E. x = ln(3), x = 1.0986119, E^x, Graph() -> 0,0,1,0,0...
      
	}

	public static void Graph(){
		int counter=0;
		int board[][] = new int[20][20];
		double y = board.length-1, x = 0;
		while(counter<=40){
			if((int)y<0 || (int)x<0 || (int)y>board.length-1 || (int)x>board[0].length-1){
				break;
			}
			if(x>=0){
				board[(int)y][(int)x]=1;
			}
			x+=0.5;       //<--- Change accuracy here! 0.1 is more samples, 0.5 is less samples, some equations require more samples than others.
                                       //
			y=(board.length-1)-(ln(x)*2); //<----- If you want to graph an equation, change it here! I.E. (y =(board.length-1) - (findSqrt(x)))
                                       //
			counter++;
		}
      
      
      
		for(int i = 0; i<board.length;i++){
			for(int j = 0; j<board[0].length;j++){
				System.out.print(board[i][j] + " "); //Displaying the graph.
			}
			System.out.println();
		}
	}


	public static double ln(double num){
		return Log(10,num)/Log10e();   //<--- Natural Log Function
	}

	public static double Log(int base, double num){  //<--- Log Function, input (base, number)
		int dec = base;
		double ans = 0;
		int counter=0;
		if(num==base){
			return 1.0;
		}
		for(int i = 0;i<=9;i++){        //First Digit
			if(Math.pow(base,i)>=num){
				break;
			}
			ans=i;
		}
		for(int k = 0; k<=5;k++){   //<-- Change accuracy of decimal by increasing k limit, I.E "k<5" == five digits long, "k<10" == ten digits long
			counter=0;
			for(int i = 1; i<=9;i++){
				double check = (double)i/dec+ans;
				if(Math.pow(base,check)-num<0){    //if 10^0.4 - 3 < 0 (-0.488..) less than zero counter goes +1.
					counter++;
				}
			}
			ans+=(double)counter/dec;
			dec*=10;
		}
		return ans;
	}

	public static double LambertW(double num){
		double fin = 0;
		int dec = 10;
		for(int i = -10; i<num;i++){
			if(num>i*Math.pow(E(),i)){ //First Digit
				fin=i;
			}
		}
		for(int k = 0; k<=5;k++){    //<-- Change accuracy of decimal by increasing k limit, I.E "k<5" == five digits long, "k<10" == ten digits long
			int counter=0;
			for(int i=1;i<=9;i++){
				double check = ((double)i/dec)+fin;
				if(num>check*Math.pow(E(),check)){
					counter++;
				}
			}
			fin+=((double)counter/dec);
			dec*=10;
		}
		return fin;
	}

	public static double findSqrt(double a){
		double ans = 0;
		int dec=10;
		int counter=0;
		for(int i = 1; i<=9;i++){   //First Digit.
			if(i*i>=a){
				break;
			}
			ans=i;
		}
		for(int k = 0; k<6;k++){   //<-- Change accuracy of decimal by increasing k limit, I.E "k<6" == five digits long, "k<10" == ten digits long
			counter=0;
			for(int i = 1; i<=9;i++){
				double check = (double)i/dec+ans;
				if((check*check)<a){
					counter++;
				}
			}
			ans+=(double)counter/dec;
			dec*=10;
		}
		return ans;
	}

	public static double findCube(double a){
		double ans = 0;
		int dec=10;
		int counter=0;
		for(int i = 1; i<=9;i++){   //First Digit.
			if(i*i*i>=a){
				break;
			}
			ans=i;
		}
		for(int k = 0; k<5;k++){   //<-- Change accuracy of decimal by increasing k limit, I.E "k<5" == five digits long, "k<10" == ten digits long
			counter=0;
			for(int i = 1; i<=9;i++){
				double check = (double)i/dec+ans;
				if((check*check*check)<a){
					counter++;
				}
			}
			ans+=(double)counter/dec;
			dec*=10;
		}
		return ans;
	}

	public static double infSeries(int start, int end){
		double sum = 0;
		for(int n = start; n<=end;n++){
			sum += (double)1/(n*n);       //<---Change the Infinite Series equation HERE.
		}
		return sum;
	}

	public static String powRule(int coef, String var, int pow){
		String fin = "";
		if(pow==1 && coef==1){
			return "1";
		}
		fin+=Integer.toString(coef*pow);
		fin+=var;
		pow--;
		if(pow==1 || pow==0){
			return fin;
		}
		else{
			return fin+"^"+pow;
		}
	}

	public static double E(){
		return 2.71828182;
	}

	public static double Log10e(){
		return 0.4342944;
	}

	public static double piConstant(){
		return 3.14159265;
	}
}
