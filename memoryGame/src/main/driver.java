package main;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class profile {
	String name;
	String car;
	String plate;
}


public class driver {
	
	public static String licensePlate() {
		String letters = "";
		int x=0;
		while(x<3) {
			Random r = new Random();
			letters = letters + (char)(r.nextInt(26) + 'A');
			x=x+1;
		}
		return letters + "·" + ThreadLocalRandom.current().nextInt(1000, 9999 + 1);
	}
	
	public static String car(ArrayList<String> colors, ArrayList<String> makes) {

		return colors.get((new Random()).nextInt(colors.size())) + " " + makes.get((new Random()).nextInt(makes.size()));
	}
	
	public static String name(ArrayList<String> first, ArrayList<String> last) {
		return first.get((new Random()).nextInt(first.size())) + " " + last.get((new Random()).nextInt(last.size()));
	}
	
	public static void makeAnswersName(profile one, profile two, profile three, profile four, JButton button1, JButton button2, JButton button3, JButton button4) {
		ArrayList<String> profiles = new ArrayList<String>();
		profiles.add(one.name);
		profiles.add(two.name);
		profiles.add(three.name);
		profiles.add(four.name);
		Collections.shuffle(profiles);
		button1.setText(profiles.get(0));
		button2.setText(profiles.get(1));
		button3.setText(profiles.get(2));
		button4.setText(profiles.get(3));
	}
	
	public static void makeAnswersCar(profile one, profile two, profile three, profile four, JButton button1, JButton button2, JButton button3, JButton button4) {
		ArrayList<String> profiles = new ArrayList<String>();
		profiles.add(one.car);
		profiles.add(two.car);
		profiles.add(three.car);
		profiles.add(four.car);
		Collections.shuffle(profiles);
		button1.setText(profiles.get(0));
		button2.setText(profiles.get(1));
		button3.setText(profiles.get(2));
		button4.setText(profiles.get(3));
	}
	
	public static void makeAnswersPlate(profile one, profile two, profile three, profile four, JButton button1, JButton button2, JButton button3, JButton button4) {
		ArrayList<String> profiles = new ArrayList<String>();
		profiles.add(one.plate);
		profiles.add(two.plate);
		profiles.add(three.plate);
		profiles.add(four.plate);
		Collections.shuffle(profiles);
		button1.setText(profiles.get(0));
		button2.setText(profiles.get(1));
		button3.setText(profiles.get(2));
		button4.setText(profiles.get(3));
	}
	
	public static profile makePerson(ArrayList<String> colors, ArrayList<String> makes, ArrayList<String> first, ArrayList<String> last) {
		profile retVal = new profile();
		retVal.car=car(colors, makes);
		retVal.name= name(first, last);
		retVal.plate=licensePlate();
		return retVal;
	}
	
