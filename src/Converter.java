
public class Converter {

	private static StepTracker user;
	double stepCm = 0.75;
	int kCall = 1000;
	int forStepOneCal = 50;
	//StepTracker user = new StepTracker();

	
	int convertKall ( int a ){
		return (a*forStepOneCal)/kCall;

	}

	double convertInKm ( double a ){
		return (a*stepCm)/1000;

	}

}
