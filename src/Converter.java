


public class Converter {

	private static StepTracker user;
	double stepCm = 0.75;
	int kCall = 1000;
	int forStepOneCal = 50;

	int convertCall(int mounthCall) {
		return (mounthCall * forStepOneCal) / kCall;
	}

	double convertInKm(double mountMaxStep) {
		return (mountMaxStep * stepCm) / 1000;
	}

}
