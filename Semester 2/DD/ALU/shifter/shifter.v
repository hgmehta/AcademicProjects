`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date:    12:11:41 04/14/2015 
// Design Name: 
// Module Name:    shifter 
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
module shifter(B, op, sa, cout, out, outRev);
input [3:0]	B, op, sa;
input cout;
output out, outRev;
reg [3:0] rev;
FLIP flip1(B, rev);
endmodule
	if()

module FLIP(in, out);
input [3:0] in;
output [3:0] out;
reg [1:0] i;
always@(in)
for(i=0; i<3 ; i=i+1)
	begin
		out[i] = in[3-i];
	end
endmodule

module LEFTSHIFT(in, sa, cout, out);
input [3:0] in, sa, cout;
output [3:0] out;
reg [1:0] i;
always@(in, sa, cout)
	begin 
		for(i = 0 ; i < [1:0]sa; i = i+1)
			begin
				out[i] = in[[1:0]sa+i];
			end
		
	end


endmodule
