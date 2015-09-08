package com.example.tests;

public class FillEntryFormParameter implements Comparable<FillEntryFormParameter> {
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

	@Override
	public String toString() {
		return "FillEntryFormParameter [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
				+ ", phones=" + phones + ", email=" + email + ", emailSecond=" + emailSecond + ", birthDate="
				+ birthDate + ", additInfo=" + additInfo + "]";
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
		if (additInfo == null) {
			if (other.additInfo != null)
				return false;
		} else if (!additInfo.equals(other.additInfo))
			return false;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (birthDate == null) {
			if (other.birthDate != null)
				return false;
		} else if (!birthDate.equals(other.birthDate))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (emailSecond == null) {
			if (other.emailSecond != null)
				return false;
		} else if (!emailSecond.equals(other.emailSecond))
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
		if (phones == null) {
			if (other.phones != null)
				return false;
		} else if (!phones.equals(other.phones))
			return false;
		return true;
	}

	@Override
	public int compareTo(FillEntryFormParameter other) {
			return this.firstName.toLowerCase().compareTo(other.firstName.toLowerCase());

	}
	
	
}