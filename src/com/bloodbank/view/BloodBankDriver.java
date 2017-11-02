package com.bloodbank.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.bloodbank.controller.BloodBankController;
import com.bloodbank.controller.DonarController;
import com.bloodbank.controller.SeekerController;
import com.bloodbank.model.BloodBank;
import com.bloodbank.model.Donar;

public class BloodBankDriver {

	public static Connection con = null;
	static {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@10.100.1.30:1521:kurnia", "kurniadev",
					"system");
		} catch (ClassNotFoundException e) {
			System.out.println("" + e);
		} catch (SQLException e) {
			System.out.println("" + e);
		}
	}

	public static void main(String[] args) throws SQLException {

		Scanner scanner = new Scanner(System.in);

		String name;
		int age;
		int weight;
		String gender;
		String bloodGroup;
		String phoneNumber;
		String emailId;
		String state;
		String city;
		String area;
		String userName;
		String password;
		String address;
		String pincode;

		int option;
		String wish;
		boolean result;

		ResultSet rs;
		Donar donar;
		BloodBank bloodbank;
		DonarController donarController = new DonarController();
		SeekerController seekerController = new SeekerController();
		BloodBankController bloodbankController = new BloodBankController();

		System.out.println("*******************************************");
		System.out.println("--------------ONLINE BLOOD BANK------------");
		System.out.println("*******************************************");

		do {
			System.out.println("\n1.Donar");
			System.out.println("2.Seeker");
			System.out.println("3.Admin");
			System.out.println("4.Exit");

			option = scanner.nextInt();

			System.out.println("------Select The Option--------");

			switch (option) {
			case 1:

				System.out.println("1.Register");
				System.out.println("2.Login");
				int choice = scanner.nextInt();

				switch (choice)

				{
				case 1:

					System.out
							.println("*******************************************");
					System.out
							.println("Please check your eligibility to donate blood");
					System.out
							.println("*******************************************");
					System.out
							.println("\n1. Anyone above 18 years weighing more than 50 kgs (110 lbs) can donate blood");
					System.out
							.println("2. Your hemoglobin is not less than 12.5 grams");
					System.out
							.println("3. You should be free from acute respiratory diseases and skin diseases");
					System.out
							.println("3. You do not carry any disease transmissible by blood transfusion");
					System.out
							.println("5. You should not be under medication for Malaria / Tuberculosis / Diabetes / Fits / Convulsions");
					System.out
							.println("\nYou may not suffered from following diseases");
					System.out
							.println("1. Hepatitis B, C\n2. AIDS\n3. Cancer\n4. Kidney disease\n5. Heart disease");
					System.out
							.println("----------------------------------------------------------------------------------------------------");
					System.out
							.println("\nIf you are eligible then register as a donar");
					System.out.println("\n Do you wish to register as Donar?");
					String choice1 = scanner.next();
					if (choice1.equals("yes")) {
						System.out.println("Enter the details to register");
						System.out.println("Enter your Name : ");
						name = scanner.next();
						result = validateName(name);
						while (!result == true) {
							System.out.println("Enter the valid Name:");
							name = scanner.next();
							result = validateName(name);
						}
						System.out.println("Enter your Age : ");
						age = scanner.nextInt();
						result = validateAge(age);
						while (!result == true) {
							System.out.println("Enter the valid Age:");
							age = scanner.nextInt();
							result = validateAge(age);
						}
						System.out.println("Enter your Weight : ");
						weight = scanner.nextInt();
						result = validateWeight(weight);
						while (!result == true) {
							System.out.println("Enter the valid Weight:");
							weight = scanner.nextInt();
							result = validateWeight(weight);
						}
						System.out.println("Enter your Gender : ");
						gender = scanner.next();
						result = validateGender(gender);
						while (!result == true) {
							System.out.println("Enter the valid Gender:");
							gender = scanner.next();
							result = validateGender(gender);
						}
						System.out.println("Enter your Blood Group : ");
						bloodGroup = scanner.next();
						result = validateBloodGroup(bloodGroup);
						while (!result == true) {
							System.out.println("Enter the valid BloodGroup:");
							bloodGroup = scanner.next();
							result = validateBloodGroup(bloodGroup);
						}
						System.out.println("Enter your Contact Number : ");
						phoneNumber = scanner.next();
						result = validatePhoneNumber(phoneNumber);
						while (!result == true) {
							System.out
									.println("Enter the valid Contact Number:");
							name = scanner.next();
							result = validatePhoneNumber(phoneNumber);
						}
						System.out.println("Enter your Email Id : ");
						emailId = scanner.next();
						result = validateEmailid(emailId);
						while (!result == true) {
							System.out.println("Enter the valid Email Id:");
							emailId = scanner.next();
							result = validateEmailid(emailId);

						}
						System.out.println("Enter your State : ");
						state = scanner.next();
						result = validateName(state);
						while (!result == true) {
							System.out.println("Enter the valid State Name:");
							state = scanner.next();
							result = validateName(state);
						}
						System.out.println("Enter your City : ");
						city = scanner.next();
						result = validateName(city);
						while (!result == true) {
							System.out.println("Enter the valid City Name:");
							city = scanner.next();
							result = validateName(city);
						}
						System.out.println("Enter your Area : ");
						area = scanner.next();
						result = validateName(area);
						while (!result == true) {
							System.out.println("Enter the valid Name:");
							area = scanner.next();
							result = validateName(area);
						}

						System.out.println("Enter the Password");
						password = scanner.next();
						result = validatePassword(password);
						while (!result == true) {
							System.out.println("Enter the valid Password:");
							password = scanner.next();
							result = validatePassword(password);
						}

						donar = new Donar(name, age, weight, gender,
								bloodGroup, phoneNumber, emailId, state, city,
								area, password);

						int output = donarController.addDonar(donar);
						if (output > 0) {
							System.out.println("***Registration Successful***");
							System.out.println("***Your DonarId is : "
									+ donarController.displayDonarId(name)
									+ "***");
							System.out
									.println("***Use your EmailId and Password to Login ***");
						} else

							System.out
									.println("There is error in the given data!");
					}
					break;

				case 2:
					System.out.println("Enter the Email ID");
					emailId = scanner.next();
					System.out.println("Enter the Password");
					password = scanner.next();
					result = donarController.checkLogin(emailId, password);

					if (result == true) {
						System.out.println("***Login Successful***");
					} else {
						System.out.println("Invalid Login!");
					}

					if (result == true) {
						do {
							System.out.println("1.View Details");
							System.out.println("2.Update");
							System.out.println("Enter your choice");
							choice = scanner.nextInt();

							switch (choice) {
							case 1:

							{
								rs = donarController
										.displayDonarProfile(emailId);
								if (rs.next()) {
									System.out
											.println("************************");
									System.out
											.println("------YOUR PROFILE------");
									System.out
											.println("************************");
									System.out.println("DonarID	: "
											+ rs.getString(1));
									System.out.println("Name	: "
											+ rs.getString(2));
									System.out.println("Age	: "
											+ rs.getString(3));
									System.out.println("Weight	: "
											+ rs.getString(4) + "kgs");
									System.out.println("Gender	: "
											+ rs.getString(5));
									System.out.println("BloodGroup : "
											+ rs.getString(6));
									System.out.println("PhoneNumber : "
											+ rs.getString(7));
									System.out.println("Email	: "
											+ rs.getString(8));
									System.out.println("State	: "
											+ rs.getString(9));
									System.out.println("City	: "
											+ rs.getString(10));
									System.out.println("Area	: "
											+ rs.getString(11));

								}

								break;
							}

							case 2:

							{
								System.out
										.println("If you want to update your details you have to Re-Enter all the details once again");
								System.out.println("Do you wish to update?");
								choice1 = scanner.next();
								if (choice1.equals("yes")) {

									System.out.println("Enter your Name : ");
									name = scanner.next();
									result = validateName(name);
									while (!result == true) {
										System.out
												.println("Enter the valid Name:");
										name = scanner.next();
										result = validateName(name);
									}
									System.out.println("Enter your Age : ");
									age = scanner.nextInt();
									result = validateAge(age);
									while (!result == true) {
										System.out
												.println("Enter the valid Age:");
										age = scanner.nextInt();
										result = validateAge(age);
									}
									System.out.println("Enter your Weight : ");
									weight = scanner.nextInt();
									result = validateWeight(weight);
									while (!result == true) {
										System.out
												.println("Enter the valid Weight:");
										weight = scanner.nextInt();
										result = validateWeight(weight);
									}
									System.out.println("Enter your Gender : ");
									gender = scanner.next();
									result = validateGender(gender);
									while (!result == true) {
										System.out
												.println("Enter the valid Gender:");
										gender = scanner.next();
										result = validateGender(gender);
									}
									System.out
											.println("Enter your Blood Group : ");
									bloodGroup = scanner.next();
									result = validateBloodGroup(bloodGroup);
									while (!result == true) {
										System.out
												.println("Enter the valid BloodGroup:");
										bloodGroup = scanner.next();
										result = validateBloodGroup(bloodGroup);
									}
									System.out
											.println("Enter your Contact Number : ");
									phoneNumber = scanner.next();
									result = validatePhoneNumber(phoneNumber);
									while (!result == true) {
										System.out
												.println("Enter the valid Contact Number:");
										name = scanner.next();
										result = validatePhoneNumber(phoneNumber);
									}
									System.out
											.println("Enter your Email Id : ");
									emailId = scanner.next();
									result = validateEmailid(emailId);
									while (!result == true) {
										System.out
												.println("Enter the valid Email Id:");
										emailId = scanner.next();
										result = validateEmailid(emailId);

									}
									System.out.println("Enter your State : ");
									state = scanner.next();
									result = validateName(state);
									while (!result == true) {
										System.out
												.println("Enter the valid State Name:");
										state = scanner.next();
										result = validateName(state);
									}
									System.out.println("Enter your City : ");
									city = scanner.next();
									result = validateName(city);
									while (!result == true) {
										System.out
												.println("Enter the valid City Name:");
										city = scanner.next();
										result = validateName(city);
									}
									System.out.println("Enter your Area : ");
									area = scanner.next();
									result = validateName(area);
									while (!result == true) {
										System.out
												.println("Enter the valid Name:");
										area = scanner.next();
										result = validateName(area);
									}

									donar = new Donar(name, age, weight,
											gender, bloodGroup, phoneNumber,
											emailId, state, city, area,
											password);
									donarController.modifyDonar(donar);
									System.out
											.println("***Updation Successful***");
								}

								break;
							}

							}
							System.out
									.println("Do you want to continue  the donar operation");
							wish = scanner.next();
						} while (wish.contentEquals("yes"));
					}
					break;
				}
				break;
			case 2: 
				do{
				System.out.println("1.Search a Donar");
				System.out.println("2.Life Saving Contacts");
				System.out.println("3.Mobilink Paging Service");
				System.out.println("Enter the Option");
				option = scanner.nextInt();
				switch (option) {
				case 1:

					System.out.println("Enter your State : ");
					state = scanner.next();
					result = validateName(state);
					while (!result == true) {
						System.out.println("Enter the valid State Name:");
						state = scanner.next();
						result = validateName(state);
					}
					System.out.println("Enter your City : ");
					city = scanner.next();
					result = validateName(city);
					while (!result == true) {
						System.out.println("Enter the valid City Name:");
						city = scanner.next();
						result = validateName(city);
					}

					System.out.println("Enter your Blood Group : ");
					bloodGroup = scanner.next();
					result = validateBloodGroup(bloodGroup);
					while (!result == true) {
						System.out.println("Enter the valid BloodGroup:");
						bloodGroup = scanner.next();
						result = validateBloodGroup(bloodGroup);
					}
					donar = new Donar(state, city, bloodGroup);
					rs = seekerController.searchDonar(donar);

					if (rs.next()) {

						System.out.println("Name	: " + rs.getString(2));
						System.out.println("Blood Group	: " + rs.getString(6));
						System.out.println("Phone Number	: " + rs.getString(7));
					}

					else

						System.out
								.println("Sorry donars are not available in this Blood Group\nKindly use the Life Saving Contact Service");

					break;
				case 2: {
					System.out.println("Enter your State : ");
					state = scanner.next();
					result = validateName(state);
					while (!result == true) {
						System.out.println("Enter the valid State Name:");
						state = scanner.next();
						result = validateName(state);
					}
					System.out.println("Enter your City : ");
					city = scanner.next();
					result = validateName(city);
					while (!result == true) {
						System.out.println("Enter the valid City Name:");
						city = scanner.next();
						result = validateName(city);
					}

					rs = bloodbankController.searchLifeSaveContactPerson(state,
							city);

					if (rs.next()) {

						System.out.println("Name	: " + rs.getString(2));
						System.out.println("Address	: " + rs.getString(3));
						System.out.println("Pincode	: " + rs.getString(4));
						System.out.println("State	: " + rs.getString(5));
						System.out.println("City	: " + rs.getString(6));
						System.out.println("Phone Number	: " + rs.getString(7));

					}

					else {
						System.out
								.println("Sorry Life Saving Contact Person is not available in this Area \nKindly use the Mobilink Paging Service");
					}

					break;
				}
				case 3: {
					System.out.println("The Mobilink Service Number is");
					System.out.println("0300 010 010 ");

					break;
				}

				}System.out.println("Do you want to continue the Seeker operation..?");
				wish = scanner.next();
				
			}while (wish.contentEquals("yes"));
				

			case 3:
				System.out.println("1.Login");
				System.out.println("2.Exit");
				choice = scanner.nextInt();

				switch (choice) {

				case 1:
					System.out.println("Enter the Username");
					userName = scanner.next();
					System.out.println("Enter the Password");
					password = scanner.next();
					result = bloodbankController.checkAdminLogin(userName,
							password);
					if (result == true) {
						System.out.println("***Login Successful***");
					} else {
						System.out.println("Invalid Login!");
					}

					if (result == true) {
						do {
							System.out.println("1.View Donar Details");
							System.out
									.println("2.Add Life Saving Contact Person");
							System.out.println("3.View Life Saver Details");
							System.out
									.println("4.Delete Life Saving Contact Person");
							System.out.println("Enter your choice");
							choice = scanner.nextInt();
							switch (choice) {
							case 1:

								System.out
										.println("\t\t\t\t\t**************************************"
												+ "*********************************");
								System.out
										.println("\t\t\t\t\t\t\t----------List of Registered Donars---------\t\t\t\t\t\t\t\t");
								System.out
										.println("\t\t\t\t\t**************************************"
												+ "*********************************");
								rs = bloodbankController.viewDonarDetails();
								while (rs.next()) {
									System.out.println("Donar ID : "
											+ rs.getString(1) + "\t\tName : "
											+ rs.getString(2) + "\t\tAge : "
											+ rs.getString(3) + "\t\tWeight : "
											+ rs.getString(4) + "kgs"
											+ "\t\tGender : " + rs.getString(5)
											+ "\t\tBloodGroup : "
											+ rs.getString(6)
											+ "\t\tPhone Number : "
											+ rs.getString(7) + "\t\tEmail : "
											+ rs.getString(8) + "\t\tState : "
											+ rs.getString(9) + "\t\tCity : "
											+ rs.getString(10) + "\t\tArea : "
											+ rs.getString(11)
											+ "\t\tPassword : "
											+ rs.getString(12));

								}
								break;
							case 2:
								System.out.println("Add the Details:");
								System.out.println("Enter the Name");
								name = scanner.next();
								System.out.println("Enter the Address");
								address = scanner.next();
								System.out.println("Enter the Pincode");
								pincode = scanner.next();
								System.out.println("Enter your State : ");
								state = scanner.next();
								System.out.println("Enter your City : ");
								city = scanner.next();
								System.out.println("Enter the Contact Number:");
								phoneNumber = scanner.next();
								bloodbank = new BloodBank(name, address,
										pincode, state, city, phoneNumber);
								int output = bloodbankController
										.addLifeSaver(bloodbank);

								if (output > 0) {
									System.out
											.println("***Creation Successful***");

								} else
									System.out
											.println("There is error in the given data!");
								break;

							case 3:

								System.out
										.println("\t\t\t\t\t**************************************"
												+ "*********************************");
								System.out
										.println("\t\t\t\t\t\t\t----------List of Life Saving Contacts---------\t\t\t\t\t\t");
								System.out
										.println("\t\t\t\t\t**************************************"
												+ "*********************************");
								rs = bloodbankController.viewLifeSaverDetails();

								while (rs.next()) {
									System.out.println("Person ID : "
											+ rs.getString(1) + "\t\tName : "
											+ rs.getString(2)
											+ "\t\tAddress : "
											+ rs.getString(3)
											+ "\t\tPincode : "
											+ rs.getString(4) + "\t\tState : "
											+ rs.getString(5) + "\t\tCity : "
											+ rs.getString(6)
											+ "\t\tPhone Number : "
											+ rs.getString(7));

								}

								break;

							case 4:
								System.out.println("Enter the LifeSaver Id: ");
								int id = scanner.nextInt();
								output = bloodbankController
										.deleteLifeSaver(id);
								if (output > 0) {
									System.out
											.println("***Deletion Successful***");

								} else
									System.out
											.println("There is error in the given data!");

								break;
							}
							System.out
									.println("Do you want to continue  the Admin operation");
							wish = scanner.next();
						} while (wish.contentEquals("yes"));
					}
					break;
				}
				break;

			case 4:

				System.out.println("Exit");

				con.close();
				System.out.println("Connection closed");
			}
			System.out.println("Do you want to stop the whole operation?");
			wish = scanner.next();
		} while (wish.contentEquals("no"));
		
		scanner.close();
	}

	private static Pattern namepattern = Pattern.compile("[a-zA-Z]{3,20}");
	private static Pattern passwordpattern = Pattern
			.compile("[a-zA-Z0-9@]{3,14}");
	private static Pattern phonepattern = Pattern.compile("[0-9]{10,13}");

	public static boolean validateName(String name) {
		Matcher match = namepattern.matcher(name);
		if (match.matches()) {
			return true;
		}
		return false;
	}

	public static boolean validatePassword(String password) {
		Matcher match = passwordpattern.matcher(password);
		if (match.matches()) {
			return true;
		}
		return false;
	}

	public static boolean validateBloodGroup(String bloodGroup) {

		if (bloodGroup.contains("O+ve") || bloodGroup.contains("O-ve")
				|| bloodGroup.contains("A+ve") || bloodGroup.contains("A-ve")
				|| bloodGroup.contains("B+ve") || bloodGroup.contains("B-ve")
				|| bloodGroup.contains("A1+ve") || bloodGroup.contains("A1-ve")
				|| bloodGroup.contains("A2+ve") || bloodGroup.contains("A2-ve")
				|| bloodGroup.contains("A1B+ve")
				|| bloodGroup.contains("A1B-ve")
				|| bloodGroup.contains("A2B+ve")
				|| bloodGroup.contains("A2B-ve")
				|| bloodGroup.contains("AB+ve") || bloodGroup.contains("AB-ve")) {
			return true;
		} else
			return false;
	}

	public static boolean validateEmailid(String emailid) {

		if (emailid.contains("@") && emailid.contains(".com")) {
			return true;
		} else
			return false;
	}

	public static boolean validateGender(String gender) {

		if (gender.contains("Male") || gender.contains("Female")
				|| gender.contains("Others")) {
			return true;
		} else
			return false;
	}

	public static boolean validateAge(int age) {

		if (age >= 18 && age <= 55) {
			return true;
		} else
			return false;
	}

	public static boolean validateWeight(int weight) {

		if (weight >= 50) {
			return true;
		} else
			return false;
	}

	public static boolean validatePhoneNumber(String phoneNumber) {
		Matcher match = phonepattern.matcher(phoneNumber);
		if (match.matches()) {
			return true;
		}
		return false;
	}
}
