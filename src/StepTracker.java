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
	boolean isCheckFirstDay(int keyMounth) {//метод проверяет Если текущий день — первый в месяце
		int a = 0;
		if (mounthTableStep.containsKey(keyMounth)) {
			int[] value = mounthTableStep.get(keyMounth);
			for (int i = 0; i < value.length; i++) {
				if (value[i] != 0) {
					a++;
				}
				if (a >= 2) {
					return true;
				}
			}
		}
		return false;
	}
	void getStepsHashMap(int keyMounth, int day, int steps) {

		if (mounthTableStep.containsKey(keyMounth - 1)) {
			int[] a = mounthTableStep.get(keyMounth - 1);
			a[day - 1] = steps;
			mounthTableStep.put(keyMounth - 1, a);
		}
	}
	void printStepsMounth(int keyMounth) {// Печать за месяц Количества пройденных шагов по дням
		if (mounthTableStep.containsKey(keyMounth - 1) &&
				!(isCheckFirstDay(keyMounth - 1))) {//Если текущий день — первый в месяце (количество дней, за которое есть данные = 0),
			System.out.println("• Количество дней, за которые есть данные = 0;");
			System.out.println("• Количество пройденных шагов по дням = 0;");
		} else if (mounthTableStep.containsKey(keyMounth - 1) &&
				isCheckFirstDay(keyMounth - 1)) {
			System.out.println(keyMounth + "-й Месяц");
			int day = 0;
			int[] m = mounthTableStep.get(keyMounth - 1);
			for (int b : m) {
				++day;
				System.out.print(day + " День: " + b);
				if (day < m.length)
					System.out.print(", ");
			}
			System.out.println(";");
		}
	}
	void sumStepsMounth(int keyMounth) {//Метод Общее количество шагов за месяц
		if (mounthTableStep.containsKey(keyMounth - 1) &&
				!(isCheckFirstDay(keyMounth - 1))) {//Если текущий день — первый в месяце (количество дней, за которое есть данные = 0),
			System.out.println("• Общее количество шагов за месяц = 0;");
		} else if (mounthTableStep.containsKey(keyMounth - 1) && isCheckFirstDay(keyMounth - 1)) {
			int sumAllStep = 0;
			int[] a = mounthTableStep.get(keyMounth - 1);
			for (int b : a) {
				sumAllStep += b;
			}
			System.out.println("• Общее количество шагов за месяц: " + sumAllStep + ";");
		}
	}
	void averStepsMount(int keyMounth) {//Метод Среднее количество шагов;
		if (mounthTableStep.containsKey(keyMounth - 1) &&
				!(isCheckFirstDay(keyMounth - 1))) {//Если текущий день — первый в месяце (количество дней, за которое есть данные = 0),
			System.out.println("• Среднее количество шагов = 0;");
		} else if (mounthTableStep.containsKey(keyMounth - 1) &&
				isCheckFirstDay(keyMounth - 1)) {//Среднее количество шагов;
			int sumAllStep = 0;
			int averageSteps = 0;
			int[] a = mounthTableStep.get(keyMounth - 1);
			for (Integer b : a) {

				if (b != 0) {
					averageSteps++;
				}
				sumAllStep += b;
			}
			sumAllStep /= averageSteps;
			System.out.println("• Среднее количество шагов за месяц: " + sumAllStep + ";");
		}
	}
	void distanceKm(int keyMounth) {//Метод Пройденная дистанция (в км){
		if (mounthTableStep.containsKey(keyMounth - 1) &&
				!(isCheckFirstDay(keyMounth - 1))) {//Если текущий день — первый в месяце (количество дней, за которое есть данные = 0),
			System.out.println("• Пройденная дистанция (в км) = 0;");
		} else if (mounthTableStep.containsKey(keyMounth - 1) && isCheckFirstDay(keyMounth - 1)) {
			int sumAllStep = 0;
			int[] a = mounthTableStep.get(keyMounth - 1);
			for (int b : a) {
				sumAllStep += b;
			}
			double km = converter.convertInKm(sumAllStep);
			System.out.println("• Пройденная дистанция (в км): " + km + ";");
		}
	}
	void minusCalories(int keyMounth) {//Метод Количество сожжённых килокалорий
		if (mounthTableStep.containsKey(keyMounth - 1) &&
				!(isCheckFirstDay(keyMounth - 1))) {//Если текущий день — первый в месяце (количество дней, за которое есть данные = 0),
			System.out.println("• Количество сожжённых килокалорий = 0;");
		} else if (mounthTableStep.containsKey(keyMounth - 1) && isCheckFirstDay(keyMounth - 1)) {
			int sumAllStep = 0;
			int[] a = mounthTableStep.get(keyMounth - 1);
			for (Integer b : a) {
				sumAllStep += b;
			}
			int fireCall = converter.convertCall(sumAllStep);
			System.out.println("• Количество сожжённых килокалорий: " + fireCall + ";");
		}
	}
	void bestSeries(int keyMounth) {//Лучшая серия: максимальное количество подряд идущих дней
		if (mounthTableStep.containsKey(keyMounth - 1) &&
				!(isCheckFirstDay(keyMounth - 1))) {//Если текущий день — первый в месяце (количество дней, за которое есть данные = 0),
			System.out.println("• Лучшая серия: максимальное количество подряд идущих дней = 0;");
		} else if (mounthTableStep.containsKey(keyMounth - 1) &&
				isCheckFirstDay(keyMounth - 1)) {//Лучшая серия: максимальное количество подряд идущих дней
			int day = 0;
			int max = 0;
			int[] a = mounthTableStep.get(keyMounth - 1);
			System.out.print("• Лучшая серия: ");
			for (int b : a) {//печать лучших результатов
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
	}
	int changeTargetSteps(int change) {//метод по замене Целевого количество шагов.
		return targetStepsDay = change;
	}
}
