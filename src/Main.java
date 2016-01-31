import javax.swing.*;

public class Main {
	static JFrame frame;

	public static void main(String s[]) {

		frame = new MainFrame("JFrame Example");
		frame.setSize(300, 300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}
}