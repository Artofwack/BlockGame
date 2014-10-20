import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * ARTURO POLANCO CARRILLO
 * 01200720
 * 10/15/2014
 * Block Game
 */
class Game extends JPanel {
	private       ArrayList<JButton> list;
	private       JButton            button1;
	private       JButton            button2;
	private       JButton            button3;
	private       JButton            button4;
	private       JButton            button5;
	private       JButton            button6;
	private       JButton            button7;
	private       JButton            button8;
	private       JButton            button9;
	private static int               tilesMoved;
	public JLabel moves;

	public Game() {
		this.setLayout( new GridLayout( 3, 3 ) );
		list = new ArrayList<>();
		button1 = new JButton( "1" );
		button2 = new JButton( "2" );
		button3 = new JButton( "3" );
		button4 = new JButton( "4" );
		button5 = new JButton( "5" );
		button6 = new JButton( "6" );
		button7 = new JButton( "7" );
		button8 = new JButton( "8" );
		button9 = new JButton( "X" );

		moves = new JLabel();

		list.add( button1 );
		list.add( button2 );
		list.add( button3 );
		list.add( button4 );
		list.add( button5 );
		list.add( button6 );
		list.add( button7 );
		list.add( button8 );
		list.add( button9 );

		button1.addActionListener( e -> {
			swap( button2, button1 );
			swap( button4, button1 );
		} );

		button2.addActionListener( e -> {
			swap( button1, button2 );
			swap( button3, button2 );
			swap( button5, button2 );
		} );

		button3.addActionListener( e -> {
			swap( button2, button3 );
			swap( button6, button3 );
		} );

		button4.addActionListener( e -> {
			swap( button1, button4 );
			swap( button5, button4 );
			swap( button7, button4 );
		} );

		button5.addActionListener( e -> {
			swap( button2, button5 );
			swap( button4, button5 );
			swap( button6, button5 );
			swap( button8, button5 );
		} );

		button6.addActionListener( e -> {
			swap( button3, button6 );
			swap( button5, button6 );
			swap( button9, button6 );
		} );

		button7.addActionListener( e -> {
			swap( button4, button7 );
			swap( button8, button7 );
		} );

		button8.addActionListener( e -> {
			swap( button5, button8 );
			swap( button7, button8 );
			swap( button9, button8 );
		} );

		button9.addActionListener( e -> {
			swap( button6, button9 );
			swap( button8, button9 );
			if ( win() )
				newGame();
		} );

		newGame();
		list.forEach( this::add );
		this.setVisible( true );
	}

	private boolean win() {
		if ( button1.getText().equals( "1" ) && button2.getText().equals( "2" ) && button3.getText().equals( "3" ) )
			if ( button4.getText().equals( "4" ) && button5.getText().equals( "5" ) && button6.getText().equals( "6" ) )
				if ( button7.getText().equals( "7" ) && button8.getText().equals( "8" ) && button9.getText().equals( "X" ) ) {
					JOptionPane.showMessageDialog( this, "You Won!\nMoves: " + tilesMoved, "Winner!", JOptionPane.INFORMATION_MESSAGE );
					return true;
				}
		return false;
	}

	private void swap( JButton jButton, JButton jButton2 ) {
		if ( jButton.getText().equals( "X" ) ) {
			jButton.setText( jButton2.getText() );
			jButton2.setText( "X" );
			jButton2.setVisible( false );
			jButton.setVisible( true );
			jButton.setEnabled( true );
			jButton2.setEnabled( false );
			moves.setText( "Moves: " + ++tilesMoved );
		}
	}

	public void newGame() {
		Random move = new Random();
		int move2;
		int j = 0;

		do {
			move2 = move.nextInt( 5 );

				/* 1,3,7,9 */
			if ( move2 < 2 ) {
				swap( button1, button2 );
				swap( button3, button2 );
				swap( button7, button4 );
				swap( button9, button6 );
			}
			else {
				swap( button1, button4 );
				swap( button3, button6 );
				swap( button7, button8 );
				swap( button9, button8 );
			}

				/* 2,4,6,8 */
			if ( move2 < 1 ) {
				swap( button2, button1 );
				swap( button4, button1 );
				swap( button6, button3 );
				swap( button8, button7 );
			}
			else if ( 1 >= move2 && move2 <= 2 ) {
				swap( button2, button5 );
				swap( button4, button5 );
				swap( button6, button5 );
				swap( button8, button5 );
			}
			else if ( move2 > 2 ) {
				swap( button2, button3 );
				swap( button4, button7 );
				swap( button6, button9 );
				swap( button8, button9 );
			}

				/* 5 */
			if ( move2 < 1 )
				swap( button5, button2 );
			else if ( move2 >= 1 && move2 < 2 )
				swap( button5, button4 );
			else if ( move2 >= 2 && move2 < 3 )
				swap( button5, button6 );
			else if ( move2 >= 3 )
				swap( button5, button8 );

			j++;
		} while ( j < 1000 );

		tilesMoved = 0;
		moves.setText( "Moves: " + tilesMoved );
	}
}