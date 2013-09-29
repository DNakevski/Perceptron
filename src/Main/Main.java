package Main;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		//Se zemaat site podatoci za treniranje na perceptronot
		List<DataSet> dataList = GenerateTrainingData();
		
		//Collections.shuffle(dataList);
		//Se kreira nov perceptron so rata na ucenje 0.15, pragova vrednos od 0.8
		//i treniracko mnozestcvo smesteno vo listata dataList
		Perceptron perceptron = new Perceptron(0.15, 0.8, dataList);
		
		//Se povikuva funkcijata za treniranje na perceptronot
		System.out.println("Treniranje...");
		System.out.println("");
		perceptron.Train();
		
		//Se zemaat site podatoci za treniranje na perceptronot
		//i istite mu se dodeluvaat
		List<DataSet> testingList = GenerateTestingData();
		perceptron.SetTestingData(testingList);
		
		System.out.println("");
		System.out.println("Testiranje...");
		System.out.println("==================================================");
		
		perceptron.Test();
		
		System.out.println("==================================================");
	}
	
	//Gi generira site Treniracki podatoci i gi vrakja vo vid na lista
	public static List<DataSet> GenerateTrainingData()
	{
		List<DataSet> trainingData = new ArrayList<DataSet>();
		
		trainingData.add(new DataSet(1,1,1,2,1));
		trainingData.add(new DataSet(1,0,0,1,0));
		trainingData.add(new DataSet(0,1,1,2,0));
		trainingData.add(new DataSet(1,1,0,2,1));
		trainingData.add(new DataSet(1,0,0,2,0));
		trainingData.add(new DataSet(1,0,-1,0,0));
		trainingData.add(new DataSet(0,1,0,0,0));
		trainingData.add(new DataSet(0,0,0,1,0));
		trainingData.add(new DataSet(0,1,-1,2,0));
		trainingData.add(new DataSet(0,0,-1,2,0));
		trainingData.add(new DataSet(0,0,0,2,0));
		trainingData.add(new DataSet(1,1,1,1,1));
		trainingData.add(new DataSet(1,0,1,1,0));
		trainingData.add(new DataSet(0,0,1,1,0));
		trainingData.add(new DataSet(0,0,-1,1,0));
		trainingData.add(new DataSet(1,1,0,0,1));
		trainingData.add(new DataSet(0,0,1,2,0));
		trainingData.add(new DataSet(1,0,-1,2,0));
		trainingData.add(new DataSet(1,1,-1,2,1));
		trainingData.add(new DataSet(0,1,1,1,0));
		return trainingData;
	}
	
	//Gi generira site Testiracki podatoci i gi vrakja vo vid na lista
	public static List<DataSet> GenerateTestingData()
	{
		List<DataSet> testingData = new ArrayList<DataSet>();
		
		testingData.add(new DataSet(1,1,-1,1,1));
		testingData.add(new DataSet(1,0,-1,1,0));
		testingData.add(new DataSet(0,1,-1,1,0));
		testingData.add(new DataSet(1,1,0,1,1));
		testingData.add(new DataSet(1,0,0,0,0));
		testingData.add(new DataSet(1,0,1,0,0));
		testingData.add(new DataSet(0,1,1,0,0));
		testingData.add(new DataSet(0,0,1,0,0));
		testingData.add(new DataSet(0,1,0,1,0));
		testingData.add(new DataSet(1,1,1,0,1));
		testingData.add(new DataSet(1,0,1,2,0));
		testingData.add(new DataSet(0,0,0,0,0));
		testingData.add(new DataSet(1,1,-1,0,1));
		testingData.add(new DataSet(0,1,0,2,0));
		testingData.add(new DataSet(0,1,-1,0,0));
		testingData.add(new DataSet(0,0,-1,0,0));
		return testingData;
	}
}
