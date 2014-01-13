/***
 * Copyright (c) 2010
 * Shumon Loutfouz Zaman
 * Department of Computer Science and Engineering
 * York University, Canada
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:

    * Redistributions of source code must retain the above copyright 
      notice, this list of conditions and the following disclaimer.
    * Redistributions in binary form must reproduce the above copyright 
      notice, this list of conditions and the following disclaimer in 
      the documentation and/or other materials provided with the distribution
      
* THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
* AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
* IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
* ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
* LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
* CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
* SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
* INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
* CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
* ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
* POSSIBILITY OF SUCH DAMAGE.***/
class Ballatsq 
	{
		public static void calcBallatsq(int size)
		{
			int [][] ballatsq = new int[size][size];
			
			ballatsq[0][0] = 1;
			ballatsq[0][1] = 2;
			
			for (int i = 2, j = size; i <size; i+=2,j--)
			{
				ballatsq[0][i] = j;
			}
			
			for (int i = 3, j = 3; i < size; i+=2,j++)
			{
				ballatsq[0][i] = j;
			}
			
			//Initial values are generated, now we need to create the remaining rows using circular shift			
		
			for (int col = 0; col < size; col++)
			{
				for (int row = 1; row < size; row++)
				{
					ballatsq[row][col] = 1 + (ballatsq[row-1][col]) % size; 
				}
			}
			
			//print
			for (int i = 0; i < size; i++)
			{
				for (int j = 0; j < size; j++)
				{
					System.out.print(ballatsq[i][j]+((j==size-1)?"":","));
				}
				System.out.println();
			}
			System.out.println();
		}
		public static void main(String[] args)
		{
			if (args!= null && args.length == 1)
				calcBallatsq(Integer.parseInt(args[0]));
			else
				System.out.println("Usage: Ballatsq [size]\n where size is 2,4,5,6,etc...");
		}
	}	
	