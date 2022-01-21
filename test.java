import javax.swing.*;


public class test{
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable(){;
			public void run(){
				Converter fenetre = new Converter();
				fenetre.setVisible(true);

				double euro = 1;
				double dollas = 50;
			/* Verification les fonction toDollars() toEuro() setTaux()


			
				System.out.println(fenetre.toEuros(euro));
				System.out.println(fenetre.toDollars(dollas));
				fenetre.setTaux(2.5);
				System.out.println(fenetre.toEuros(euro));
				System.out.println(fenetre.toDollars(dollas)); 

			*/
				
			}
		});





	}
	

}