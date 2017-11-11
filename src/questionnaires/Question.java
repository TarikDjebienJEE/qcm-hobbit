package questionnaires;


/**
 * @uml.dependency   supplier="questionnaires.Answer"
 */
public class Question {

	/**
	 * le nombre de point que rapporte la question
	 * @uml.property  name="nbPoints"
	 */
	protected int nbPoints;

	/**
	 * le texte decrivant la question
	 * @uml.property  name="text"
	 */
	protected String text = "Question vide";
	

	/**
	 * la bonne reponse à la question posée
	 * @uml.property  name="theRightAnswer"
	 */
	protected Answer<?> theRightAnswer;
	
	/**
	 * La reponse de l'utilisateur
	 * @uml.property  name="theUserTextAnswer"
	 */
	protected String theUserTextAnswer;

	/**
	 * Setter of the property <tt>nbPoints</tt>
	 * @param nbPoints  The nbPoints to set.
	 * @uml.property  name="nbPoints"
	 */
	public void setNbPoints(int nbPoints) {
		this.nbPoints = nbPoints;
	}




	/**
	 * Constructor of initialization
	 */
	public Question(String t, Answer<?> a, int nbP){
	 this.nbPoints=nbP;
	 this.text=t;
	 this.theRightAnswer=a;
	}


	/**
	 * @return le nombre de points de la question courante
	 */
	public int getNbOfPoints(){
		return this.nbPoints;
	}


	/**
	 * @return le texte de la question courante
	 */
	public String getQuestionText(){
		return this.text;	
	}


	/**
	 * recupere la reponse exacte de la question
	 */
	public Answer<?> getTheRightAnswer(){
		return this.theRightAnswer;
	}


	/**
	 * recupere la reponse donnee par l'utilisateur
	 */
	public String getTheUserAnswer(){
		return this.theUserTextAnswer;	
	}


	/**
	 * predicat qui teste si la reponse donne par l'utilisateur est du bon type Reponse autorisee
	 */
	public boolean isAcceptable(String userAnswer){
		return this.getTheRightAnswer().accept(userAnswer);	
	}


	/**
	 * predicat qui teste si la reponse de l'utilisateur est exacte
	 */
	public boolean isUserAnswerCorrect(){
		return this.getTheRightAnswer().isCorrect(this.getTheUserAnswer());	
	}

	/**
	 * @return the theUserTextAnswer
	 */
	public String getTheUserTextAnswer() {
		return theUserTextAnswer;
	}

	/**
	 * @param theUserTextAnswer the theUserTextAnswer to set
	 */
	public void setTheUserTextAnswer(String theUserTextAnswer) {
		this.theUserTextAnswer = theUserTextAnswer;
	}

}
