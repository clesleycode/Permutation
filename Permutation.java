import java.util.ArrayList;
import java.awt.*;
import java.applet.*;
import java.net.URL;
import graph.*;

public class Permutation extends Applet {
	public void init() {
		int n = 100;
		double time = 0.0;
		ArrayList<Double> usedPerm = new ArrayList<Double>();
		ArrayList<Double> randPerm = new ArrayList<Double>();
		ArrayList<Double> swapPerm = new ArrayList<Double>();
		ArrayList<Integer> axis = new ArrayList<Integer>();
		while (n <= 7000000 && time <= 30.0) {
			TimeInterval t = new TimeInterval();
			t.startTiming();
			UsedPermutation.generate(n);
			t.endTiming();
			time = t.getElapsedTime();
			System.out.println(n + " " + time);
			usedPerm.add(time);
			axis.add(n);
			n *= 2;
			
		}
		n = 100;
		time = 0.0;
		while (n <= 7000000 && time <= 30.0) {
			TimeInterval t = new TimeInterval();
			t.startTiming();
			RandomPermutation.generate(n);
			t.endTiming();
			time = t.getElapsedTime();
			System.out.println(n + " " + time);
			randPerm.add(time);
			n *= 2;
		}
		n = 100; 
		time = 0.0;
		while (n <= 7000000 && time <= 30.0) {
			TimeInterval t = new TimeInterval();
			t.startTiming();
			SwapPermutation.generate(n);
			t.endTiming();
			time = t.getElapsedTime();
			System.out.println(n + " " + time);
			swapPerm.add(time);
			n *= 2;
		}
		
		double swapData[] = new double[swapPerm.size()];
		double randData[] = new double[randPerm.size()];
		double usedData[] = new double[usedPerm.size()];
		double axisData[] = new double[axis.size()];

		for (int i=swapPerm.size()-1; i >= 0; i--) {
			swapData[i] = swapPerm.get(i);
		}
		
		for (int i=randPerm.size()-1; i >= 0; i--) {
			randData[i] = randPerm.get(i);
		}
		for (int i=usedPerm.size()-1; i >= 0; i--) {
			usedData[i] = usedPerm.get(i);
		}
		for (int i=axis.size()-1; i >= 0; i--) {
			axisData[i] = axis.get(i);
		}
		
		double data1[] = new double[2*swapData.length];
		double data2[] = new double[2*randData.length];
		double data3[] = new double[2*usedData.length];
		
		int j = 0;
		for(int i = 0; i < swapData.length; i++) {
			data1[j] = axisData[i];
			data1[j+1] = swapData[i];
			j+=2;
		}
		
		j = 0;
		for(int i = 0; i < randData.length; i++) {
			data2[j] = axisData[i];
			data2[j+1] = randData[i];
			j+=2;
		}
		
		j = 0;
		for(int i = 0; i < usedData.length; i++) {
			data3[j] = axisData[i];
			data3[i+1] = usedData[i];
			j+=2;
		}

        System.out.println("Hi");
        

	     Graph2D graph = new Graph2D();
	     graph.drawzero = false;
	     graph.drawgrid = false;
	     graph.borderTop = 50;
	     
        setLayout(new BorderLayout());
        add("Center", graph);
	     
	     DataSet dataSet1 = graph.loadDataSet(data1, data1.length / 2);
	     dataSet1.linestyle = 0;
         dataSet1.marker = 1;
         dataSet1.markerscale = 1.5;
         dataSet1.markercolor = new Color(0,0,255);
         dataSet1.legend(200,100,"Swap");
         dataSet1.legendColor(Color.black);
         
         DataSet dataSet2 = graph.loadDataSet(data2, data2.length / 2);
         dataSet2.linecolor = new Color(0,255,0);
         dataSet2.marker = 2;
         dataSet2.markercolor = new Color(100,100,255);
         dataSet2.legend(200,120,"Random");
         dataSet2.legendColor(Color.black);
         
         DataSet dataSet3 = graph.loadDataSet(data3, data3.length / 2);
         dataSet3.linecolor = new Color(0,255,0);
         dataSet3.marker = 3;
         dataSet3.markercolor = new Color(100,100,255);
         dataSet3.legend(200,120,"Used");
         dataSet3.legendColor(Color.black);
     
         System.out.println("Hi");
         
         Axis xaxis = graph.createAxis(Axis.BOTTOM);
         xaxis.attachDataSet(dataSet1);
         xaxis.attachDataSet(dataSet2);
         xaxis.attachDataSet(dataSet3);
         xaxis.setTitleText("Xaxis");
         xaxis.setTitleFont(new Font("TimesRoman",Font.PLAIN,20));
         xaxis.setLabelFont(new Font("Helvetica",Font.PLAIN,15));
         
         Axis yaxis_left = graph.createAxis(Axis.LEFT);
         yaxis_left.attachDataSet(dataSet1);
         yaxis_left.attachDataSet(dataSet2);
         yaxis_left.attachDataSet(dataSet3);
         yaxis_left.setTitleText("y=6x10{^4}x^2");
         yaxis_left.setTitleFont(new Font("TimesRoman",Font.PLAIN,20));
         yaxis_left.setLabelFont(new Font("Helvetica",Font.PLAIN,15));
         yaxis_left.setTitleColor( new Color(0,0,255) );
         System.out.println("Hi");
	}
		
}
