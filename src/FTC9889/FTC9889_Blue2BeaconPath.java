package FTC9889;

import java.awt.Color;

import usfirst.frc.team2168.robot.FalconLinePlot;
import usfirst.frc.team2168.robot.FalconPathPlanner;

public class FTC9889_Blue2BeaconPath {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		
		double FTCtotalTime = 5; //seconds
		double FTCtimeStep = 0.1; //period of control loop on Rio, seconds
		double FTCrobotTrackWidth = 1; //distance between left and right wheels, feet
		
		FalconLinePlot FTC = new FalconLinePlot(new double[][]{{0.0,0.0}});
		FTC.yGridOn();
		FTC.xGridOn();
		FTC.setYLabel("Y (feet)");
		FTC.setXLabel("X (feet)");
		FTC.setTitle("Top Down View of FTC Field (12ft x 12ft) \n shows global position of robot path, along with left and right wheel trajectories");

		//force graph to show 1/2 field dimensions of 24.8ft x 27 feet
		double FTCfieldWidth = 12.0;
		FTC.setXTic(0, FTCfieldWidth, 1);
		FTC.setYTic(0, FTCfieldWidth, 1);
		
		double[][] CenterLine = new double[][] {{0,0},{FTCfieldWidth, FTCfieldWidth}};
		double[][] redCorner = new double[][] {{0,10}, {2,12},};
		double[][] blueCorner = new double[][] {{10,0},{12,2},};
		double[][] centerGoal = new double[][] {{5,5},{7,5},{7,7},{5,7},{5,5},};
		
		FTC.addData(CenterLine, Color.black);

		FTC.addData(redCorner, Color.RED);
		FTC.addData(blueCorner, Color.blue);
		FTC.addData(centerGoal, Color.BLACK);
		
		double[][] FirstftcPath = new double[][]{
			{9,0.5},
			{9,3},
			{11,4},
			{11.2,4},
			{11.5,4},
		};
		
		double[][] SecondftcPath = new double[][]{
			{11.5,4},
			{9,4},
			{9,6},
			{9,8},
			{11,10},
			{11.5,10},
		};
		
		double[][] ThirdftcPath = new double[][]{
			{11.5,10},
			{11,10},
			{7,5.5},
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
		
		FalconLinePlot fig2 = new FalconLinePlot(FirstFTCPATH.smoothCenterVelocity,null,Color.blue);
		fig2.yGridOn();
		fig2.xGridOn();
		fig2.setYLabel("Velocity (ft/sec)");
		fig2.setXLabel("time (seconds)");
		fig2.setTitle("Velocity Profile for Left and Right Wheels \n Left = Cyan, Right = Magenta");
		fig2.addData(FirstFTCPATH.smoothRightVelocity, Color.magenta);
		fig2.addData(FirstFTCPATH.smoothLeftVelocity, Color.cyan);
		
		FalconPathPlanner.print(FirstFTCPATH.smoothPath);

		//example on printing useful path information
		System.out.print("\n\n----------------------------\n");
		System.out.print("Blue 2 Beacon Cap Ball Points");
		System.out.print("\nNumber of Points for First Path: " + FirstFTCPATH.numFinalPoints);
		System.out.print("\nNumber of Points for Second Path: " + SecondFTCPATH.numFinalPoints);
		System.out.print("\nNumber of Points for Third: " + ThirdFTCPATH.numFinalPoints);
		System.out.print("\nTime to generate in ms: " + (System.currentTimeMillis()-start));
		System.out.print("\n----------------------------\n");
	}

}
