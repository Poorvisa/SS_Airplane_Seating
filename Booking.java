package flight;
import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class Booking {

	static class Grouping {
		int col;
		int row;

		public Grouping(int col, int row) {
			super();
			this.col = col;
			this.row = row;
		}
	};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		
		//Get the passenger id from users
		System.out.println("Enter number of Passenger ids");
		
		int size_passids=sc.nextInt(), userInputArr[] = {};
		if(size_passids > (int) Math. pow(10, 9)) {
			System.out.println("Array size of passenger_id will not exceed 10^9");
			System.exit(0);
		}
		userInputArr = getThePassengerIds(sc, size_passids, userInputArr);
		
		List<Integer> primeNumbers = new ArrayList<Integer>();
		List<Integer> notPrimeNumbers = new ArrayList<Integer>();
		List<Integer> powerofTwo = new ArrayList<Integer>();
		List<Integer> others = new ArrayList<Integer>();
		Grouping overAllGrouping[] = {};
		
		//Get the prime number list from passenger ids -- primeNumbers
		getPrimeNumbers(userInputArr, primeNumbers, notPrimeNumbers);

		//Get the multiple of 2 power number from passenger ids  -- powerofTwo
		getPowerOfTwoValues(notPrimeNumbers, powerofTwo, others);
		
		
		//Get the number of Flight seating groups from users
		System.out.println("Enter the number of seating groups");
		int groups=sc.nextInt();
		overAllGrouping = new Grouping[groups];
		getSeatingRowAndColumns(sc, groups, overAllGrouping);
		
			
		//Prepare new Array for - Grouping Class
		int highestRow = 0;
		int totalCol = 0;
		for (int in = 0; in < overAllGrouping.length; in++) {
			Grouping flightSeat = overAllGrouping[in];
			totalCol += flightSeat.col;
			if (highestRow < flightSeat.row) {
				highestRow = flightSeat.row;
			}
		}
		
		
		String[][] flighSeats = new String[highestRow][totalCol];
		int groupingLength = 0;
		seatingArragements(overAllGrouping, totalCol, flighSeats, groupingLength);

		System.out.println("");
		System.out.println("WW - window Seat");
		System.out.println("MM - middle Seat");
		System.out.println("aa - aisle Seat");
		System.out.println("");
		
		//Print out put headings
		for (int tdArrRow = 0; tdArrRow < highestRow; tdArrRow++) {
			if (tdArrRow == 0) {
				printSeatingDetails(totalCol, flighSeats, tdArrRow);
			}
		}

		/**
		 * Fill aisle seats first followed by window seats followed by center seats (any order in center seats).
		 * Insert Passenger_id into flighSeats using below conditions
		 * Passenger_id with a prime number should be given first priority
		 */
		 
		//Priority base booking logic
		for (int tdArrCol = 0; tdArrCol < totalCol; tdArrCol++) {
			for (int tdArrRow = 0; tdArrRow < highestRow; tdArrRow++) { 
				if (flighSeats[tdArrRow][tdArrCol] != null) {
					if (flighSeats[tdArrRow][tdArrCol] == "aa") {
						allocateSeating(primeNumbers, powerofTwo, others, flighSeats, tdArrCol, tdArrRow);
					}
				}
			}
		}
		
		for (int tdArrCol = 0; tdArrCol < totalCol; tdArrCol++) {
			for (int tdArrRow = 0; tdArrRow < highestRow; tdArrRow++) {
				if (flighSeats[tdArrRow][tdArrCol] != null) {
					if (flighSeats[tdArrRow][tdArrCol] == "WW") {
						allocateSeating(primeNumbers, powerofTwo, others, flighSeats, tdArrCol, tdArrRow);
					}
				}
			}
		}
		
		for (int tdArrCol = 0; tdArrCol < totalCol; tdArrCol++) {
			for (int tdArrRow = 0; tdArrRow < highestRow; tdArrRow++) {
				if (flighSeats[tdArrRow][tdArrCol] != null) {
					if (flighSeats[tdArrRow][tdArrCol] == "MM") {
						allocateSeating(primeNumbers, powerofTwo, others, flighSeats, tdArrCol, tdArrRow); 
						
					}
				}
			}
		}
		
		
		//Final Output
		for (int tdArrRow = 0; tdArrRow < highestRow; tdArrRow++) { 
			printSeatingDetails(totalCol, flighSeats, tdArrRow);
		}

	}

	private static void seatingArragements(Grouping[] overAllGrouping, int totalCol, String[][] flighSeats,
			int groupingLength) {
		for(int sg = 0; sg < overAllGrouping.length; sg++) {
			Grouping flightSeat = overAllGrouping[sg];
			if(sg > 0) {
				Grouping prevoiusSeats = overAllGrouping[sg-1];
				groupingLength = groupingLength + prevoiusSeats.col; 
			}
			
			int rowLenth = flightSeat.row;
			for (int rl = 0; rl < rowLenth; rl++) {
				
				int columnLength = flightSeat.col;
				int staringArrayPosition = groupingLength;
				findSeatingArrangements(totalCol, flighSeats, rl, columnLength, staringArrayPosition);
			}
		}
	}

	private static void getSeatingRowAndColumns(Scanner sc,int groups, Grouping[] overAllGrouping) {
		
		for(int i=0;i<groups;i++) {
			//Get the Flight seating rows and columns from users
			System.out.println("Enter "+(i+1)+"st column and Row values:");
			int column=sc.nextInt();
			int row=sc.nextInt();
			
			/**
			 * 	1 <= Rows, Columns <= 103
				1 <= Passenger_id <= 109
				Array size of passenger_id will not exceed 109
			 */
			if(row <= 0 || column>((int) Math. pow(10, 3))){
				if(row<= 0) {
					System.out.println("Row should be greater than 0");
					System.exit(0);
				} else if(column > ((int) Math. pow(10, 3))){
					System.out.println("Column should not be greater than 10^3");
					System.exit(0);
				}
			} else {
				//Initialize overAllInput is an ArrayList of ArrayLists
				overAllGrouping[i] = new Grouping(column, row);
			}
		}
	}

	private static int[] getThePassengerIds(Scanner sc, int size_passids, int[] userInputArr) {
		if(size_passids <= 0) {
			System.out.println("Passenger_id will greater then 0");
			System.exit(0);
		} else if(size_passids > (int) Math. pow(10, 9)) {
			System.out.println("Passenger_id will not exceed 10^9.So enter within 10^9");
			System.exit(0);
		} else {
			System.out.println("Enter "+size_passids+" Passenger id");
			userInputArr = new int[size_passids];
			for(int i=0;i<size_passids;i++) {
				userInputArr[i] =sc.nextInt();
	        }
		}
		return userInputArr;
	}

	private static void getPowerOfTwoValues(List<Integer> notPrimeNumbers, List<Integer> powerofTwo,
			List<Integer> others) {
		for (Integer s : notPrimeNumbers) {

			if (isPowerOfTwo(s)) {
				powerofTwo.add(s);
				// System.out.println((s));
			} else {
				
				//Get the other numbers list filter  -- others
				others.add(s);
			}
		}
	}

	private static void getPrimeNumbers(int[] userInputArr, List<Integer> primeNumbers, List<Integer> notPrimeNumbers) {
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
	}

	private static void findSeatingArrangements(int totalCol, String[][] flighSeats, int rl, int columnLength,
			int staringArrayPosition) {
		for (int col = staringArrayPosition; col < columnLength + staringArrayPosition; col++) {
			if (staringArrayPosition == col) {
				if (col == 0) {
					flighSeats[rl][col] = "WW";
				} else {
					flighSeats[rl][col] = "aa";
				}
			} else if (col == staringArrayPosition + columnLength - 1) {
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

	private static void allocateSeating(List<Integer> primeNumbers, List<Integer> powerofTwo, List<Integer> others,
			String[][] flighSeats, int tdArrCol, int tdArrRow) {
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
	}

	private static void printSeatingDetails(int totalCol, String[][] flighSeats, int tdArrRow) {
		for (int tdArrCol = 0; tdArrCol < totalCol; tdArrCol++) {
			if (flighSeats[tdArrRow][tdArrCol] == null) {
				System.out.print("   ");
			} else {
				System.out.print(flighSeats[tdArrRow][tdArrCol] + " ");
			}
		}
		System.out.println("");
	}

	// Check the multiple of 2 power number list filter
	static boolean isPowerOfTwo(int n) {
		if (n == 0)
			return false;

		return (int) (Math.ceil((Math.log(n) / Math.log(2)))) == (int) (Math.floor(((Math.log(n) / Math.log(2)))));
	}

}
