package beans;

public class PrimeBean {
	private int number;
	private String message;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void detect() {
		boolean prime = true;

		for (int i = 2; i <= number / 2; i++)
			if (number % i == 0) {
				prime = false;
				break;
			}

		if (prime)
			message = "Prime number";
		else
			message = "Not a prime number";
	}

}
