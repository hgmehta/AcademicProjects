`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date:    09:53:17 04/14/2015 
// Design Name: 
// Module Name:    alu 
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
module alu(A,B,OP,Sum,Cout,Of);
input [3:0] A,B;
input OP;
output Of;
output [3:0] Sum;
output Cout;
reg [3:0] temp;
wire tempCarry;
always @(A,B,OP)
begin
	if(OP)
		begin
			temp <= ~B;
		end
	else
		begin
			temp <= B;
		end
end

fulladder adder1 (A[0],temp[0],OP, tempCarry, Sum[0]);		
fulladder adder2 (A[1],temp[1],tempCarry, tempCarry, Sum[1]);		
fulladder adder3 (A[2],temp[2],tempCarry, tempCarry, Sum[2]);		
fulladder adder4 (A[3],temp[3],tempCarry, Cout, Sum[3]);		
XOR xor1 (tempCarry, Cout, Of); 
endmodule
module fulladder(A,B,Cin,Cout,Sum);
input A,B,Cin;
output reg Cout,Sum;
always @(A,B,Cin)
begin
	{Cout,Sum} = A+B+Cin;
end
endmodule
module XOR(A,B,Out);
input A,B;
output reg Out;
always @ (A,B)
	begin
		Out = A^B;
	end
endmodule
