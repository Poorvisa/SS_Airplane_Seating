package flight;

import java.util.ArrayList;
import java.util.List;

public class HelloWorld {

	static class Interval {
		int row;
		int col;

		public Interval(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
	};

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> primeNumbers = new ArrayList<Integer>();
		List<Integer> notPrimeNumbers = new ArrayList<Integer>();
		List<Integer> powerofTwo = new ArrayList<Integer>();
		List<Integer> others = new ArrayList<Integer>();
		
		//Get the array from user using scanner
		int userInputArr[] = { 29, 59, 14, 11, 3, 13, 15, 18, 12, 16, 6, 17, 7, 47, 61, 5, 21, 2, 41, 9, 10, 8, 19, 1, 4 };
		
		//Get the prime number list filter  -- primeNumbers
		for (int j = 0; j < userInputArr.length; j++) {
			// System.out.print(arr[j]+" ,");
			int num = userInputArr[j];
			boolean flag1 = false;
			for (int k = 2; k <= num / 2; ++k) {
				// condition for nonprime number
				if (num % k == 0) {
					flag1 = true;
					break;
				}
			}

			if (!flag1) {
				primeNumbers.add(num);
				// System.out.println(num + " is a prime number.");
			} else {
				notPrimeNumbers.add(num);
				// System.out.println(num + " is not a prime number.");
			}
		}

		//Get the multiple of 2 power number list filter  -- powerofTwo
		for (Integer s : notPrimeNumbers) {

			if (isPowerOfTwo(s)) {
				powerofTwo.add(s);
				// System.out.println((s));
			} else {
				
				//Get the other numbers list filter  -- others
				others.add(s);
			}
		}
		
		
		
		/**
		 * 	1 <= Rows, Columns <= 103
			1 <= Passenger_id <= 109
			Array size of passenger_id will not exceed 109
		 */
		
		// Initialize overAllInput is an ArrayList of ArrayLists
		
		//Get the row and column from user using scanner
		ArrayList<ArrayList<Integer>> overAllInput = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> firstInput = new ArrayList<Integer>(List.of(3, 2));
		ArrayList<Integer> secondinput = new ArrayList<Integer>(List.of(4, 3));
		ArrayList<Integer> thirdinput = new ArrayList<Integer>(List.of(2, 3));
		ArrayList<Integer> fourthinput = new ArrayList<Integer>(List.of(3, 4));
		
		overAllInput.add(firstInput);
		overAllInput.add(secondinput);
		overAllInput.add(thirdinput);
		overAllInput.add(fourthinput);
		
		//Prepare new Array for - Interval => userDefined Data  
		Interval arr1[] = { new Interval(3, 2), new Interval(4, 3), new Interval(2, 3), new Interval(3, 4) };
		// System.out.println(overAllInput.toString());

		int highestRow = 0;
		int totalCol = 0;
		for (int in = 0; in < overAllInput.size(); in++) {
			// System.out.println(overAllInput.get(in));
			ArrayList<Integer> flightSeats = overAllInput.get(in);
			totalCol += flightSeats.get(0);
			if (highestRow < flightSeats.get(1)) {
				highestRow = flightSeats.get(1);
			}
		}
		
		// 4 rows and 12 columns array created
		String[][] flighSeats = new String[highestRow][totalCol];
		
		//Iterate 3, 2 from firstInput
		for (int p = 0; p < firstInput.size(); p++) {
			
			// zero index col value
			if (p == 0) {
				int rowLenth = firstInput.get(1);
				for (int rl = 0; rl < rowLenth; rl++) {
					int columnLength = firstInput.get(0);
					// System.out.println(columnLength);
					for (int col = 0; col < columnLength; col++) {
						if (0 == col) {
							// System.out.println("start");
							flighSeats[rl][col] = "WW";
						} else if (col == columnLength - 1) {
							// System.out.println("end");
							if (col == totalCol - 1) {
								flighSeats[rl][col] = "WW";
							} else {
								flighSeats[rl][col] = "aa";
							}
						} else {
							flighSeats[rl][col] = "MM";
						}
					}
				}
			}
			// first index row value
		}

		
		//Iterate 4,3 from second input
		for (int p = 0; p < secondinput.size(); p++) {
			// System.out.println(firstInput.get(p));

			// zero index col value
			if (p == 0) {
				int rowLenth = secondinput.get(1);
				for (int rl = 0; rl < rowLenth; rl++) {
					int columnLength = secondinput.get(0);
					// System.out.println(columnLength+" "+firstInput.get(0));
					for (int col = firstInput.get(0); col < columnLength + firstInput.get(0); col++) {
						// System.out.println(col+firstInput.get(0));

						if (firstInput.get(0) == col) {
							if (col == 0) {
								flighSeats[rl][col] = "WW";
							} else {
								flighSeats[rl][col] = "aa";
							}

						} else if (col == firstInput.get(0) + columnLength - 1) {
							// System.out.println("end");
							if (col == totalCol - 1) {
								flighSeats[rl][col] = "WW";
							} else {
								flighSeats[rl][col] = "aa";
							}
						} else {
							// System.out.println("middle");
							flighSeats[rl][col] = "MM";
						}
					}
				}
			}
			// first index row value
		}

