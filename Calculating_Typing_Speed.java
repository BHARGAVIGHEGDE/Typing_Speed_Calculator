    import java.time.LocalTime;                         //displays current time
    import java.util.Random;                            //to import random number
	import java.util.Scanner;                           //it is used to obtain input
	import java.util.concurrent.TimeUnit;               //TimeUnit is useful to know how a given time should be interpreted that is which time unit should be considered.
	
	
	
	public class Calculating_Typing_Speed               //class name defined publically
	{
		

		static String[] sentences = {"You do not find the happy life. You make it" , "The most wasted of days is one without laughter." , 
				                    "Make each day your masterpiece." , "Impossible is for the unwilling" , 
				                    "I invented a new word!" , "Knock! Knock!Who is there?" ,
				                    "They call me idol,They call me artist" , "How come the barber won the race?" , 
				                    "Get ready for some serious giggles"};		
		
		
		
		
		static String example,inSentence;                   //declaration of variables of type string,double and int
		static double seconds;
		static int wordnum,wordspermin,charpermin;
		
		
		
		
		
		//calculating number of words
		static void wordcount(int Chars)
		{
			int space=0;
	        for(int i=0;i<Chars;i++)
	        {
	        	if(example.charAt(i)==' ')
	        		space++;
	        }
	        wordnum=space+1;	
		}
		
		
		
		
		
		//COUNTDOWN
		static void countdown(int n) throws InterruptedException    
		{
		    //we are letting know to the program that this function may throw an error InterruptedException if there is delay in time
	        
            TimeUnit.SECONDS.sleep(1);                             //dalay of 1 second
	        System.out.println("Start typing in:");                //printing statement
		    TimeUnit.SECONDS.sleep(1);
		        while(n>=1)                                        //condition loop
		                 {
		                	System.out.println(n);
		                	TimeUnit.SECONDS.sleep(1);
		                   	n--;
		                 }
		    System.out.println("Go!!");
		    TimeUnit.SECONDS.sleep(1);
		   
		}
		
		
		
		
		
		//Calculating the ACCURACY of typed word
		static int accuracy(String auto,String user,int wnum)	        
		{
			 auto=auto+" ";
			 user=user+" ";
			
			 int l=0,m=0,correct=0,per;
			 int anum=auto.length();
			 int unum=user.length();
			  while(l<anum&&m<unum)
		         {	
		        		while((auto.charAt(l)==user.charAt(m))&&(auto.charAt(l)!=' '))
		        		{
		        			l++;
		        			m++;
		        		}
		        		if((auto.charAt(l)==' ')&&(user.charAt(m)==' '))
		        			correct++;
		      	
		        		while(auto.charAt(l)!=' ')                //finding the next word in auto generated string
		        			l++;
		        		
		        		while(user.charAt(m)!=' ')                //finding the next word in user entered string
		        			m++;
		        		
		        		l++; m++;                                 //going to the next word
		        		
		          }
			 per=(int) (((double)correct/wnum)*100);              //calculating accuracy percentage 
			 return per;
		}
		
		
		
		
		
		
		//Display all the content(required output)
		static void disp() throws InterruptedException
		{
			
	        int Apercentage;                                        // for accuracy
	        Apercentage=accuracy(example,inSentence,wordnum);
	       
	        System.out.println("----------------------------------");
	        TimeUnit.SECONDS.sleep(1);                                           //delay of 1 second
	        System.out.println("Your Accurcy is : "+Apercentage+"%");            //printing accuracy
	        TimeUnit.SECONDS.sleep(1);                                           //delay of 1 second
	        System.out.println("Time Taken : "+seconds+" sec");                  //printing total time taken to type
	        TimeUnit.SECONDS.sleep(1);                                           //delay of 1 second
		    System.out.println("You can write "+wordspermin+" wpm (WORDS/min)"); //printing  wpm(words per minute)
		    TimeUnit.SECONDS.sleep(1);                                           //delay of 1 second
		    System.out.println("Also, you can write "+charpermin+" cpm (CHARACTERS/min)");//printing cpm(characters per minute)
		    TimeUnit.SECONDS.sleep(1);                                           //delay of 1 second
		    System.out.println("----------------------------------");
		    TimeUnit.SECONDS.sleep(1);                                           //delay of 1 second
		    if(Apercentage>=75)                                                 
		    {
		    if(wordspermin<=30)
		    	System.out.println("NEEDS IMPROVEMENT!!");
		    else                                                                //calculating accuracy performance
		    	System.out.println("WELL DONE!!");
		    }
		    else 
		    	System.out.println("TYPE CORRECTLY!!");
		}
		
		
		
		
		
	
		
		//MAIN function (Execution starts here)
		
		public static void main(String[] args) throws InterruptedException 
		{
			//we are letting know to the program that this function may throw an error InterruptedException if there is delay in time
			Random ran = new Random();                          
			example=sentences[ran.nextInt(8)];                   //generating random strings between 1 to 8
		
			
			int anumChars = example.length();                    // getting the number of characters that auto generated
			
			System.out.println("Read out the sentence given below: ");
			System.out.println(example);                         //it will display the random strings generated
			TimeUnit.SECONDS.sleep(3);                           //delay of 3 seconds
			System.out.println("--------------------------------------------------------");
			TimeUnit.SECONDS.sleep(1);                           //delay of 1 second

			
			
			countdown(3);                                         //Calling Countdown
			
			
			  
			double start = LocalTime.now().toNanoOfDay();         //start time in nanosecond
			
			Scanner sc= new Scanner(System.in);
			inSentence  = sc.nextLine();                          //taking user input
			sc.close();
			
			double end = LocalTime.now().toNanoOfDay();           //end time in nanosecond
			  
			double calculatedTime = end - start;                  //difference between end and start time 
			seconds = calculatedTime / 1000000000.0;              //converting the calculated time to seconds 
			
	        int unumChars = inSentence.length();                  //getting the number of characters that user entered 
   
	        
	      
	          
	        
	        wordcount(anumChars);                                 //Calling Wordcount
	       
	       
	        wordspermin = (int) (((double)wordnum/seconds)*60);   //Calculating words per min
	        
	        
	        charpermin=(int) (((double)unumChars/seconds)*60);    //Calculating characters per min
	        
	    
	        disp();	        	                                  //Calling Display
		}

	}
    

