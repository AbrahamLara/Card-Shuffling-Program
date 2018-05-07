package DeckOfCards;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;

public class CG extends CardIdentifier {

	static JFrame gui 		= new JFrame();
	
	JPanel p1 				= new JPanel();
	JPanel p2 				= new JPanel();
	JPanel p3 				= new JPanel();
	
	int randomlyChosenCard;
	
	JButton draw 			= new JButton("Draw");
	JButton shuffle 		= new JButton("Shuffle");
	
    JLabel jl1 				= new JLabel("Click \"Shuffle\" Button");
    
    static int[] card = new int[52];
    
    int index = -1;
    
    public CG() {
        
    	System.out.println("Order from Left to Right: Ace, 2-10, Joker, Queen, King\n");
        printImagesWithClubSuit();
        printImagesWithDiamondSuit();
        printImagesWithHeartSuit();
        printImagesWithSpadeSuit();
        
        GridBagConstraints g 	= new GridBagConstraints();
        
		Container container 	= gui.getContentPane();
		
		//JLabel
		p3.setLayout(new GridBagLayout());
		g.insets 	= new Insets(0,0,0,0);
		g.gridx 	= 0;
		g.gridy	 	= 0;
		g.anchor 	= GridBagConstraints.CENTER;
		
		p3.add(jl1, g);
		p3.setBackground(Color.WHITE);
		
		//Default Image on start
		JLabel defaultImg = new JLabel(new ImageIcon("img/0.png"));
		
		p1.add(defaultImg);
		p1.setBackground(Color.WHITE);
		
		//Buttons shuffle and draw
		p2.setBackground(Color.WHITE);
		p2.add(shuffle);
		draw.setEnabled(false);
		
		shuffle.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				index = -1;
				defaultImg.setIcon(new ImageIcon("img/shuffling.gif"));

			    shuffleArray(card);
			    
				shuffle.setEnabled(false);
				
				jl1.setText("Shuffling...");
				jl1.setForeground(Color.BLACK);
				draw.setEnabled(true);
				draw.setText("Draw");
				
			}
			
		});
		
		p2.add(draw);
		
		draw.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				//Randomly chosenCard
				try {
					randomlyChosenCard = card[++index];
				} catch(ArrayIndexOutOfBoundsException e1) {
					
				}
				
				if(hasClubSuit(randomlyChosenCard)) jl1.setText(identifyClubCard(randomlyChosenCard)); 
				
				else if(hasDiamondSuit(randomlyChosenCard)) {
					
					jl1.setText(identifyDiamondCard(randomlyChosenCard));
					jl1.setForeground(Color.RED);
					
				} else if(hasHeartSuit(randomlyChosenCard)) {
					
					jl1.setText(identifyHeartCard(randomlyChosenCard));
					jl1.setForeground(Color.RED);
					
				} else if(hasSpadeSuit(randomlyChosenCard)) jl1.setText(identifySpadeCard(randomlyChosenCard));
					
				else jl1.setText("Error: Card could not be Identified");
				
				System.out.println("\nRandomly Chosen Image: " + randomlyChosenCard);
				
				defaultImg.setIcon(new ImageIcon("img/"+ randomlyChosenCard + ".png"));
				
				shuffle.setEnabled(true);
				shuffle.setText("Shuffle");
			}
			
		});
		
		container.add(p1, BorderLayout.PAGE_START);
		container.add(p3, BorderLayout.CENTER);
		container.add(p2, BorderLayout.PAGE_END);
    	
    }
    
    public void shuffleArray(int[] array)
    {
        int index;
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--)
        {
            index = random.nextInt(i + 1);
            if (index != i)
            {
                array[index] ^= array[i];
                array[i] ^= array[index];
                array[index] ^= array[i];
            }
        }
    }
    
	public static void main(String[] args) {
		
		for(int i = 0; i < 52; i++) card[i] = i+1;
		
		System.err.println("Note: There are 2 Queen of Spades, 2 Joker of Diamonds, and 2 nine of \nClubs in \"img\" folder. If there is any mismatch, that is why.\n");
		
		gui.setTitle("Card Shuffling Program");
		gui.setMinimumSize(new Dimension(200,200));
		gui.setSize(300,300);
		gui.setLocationRelativeTo(null);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		new CG();
		gui.setVisible(true);
	}
}