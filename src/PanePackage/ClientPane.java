package PanePackage;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ClientPane extends JPanel implements ValidatePane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3735811554537913150L;

    static String titleText = "Dane Klienta";
    static String nameText = "Imie:";
    static String lastNameText = "Nazwisko:";
    static String birthText = "Data urodzenia:";
    static String peselText = "PESEL:";
    static String citizenshipText = "Obywatelstwo:";
    static String passportText = "Nr paszportu/karta stałego pobytu:";
    static String streetText = "Ulica:";
    static String houseText = "Nr domu:";
    static String apartmentText = "Nr mieszkania";
    static String postCodeText = "Kod pocztowy:";
    static String cityText = "Miejscowość:";
    static String telephoneText = "Nr telefonu:";
    static String emailText = "E-mail:";

	static JTextField nameTextField = new JTextField(30);
	static JTextField lastNameTextField = new JTextField(30);
	static JTextField birthDateTextField = new JTextField(8);
	static JTextField peselTextField = new JTextField(11);
	static JTextField citizenshipTextField = new JTextField(30);
	static JTextField passportTextField = new JTextField(30);
	static JTextField streetTextField = new JTextField(30);
	static JTextField houseTextField = new JTextField(4);
	static JTextField apartmentTextField = new JTextField(4);
	static JTextField postCodeTextField = new JTextField(6);
	static JTextField cityTextField = new JTextField(30);
	static JTextField telephoneTextField = new JTextField(30);
	static JTextField emailTextField = new JTextField(30);	

	public ClientPane() {
		JLabel label = new JLabel(titleText);
		add(label);
		label = new JLabel(nameText);
		add(label);
		add(nameTextField);
		label = new JLabel(lastNameText);
		add(label);
		add(lastNameTextField);
		label = new JLabel(birthText);
		add(label);
		add(birthDateTextField);
		label = new JLabel(peselText);
		add(label);
		add(peselTextField);
		label = new JLabel(citizenshipText);
		add(label);
		add(citizenshipTextField);
		label = new JLabel(passportText);
		add(label);
		add(passportTextField);
		label = new JLabel(streetText);
		add(label);
		add(streetTextField);
		label = new JLabel(houseText);
		add(label);
		add(houseTextField);
		label = new JLabel(apartmentText);
		add(label);
		add(apartmentTextField);
		label = new JLabel(postCodeText);
		add(label);
		add(postCodeTextField);
		label = new JLabel(cityText);
		add(label);
		add(cityTextField);
		label = new JLabel(telephoneText);
		add(label);
		add(telephoneTextField);
		label = new JLabel(emailText);
		add(label);
		add(emailTextField);
	}
	
	public Boolean validatePaneData() {
		return false;
	}
}
