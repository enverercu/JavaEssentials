package Basic.AADesign;

import java.util.*;

class Contact {
	
	private String name;
	private String number;
	
	private Contact(String name, String number) {
		super();
		this.name = name;
		this.number = number;
	}


	public String getName() {
		return name;
	}

	public String getNumber() {
		return number;
	}

	public static Contact createContact(String name, String number){//factory
		return new Contact(name,number);
	}
	
	
}

class MobilePhone {

	private String number;
	private ArrayList<Contact> myContacts;
	
	public MobilePhone(String myNumber){
		this.number = myNumber;
		myContacts = new ArrayList<Contact>();
	}
	
	public int findContact(String name){
		
		for (int i = 0; i < myContacts.size(); i++){
			Contact c = myContacts.get(i);
			if (c.getName().equals(name)){
				return i;
			}
		}
		
		return -1;
	}
	
	public int findContact(Contact contact){
		return myContacts.indexOf(contact);
	}
	
	public boolean addNewContact(Contact contact){
		if (findContact(contact.getName()) >= 0){
			System.out.println("Contact already exists");
			return false;
		}
		myContacts.add(contact);
		System.out.println("Added.");
		return true;
			
	}
	
	public boolean updateContact(Contact oldcontact, Contact newContact){
	
		int position = findContact(oldcontact);
		if (position < 0){
			System.out.println("Contact not exists");
			return false;
		}
		
		myContacts.set(position, newContact);
		System.out.println("Modified.");
		return true;
			
	}
	
	public boolean removeContact(Contact contact){
		
		int position = findContact(contact);
		if (position < 0){
			System.out.println("Contact not exists");
			return false;
		}
		
		myContacts.remove(position);
		System.out.println("Removed.");
		return true;
			
	}
	
	public String queryContact(Contact contact){
		if (findContact(contact.getName()) >= 0){
			return contact.getName();
		}
		
		return null;
	}
	
	public void printContacts(){
		for (Contact contact:myContacts){
			System.out.println(contact.getName() + " - " + contact.getNumber());
		}
	}
}

public class OOMobilePhoneApp {

	private static MobilePhone mobilePhone = new MobilePhone("11 22 33 44");
	
	public static void main(String[] args){
		
		Contact contact = Contact.createContact("Enver","0000000000");
		
		if (mobilePhone.addNewContact(contact)){
			System.out.println("New contact added");
		}
		
		Contact contact2 = Contact.createContact("Enver","111111111");
		if (mobilePhone.updateContact(contact, contact2)){
			System.out.println("Contact updated");
		}
		
		if (mobilePhone.removeContact(contact2)){
			System.out.println("Contact deleted");
		}
		
		mobilePhone.queryContact(contact);
		
	}
}
