package FTC9889;

import java.awt.Color;

import usfirst.frc.team2168.robot.FalconLinePlot;
import usfirst.frc.team2168.robot.FalconPathPlanner;

public class FTC9889_Blue2BeaconPathCorner {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		
		double FTCtotalTime = 5; //seconds
		double FTCtimeStep = 0.1; //period of control loop on Rio, seconds
		double FTCrobotTrackWidth = 1; //distance between left and right wheels, feet
		
		FalconLinePlot FTC = new FalconLinePlot(new double[][]{{0.0,0.0}});
		
		FTC2016_2017Field.make(FTC);
		
		double[][] FirstftcPath = new double[][]{
			{8,0.5},
			{8,3},
			{11,5},
			{11.2,5},
			{11.5,5},
		};
		
		double[][] SecondftcPath = new double[][]{
			{11.5,5},
			{9,5},
			{9,6},
			{9,8},
			{11,9},
			{11.6,9},
		};
		
		double[][] ThirdftcPath = new double[][]{
			{11.6,9},
			{11,9},
			{10.5,1.7},
		};
		
		final FalconPathPlanner FirstFTCPATH = new FalconPathPlanner(FirstftcPath);
		final FalconPathPlanner SecondFTCPATH = new FalconPathPlanner(SecondftcPath);
		final FalconPathPlanner ThirdFTCPATH = new FalconPathPlanner(ThirdftcPath);
		
		FirstFTCPATH.calculate(FTCtotalTime, FTCtimeStep, FTCrobotTrackWidth);
		SecondFTCPATH.calculate(FTCtotalTime, FTCtimeStep, FTCrobotTrackWidth);
		ThirdFTCPATH.calculate(FTCtotalTime, FTCtimeStep, FTCrobotTrackWidth);
		
		//waypoint path
		FTC.addData(FirstFTCPATH.nodeOnlyPath,Color.blue,Color.green);
		FTC.addData(SecondFTCPATH.nodeOnlyPath, Color.blue,Color.green);
		FTC.addData(ThirdFTCPATH.nodeOnlyPath,Color.blue,Color.green);

		//Path to First Beacon
		FTC.addData(FirstFTCPATH.smoothPath, Color.red, Color.blue);
		FTC.addData(FirstFTCPATH.leftPath, Color.magenta);
		FTC.addData(FirstFTCPATH.rightPath, Color.magenta);	
		
		//Path to Second Beacon
		FTC.addData(SecondFTCPATH.smoothPath, Color.red, Color.blue);
		FTC.addData(SecondFTCPATH.leftPath, Color.magenta);
		FTC.addData(SecondFTCPATH.rightPath, Color.magenta);	
		
		//Path to Cap Ball
		FTC.addData(ThirdFTCPATH.smoothPath, Color.red, Color.blue);
		FTC.addData(ThirdFTCPATH.leftPath, Color.magenta);
		FTC.addData(ThirdFTCPATH.rightPath, Color.magenta);	
		

	}

}
