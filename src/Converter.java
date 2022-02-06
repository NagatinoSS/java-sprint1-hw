public class Converter {
	double stepCm = 0.75;
	int kCall = 1000;
	int forStepOneCal = 50;
	int convertCall(int mounthCall) {
		if (mounthCall!=0){
			return (mounthCall * forStepOneCal) / kCall;}
		else return mounthCall;
	}
	double convertInKm(double mountMaxStep) {
		if (mountMaxStep!=0){
		return (mountMaxStep * stepCm) / 1000;}
		else return mountMaxStep;
	}
}