		//Iterate 2,3 from third input
		for (int p = 0; p < thirdinput.size(); p++) {
			// System.out.println(firstInput.get(p));

			// zero index col value
			if (p == 0) {
				int rowLenth = thirdinput.get(1);
				for (int rl = 0; rl < rowLenth; rl++) {
					int columnLength = thirdinput.get(0);
					// System.out.println(columnLength+" "+firstInput.get(0));
					for (int col = firstInput.get(0) + secondinput.get(0); col < columnLength + firstInput.get(0)
							+ secondinput.get(0); col++) {
						// System.out.println(col+firstInput.get(0));
						if (firstInput.get(0) + secondinput.get(0) == col) {
							// System.out.println("start");
							if (col == 0) {
								flighSeats[rl][col] = "WW";
							} else {
								flighSeats[rl][col] = "aa";
							}
						} else if (col == firstInput.get(0) + secondinput.get(0) + columnLength - 1) {
							// System.out.println("end");
							if (col == totalCol - 1) {
								flighSeats[rl][col] = "WW";
							} else {
								flighSeats[rl][col] = "aa";
							}
						} else {
							// System.out.println("middle");
							flighSeats[rl][col] = "MM";
						}
					}
				}
			}
			// first index row value
		}

		
		//Iterate 2,3 from fourth input
		for (int p = 0; p < fourthinput.size(); p++) {
			// System.out.println(firstInput.get(p));

			// zero index col value
			if (p == 0) {
				int rowLenth = fourthinput.get(1);
				for (int rl = 0; rl < rowLenth; rl++) {
					int columnLength = fourthinput.get(0);
					// System.out.println(columnLength+" "+firstInput.get(0));
					for (int col = firstInput.get(0) + secondinput.get(0) + thirdinput.get(0); col < columnLength
							+ firstInput.get(0) + secondinput.get(0) + thirdinput.get(0); col++) {
						// System.out.println(col+firstInput.get(0));
						if (firstInput.get(0) + secondinput.get(0) + thirdinput.get(0) == col) {
							// System.out.println("start");
							if (col == 0) {
								flighSeats[rl][col] = "WW";
							} else {
								flighSeats[rl][col] = "aa";
							}
						} else if (col == firstInput.get(0) + secondinput.get(0) + thirdinput.get(0) + columnLength
								- 1) {
							if (col == totalCol - 1) {
								flighSeats[rl][col] = "WW";
							} else {
								flighSeats[rl][col] = "aa";
							}
						} else {
							// System.out.println("middle");
							flighSeats[rl][col] = "MM";
						}
					}
				}
			}
			// first index row value
		}
		
		System.out.println("WW - window Seat");
		System.out.println("MM - middle Seat");
		System.out.println("aa - aisle Seat");
		
		
		//Print out put headings
		for (int tdArrRow = 0; tdArrRow < highestRow; tdArrRow++) {
			if (tdArrRow == 0) {
				ArrayList<Integer> flightSeats = overAllInput.get(tdArrRow);
				for (int tdArrCol = 0; tdArrCol < totalCol; tdArrCol++) {
					if (flighSeats[tdArrRow][tdArrCol] == null) {
						System.out.print("   ");
					} else {
						System.out.print(flighSeats[tdArrRow][tdArrCol] + " ");
					}
				}
				System.out.println("");
			}
		}

		/**
		 * Insert Passenger_id into flighSeats using below conditions
		 * Passenger_id with a prime number should be given first priority
		 */
		for (int tdArrRow = 0; tdArrRow < highestRow; tdArrRow++) {
			ArrayList<Integer> flightSeats = overAllInput.get(tdArrRow);
			for (int tdArrCol = 0; tdArrCol < totalCol; tdArrCol++) {
				if (flighSeats[tdArrRow][tdArrCol] == null) {
					// System.out.print(" ");
				} else {
					if (flighSeats[tdArrRow][tdArrCol] == "aa") {
						if (primeNumbers.size() > 0) {
							flighSeats[tdArrRow][tdArrCol] = primeNumbers.get(0) >= 10
									? primeNumbers.get(0).toString()
									: "0" + primeNumbers.get(0).toString();
							primeNumbers.remove(0);
						} else if (powerofTwo.size() > 0) {
							flighSeats[tdArrRow][tdArrCol] = powerofTwo.get(0) >= 10 ? powerofTwo.get(0).toString()
									: "0" + powerofTwo.get(0).toString();
							powerofTwo.remove(0);
						} else if (others.size() > 0) {
							flighSeats[tdArrRow][tdArrCol] = others.get(0) >= 10 ? others.get(0).toString()
									: "0" + others.get(0).toString();
							others.remove(0);
						}
						// System.out.print(integer2DArray[tdArrRow][tdArrCol]+" ");
					} 
					/*else if (flighSeats[tdArrRow][tdArrCol] == "WW") {
						// System.out.print(integer2DArray[tdArrRow][tdArrCol]+" ");
					} else if (flighSeats[tdArrRow][tdArrCol] == "MM") {
						// System.out.print(integer2DArray[tdArrRow][tdArrCol]+" ");
					}*/
				}

			}
			// System.out.println("");
		}

