import java.awt.event.*;
import javax.swing.*;

public class Setup extends JFrame implements ActionListener {

    private final InputHandler input_handler = new InputHandler();
    private final JFrame frame;


    public Setup(){
        this.frame = new JFrame();

        SetupGame();

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String difficulty = e.getActionCommand();
        switch(difficulty){
            case "Easy" -> new Game(8,8,10);
            case "Medium" ->  new Game(16,16, 40);
            case "Hard" -> new Game(16, 30, 99);

        }
    }


    // Let the user select a grid to play
    public void SetupGame(){
        JPanel panel = new JPanel();
        JLabel label = new JLabel("===== WELCOME TO MINESWEEPER =====");
        panel.add(label);

        JButton button = new JButton("Easy");
        button.addActionListener(this);
        panel.add(button);

        button = new JButton("Medium");
        button.addActionListener(this);
        panel.add(button);

        button = new JButton("Hard");
        button.addActionListener(this);
        panel.add(button);

        this.frame.add(panel);
        this.frame.pack();
        this.frame.setVisible(true);
        /*

        String[] grid_options = {"EASY", "MEDIUM", "HARD", "CUSTOM"};
        int grid_input = SelectGrid(grid_options);

        Game game = null;
        switch (grid_input) {
            case 0 -> game = new Game(8, 8, 10); // EASY
            case 1 -> game = new Game(16, 16, 40); // MEDIUM
            case 2 -> game = new Game(16, 30, 99); // HARD
            case 3 -> { // CUSTOM
                int custom_rows = input_handler.InputInteger("Enter number of rows (minimum of 1): ", 1, null);
                int custom_columns = input_handler.InputInteger("Enter number of columns (minimum of " + (custom_rows == 1 ? 2 : 1) + "): ", (custom_rows == 1 ? 2 : 1), null);

                int max_bombs = custom_columns * custom_rows - 1;
                int custom_bombs = input_handler.InputInteger("Enter number of bombs (minimum of 1, maximum of " + max_bombs + "):", 0, max_bombs);

                game = new Game(custom_rows, custom_columns, custom_bombs);
            }
        }
        game.PlayGame(); // Begin game

         */


    }

    public int SelectGrid(String[] menu_options){
        int menu_input = -1;
        boolean menu_confirm = false;

        while(!menu_confirm) {
            menu_input = input_handler.InputInteger("""
                            Choose your grid:
                            0 - EASY (10x10 - 10 bombs)
                            1 - MEDIUM (16x16 - 40 bombs)
                            2 - HARD (30x16 - 99 bombs)
                            3 - CUSTOM
                            Please select [0-3]""",
                    0, 3);

            // Confirm menu selection
            String[] options = {"Y", "N"};
            String confirm_input = input_handler.InputMenu(("You have chosen " + menu_options[menu_input] + ". Is this correct? [Y/N]"),
                    options);

            if(confirm_input.equals("Y")) menu_confirm = true;
        }
        return menu_input;
    }


}
