package observer;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import domain.Covid19Pacient;
import domain.Symptom;
import factory.SymptomFactory;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class PacientSymptomGUI extends JFrame {
	private JPanel contentPane;
	private JTextField weightField;
	JComboBox<Symptom> symptomComboBox;
	private JButton btnRemoveSymptom;
	private JLabel errorLabel;
	private JLabel lblPacient;
	private JLabel labelPacient;
	private SymptomFactory fs = new SymptomFactory();

	
	/**
	 * Create the frame.
	 */
	public PacientSymptomGUI(Covid19Pacient p) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSelectSymptom = new JLabel("Select Symptom");
		lblSelectSymptom.setBounds(32, 68, 100, 16);
		contentPane.add(lblSelectSymptom);
		
		symptomComboBox = new JComboBox<Symptom>();
		symptomComboBox.setBounds(195, 57, 192, 27);
		symptomComboBox.addItem(fs.createSymptom("fiebre"));
		symptomComboBox.addItem(fs.createSymptom("tos seca"));
		symptomComboBox.addItem(fs.createSymptom("astenia"));
		symptomComboBox.addItem(fs.createSymptom("expectoracion"));
		symptomComboBox.addItem(fs.createSymptom("disnea"));
		symptomComboBox.addItem(fs.createSymptom("dolor de garganta"));
		symptomComboBox.addItem(fs.createSymptom("cefalea"));
		symptomComboBox.addItem(fs.createSymptom("mialgia"));
		symptomComboBox.addItem(fs.createSymptom("escalofrios"));
		symptomComboBox.addItem(fs.createSymptom("náuseas o vómitos"));
		symptomComboBox.addItem(fs.createSymptom("diarrea"));
		symptomComboBox.addItem(fs.createSymptom("congestión nasal"));
		symptomComboBox.addItem(fs.createSymptom("hemoptisis"));
		symptomComboBox.addItem(fs.createSymptom("congestión conjuntival"));
			
		
		contentPane.add(symptomComboBox);
		
		JLabel lblSymptomWeight = new JLabel("Symptom weight");
		lblSymptomWeight.setBounds(32, 96, 125, 16);
		contentPane.add(lblSymptomWeight);
		
		weightField = new JTextField();
		weightField.setBounds(195, 91, 130, 26);
		contentPane.add(weightField);
		weightField.setColumns(10);
		
		JButton btnNewButton = new JButton("Add Symptom");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				errorLabel.setText(" ");
				if (new Integer(weightField.getText())<=3) {
		    	System.out.println("Symptom added :"+(Symptom)symptomComboBox.getSelectedItem());

		    	p.addSymptomByName(((Symptom)symptomComboBox.getSelectedItem()).getName(), new Integer(weightField.getText()));
				
			} else errorLabel.setText("ERROR, Weight between [1..3]");
				
			}
		});
		btnNewButton.setBounds(88, 202, 117, 29);
		contentPane.add(btnNewButton);
		
		btnRemoveSymptom = new JButton("Remove Symptom");
		btnRemoveSymptom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				errorLabel.setText(" ");

		    	System.out.println("Symptom removed :"+(Symptom)symptomComboBox.getSelectedItem());

		    	p.removeSymptomByName(((Symptom)symptomComboBox.getSelectedItem()).getName());
				
			} 
		});
		btnRemoveSymptom.setBounds(255, 202, 147, 29);
		contentPane.add(btnRemoveSymptom);
		
		errorLabel = new JLabel("");
		errorLabel.setBounds(117, 146, 238, 16);
		contentPane.add(errorLabel);
		
		lblPacient = new JLabel("Pacient:");
		lblPacient.setBounds(210, 17, 61, 16);
		contentPane.add(lblPacient);
		
	    labelPacient = new JLabel("New label");
		labelPacient.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		labelPacient.setBounds(271, 17, 131, 16);
		labelPacient.setText(p.getName());

		contentPane.add(labelPacient);
		this.setVisible(true);
	}
}
