package FTC9889;

import java.awt.Color;

import usfirst.frc.team2168.robot.FalconLinePlot;

public class FTC2016_2017Field {
	
	public static void main(String[] args) {
		//Demonstrate FTC FieldMaker
		FalconLinePlot FTCfield = new FalconLinePlot(new double[][]{{0.0,0.0}});
		make(FTCfield);
	}
	
	//Generate Field
	public static void make(FalconLinePlot Plot){
		
		Plot.setBackground(Color.white);
		Plot.setYLabel("Y (feet)");
		Plot.setXLabel("X (feet)");
		Plot.setTitle("Top Down View of FTC Field (12ft x 12ft)");

		//FTC General field
		double FTCfieldWidth = 12.0;
		double[][] wall = new double[][] {{12,0},{12,12},{0,12},};
		double[][] FieldTiles = new double[][] {
			{1*(FTCfieldWidth/6), 0},{1*(FTCfieldWidth/6), FTCfieldWidth},
			{2*(FTCfieldWidth/6), FTCfieldWidth},{2*(FTCfieldWidth/6), 0},
			{3*(FTCfieldWidth/6), 0},{3*(FTCfieldWidth/6), FTCfieldWidth},{3*(FTCfieldWidth/6), 0},
			{4*(FTCfieldWidth/6), 0},{4*(FTCfieldWidth/6), FTCfieldWidth},{4*(FTCfieldWidth/6), 0},
			{5*(FTCfieldWidth/6), 0},{5*(FTCfieldWidth/6), FTCfieldWidth},{5*(FTCfieldWidth/6), 0},
			{FTCfieldWidth,0},{0,0},
			{0,1*(FTCfieldWidth/6)},{FTCfieldWidth, 1*(FTCfieldWidth/6)},{0,1*(FTCfieldWidth/6)},
			{0,2*(FTCfieldWidth/6)},{FTCfieldWidth, 2*(FTCfieldWidth/6)},{0,2*(FTCfieldWidth/6)},
			{0,3*(FTCfieldWidth/6)},{FTCfieldWidth, 3*(FTCfieldWidth/6)},{0,3*(FTCfieldWidth/6)},			
			{0,4*(FTCfieldWidth/6)},{FTCfieldWidth, 4*(FTCfieldWidth/6)},{0,4*(FTCfieldWidth/6)},
			{0,5*(FTCfieldWidth/6)},{FTCfieldWidth, 5*(FTCfieldWidth/6)},{0,5*(FTCfieldWidth/6)},
		};
		
		//Velocity Vortex specific code
		double[][] CenterLine = new double[][] {{0,0},{FTCfieldWidth, FTCfieldWidth}};
		double[][] redCorner = new double[][] {{0,9}, {3,12},};
		double[][] blueCorner = new double[][] {{9,0},{12,3},};
		double[][] centerGoal = new double[][] {{5,5},{7,5},{7,7},{5,7},{5,5},};
		double[][] Beacons = new double[][] {
			{12,5},{12,5.3},{11.9,5.3},{11.9,4.7},{12,4.7},
			{12,9},{12,9.3},{11.9,9.3},{11.9,8.7},{12,8.7},
			{FTCfieldWidth, FTCfieldWidth},
			{9,12},{9.3,12},{9.3,11.9},{8.7,11.9},{8.7,12},
			{5,12},{5.3,12},{5.3,11.9},{4.7,11.9},{4.7,12},
		};
		
		/*
		double[][] ball = new double[][] {
			
		};
		*/

		Plot.setXTic(0, FTCfieldWidth, 1);
		Plot.setYTic(0, FTCfieldWidth, 1);	
		Plot.addData(CenterLine, Color.black);
		Plot.addData(redCorner, Color.RED);
		Plot.addData(blueCorner, Color.blue);
		Plot.addData(centerGoal, Color.BLACK);
		Plot.addData(wall, Color.BLACK);
		Plot.addData(Beacons, Color.BLACK);
		Plot.addData(FieldTiles, Color.DARK_GRAY);
	}
}
