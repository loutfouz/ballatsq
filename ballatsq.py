'''
Copyright (c) 2009
Shumon Loutfouz Zaman
Department of Computer Science and Engineering
York University, Canada
All rights reserved.

Redistribution and use in source and binary forms, with or without 
modification, are permitted provided that the following conditions are 
met:

    * Redistributions of source code must retain the above copyright 
      notice, this list of conditions and the following disclaimer.
    * Redistributions in binary form must reproduce the above copyright 
      notice, this list of conditions and the following disclaimer in 
      the documentation and/or other materials provided with the distribution
      
THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" 
AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE 
IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE 
ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE 
LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR 
CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF 
SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS 
INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN 
CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
POSSIBILITY OF SUCH DAMAGE.
'''
def transposed(lists):
   if not lists: return []
   return map(lambda *row: list(row), *lists)
   
def ballatsq(size):
	first_row = [1,2]
	j = size
	for i in range(size,2,-2):
		first_row.append(j)
		j-=1
	j = 3
	for i in range(3,size,2):
		first_row.insert(i,j)
		j+=1
	#initial values were generated, 
	#now let's fill these rows using circular shift
	ballatsq = []
	for i in range(0,size):
		ballatsq.append([first_row[i]])
		for j in range(0,size-1):
			next_val = 1+(ballatsq[i][j])%(size) 
			ballatsq[i].append(next_val)

	return transposed(ballatsq)

def main():
	import sys
	length = len (sys.argv)
	if length == 2:
		M = ballatsq(int(sys.argv[1]))
		for i in M: print i
	else:
		print "usage: ballatsq.py n\nn=size of balanced latin square (must be even)"

if __name__ == '__main__': main()