package Main;

public class DataSet {
	
	public int Polozuvanje;
	public int Ucenje;
	public int Domasni;
	public int Vezbanje;
	
	public int Output;
	public int Target;
	
	public DataSet(int polozuvanje, int ucenje, int domasni, int vezbanje, int target)
	{
		this.Polozuvanje = polozuvanje;
		this.Ucenje = ucenje;
		this.Domasni = domasni;
		this.Vezbanje = vezbanje;
		this.Target = target;
	}
	
	//Go kalkulira izlezot vo zavisnot od dobienite vektori 
	//i pragovata vrednost go zapisuva vo Output promenlivata
	public void CalculateOutput(double[] w, double t)
	{
		double x1 = this.Polozuvanje * w[0];
		double x2 = this.Ucenje * w[1];
		double x3 = this.Domasni * w[2];
		double x4 = this.Vezbanje * w[3];
		
		double sum = x1 + x2 + x3 + x4;
		
		if(sum <= t)
			this.Output = 0;
		else
			this.Output = 1;
	}
}
