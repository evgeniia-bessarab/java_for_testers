package com.example.tests;

public class FillEntryFormParameter implements Comparable<FillEntryFormParameter> {
	private String firstName;
	private String lastName;
	private String address;
	private EnterPhonesParameter phones;
	private String email;
	private String emailSecond;
	private EnterBirthDateParameter birthDate;
	private EnterAdditionalInfoParameter additInfo;

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
	}

	@Override
	public String toString() {
		return "FillEntryFormParameter [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
				+  ", email=" + email + ", emailSecond=" + emailSecond + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		/*result = prime * result + ((additInfo == null) ? 0 : additInfo.hashCode());
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((birthDate == null) ? 0 : birthDate.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((emailSecond == null) ? 0 : emailSecond.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((phones == null) ? 0 : phones.hashCode());*/
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FillEntryFormParameter other = (FillEntryFormParameter) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

	@Override
	public int compareTo(FillEntryFormParameter other) {
			return this.firstName.toLowerCase().compareTo(other.firstName.toLowerCase());

	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}

	public EnterPhonesParameter getPhones() {
		return phones;
	}

	public String getEmail() {
		return email;
	}

	public String getEmailSecond() {
		return emailSecond;
	}

	public EnterBirthDateParameter getBirthDate() {
		return birthDate;
	}

	public EnterAdditionalInfoParameter getAdditInfo() {
		return additInfo;
	}

	public FillEntryFormParameter withFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public FillEntryFormParameter withLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public FillEntryFormParameter withAddress(String address) {
		this.address = address;
		return this;
	}

	public FillEntryFormParameter withEmailSecond(String emailSecond) {
		this.emailSecond = emailSecond;
		return this;
	}

	public FillEntryFormParameter withEmail(String email) {
		this.email = email;
		return this;
	}

	public FillEntryFormParameter withBirthDate(EnterBirthDateParameter birthDate) {
		this.birthDate = birthDate;
		return this;
	}

	public FillEntryFormParameter withPhones(EnterPhonesParameter phones) {
		this.phones = phones;
		return this;
	}

	public FillEntryFormParameter withAdditInfo(EnterAdditionalInfoParameter addInfo) {
		this.additInfo = addInfo;
		return null;
	}
	
	
}