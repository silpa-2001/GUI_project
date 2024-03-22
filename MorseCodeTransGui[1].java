import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MorseCodeTrans extends JFrame {

    private JTextField inputTextField;
    private JTextArea outputTextArea;

    public MorseCodeTrans() {
        setTitle("Morse Code Translator");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Input panel
        JPanel inputPanel = new JPanel();
        JLabel inputLabel = new JLabel("Input:");
        inputTextField = new JTextField(20);
        inputPanel.add(inputLabel);
        inputPanel.add(inputTextField);

        // Output panel
        JPanel outputPanel = new JPanel();
        JLabel outputLabel = new JLabel("Output:");
        outputTextArea = new JTextArea(10, 20);
        outputTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputTextArea);
        outputPanel.add(outputLabel);
        outputPanel.add(scrollPane);

        // Translate button
        JButton translateButton = new JButton("Translate");
        translateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                translate();
            }
        });

        // Button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(translateButton);

        // Main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(inputPanel);
        mainPanel.add(outputPanel);
        mainPanel.add(buttonPanel);

        add(mainPanel);
        setVisible(true);
    }

    private void translate() {
        String input = inputTextField.getText();
        if (!input.isEmpty()) {
            try {
                String result;
                if (input.matches("[.-/ ]+")) { // Morse code input
                    result = morseToText(input);
                } else { // Text input
                    result = textToMorse(input);
                }
                outputTextArea.setText(result);
            } catch (Exception e) {
                outputTextArea.setText("Error: " + e.getMessage());
            }
        } else {
            outputTextArea.setText("Input is empty.");
        }
    }

   public static String textToMorse(String text) {
    StringBuilder morseCode = new StringBuilder();
    for (int i = 0; i < text.length(); i++) {
        char cha = Character.toUpperCase(text.charAt(i));
        String morseChar = charToMorse(cha);
        if (morseChar != null) {
            morseCode.append(morseChar).append(" ");
        } else {
            morseCode.append(" ");
        }
    }
    return morseCode.toString();
}

public static String morseToText(String morseCode) {
    StringBuilder text = new StringBuilder();
    String[] morseWords = morseCode.split("  ");
    for (String morseWord : morseWords) {
        String[] morseChars = morseWord.split(" ");
        for (String morseChar : morseChars) {
            char textChar = morseToChar(morseChar);
            text.append(textChar);
        }
        text.append(" ");
    }
    return text.toString().trim();
}

private static String charToMorse(char ch) {
    switch (ch) {
        case 'A':
            return ".-";
        case 'B':
            return "-...";
        case 'C':
            return "-.-.";
        case 'D':
            return "-..";
        case 'E':
            return ".";
        case 'F':
            return "..-.";
        case 'G':
            return "--.";
        case 'H':
            return "....";
        case 'I':
            return "..";
        case 'J':
            return ".---";
        case 'K':
            return "-.-";
        case 'L':
            return ".-..";
        case 'M':
            return "--";
        case 'N':
            return "-.";
        case 'O':
            return "---";
        case 'P':
            return ".--.";
        case 'Q':
            return "--.-";
        case 'R':
            return ".-.";
        case 'S':
            return "...";
        case 'T':
            return "-";
        case 'U':
            return "..-";
        case 'V':
            return "...-";
        case 'W':
            return ".--";
        case 'X':
            return "-..-";
        case 'Y':
            return "-.--";
        case 'Z':
            return "--..";
        case '1':
            return ".----";
        case '2':
            return "..---";
        case '3':
            return "...--";
        case '4':
            return "....-";
        case '5':
            return ".....";
        case '6':
            return "-....";
        case '7':
            return "--...";
        case '8':
            return "---..";
        case '9':
            return "----.";
        case '0':
            return "-----";
        case '.':
            return ".-.-.-";
        case ',':
            return "--..--";
        case '?':
            return "..--..";
        case ' ':
            return "/";
        default:
            return null;
    }
}

private static char morseToChar(String morseCh) {
    switch (morseCh) {
        case ".-":
            return 'A';
        case "-...":
            return 'B';
        case "-.-.":
            return 'C';
        case "-..":
            return 'D';
        case ".":
            return 'E';
        case "..-.":
            return 'F';
        case "--.":
            return 'G';
        case "....":
            return 'H';
        case "..":
            return 'I';
        case ".---":
            return 'J';
        case "-.-":
            return 'K';
        case ".-..":
            return 'L';
        case "--":
            return 'M';
        case "-.":
            return 'N';
        case "---":
            return 'O';
        case ".--.":
            return 'P';
        case "--.-":
            return 'Q';
        case ".-.":
            return 'R';
        case "...":
            return 'S';
        case "-":
            return 'T';
        case "..-":
            return 'U';
        case "...-":
            return 'V';
        case ".--":
            return 'W';
        case "-..-":
            return 'X';
        case "-.--":
            return 'Y';
        case "--..":
            return 'Z';
        case ".----":
            return '1';
        case "..---":
            return '2';
        case "...--":
            return '3';
        case "....-":
            return '4';
        case ".....":
            return '5';
        case "-....":
            return '6';
        case "--...":
            return '7';
        case "---..":
            return '8';
        case "----.":
            return '9';
        case "-----":
            return '0';
        case ".-.-.-":
            return '.';
        case "--..--":
            return ',';
        case "..--..":
            return '?';
        case "/":
            return ' ';
        default:
            return '\0';
    }
}
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MorseCodeTrans();
            }
        });
    }
}
