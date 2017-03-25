`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date:    11:27:00 04/14/2015 
// Design Name: 
// Module Name:    comparator 
// Project Name: 
// Target Devices: 
// Tool versions: 
// Description: 
//
// Dependencies: 
//
// Revision: 
// Revision 0.01 - File Created
// Additional Comments: 
//
//////////////////////////////////////////////////////////////////////////////////
module comparator(A, B, carry, Xor, less, greater, eq, neq);
input [3:0] A,B,Xor;
input carry;
output greater, eq;
output reg less,neq;
Nor4 nor2 (Xor[0], Xor[1], Xor[2], Xor[3], eq);
always@(A,B,Xor)
	begin
		neq = ~eq;
		if(A[3]>B[3])
			begin
				less = 1'b1;
			end
		else if(A[3]<B[3])
			begin
				less = 1'b0;
			end
		else
			begin
					if(~carry)
						begin
							less = 1;
						end
					else
						begin
							less = 0;
						end
			end
	end
NOR nor1 (less, eq, greater);
	
endmodule


module Nor4(A0, A1, A2, A3, out);
input A0, A1, A2, A3;
output reg out;
always@(A0, A1, A2, A3)
	begin
		out = ~(A0 | A1 | A2 | A3);
	end
endmodule

module NOR(A,B,out);
input A,B;
output reg out;
always@(A,B)
	begin
		out = ~(A|B);
	end
endmodule	