	public static void main(String[] args) throws IOException {
		
		ArrayList<String> colors = new ArrayList<String>();
		colors.add("Red");
		colors.add("Orange");
		colors.add("Green");
		colors.add("Blue");
		colors.add("White");
		colors.add("Black");
		colors.add("Gray");
		colors.add("Silver");
		colors.add("Tan");
		
		ArrayList<String> makes = new ArrayList<String>();
		makes.add("Acura");
		makes.add("Buick");
		makes.add("BMW");
		makes.add("Mini");
		makes.add("Ford");
		makes.add("Jeep");
		makes.add("Toyota");
		makes.add("Nissan");
		makes.add("Honda");
		makes.add("Hyundai");
		makes.add("Chevy");
		makes.add("Chrystler");
		makes.add("Dodge");
		makes.add("Ram");
		makes.add("Tesla");
		makes.add("Saab");
		makes.add("Mercury");
		makes.add("Audi");
		makes.add("Infinity");
		makes.add("Mitsubishi");
		
		ArrayList<String> first = new ArrayList<String>();
		String filename = "src/main/firstNames.txt";
		for(String line : Files.readAllLines(Paths.get(filename))) {
			String[] data = line.split(" ");
			first.add(data[0]);
		}
		
		ArrayList<String> last = new ArrayList<String>();
		String filename1 = "src/main/lastNames.txt";
		for(String line : Files.readAllLines(Paths.get(filename1))) {
			String[] data = line.split(" ");
			last.add(data[1]);
		}
		
		profile one = makePerson(colors, makes, first, last);
		profile two = makePerson(colors, makes, first, last);
		profile three = makePerson(colors, makes, first, last);
		profile four = makePerson(colors, makes, first, last);
		
		ArrayList<String> questions = new ArrayList<String>();
		questions.add("Who drives the " + one.car + "?");
		questions.add("Who's license plate is " + one.plate + "?");
		questions.add("What car does " + one.name + " drive?");
		questions.add("What is " + one.name + "'s license plate?");
		questions.add("Who drives the " + two.car + "?");
		questions.add("Who's license plate is " + two.plate + "?");
		questions.add("What car does " + two.name + " drive?");
		questions.add("What is " + two.name + "'s license plate?");
		questions.add("Who drives the " + three.car + "?");
		questions.add("Who's license plate is " + three.plate + "?");
		questions.add("What car does " + three.name + " drive?");
		questions.add("What is " + three.name + "'s license plate?");
		questions.add("Who drives the " + four.car + "?");
		questions.add("Who's license plate is " + four.plate + "?");
		questions.add("What car does " + four.name + " drive?");
		questions.add("What is " + four.name + "'s license plate?");
		
		ArrayList<String> answers = new ArrayList<String>();
		answers.add(one.name);
		answers.add(one.name);
		answers.add(one.car);
		answers.add(one.plate);
		answers.add(two.name);
		answers.add(two.name);
		answers.add(two.car);
		answers.add(two.plate);
		answers.add(three.name);
		answers.add(three.name);
		answers.add(three.car);
		answers.add(three.plate);
		answers.add(four.name);
		answers.add(four.name);
		answers.add(four.car);
		answers.add(four.plate);
		


		
		Random rand = new Random();
		int  n = rand.nextInt(questions.size());
		
		
		JFrame frame = new JFrame();
		frame.setLayout(null);
		frame.setSize(500,700);
		
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		
		JLabel firstPeronLabel = new JLabel("First Person:");
		firstPeronLabel.setBounds(0,0,300,25);
		firstPeronLabel.setFont(new Font("Ariel", Font.PLAIN, 30));
		frame.add(firstPeronLabel);
		
		JLabel firstPersonName = new JLabel(one.name);
		firstPersonName.setBounds(0,25,300,25);
		firstPersonName.setFont(new Font("Ariel", Font.PLAIN, 30));
		frame.add(firstPersonName);
		
		JLabel firstPersonCar = new JLabel(one.car);
		firstPersonCar.setBounds(0,50,300,25);
		firstPersonCar.setFont(new Font("Ariel", Font.PLAIN, 30));
		frame.add(firstPersonCar);
		
		JLabel firstPersonPlate = new JLabel(one.plate);
		firstPersonPlate.setBounds(0,75,300,25);
		firstPersonPlate.setFont(new Font("Ariel", Font.PLAIN, 30));
		frame.add(firstPersonPlate);
		
		JLabel secondPersonLabel = new JLabel("Second Person:");
		secondPersonLabel.setBounds(0,125,300,25);
		secondPersonLabel.setFont(new Font("Ariel", Font.PLAIN, 30));
		frame.add(secondPersonLabel);
		
		JLabel secondPersonName = new JLabel(two.name);
		secondPersonName.setBounds(0,150,300,25);
		secondPersonName.setFont(new Font("Ariel", Font.PLAIN, 30));
		frame.add(secondPersonName);
		
		JLabel secondPersonCar = new JLabel(two.car);
		secondPersonCar.setBounds(0,175,300,25);
		secondPersonCar.setFont(new Font("Ariel", Font.PLAIN, 30));
		frame.add(secondPersonCar);
		
		JLabel secondPersonPlate = new JLabel(two.plate);
		secondPersonPlate.setBounds(0,200,300,25);
		secondPersonPlate.setFont(new Font("Ariel", Font.PLAIN, 30));
		frame.add(secondPersonPlate);
		
		JLabel thirdPersonLabel = new JLabel("Third Person:");
		thirdPersonLabel.setBounds(0,250,300,25);
		thirdPersonLabel.setFont(new Font("Ariel", Font.PLAIN, 30));
		frame.add(thirdPersonLabel);
		
		JLabel thirdPersonName = new JLabel(three.name);
		thirdPersonName.setBounds(0,275,300,25);
		thirdPersonName.setFont(new Font("Ariel", Font.PLAIN, 30));
		frame.add(thirdPersonName);
		
		JLabel thirdPersonCar = new JLabel(three.car);
		thirdPersonCar.setBounds(0, 300,300,25);
		thirdPersonCar.setFont(new Font("Ariel", Font.PLAIN, 30));
		frame.add(thirdPersonCar);
		
		JLabel thirdPersonPlate = new JLabel(three.plate);
		thirdPersonPlate.setBounds(0,325,300,25);
		thirdPersonPlate.setFont(new Font("Ariel", Font.PLAIN, 30));
		frame.add(thirdPersonPlate);
		
		JLabel fourthPersonLabel = new JLabel("Fourth Person:");
		fourthPersonLabel.setBounds(0,375,300,25);
		fourthPersonLabel.setFont(new Font("Ariel", Font.PLAIN, 30));
		frame.add(fourthPersonLabel);
		
		JLabel fourthPersonName = new JLabel(four.name);
		fourthPersonName.setBounds(0,400,300,25);
		fourthPersonName.setFont(new Font("Ariel", Font.PLAIN, 30));
		frame.add(fourthPersonName);
		
		JLabel fourthPersonCar = new JLabel(four.car);
		fourthPersonCar.setBounds(0, 425,300,25);
		fourthPersonCar.setFont(new Font("Ariel", Font.PLAIN, 30));
		frame.add(fourthPersonCar);
		
		JLabel fourthPersonPlate = new JLabel(four.plate);
		fourthPersonPlate.setBounds(0,450,300,25);
		fourthPersonPlate.setFont(new Font("Ariel", Font.PLAIN, 30));
		frame.add(fourthPersonPlate);
		
		JButton moveOn = new JButton("Click here for test");
		moveOn.setBounds(100,550,300,25);
		moveOn.setFont(new Font("Ariel", Font.PLAIN, 20));
		frame.add(moveOn);
		frame.setVisible(true);
		
		
		JFrame quiz = new JFrame();
		quiz.setSize(750,750);
		quiz.setLayout(null);
		quiz.setDefaultCloseOperation(quiz.EXIT_ON_CLOSE);
		
		JLabel q1 = new JLabel(questions.get(n));
		q1.setBounds(0,50,750,100);
		q1.setFont(new Font("Ariel", Font.PLAIN, 35));
		quiz.add(q1);
		
		JButton button1 = new JButton("");
		button1.setBounds(10,200, 200, 200);
		quiz.add(button1);

		JButton button2 = new JButton("");
		button2.setBounds(210,200, 200, 200);
		quiz.add(button2);
		
		JButton button3 = new JButton("");
		button3.setBounds(10,410, 200, 200);
		quiz.add(button3);
		
		JButton button4 =  new JButton("");
		button4.setBounds(210,410,200,200);
		quiz.add(button4);
		
		JButton nextQ = new JButton("Next Question");
		nextQ.setBounds(10, 650, 160, 50);
		quiz.add(nextQ);
		
		if(n==0 || n==4 || n==8 || n==12) {
			makeAnswersName(one, two, three, four, button1, button2, button3, button4);
		} else if(n%4==1) {
			makeAnswersName(one, two, three, four, button1, button2, button3, button4);
		} else if(n%4==2) {
			makeAnswersCar(one, two, three, four, button1, button2, button3, button4);
		} else if (n%4==3) {
			makeAnswersPlate(one, two, three, four, button1, button2, button3, button4);
		}
		
		JFrame scoreBox = new JFrame();
		scoreBox.setLayout(null);
		scoreBox.setBounds(750,0,500,250);
		
		JLabel score = new JLabel("Score: ");
		score.setBounds(60, 10,150,40);
		score.setFont(new Font("Ariel", Font.PLAIN, 40));
		scoreBox.add(score);
		
		JLabel actScore = new JLabel("0");
		actScore.setBounds(200, 10, 50,40);
		actScore.setFont(new Font("Ariel", Font.PLAIN, 40));
		scoreBox.add(actScore);
		
		JLabel feedBack = new JLabel();
		feedBack.setBounds(25,100,250,50);
		feedBack.setFont(new Font("Ariel", Font.PLAIN, 40));
		scoreBox.add(feedBack);
		
		JLabel correctAnswer = new JLabel("");
		correctAnswer.setBounds(25,150,500,50);
		correctAnswer.setFont(new Font("Ariel", Font.PLAIN, 40));
		scoreBox.add(correctAnswer);
		
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(button1.getText().equals(answers.get(questions.indexOf(q1.getText())))) {
					actScore.setText(Integer.toString((Integer.parseInt(actScore.getText())+3)));
					feedBack.setText("Correct!");
					button1.setEnabled(false);
					button2.setEnabled(false);
					button3.setEnabled(false);
					button4.setEnabled(false);
				} else {
					actScore.setText(Integer.toString((Integer.parseInt(actScore.getText())-1)));
					feedBack.setText("Incorrect!");
					correctAnswer.setText(answers.get(questions.indexOf(q1.getText())));
					button1.setEnabled(false);
					button2.setEnabled(false);
					button3.setEnabled(false);
					button4.setEnabled(false);
				}
			}
		});
		
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(button2.getText().equals(answers.get(questions.indexOf(q1.getText())))) {
					actScore.setText(Integer.toString((Integer.parseInt(actScore.getText())+3)));
					feedBack.setText("Correct!");
					button1.setEnabled(false);
					button2.setEnabled(false);
					button3.setEnabled(false);
					button4.setEnabled(false);
				} else {
					actScore.setText(Integer.toString((Integer.parseInt(actScore.getText())-1)));
					feedBack.setText("Incorrect!");
					correctAnswer.setText(answers.get(questions.indexOf(q1.getText())));
					button1.setEnabled(false);
					button2.setEnabled(false);
					button3.setEnabled(false);
					button4.setEnabled(false);
				}
			}
		});
		
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(button3.getText().equals(answers.get(questions.indexOf(q1.getText())))) {
					actScore.setText(Integer.toString((Integer.parseInt(actScore.getText())+3)));
					feedBack.setText("Correct!");
					button1.setEnabled(false);
					button2.setEnabled(false);
					button3.setEnabled(false);
					button4.setEnabled(false);
				} else {
					actScore.setText(Integer.toString((Integer.parseInt(actScore.getText())-1)));
					feedBack.setText("Incorrect!");
					correctAnswer.setText(answers.get(questions.indexOf(q1.getText())));
					button1.setEnabled(false);
					button2.setEnabled(false);
					button3.setEnabled(false);
					button4.setEnabled(false);
				}
			}
		});
		
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(button4.getText().equals(answers.get(questions.indexOf(q1.getText())))) {
					actScore.setText(Integer.toString((Integer.parseInt(actScore.getText())+3)));
					feedBack.setText("Correct!");
					button1.setEnabled(false);
					button2.setEnabled(false);
					button3.setEnabled(false);
					button4.setEnabled(false);
				} else {
					actScore.setText(Integer.toString((Integer.parseInt(actScore.getText())-1)));
					feedBack.setText("Incorrect!");
					correctAnswer.setText(answers.get(questions.indexOf(q1.getText())));
					button1.setEnabled(false);
					button2.setEnabled(false);
					button3.setEnabled(false);
					button4.setEnabled(false);
				}
			}
		});
		

		
		moveOn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				quiz.setVisible(true);
				scoreBox.setVisible(true);
			}
		});
		
		nextQ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int  n = rand.nextInt(questions.size());
				q1.setText(questions.get(n));
				button1.setEnabled(true);
				button2.setEnabled(true);
				button3.setEnabled(true);
				button4.setEnabled(true);
				correctAnswer.setText("");
				feedBack.setText("");
				
				if(n%4==0) {
					makeAnswersName(one, two, three, four, button1, button2, button3, button4);
				} else if(n%4==1) {
					makeAnswersName(one, two, three, four, button1, button2, button3, button4);
				} else if(n%4==2) {
					makeAnswersCar(one, two, three, four, button1, button2, button3, button4);
				} else if (n%4==3) {
					makeAnswersPlate(one, two, three, four, button1, button2, button3, button4);
				}
				
			}
		});
		
		
		

		
	}
}
