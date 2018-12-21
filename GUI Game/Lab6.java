import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.Color;
import java.util.Random;
import java.lang.*;

public class Lab6 extends JFrame
{
  private ButtonGroup color;
  private ButtonGroup maxTime;
  private JButton game;
  private JLabel title;
  private JLabel guess;
  private JLabel instructions;
  private ImageIcon clock;
  private JPanel p1;
  private JPanel p2;
  private JPanel p3;
  private JRadioButton twentySec;
  private JRadioButton twentyfiveSec;
  private JRadioButton greyscale;
  private JRadioButton bluescale;
  private Random r = new Random();
  private JTextField currentGuess;

  private int i = 0;
  private int maxTimeLimit;
  private int rand;
  private long startTime;
  private String userGuess;
  private Timer timer;

  public Lab6()
  {
    super("Clock Game");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new BorderLayout());

    guess = new JLabel("Guess:");
    instructions = new JLabel("Click New Game to Begin");
    game = new JButton("New Game");

    clock = new ImageIcon("clock.jpg");
    title = new JLabel("The Clock Game", clock, SwingConstants.CENTER);

    currentGuess = new JTextField(10);

    twentySec = new JRadioButton("20 seconds to guess");
    twentyfiveSec = new JRadioButton("25 seconds to guess");
    greyscale = new JRadioButton("greyscale");
    bluescale = new JRadioButton("bluescale");
    color = new ButtonGroup();
    maxTime = new ButtonGroup();

    timer = new Timer(maxTimeLimit, new TimerListener());

    p1 = new JPanel();
    p2 = new JPanel();
    p3 = new JPanel();

    game.addActionListener(new Click());
    currentGuess.addActionListener(new Click());

    p1.add(title);
    p1.add(guess);
    p1.add(currentGuess);
    p1.add(game);
    currentGuess.setEditable(false);
    this.add(p1, BorderLayout.NORTH);

    color.add(greyscale);
    color.add(bluescale);
    maxTime.add(twentySec);
    maxTime.add(twentyfiveSec);
    p2.add(twentySec);
    p2.add(twentyfiveSec);
    p2.add(greyscale);
    p2.add(bluescale);
    this.add(p2, BorderLayout.CENTER);

    p3.add(instructions);
    p3.setBackground(Color.GRAY);
    this.add(p3, BorderLayout.SOUTH);

    this.setSize(740,175);
    this.setVisible(true);
  }

  private class Click implements ActionListener
  {
    public void actionPerformed (ActionEvent e)
    {
      if (e.getSource() == game && currentGuess.getText().equals("")) //start of game
      {
        if (twentySec.isSelected()) //determines time limit
        {
          timer = new Timer(20000, new TimerListener()); //20 seconds
        }
        else if (twentyfiveSec.isSelected())
        {
          timer = new Timer(25000, new TimerListener()); //25 seconds
        }
        else
        {
          timer = new Timer(30000, new TimerListener()); //default - 30 seconds
        }

        if (bluescale.isSelected()) //color when game starts
        {
          p3.setBackground(Color.BLUE);
        }
        else if (greyscale.isSelected())
        {
          p3.setBackground(Color.GRAY);
        }
        else
        {
          p3.setBackground(Color.YELLOW);
        }

        rand = r.nextInt(1000) + 1;
        instructions.setText("The price is between $1 and $1000, begin.");

        currentGuess.setEditable(true);
        currentGuess.requestFocus();

        startTime = System.nanoTime(); //determines how long it took user to guess
        timer.start(); //counts to maxtime starting here
      }
      else if (e.getSource() == game)
      {
        int g = Integer.parseInt(currentGuess.getText()); //String to int

        if (g > rand)
        {
          instructions.setText("Too high");

          if (bluescale.isSelected()) //changes color of instructions if too high
          {
            Color darkBlue = new Color(0,25,51);
            p3.setBackground(darkBlue);
          }
          else if (greyscale.isSelected())
          {
            Color darkGrey = new Color(64, 64, 64);
            p3.setBackground(darkGrey);
          }
          else
          {
            p3.setBackground(Color.RED);
          }

          currentGuess.selectAll();
          currentGuess.requestFocus();
          i++; //adds a try
        }
        else if (g < rand)
        {
          instructions.setText("Too low");

          if (bluescale.isSelected()) //changes color of instructions if too low
          {
            Color lightBlue = new Color(102,178,255);
            p3.setBackground(lightBlue);
          }
          else if (greyscale.isSelected())
          {
            Color lightGrey = new Color(192, 192, 192);
            p3.setBackground(lightGrey);
          }
          else
          {
            p3.setBackground(Color.ORANGE);
          }

          currentGuess.selectAll();
          currentGuess.requestFocus();
          i++; //adds a try
        }
        else if (g == rand)
        {
          i++;

          timer.stop();
          long elapsedTimeNs = (System.nanoTime() - startTime)/1000000000L;

          instructions.setText("Correct! It took you " + i + " tries and " + elapsedTimeNs + " seconds");
          p3.setBackground(Color.GREEN);

          currentGuess.setText(""); //so the user can play again if they click the button
          currentGuess.setEditable(false);
        }
        else
        {
          //nothing
        }
      }
    }
  }

  private class TimerListener implements ActionListener
  {
    public void actionPerformed (ActionEvent e) //triggered when timer hits maxtime
    {
      timer.stop();
      currentGuess.setEditable(false);
      p3.setBackground(Color.GRAY);
      instructions.setText("You lose! You ran out of time. Press 'New Game' to try again.");
    }
  }

  public static void main(String[] args)
  {
    new Lab6();
  }
}
