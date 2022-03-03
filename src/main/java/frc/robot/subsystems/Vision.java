/*package frc.robot.subsystems;


//import java.beans.Visibility;
//import java.util.Set;

import edu.wpi.first.networktables.*;
// import edu.wpi.first.vision.VisionRunner;
// import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
// import org.usfirst.frc771.test2.commands.*;


public class Vision extends SubsystemBase{
    public	static	final	double	xRes	=	640;
	public	static	final	double	yRes	=	480;
	NetworkTableInstance x;
 	NetworkTable  table;
	NetworkTable GRIP;
	double dFactor = 0.9375;
	double half = 320;
    double a;
     public Vision(){
         x = NetworkTableInstance.getDefault();
 		System.out.println(x + " blah");
 		//String subtables = x.getSubTables();
 		GRIP = x.getTable("GRIP");
 		System.out.println(x);
 		System.out.println(GRIP + " blah");
 		table = GRIP.getSubTable("john");
 		System.out.println(table+ "blah2");
		
 		// System.out.println(GRIP.getSubTables());	
 		// System.out.println(table.getSubTables());
     }

     public double	Xpos()	{
		double	xPos;
		double x1;
		double x2;
		double[]	defaultValue	=	new	double[0];
		//	while(true){
		double[]	targetX	=	table.getEntry("centerX").getDoubleArray(defaultValue);
		double[]	areas	=	table.getEntry("area").getDoubleArray(defaultValue);
		double [] sortXA = new double[2];
		sortXA[0] = 1000;
		sortXA[1] = 1001;
		double sortX[] = new double[2];
		sortX[0] = 1002;
		sortX[1] = 1003;
		//System.out.println(targetX.length + " blahblah3");
		//System.out.println(targetX[0] + " blahblah3");
		//Timer.delay(0.2);
		if (targetX.length != areas.length){
			System.out.println("NetworkTable	udpated	in	the	middle	of	getRawTargetXpos;	returning	first	valid	entry");
		}
		// if (targetX.length == 0){
		// 	xPos = xRes/2;
		// }else{
		// 	x1 = targetX[0];
		// 	x2 = targetX[1];
		// 	xPos = (x2+x1)/2;
		// 	return xPos;
		// }
		// //////////////////////// int largestIdx = 0;
		// if	(targetX.length	>	1)		{
		// 	double	largest	=	0;
		// 	for	(int	c	=	0;	c	<	areas.length;	c++)	{
		// 		if	(areas[c]	>	largest){
		// 			largest	=	areas[c];
		// 			largestIdx	=	c;
		// 		}
		// 	}
		// }
		if (targetX.length == 0){
			xPos = xRes/2;
			return xPos;
		}else if (targetX.length == 1){
			xPos = targetX[0];
			if (xPos > 320){
				xPos = xPos - 15;
				return xPos;
			}else if (xPos < 320){
				xPos = xPos + 15;
				return xPos;
			}else{
				return xPos;
			}
		}else if (targetX.length == 2){
			x1 = targetX[0];
			x2 = targetX[1];
			xPos = ((x2+x1)/2);
			return xPos;
		}else{
			for (int i = 0; i < targetX.length; i++){
				a = Math.abs(half - targetX[i]);
				if (a < sortXA[0]){
					sortXA[1] = sortXA[0];
					sortXA[0] = a;
					sortX[0] = targetX[0];
				}else if(a < sortXA[1]){
					sortXA[1] = a;
					sortX[1] = targetX[i];
				}
			}
			xPos = (sortX[0] + sortX[1])/2;
			// x1 = targetX[0];
			// x2 = targetX[1];
			// xPos = ((x2+x1)/2);
			return xPos;
		}

	}

	public double pToA(){
		double a;
		double  adamSandler = Xpos();
		a = (adamSandler - half)*dFactor;
		return a;
	}

    @Override
         public void initDefaultCommand() {
        //   setDefaultCommand(new CheckYourself());
          // Set the default command for a subsystem here.
           // setDefaultCommand(new MySpecialCommand());
         }

    

 } 
*/