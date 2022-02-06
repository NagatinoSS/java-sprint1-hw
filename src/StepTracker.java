import java.util.HashMap;

public class StepTracker {
	int daysMount = 30;// на данном этапе считается, что в месяце ровно 30 дней.
	int targetStepsDay = 10000;
	public HashMap<Integer, int[]> mounthTableStep = new HashMap<>();
	public StepTracker() {
		for (int i = 0; i < 12; i++) {
			int[] a = new int[daysMount];
			mounthTableStep.put(i, a);
		}
	}
	Converter converter = new Converter();
	void getStepsHashMap(int keyMounth, int day, int steps) {
			int[] a = mounthTableStep.get(keyMounth - 1);
			a[day - 1] = steps;
			mounthTableStep.put(keyMounth - 1, a);
	}
	void printStepsMounth(int keyMounth) {// Печать за месяц Количества пройденных шагов по дням
		System.out.println(keyMounth + "-й Месяц");
		int day = 0;
		int[] mounth = mounthTableStep.get(keyMounth - 1);
		for (int b : mounth) {
			++day;
			System.out.print(day + " День: " + b);
			if (day < mounth.length)
				System.out.print(", ");
		}
		System.out.println(";");
	}
	void sumStepsMounth(int keyMounth) {//Метод Общее количество шагов за месяц
		int sumAllStep = 0;
		int[] mounth = mounthTableStep.get(keyMounth - 1);
		for (int b : mounth) {
			sumAllStep += b;
		}
		System.out.println("• Общее количество шагов за месяц: " + sumAllStep + ";");
	}
	void averStepsMount(int keyMounth) {//Метод Среднее количество шагов;
		int sumAllStep = 0;
		int averageSteps = 0;
		int[] mounth = mounthTableStep.get(keyMounth - 1);
		for (Integer b : mounth) {
			if (b != 0) {
				averageSteps++;
			}
			sumAllStep += b;
		}
		if (sumAllStep != 0) {
			sumAllStep /= averageSteps;
		}
		System.out.println("• Среднее количество шагов за месяц: " + sumAllStep + ";");
	}
	void distanceKm(int keyMounth) {//Метод Пройденная дистанция (в км){
		int sumAllStep = 0;
		int[] mounth = mounthTableStep.get(keyMounth - 1);
		for (int b : mounth) {
			sumAllStep += b;
		}
		double km = converter.convertInKm(sumAllStep);
		System.out.println("• Пройденная дистанция (в км): " + km + ";");
	}
	void minusCalories(int keyMounth) {//Метод Количество сожжённых килокалорий
		int sumAllStep = 0;
		int[] mounth = mounthTableStep.get(keyMounth - 1);
		for (int b : mounth) {
			sumAllStep += b;
		}
		int fireCall = converter.convertCall(sumAllStep);
		System.out.println("• Количество сожжённых килокалорий: " + fireCall + ";");
	}
	void bestSeries(int keyMounth) {//Лучшая серия: максимальное количество подряд идущих дней
		int day = 0;
		int max = 0;
		int[] mounth = mounthTableStep.get(keyMounth - 1);
		System.out.print("• Лучшая серия: ");
		for (int b : mounth) {//печать лучших результатов
			if (b >= targetStepsDay) {//проверка с переменной целевого количества шагов.
				max++;
				if (max > day) {
					day = max;
				}
			}
			if (b < targetStepsDay) {
				max = 0;
			}
		}
		System.out.println(day + ";");
	}
	int changeTargetSteps(int change) {//метод по замене Целевого количество шагов.
		return targetStepsDay = change;
	}
}
