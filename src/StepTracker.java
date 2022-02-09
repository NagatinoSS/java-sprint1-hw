import java.util.HashMap;

public class StepTracker {
	Converter converter = new Converter();
	int daysMont = 30;// на данном этапе считается, что в месяце ровно 30 дней.
	int targetStepsDay = 10_000;
	public HashMap<Integer, int[]> monthTableStep = new HashMap<>();

	public StepTracker() {
		for (int i = 0; i < 12; i++) {
			int[] a = new int[daysMont];
			monthTableStep.put(i, a);
		}
	}

	void getStepsHashMap(int keyMonth, int day, int steps) {
		int[] daysInMonth = monthTableStep.get(keyMonth - 1);
		daysInMonth[day - 1] = steps;
		monthTableStep.put(keyMonth - 1, daysInMonth);
	}

	void printStepsMonth(int keyMonth) {// Печать за месяц Количества пройденных шагов по дням
		System.out.println(keyMonth + "-й Месяц");
		int day = 0;
		int[] daysInMonth = monthTableStep.get(keyMonth - 1);
		for (int amountSteps : daysInMonth) {
			++day;
			System.out.print(day + " День: " + amountSteps);
			if (day < daysInMonth.length)
				System.out.print(", ");
		}
		System.out.println(";");
	}

	void calculateSumStepsMonth(int keyMonth) {//Метод Общее количество шагов за месяц
		int sumAllSteps = 0;
		int[] daysInMonth = monthTableStep.get(keyMonth - 1);
		for (int amountSteps : daysInMonth) {
			sumAllSteps += amountSteps;
		}
		System.out.println("• Общее количество шагов за месяц: " + sumAllSteps + ";");
	}

	void calculateAverStepsMonth(int keyMonth) {//Метод Среднее количество шагов;
		int sumAllStep = 0;
		int averageSteps = 0;
		int[] daysInMonth = monthTableStep.get(keyMonth - 1);
		for (int amountSteps : daysInMonth) {
			if (amountSteps != 0) {
				averageSteps++;
			}
			sumAllStep += amountSteps;
		}
		if (sumAllStep != 0) {
			sumAllStep /= averageSteps;
		}
		System.out.println("• Среднее количество шагов за месяц: " + sumAllStep + ";");
	}

	void calculateDistanceInKm(int keyMonth) {//Метод Пройденная дистанция (в км){
		int sumAllSteps = 0;
		int[] daysInMonth = monthTableStep.get(keyMonth - 1);
		for (int amountSteps : daysInMonth) {
			sumAllSteps += amountSteps;
		}
		double km = converter.convertInKm(sumAllSteps);
		System.out.println("• Пройденная дистанция (в км): " + km + ";");
	}

	void calculateFireCalories(int keyMonth) {//Метод Количество сожжённых килокалорий
		int sumAllStep = 0;
		int[] daysInMonth = monthTableStep.get(keyMonth - 1);
		for (int amountSteps : daysInMonth) {
			sumAllStep += amountSteps;
		}
		int fireCall = converter.convertCall(sumAllStep);
		System.out.println("• Количество сожжённых килокалорий: " + fireCall + ";");
	}

	void searchBestSeries(int keyMonth) {//Лучшая серия: максимальное количество подряд идущих дней
		int day = 0;
		int max = 0;
		int[] daysInMonth = monthTableStep.get(keyMonth - 1);
		System.out.print("• Лучшая серия: ");
		for (int amountSteps : daysInMonth) {//печать лучших результатов
			if (amountSteps >= targetStepsDay) {//проверка с переменной целевого количества шагов.
				max++;
				if (max > day) {
					day = max;
				}
			}
			if (amountSteps < targetStepsDay) {
				max = 0;
			}
		}
		System.out.println(day + ";");
	}

	int changeTargetSteps(int change) {//метод по замене Целевого количество шагов.
		return targetStepsDay = change;
	}
}
