package pruefung;

public class P2016 {

	public void A31() {

		boolean admin = false;
		boolean special = false;
		boolean customer = false;

		if (customer) {
			if (admin || !special)
				woof();
			else if (admin)
				woof();

			else if (!special)
				woof();

		}
	}

	private void woof() {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {

	}
}
