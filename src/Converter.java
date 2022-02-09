public class Converter {
	double stepCm = 0.75;
	int kCall = 1_000;
	int forStepOneCal = 50;

	int convertCall(int monthCall) {
		if (monthCall != 0) {
			return (monthCall * forStepOneCal) / kCall;
		} else return monthCall;
	}

	double convertInKm(double monthMaxStep) {
		if (monthMaxStep != 0) {
			return (monthMaxStep * stepCm) / 1_000;
		} else return monthMaxStep;
	}
}
