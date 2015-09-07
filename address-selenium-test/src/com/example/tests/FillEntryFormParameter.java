package com.example.tests;

public class FillEntryFormParameter {
	public String firstName;
	public String lastName;
	public String address;
	public EnterPhonesParameter phones;
	public String email;
	public String emailSecond;
	public EnterBirthDateParameter birthDate;
	public EnterAdditionalInfoParameter additInfo;

	public FillEntryFormParameter(String firstName, String lastName, String address, EnterPhonesParameter phones,
			String email, String emailSecond, EnterBirthDateParameter birthDate,
			EnterAdditionalInfoParameter additInfo) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phones = phones;
		this.email = email;
		this.emailSecond = emailSecond;
		this.birthDate = birthDate;
		this.additInfo = additInfo;
	}

	public FillEntryFormParameter() {
		// TODO Auto-generated constructor stub
	}
}