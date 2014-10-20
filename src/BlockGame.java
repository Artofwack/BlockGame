import javax.swing.*;

/**
 * ARTURO POLANCO CARRILLO
 * 01200720
 * 10/15/2014
 * Block Game
 */
class BlockGame extends JFrame {

	BlockGame() {
		super( "Block Game" );
		Game game = new Game();

		JMenuBar menuBar = new JMenuBar();
		JMenu file = new JMenu( "File" );
		JMenuItem newGame = new JMenuItem( "New Game" );
		JMenuItem exit = new JMenuItem( "Exit" );

		newGame.addActionListener( e -> game.newGame() );
		exit.addActionListener( e -> System.exit( 0 ) );

		file.add( newGame );
		file.add( exit );
		menuBar.add( file );
		menuBar.add( game.moves );

		this.setContentPane( game );
		this.setJMenuBar( menuBar );
		this.setSize( 300, 400 );
		this.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
		this.setLocation( 500, 250 );
		this.setVisible( true );
		this.setResizable( false );
	}

	public static void main( String[] args ) {
		new BlockGame();
	}
}