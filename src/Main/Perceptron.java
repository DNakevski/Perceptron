package Main;
import java.util.ArrayList;
import java.util.List;

public class Perceptron {
	
	public double a; 		//rata na ucenje
	public double [] w; 	//vektori
	public double t; 		//pragova vrednost
	
	List<DataSet> TrainingData = new ArrayList<DataSet>();		//Treniracko mnozestvo
	List<DataSet> TestingData = new ArrayList<DataSet>();		//Testiracko mnozestvo
	
	public boolean isTrainingFinished; //Sluzi za proverka dali treniranjeto e zavrseno(odnosno dali e izminata edna epoha bez promena na vektorite)
	
	public Perceptron(double LearningRate, double prag, List<DataSet> trainingData)
	{
		this.a = LearningRate;
		this.t = prag;
		this.TrainingData = trainingData;
		
		//Setiraj gi site pocetni vektori na 0
		this.w = new double[4];
		for(int i = 0; i<4; i++)
		{
			this.w[i] = 0;
		}
		
	}
	
	//Funkcija za treniranje na perceptronot
	//Se povikuva se dodeka edna epoha ne e celosno izminata bez nikakva promena na vektorite
	public void Train()
	{
		this.isTrainingFinished = false;
		int count = 0;
		
		while(!this.isTrainingFinished)
		{
			count++;
			System.out.println("Epoha " + count);
			GoThroughEpoch();
		}
		
	}
	
	//Ova funkcija gi proagja site podatoci od edna epoha.
	//Za sekoj podatok go kalkulira izlezot.
	//Dokolku izlezot e razlicen od ocekuvanata vrednst, ja povikuva funkcijata za presmetka na novite vlezni vektori
	//i ja klasificira taa epoha kako nevalidna(odnosno najdeno e greska vo tekot na nejzinoto izminuvanje)
	public void GoThroughEpoch()
	{
		boolean isEpochValid = true;
		int errorCount = 0;
		for(int i=0; i<this.TrainingData.size(); i++)
		{
			DataSet currentData = TrainingData.get(i);
			currentData.CalculateOutput(this.w, t);
			
			if(currentData.Output != currentData.Target)
			{
				double producedError = currentData.Target - currentData.Output;
				RecalculateInputVectors(producedError, currentData);
				isEpochValid = false;
				errorCount++;
			}

		}
		
		//Na krajot od izminuvanjeto na epohata
		//Se printaat vrednostite na vektorite kako i brojot na pogresnite klasifikacii
		System.out.println("Vektori: w1 = " + this.w[0] + "; w2 = " + this.w[1] + "; w3 = " + this.w[2] + "; w4 = " + this.w[3] + ";");
		System.out.println("Gresni klasifikacii: " + errorCount);
		System.out.println("-------------------------------------------------------");
		
		
		//Dokolku epohata e validna setiraj ja promenlivata isTrainingFinished na true
		//So ova zavrsuva ciklusot za treniranje na perceptronot i izminuvanje na epohite
		if(isEpochValid)
			this.isTrainingFinished = true;
		
		
	}
	
	//Ovaa funkcija se povikuva po zavrsenoto treniranje na perceptronot
	//Taa ima za zadaca da go testira perceptronot vrz osnova na trenirackite podatoci
	public void Test()
	{
		int successfullCount = 0;
		for(int i=0; i<this.TestingData.size(); i++)
		{
			DataSet currentData = this.TestingData.get(i);
			currentData.CalculateOutput(this.w, t);
			
			if(currentData.Output == currentData.Target)
			{
				successfullCount++;
			}
		}
		
		
		//Po izminuvanje na site testiracki podatoci
		//Se kalkulira i se pecati Uspeshnosta na perceptronot vo procenti
		int dataCount = this.TestingData.size();
		
		double result = (successfullCount / dataCount) * 100;
		
		System.out.println("Uspeshnosta na perceptronot iznesuva: " + result + "%");
		
	}
	
	
	//Ovaa funkcija se koristi za presmetka na novite vlezni vektori
	//vo odnos na dobienata greska i podatocite vo konkretniot element(DataSet)
	public void RecalculateInputVectors(double producedError, DataSet dataSet)
	{
		w[0] = w[0] + (this.a * producedError * dataSet.Polozuvanje);
		w[1] = w[1] + (this.a * producedError * dataSet.Ucenje);
		w[2] = w[2] + (this.a * producedError * dataSet.Domasni);
		w[3] = w[3] + (this.a * producedError * dataSet.Vezbanje);
	}
	
	//Setiraj go testirackoto mnozestco na perceptronot
	public void SetTestingData(List<DataSet> testingData)
	{
		this.TestingData = testingData;
	}
	
}
