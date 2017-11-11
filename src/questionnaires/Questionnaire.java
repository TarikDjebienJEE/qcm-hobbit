package questionnaires;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @uml.dependency   supplier="questionnaires.Question"
 */
public class Questionnaire {

	/**
	 * les questions qui composent le questionnaire
	 * @uml.property  name="lesQuestions"
	 */
	private List<Question> lesQuestions;
	
	/**
	 * @uml.property  name="nbPoints"
	 */
	private int nbPoints;

	/**
	 */
	public Questionnaire(){
		this.lesQuestions = new ArrayList<Question>();
		this.nbPoints = 0;
	}

	/**
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws NoSuchMethodException 
	 * @throws ClassNotFoundException 
	 * @throws IllegalArgumentException 
	 * @throws SecurityException 
	 * @throws NumberFormatException 
	 */
	public Question createQuestion(String type, String text, String answer, String points) 
	throws NumberFormatException, SecurityException, IllegalArgumentException, 
	       ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException
	{
		
	   return new Question(text,AnswerFactory.getFACTORY().buildAnswer(answer,type),Integer.valueOf(points).intValue());
	}

	/**
	 */
	public void initQuestionnaire(String fileName){
		File source = new File(fileName);
		String line="";
		try {
			BufferedReader in = new BufferedReader(new FileReader(source));
			line = in.readLine();
			while ( line != null ){    
            	
				String typeQuestion = "questionnaires."+ line;
				String question = in.readLine();
				String reponse = in.readLine();
				String nbpoints = in.readLine();
				Question nouvelle = this.createQuestion(typeQuestion, question, reponse, nbpoints);
				this.lesQuestions.add(nouvelle);
				line = in.readLine();
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 */
	public void poser(){
		boolean OK = false;
		this.setNbPoints(0);
		for (Question q : this.lesQuestions){
			System.out.println(q.getQuestionText());
			do{
				System.out.println(q.getTheRightAnswer().instruction());
				Scanner s = new Scanner(System.in);
				String reponse = s.nextLine();
				OK = q.isAcceptable(reponse);
				if (OK) q.setTheUserTextAnswer(reponse);
			}
			while (!(OK));
			if (q.isUserAnswerCorrect()){
				if (q.getNbOfPoints()==1){
				System.out.println("correct ("+q.getNbOfPoints()+" point)");	
				}else{
				System.out.println("correct ("+q.getNbOfPoints()+" points)");
				}
				this.setNbPoints(this.getNbPoints()+q.getNbOfPoints());
			}
			else System.out.println("incorrect, la bonne réponse est : "+q.getTheRightAnswer().toString());
		}
		System.out.println("Vous avez "+this.getNbPoints()+" points.");
	}

	/**
	 * @param lesQuestions the lesQuestions to set
	 */
	public void setLesQuestions(List<Question> lesQuestions) {
		this.lesQuestions = lesQuestions;
	}

	/**
	 * @return the lesQuestions
	 */
	public List<Question> getLesQuestions() {
		return lesQuestions;
	}

	/**
	 * @param nbPoints the nbPoints to set
	 */
	public void setNbPoints(int nbPoints) {
		this.nbPoints = nbPoints;
	}

	/**
	 * @return the nbPoints
	 */
	public int getNbPoints() {
		return nbPoints;
	}

}
