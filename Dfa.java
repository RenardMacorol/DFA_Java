public class Dfa {
	public static void main(String[] args) {
		String input[] = { "01", "001", "010101001", "011", "0000100", "000010" };
		// Expected output accepted,accepted,accepted,rejected,rejected,rejected
		Dfa dfa = new Dfa(input);

	}

	Dfa(String[] stringSets) {
		dfaScanInput(stringSets);
	}

	private void dfaScanInput(String[] input) {
		// Loop Statement to scan all input and pass in dfaUntill to check the input
		for (int inputIndex = 0; inputIndex != input.length; inputIndex++) {
			dfaUtil(input[inputIndex]);
		}
	}

	// Helper to check the String is accepted
	private void dfaUtil(String input) {
		String currentState = "q0";
		for (int index = 0; index < input.length(); index++) {
			if (currentState.equals("q0") && input.charAt(index) == '1') {
				currentState = "q0";
			} else if (currentState.equals("q0") && input.charAt(index) == '0') {
				currentState = "q1";
			} else if (currentState.equals("q1") && input.charAt(index) == '0') {
				currentState = "q1";
			} else if (currentState.equals("q1") && input.charAt(index) == '1') {
				currentState = "q2";
			} else if (currentState.equals("q2") && input.charAt(index) == '0') {
				currentState = "q1";
			} else if (currentState.equals("q2") && input.charAt(index) == '1') {
				currentState = "q0";
			}
		}
		if (currentState.equals("q2")) {
			System.out.println("String accepted");
		} else {
			System.out.println("String not Accepted");
		}
	}
}
