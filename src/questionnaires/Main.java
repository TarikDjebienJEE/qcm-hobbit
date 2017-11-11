package questionnaires;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Questionnaire A = new Questionnaire();
		A.initQuestionnaire("question_tolkien.txt");
		A.poser();

	}

}
