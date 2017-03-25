`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date:    11:08:10 04/14/2015 
// Design Name: 
// Module Name:    logic 
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
module logic(A,B,Xor,And,Or,Nor);
	input [3:0] A,B;
	output [3:0] Xor,And,Or,Nor; 
	XOR xor1(A,B,Xor);
	AND and1(A,B,And);
	NOR nor1(A,B,Nor);
	OR or1(A,B,Or);
	endmodule
module XOR(A,B,Out);
	input [3:0] A,B;
	output reg [3:0] Out;
	always @ (A,B)
	begin
	Out = A^B;
	end
endmodule
module AND(A,B,Out);
	input [3:0] A,B;
	output reg [3:0] Out;
	always @ (A,B)
	begin
	Out = A&B;
	end
endmodule
module OR(A,B,Out);
	input [3:0] A,B;
	output reg [3:0] Out;
	always @ (A,B)
	begin
	Out = A|B;
	end
endmodule
module NOR(A,B,Out);
	input [3:0] A,B;
	output reg [3:0] Out;
	always @ (A,B)
	begin
	Out = ~(A|B);
	end
endmodule
