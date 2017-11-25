import javax.swing.JOptionPane;

/**
* Unicode has been extended beyond the realm of a word, but in general
* You can use a hexadecimal word after \u to display unicode characters.
*/
public class DisplayUnicode {
	public static void main(String args[]) {
		JOptionPane.showMessageDialog(null,
		"\u6B22\u8FCE \u03b1 \u03b2 \u03b3",
		"\u6B22\u8FCE Welcome",
		JOptionPane.INFORMATION_MESSAGE);
	}
}