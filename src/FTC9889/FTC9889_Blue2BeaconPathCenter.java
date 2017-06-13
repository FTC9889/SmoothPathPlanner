package FTC9889;

import java.awt.Color;

import usfirst.frc.team2168.robot.FalconLinePlot;
import usfirst.frc.team2168.robot.FalconPathPlanner;

public class FTC9889_Blue2BeaconPathCenter {

	public static void main(String[] args) {
		//TODO Add code generator for path
		
		long start = System.currentTimeMillis();
		
		FalconLinePlot FTC = new FalconLinePlot(new double[][]{{0.0,0.0}});
		
		FTC2016_2017Field.make(FTC);
		
		double FTCtotalTime = 6; //seconds
		double FTCtimeStep = 0.1;
		double FTCrobotTrackWidth = 1; //distance between left and right wheels, feet
		
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
		
		boolean speed = false;
		
		//display speeds
		if(speed){
			FalconLinePlot fig2 = new FalconLinePlot(FirstFTCPATH.smoothCenterVelocity,null,Color.blue);
			fig2.yGridOn();
			fig2.xGridOn();
			fig2.setYLabel("Velocity (ft/sec)");
			fig2.setXLabel("time (seconds)");
			fig2.setTitle("Velocity Profile for Left and Right Wheels \n Left = Cyan, Right = Magenta");
			fig2.addData(FirstFTCPATH.smoothRightVelocity, Color.magenta);
			fig2.addData(FirstFTCPATH.smoothLeftVelocity, Color.cyan);
		}
		
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