		for (int tdArrRow = 0; tdArrRow < highestRow; tdArrRow++) {
			ArrayList<Integer> flightSeats = overAllInput.get(tdArrRow);
			for (int tdArrCol = 0; tdArrCol < totalCol; tdArrCol++) {
				if (flighSeats[tdArrRow][tdArrCol] == null) {
					// System.out.print(" ");
				} else {
					if (flighSeats[tdArrRow][tdArrCol] == "WW") {
						if (primeNumbers.size() > 0) {
							flighSeats[tdArrRow][tdArrCol] = primeNumbers.get(0) >= 10
									? primeNumbers.get(0).toString()
									: "0" + primeNumbers.get(0).toString();
							primeNumbers.remove(0);
						} else if (powerofTwo.size() > 0) {
							flighSeats[tdArrRow][tdArrCol] = powerofTwo.get(0) >= 10 ? powerofTwo.get(0).toString()
									: "0" + powerofTwo.get(0).toString();
							powerofTwo.remove(0);
						} else if (others.size() > 0) {
							flighSeats[tdArrRow][tdArrCol] = others.get(0) >= 10 ? others.get(0).toString()
									: "0" + others.get(0).toString();
							others.remove(0);
						}
						// System.out.print(integer2DArray[tdArrRow][tdArrCol]+" ");
					}
					//else if (flighSeats[tdArrRow][tdArrCol] == "MM") {
						/*
						 * if(primeNumbers.size() > 0) { System.out.print(primeNumbers.get(0)+" ");
						 * primeNumbers.remove(0); } else if(powerofTwo.size() > 0){
						 * System.out.print(powerofTwo.get(0)+" "); powerofTwo.remove(0); } else
						 * if(others.size() > 0){ System.out.print(others.get(0)+" "); others.remove(0);
						 * }
						 */
						// System.out.print(integer2DArray[tdArrRow][tdArrCol]+" ");
					//} else {
						// System.out.print(integer2DArray[tdArrRow][tdArrCol]+" ");
					//}
				}

			}

		}

		for (int tdArrRow = 0; tdArrRow < highestRow; tdArrRow++) {
			ArrayList<Integer> flightSeats = overAllInput.get(tdArrRow);
			for (int tdArrCol = 0; tdArrCol < totalCol; tdArrCol++) {
				if (flighSeats[tdArrRow][tdArrCol] == null) {
					System.out.print("   ");
				} else {
					if (flighSeats[tdArrRow][tdArrCol] == "MM") {
						if (primeNumbers.size() > 0) {
							flighSeats[tdArrRow][tdArrCol] = primeNumbers.get(0) >= 10
									? primeNumbers.get(0).toString()
									: "0" + primeNumbers.get(0).toString();
							primeNumbers.remove(0);
						} else if (powerofTwo.size() > 0) {
							flighSeats[tdArrRow][tdArrCol] = powerofTwo.get(0) >= 10 ? powerofTwo.get(0).toString()
									: "0" + powerofTwo.get(0).toString();
							powerofTwo.remove(0);
						} else if (others.size() > 0) {
							flighSeats[tdArrRow][tdArrCol] = others.get(0) >= 10 ? others.get(0).toString()
									: "0" + others.get(0).toString();
							others.remove(0);
						} else {
							flighSeats[tdArrRow][tdArrCol] = "XX";
						}
						System.out.print(flighSeats[tdArrRow][tdArrCol] + " ");
					} else {
						System.out.print(flighSeats[tdArrRow][tdArrCol] + " ");
					}
				}

			}
			//Over all output for User
			System.out.println("");
		}
	}

	// Check the multiple of 2 power number list filter
	static boolean isPowerOfTwo(int n) {
		if (n == 0)
			return false;

		return (int) (Math.ceil((Math.log(n) / Math.log(2)))) == (int) (Math.floor(((Math.log(n) / Math.log(2)))));
	}

}
