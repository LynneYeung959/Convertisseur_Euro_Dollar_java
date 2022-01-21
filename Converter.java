import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Converter extends JFrame implements ActionListener{

	private double taux = 1.09;

	//Label to identify the fields
	private JLabel euroLabel;
	private JLabel dollarsLabel;
	private JLabel tauxLable;

	//Boutons
	private JButton b1 = new JButton("+");
	private JButton b2 = new JButton("-");
	private JButton b3 = new JButton("QUITTER");


	//case à saisir les texts
	private JTextField valeureuros = new JTextField();
	private JTextField valeurdollars = new JTextField();
	private JTextField valeurtaux = new JTextField();

	public Converter(){
		super();
		build();


		b3.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked (MouseEvent ev)
			{
				if ((JButton)ev.getSource() == b3){
					setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  				//estVisible(false);
  					dispose();	
				}
			}
		} );



	}

	private void build(){
		setTitle("Convertisseur"); // on donne un titre à l'application
		setSize(320,240); // on donne une taille à notre fenêtre
		setLocationRelativeTo(null);// on centre la fenêtre sur l'écran
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(buildContentPane());
	}

	private JPanel buildContentPane(){
		JPanel panel = new JPanel();
		//panel.setLayout(new FlowLayout());
	
		valeureuros.setColumns(8);
		valeureuros.setEditable(true);
		panel.add(valeureuros);
		valeureuros.addActionListener(this);

		euroLabel =  new JLabel("€  => ");
		panel.add(euroLabel);

		
		valeurdollars.setColumns(8);
		valeurdollars.setEditable(true);
		panel.add(valeurdollars);
		valeurdollars.addActionListener(this);

		dollarsLabel = new JLabel("$");
		panel.add(dollarsLabel);

		tauxLable = new JLabel("TAUX : 1 € =");
		panel.add(tauxLable);
		
		valeurtaux.setColumns(5); //ajouter le case à saisir le taux
		valeurtaux.setEditable(true);
		panel.add(valeurtaux);
		valeurtaux.addActionListener(this);
		//textField.addPropertyChangeListener("value",this);
		 
		panel.add(b1);
		panel.add(b2);
		panel.add(b3);

		return panel;
	}

	// Convertit s de dollars en euro
	public double toDollars(double s){ 
		return s/taux;
	}

	// Convertir s d'euros en dollars
	public double toEuros(double s){
		return s*taux;
	}
	// set le taux
	public void setTaux(double t){
		taux = t;
		System.out.println(taux);
	}


	//les actions sur les valeur saisies
	public void actionPerformed(ActionEvent e){
		// mise à jour le taux
		if (e.getSource() == valeurtaux){ // if action est le case de taux
			String s = valeurtaux.getText(); //recuperer la valeur saisie
			double newTaux = Double.parseDouble(s); //transforme en double
			this.setTaux(newTaux); //set le taux
			double euro = Double.parseDouble(valeureuros.getText());
			valeurdollars.setText(String.valueOf(toEuros(euro)));

		}
		if (e.getSource() == valeureuros){ //if action est dans le case de euro
			double euro = Double.parseDouble(valeureuros.getText());
			valeurdollars.setText(String.valueOf(toEuros(euro)));
					
		}
		if (e.getSource() == valeurdollars){ //if action est dans le case de dollars
			double dollars = Double.parseDouble(valeurdollars.getText());
			valeureuros.setText(String.valueOf(toDollars(dollars)));

		}

	}


}