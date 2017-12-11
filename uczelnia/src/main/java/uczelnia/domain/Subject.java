package uczelnia.domain;

public class Subject {
	private String subjectId;
	private String nazwa;
	private int length;
		
	public String getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}
	public String getNazwa() {
		return nazwa;
	}
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int czasTrwaniaMin) {
		this.length = czasTrwaniaMin;
	}
	
	public Subject(String subjectId, String nazwa, int czasTrwaniaMin) {
		this.setSubjectId(subjectId);
		this.nazwa = nazwa;
		this.length = czasTrwaniaMin;
	}
	public Subject() {
		super();
	}
	
	
}
